package custom_datastructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList {
	private Node first;
	private Node last;
	private int size;

	public void addFirst(int item) {
		var node = new Node(item);
		size++;
		if (first == null)
			first = last = node;
		else {
			node.next = first;
			first = node;
		}
	}

	public void addLast(int item) {
		var node = new Node(item);
		size++;
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	public void deleteFirst() {
		if (isEmpty()) throw new NoSuchElementException();
		size--;
		if (first == last) {
			first = last = null;
			return;
		}
		var second = first.next;
		first.next = null;
		first = second;
	}

	public void deleteLast() {
		if (isEmpty()) throw new NoSuchElementException();
		last = getPrevious(last);
		size--;
		if (last == null) {
			first = null;
			return;
		}
		last.next = null;
	}

	private Node getPrevious(Node node) {
		var i = first;
		while (i != null) {
			if (i.next == node) return i;
			i = i.next;
		}
		return null;
	}

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	public int indexOf(int item) {
		var i = first;
		var index = 0;
		while (i != null) {
			if (i.value == item) return index;
			index++;
			i = i.next;
		}
		return -1;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return size;
	}

	public void reverse() {
		if (isEmpty()) return;

		var previous = first;
		var current = previous.next;
		while (current != null) {
			var next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		last = first;
		last.next = null;
		first = previous;
	}

	public int[] toArray() {
		var arr = new int[size];
		var i = first;
		var index = 0;
		while (i != null) {
			arr[index++] = i.value;
			i = i.next;
		}
		return arr;
	}

	public int getKthfromTheEnd(int k) {
		if (k < 1 || k > size) throw new IndexOutOfBoundsException();
		var pointer = first;
		var advisor = first;
		for (int i = 0; i < k; i++) {
			advisor = advisor.next;
		}
		while (advisor != null) {
			advisor = advisor.next;
			pointer = pointer.next;
		}
		return pointer.value;
	}

	@Override
	public String toString() {
		if (isEmpty()) return "[]";
		var res = new StringBuilder("[");
		var i = first;
		while (i != last) {
			res.append(i.value).append(", ");
			i = i.next;
		}
		res.append(last.value).append("]");
		return res.toString();
	}

	static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}
