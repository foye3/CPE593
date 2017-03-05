package practice;

public class QuickSort {
	public int[] quicksort(int[] a, int left, int right) {
		if (left < right) {
			int pivot =a[left];
			
			int i = left;
			int j = right;
			while (i < j) {
				while (a[i] < pivot) {
					i++;
				}
				while (a[j] > pivot) {
					j--;
				}
				if (i < j) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}

			}
			quicksort(a, left, j);
			quicksort(a, j + 1, right);
		}
		return a;
	}

	static int[] a = { 8, 9, 4, 2, 3, 5, 7, 5, 6, 0, 3,3,3,3,3,3,3,3,3,3,5,6,7,8,6,34,345,234,2345 };

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();

		a = qs.quicksort2(a, 0, a.length - 1);
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + ",");
		}
	}
	public int[] quicksort2(int[] a, int l, int r) {
		if (l < r) {
			int p = (a[l]+a[r])/2;
			int i = l - 1;
			int j = r + 1;
			while (true) {
				do {
					i = i + 1;
				} while (a[i] < p);
				do {
					j = j - 1;
				} while (a[j] > p);
				if (i >= j) {
					break;
				}
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			quicksort2(a, l, j);
			quicksort2(a, j + 1, r);

		}
		return a;
	}
}
