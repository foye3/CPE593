package hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashLinerChaining {

	private class Node {
		String val;
		Node next;

		public Node(String s) {
			this.val = s;
		}
	}

	private Node[] table;
	private int used;
	private int limit;
	private int[] hist;

	public HashLinerChaining(int initialize) {
		int i;
		for (i = 1; i < initialize; i *= 2)
			;
		used = 0;
		limit = i / 2;
		table = new Node[i];
		hist = new int[51];
	}

	public HashLinerChaining() {
		this(16);
	}

	public void grow() {
		Node[] temp = table;
		table = new Node[table.length * 2];
		limit = table.length / 2;
		used=0;
		hist=new int[51];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				Node p =temp[i];
				while (p != null) {
					add(p.val);
					p=p.next;
				}
			}
		}
	}

	private int hash(String s) {
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = (sum << 13) + s.charAt(i) + (sum >> 17);
		}
		return (int) Math.abs(sum % table.length);
	}

	public void add(String s) {

		used++;
		if (used > limit) {
			grow();
		}
		int i = hash(s);

		if (table[i] == null) {
			table[i] = new Node(s);
			hist[0]++;
			return;
		}
		Node p = new Node(null);
		p.next = table[i];
		int count =0;
		while (p.next != null) {
			count++;
			p = p.next;
			if (p.val.equals(s)) {
				used--;
				return;
			}
		}
		hist[count]++;
		p.next = new Node(s);
	}

	public boolean contains(String s) {
		int i = hash(s);
		Node p = table[i];

		while (p != null) {
			if (p.val.equals(s)) {
				return true;
			}
			p = p.next;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		HashLinerChaining hlc = new HashLinerChaining();
		BufferedReader br = new BufferedReader(new FileReader("src/hw/dict.txt"));
		String s;
		while ((s = br.readLine()) != null) {
			hlc.add(s);
		}
		System.out.println("insert    count");
		//hlc.count();
		for (int i = 0; i < 51; i++) {
			System.out.println("  " + (i + 1) + "      " + (hlc.hist[i]));
		}
		BufferedReader br2 = new BufferedReader(new FileReader("src/hw/hw8.dat"));
		String str;
		while ((str = br2.readLine()) != null) {
			System.out.println(str + ":" + hlc.contains(str));
		}
	}

}
