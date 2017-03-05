package practice;

public class SelectionSort {
	public int[] selectionSort(int[] a){
		for(int i=a.length-1;i>0;i--){
			int pos = 0;
			for(int j=1;j<=i;j++){
				if(a[pos]<a[j]){
					pos = j;
				}
				
			}
			int temp = a[pos];
			a[i] = a[pos];
			a[pos] = temp;
		}
		return a;
	}
}
