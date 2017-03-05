package hw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sorting2 {

	public int[] quickSort(int[] a, int left, int right) {
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
			quickSort(a, left, j);
			quickSort(a, j + 1, right);

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
	
	public int[] generateRandomArray(int n,int max){
		int[] a = new int[n];
		for(int i =0;i<n;i++){
			a[i] = (int)Math.random()*max;
		}
		return a;
	}
	
	public void contorler(String s){
		String[] sa = s.split(" ");
		int[] a = new int[Integer.valueOf(sa[2])];
		if(sa[1].equals("RANDOM")){
			int n =Integer.valueOf(sa[2]);
			int max =Integer.valueOf(sa[3]);
			a = generateRandomArray(n, max);		
		}else if(sa[1].equals("INPUT")){
			System.out.println("Please input array.");
			Scanner sc =new Scanner(System.in);
			String input = sc.nextLine();
			String[] inputarray = input.split("[ ,]");
			a = null;
			for(int i=0;i<inputarray.length;i++){
				a[i]=Integer.valueOf(inputarray[i]);
			}
		}else{
			System.out.println("Wrong commamd!");
		}
		if(sa[0].equals("PRINT")){
			System.out.println("before sorting:");
			printArray(a);
			System.out.println("quicksort:");
			printArray(quickSort(a,0,a.length-1));
			System.out.println("selectionsort:");
			printArray(a);
			System.out.println(a.toString());
		}else if(sa[0].equals("BENCHMARK")){
			double t1 = System.currentTimeMillis();
			quickSort(a, 0, a.length-1);
			double t2 = System.currentTimeMillis();
			selectionSort(a);
			double t3 = System.currentTimeMillis();
			System.out.println("quickSort time: "+(t2-t1));
			System.out.println("selectionsort time: "+(t3-t2));
		}
		
	}
	
	public void printArray(int[] a){
		for(int i:a){
			System.out.print(i+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/hw/hw5a.txt"));
		Sorting2 sor = new Sorting2();
		String s;
		while((s=br.readLine())!=null){
			sor.contorler(s);
		}

	}

}
