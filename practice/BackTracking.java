package practice;


public class BackTracking {
	public int[] p;
	
	public BackTracking(){
		
	}

	public void generate(int n) {
		if (n == 0) {
			doit();
		}
		for(int c=0;c<n;c++){
			swap(c,n-1);
			generate(n-1);
			swap(c,n-1);
		}
	}

	private void doit() {
		for(int i=0;i<p.length;i++){
			System.out.println(p[i]);
		}
	}
	void swap(int a,int b){
		int temp =p[b];
		p[b] = p[a];
		p[a] = temp;
	}

}
