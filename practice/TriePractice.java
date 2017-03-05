package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TriePractice {
	public class Node{
		Node[] nextL;
		boolean isword;
		public Node(){
			this.nextL=null;
			this.isword = false;
		}
	}
	
	Node root;
	
	public void add(String s){
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
				//p.nextL[c-97].isword=true;
			}
			p=p.nextL[index];
		}
		p.isword=true;
	}
	public boolean serach(String s){
		Node p =root;
		//??
		for(int i =0;i<s.length();i++){
			int index = s.charAt(i)-97;
			if(p.nextL[index]==null){
			//if(p.nextL[index]==null){
				return false;
			}else{
				p = p.nextL[index];
			}
		}
		if(p.isword){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("src/hw/dict.txt"));
		TriePractice tp = new TriePractice();
		String s;
		while((s = br.readLine())!=null){
			s.toLowerCase();
			
			tp.add(s);
		}
		BufferedReader br2 = new BufferedReader(new FileReader("src/hw/HW6b.txt"));
		while((s=br2.readLine())!=null){
			s.toLowerCase();
			System.out.println(s+":"+tp.serach(s));
			//tp.serach(s)
		}
		long t2 =System.currentTimeMillis();
		System.out.println(t2-t1+"ms");
	}
}

//LCS
//test:3 order 
//	badgrowarray:
//		add O(n)
//	growarray     need write
//		addend O(1)
//		addstart O(n)	
//	linkedlist
//	doublelinkedlist
//		addend,addstart,removeend,removestart,get(i)
//		void finalize(){
//			for(Node p =head;p!=null;p=q){//O(n)
//				q=p.next;
//				delete p;
//		}
//	No shuffling


//
//
//class hashmap{
//	private linkedlist table;
//	
//	
//}
//n mod x => n&(x-1)
// try small hash use prime number
