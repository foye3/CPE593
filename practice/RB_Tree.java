package practice;


public class RB_Tree {
	public class TreeNode {
		TreeNode left, right,parent;
		private int val;
		//red = true, black = false
		private boolean color;
		public TreeNode(int v,TreeNode p) {
			this.val = v;
			this.left = null;
			this.right = null;
			this.parent = p;
			this.color = true;
		}
		public TreeNode(int v, TreeNode l, TreeNode r,TreeNode p) {
			this.val = v;
			this.left = l;
			this.right = r;
			this.parent = p;
			this.color = true;
		}
		public void rb() {
			if(this.parent.color==false) return;
			TreeNode u = uncle(); 
			if(u!=null){
				parent.color=false;
				u.color = false;
				TreeNode g = grandparent();
				g.color = true;
				g.rb();
			}
			
		}
		public TreeNode uncle(){
			
			
			
			return left;
			
		}
		public TreeNode grandparent(){
			
			
			
			return left;
			
		}
		
	}
	
	TreeNode root;
	
	public void add(int v){
		if (root == null) {
			root = new TreeNode(v,null);
			root.color = false;
			return;
		}
		TreeNode p =root;
		while(true){
			if(v>p.val){
				if(p.right==null){
					p.right=new TreeNode(v,p);
					p.right.rb(); //fix color
					return;
				}
				p = p.right;
			}else{
				if(p.left==null){
					p.left=new TreeNode(v,p);
					p.left.rb(); //fix color
					return;
				}
				p = p.left;
			}
		}
	}
	
	public int[] quicksort2(int[] a, int l, int r) {
		if (l < r) {
			int p = a[l];
			int i = l - 1;
			int j = r + 1;
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
			quicksort2(a, l, j);
			quicksort2(a, j + 1, r);

		}
		return a;
	}
	
}
