package hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Linked_List_2 {
	
	public class ListNode {
		public int val;
		public ListNode next;
		//should not be here!!
		public ListNode(int x) { val = x; }
		public ListNode(){}
	}
	
	
	private ListNode head;
	private ListNode end;
	public Linked_List_2(){
		this.head = new ListNode();
	}
	
	private void addFront(int v){
		if(head.next!=null){
			ListNode temp = head.next;
			head.next = new ListNode(v);
			head.next.next = temp; 
		}else{
			head.next= new ListNode(v);
			end =head.next;
		}
		
	}
	
	private void addBack(int v){
		if(head.next!=null){
			end.next = new ListNode(v);
			end = end.next;
			
		}else{
			head.next= new ListNode(v);
			end =head.next;
		}
	}
	
	private void removeFront(){
		if(head.next.next!=null){
			head.next = head.next.next;
		}else{
			head.next=null;
			end=null;
		}
	}
	
	private void removeBack(){
		if(head.next.next!=null){
			ListNode temp = head;
			while(temp.next.next!=null){
				temp=temp.next;
			}
			end = temp;
			end.next = null;
		}else{
			head.next = null;
			end = null;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/hw/HW4a.txt"));
		Linked_List_2 ll = new Linked_List_2();
		String c;
		while ((c = br.readLine()) != null) {
			if (!(c.equals(""))) {
				System.out.println(c);
				switch (c.charAt(0)) {
				case 'A':
					int start = Integer.valueOf(c.substring(c.lastIndexOf(" ") + 1, c.indexOf(":")));
					int step = Integer.valueOf(c.substring(c.indexOf(":") + 1, c.lastIndexOf(":")));
					int end = Integer.valueOf(c.substring(c.lastIndexOf(":") + 1, c.length()));
					// add front
					if (c.charAt(4) == 'F') {
						while (start <= end) {
							ll.addFront(start);
							start += step;
						}
					}
					// add back
					if (c.charAt(4) == 'B') {
						while (start <= end) {
							ll.addBack(start);
							start += step;
						}
					}
					break;
				case 'R':
					int n = Integer.valueOf(c.substring(c.lastIndexOf(" ") + 1, c.length()));
					// remove front
					if (c.charAt(7) == 'F') {
						for (int i = 0; i < n; i++) {
							ll.removeFront();
						}
					}
					// remove back
					if (c.charAt(7) == 'B') {
						for (int i = 0; i < n; i++) {
							ll.removeBack();
						}
					}
					break;
				// output
				case 'O':
					ListNode a = ll.head;
					while(a.next!=ll.end){
						a=a.next;
						System.out.print(a.val+" ");
					}
					System.out.println("");
					break;
				default:
					break;
				}
			}
		}
	}
}
