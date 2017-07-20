package practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AppReturnKLargest {
	int klargest;
	Map<Object,Integer> treemap;
	
	public AppReturnKLargest(int k){
		this.klargest = k;
		this.treemap = new TreeMap<>(Collections.reverseOrder());
	}
	
	public void offer(Object obj){
		if(treemap.containsKey(obj)){
			treemap.replace(obj, treemap.get(obj)+1);
		}else{
			treemap.put(obj, 1);
		}
		
	}
	
	public List<Object> getTopK(){
		List<Object> list = new LinkedList<>();
		Iterator<Object> iter = treemap.keySet().iterator();
		int count = 0;
		while(iter.hasNext()&&count<klargest){
			Object obj = iter.next();
			for(int j = 0 ; j<treemap.get(obj)&&count<klargest;j++){
				list.add(obj);
				count++;
			}
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		AppReturnKLargest app = new AppReturnKLargest(3);
		
		app.getTopK();
		
		app.offer("a");
		app.offer("b");
		app.offer("aa");
		app.offer("c");
		app.offer("a");
		app.offer("d");

		List<Object> list = new LinkedList<>(app.getTopK());
		for(Object obj : list){
			System.out.println(obj);
		}

	}
}
