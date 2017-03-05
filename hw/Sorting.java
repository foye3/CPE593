package hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import practice.QuickSort;

public class Sorting {
	
	public int[] quickSort(int[] a,int left, int right) {
		if (left < right) {
			int p = (a[left]+a[right])/2;
			int i = left - 1;
			int j = right + 1;
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
			quickSort(a,left, j);
			quickSort(a,j + 1, right);

		}
		return a;
	}
	
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
	public void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/hw/hw5a.txt"));
		Sorting sor = new Sorting();
		String s;
		while((s=br.readLine())!=null){
			System.out.println(s);
			String[] sa = s.split(" ");
			int n = Integer.valueOf(sa[2]);
			int[] a = new int[n];
			if(sa[1].equals("RANDOM")){
				int m = Integer.valueOf(sa[3]);
				for(int i =0;i<n;i++){
					a[i] = (int) (Math.random()*(m+1));	
				}
			}else if(sa[1].equals("INPUT")){
				//System.out.println("Please input "+n+" numbers.");
				//Scanner sc =new Scanner(System.in);
				//String input = sc.nextLine();
				String input = br.readLine();
				System.out.println("array: "+input);
				String[] inputarray = input.split("[ ,]");
				for(int i=0;i<inputarray.length&&i<n;i++){
					a[i]=Integer.valueOf(inputarray[i]);
				}
			}else{
				System.out.println("Wrong command");
				continue;
			}
			
			if(sa[0].equals("PRINT")){
				System.out.println("array: ");
				sor.printArray(a);
				int[] quick =a,select=a;
				System.out.println("quicksort: ");
				sor.printArray(sor.quickSort(quick, 0, n-1));
				System.out.println("selection: ");
				sor.printArray(sor.selectionSort(select));
				
			}else if(sa[0].equals("BENCHMARK")){
				double t1 = System.currentTimeMillis();
				sor.quickSort(a, 0, n-1);
				double t2 =System.currentTimeMillis();
				sor.selectionSort(a);
				double t3 = System.currentTimeMillis();
				System.out.println("quicksort time:"+(t2-t1)
						+"ms\nselectionsort time: "+(t3-t2)+"ms");
				
			}
			
		}

	}

}
