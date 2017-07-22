package practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AppReturnKLargest {
	/*
	 * Imagine you are creating an application that is going to receive a stream
	 * of objects. At any given time, this application will need the ability to
	 * return a list of the k largest values, where k is a constant that is
	 * passed as a program argument.
	 * 
	 * Please provide a functioning implementation of the following psudeo class
	 * in any programming language you are comfortable with along with whatever
	 * unit tests you feel are appropriate:
	 * 
	 * 
	 * class App {
	 * 
	 * // constructor 
	 * def App(integer : k);
	 * 
	 * // interfaces def offer (Object : o); 
	 * def List<Object> getTopK(); }
	 * 
	 * 
	 * An example of a correctly functioning data structure is as follows:
	 * 
	 * App foo = new App(3); 
	 * // foo.getTopK() returns []
	 * 
	 * foo.offer("a"); 
	 * // foo.getTopK() returns [a]
	 * 
	 * foo.offer("b"); 
	 * // foo.getTopK() returns [b,a]
	 * 
	 * foo.offer("aa"); 
	 * // foo.getTopK() returns [b,aa,a]
	 * 
	 * foo.offer("c"); 
	 * // foo.getTopK() returns [c,b,aa]
	 * 
	 * foo.offer("a"); 
	 * // foo.getTopK() returns [c,b,aa]
	 * 
	 * foo.offer("d"); 
	 * // foo.getTopK() returns [d,c,b]
	 * 
	 * 
	 */

	int klargest;
	//use treemap to handle sorting and duplicate object
	Map<Object, Integer> treemap;

	public AppReturnKLargest(int k) { 
		this.klargest = k;
		this.treemap = new TreeMap<>(Collections.reverseOrder());
	}

	public void offer(Object obj) {	
		if (treemap.containsKey(obj)) {
			treemap.replace(obj, treemap.get(obj) + 1);
		} else {
			treemap.put(obj, 1);
		}

	}

	public List<Object> getTopK() {
		List<Object> list = new LinkedList<>();
		Iterator<Object> iter = treemap.keySet().iterator();
		int count = 0;
		while (iter.hasNext() && count < klargest) {
			Object obj = iter.next();
			for (int j = 0; j < treemap.get(obj) && count < klargest; j++) {
				list.add(obj);
				count++;
			}
		}

		return list;

	}

	// public static void main(String[] args) {
	// AppReturnKLargest app = new AppReturnKLargest(3);
	//
	// app.getTopK();
	//
	// app.offer("a");
	// app.offer("b");
	// app.offer("aa");
	// app.offer("c");
	// app.offer("a");
	// app.offer("d");
	//
	// List<Object> list = new LinkedList<>(app.getTopK());
	// for(Object obj : list){
	// System.out.println(obj);
	// }
	//
	// }
}
