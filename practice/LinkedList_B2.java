package practice;

public class LinkedList_B2 {
	private static class Node { // LinkedList_B.Node
		// 12 bytes overhead
		int val; // 4 bytes
		Node next; // 4 bytes

		Node(int v, Node n) {
			val = v;
			next = n;
		}
		// hidden pointer to parent(LinkedList_B) (not with static)
	}

	private Node head;
	private int count;

	public LinkedList_B2() {
		head = null;
	}

	public void addEnd(int v) {
		if (head == null) {
			head = new Node(v, null);
			count++;
			return;
		}
		Node p;
		for (p = head; p.next != null; p = p.next)
			;
		p.next=new Node(v,null);
		count++;
	}

	public void addStart(int v) {
		head = new Node(v, head);
		count++;

	}

//	public int removeStart() { // O(1)
//		if (head == null) {
//			throw new IllegalOutOfBoundException("No element");
//
//		}
//		int temp = head.val;
//		head = head.next;
//		count--;
//		return temp;
//	}

	public int removeEnd() throws Exception {
		if (head == null)
			throw new Exception("No element");
		if (head.next == null) {
			int temp = head.val;
			head = null;
			count--;
			return temp;
			
		}
		Node p;
		for (p = head; p.next.next != null; p = p.next)
			;
		int temp = p.next.val;
		count--;
		p.next = null;
		return temp;
	}

	public int size() {
		return count;
	}

	public String toString() {
		StringBuilder b = new StringBuilder(32768);
		b.append("[");
		for (Node p = head; p != null; p = p.next) {
			b.append(p.val).append(",");
		}
		b.append("]");
		return b.toString();
	}
	
//	public int get(int i){
//		if(i>count||i<=0){
//			throw new IllegalOutOfBoundException("Out of bounds"); 
//		}
//		Node p;
//		for(p =head;i>0;i--,p=p.next);
//		return p.val;
//	}

	public static void main(String[] args) {
		LinkedList_B2 x = new LinkedList_B2();
		for (int i = 0; i < 10; i++) {
			x.addEnd(i);
		}
		for (int i = 0; i < 10; i++) {
			x.addStart(i);
		}
		System.out.println(x);
	}

}
