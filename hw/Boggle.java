package hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import hw.TrieDictionary.Node;

public class Boggle {

	public class Node{
		Node[] nextL;
		boolean isword;
		public Node(){
			this.nextL=new Node[26];
			this.isword = false;
		}
	}

	Node root;
	int N;						//length of matrix
	char[][] matrix;
	boolean[][] used;
	ArrayList<String> findwords;
	
	public Boggle(int N) {
		this.N = N;
		matrix = new char[N][N];
		used = new boolean[N][N];
		findwords = new ArrayList<>();
	}

	public void addtrie(String s) {
		if(root==null){
			root = new Node();
		}
		Node p = root;
		for(int i=0;i<s.length();i++){
			int index = s.charAt(i)-97;
			if(p.nextL==null){
				p.nextL = new Node[26];
			}
			if(p.nextL[index]==null){
				p.nextL[index]=new Node();
			}
			p=p.nextL[index];
		}
		p.isword=true;
	}

	public boolean contains(String s) {
		Node p = root;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 97;
			if (p.nextL[index] == null) {
				return false;
			} else {
				p = p.nextL[index];
			}
		}
		if (p.isword) {
			return true;
		}
		return false;
	}

	public boolean containsPrefix(String s) {
		if (s == null || s.equals(""))
			return true;
		Node p = root;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 97;
			if (p.nextL[index] == null) {
				return false;
			} else {
				p = p.nextL[index];
			}
		}
		return true;
	}

	public void findwords() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solve("", i, j);
			}
		}
		for(String s:findwords){
			System.out.println(s.toUpperCase()+" is a word");
		}
		System.out.println("total words: "+findwords.size());
	}

	public void solve(String prefix, int i, int j) {
		if (i < 0 || j < 0 || i >= N || j >= N)
			return;
		if (used[i][j])
			return;
		if (!containsPrefix(prefix))
			return;
		used[i][j] = true;
		prefix = prefix + matrix[i][j];
		if (prefix.length()>=3&&contains(prefix)){
			//System.out.println(prefix+" is a word");
			if(!findwords.contains(prefix)){
				findwords.add(prefix);
			}
		}
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				solve(prefix, i + x, j + y);
			}
		}
		used[i][j] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br2 = new BufferedReader(new FileReader("src/hw/boggle.dat"));
		int N = Integer.valueOf(br2.readLine());
		Boggle boggle = new Boggle(N);
		String s;
		int row = 0;
		while ((s = br2.readLine()) != null) {
			char[] a = s.replaceAll(" ", "").toCharArray();
			for (int i = 0; i < a.length; i++) {
				boggle.matrix[row][i] = a[i];
			}
			row++;
		}
		BufferedReader br = new BufferedReader(new FileReader("src/hw/dictionary.txt"));
		while ((s = br.readLine()) != null) {
			boggle.addtrie(s.toLowerCase().replace("-", ""));
		}
		boggle.findwords();
	}
}
