package custom_datastructures;

public class DinamicArray {
	private int count = 0;
	private int[] items;

	public DinamicArray(int length) {
		items = new int[length];
	}

	public void insert(int item) {
		if (count >= items.length) {
			var aux = new int[count * 2];
			for (int i = 0; i < count; i++) {
				aux[i] = items[i];
			}
			items = aux;
		}
		items[count++] = item;
	}

	public void removeAt(int index) {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		if (index == count - 1) {
			count--;
			return;
		}
		for (int i = index; i < count; i++) {
			items[i] = items[i + 1];
		}
		count--;
	}

	public int indexOf(int item) {
		for (int i = 0; i < count; i++) {
			if (items[i] == item) return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		var res = new StringBuilder("[");
		for (int i = 0; i < count - 1; i++) {
			res.append(items[i]).append(", ");
		}
		if (count > 1)
			res.append(items[count - 1]);
		res.append("]");
		return res.toString();
	}
}
