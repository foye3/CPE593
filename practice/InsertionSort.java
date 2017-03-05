package practice;

public class InsertionSort {
	public int[] insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				int temp = a[i];
				for (int j = i - 1; j >= 0; j--) {
					if (a[j] > temp)
						a[j + 1] = a[j];
					else
						a[j + 1] = temp;
				}
			}
		}
		return a;
	}
	
}
