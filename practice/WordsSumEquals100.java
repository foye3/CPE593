package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class WordsSumEquals100 {
	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("src/hw/dict.txt"));
		
		String s;
		int count =0;
		while((s = br.readLine())!=null){
			s.toLowerCase();
			char[] arr = s.toCharArray();
			int total = 0;
			for(char c : arr){
				total += c - 'a' + 1 ;
			}
			if(total == 100){
				System.out.println(s);
				count++;
			}
		}
		
		long t2 =System.currentTimeMillis();
		System.out.println(t2-t1+"ms");
		System.out.println("Total number: "+count);
	}
}
