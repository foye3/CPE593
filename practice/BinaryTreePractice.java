package practice;

public class BinaryTreePractice {
	public class TreeNode {
		TreeNode left, right;
		private int val;

		public TreeNode(int v) {
			this.val = v;
			this.left = null;
			this.right = null;
		}

		public TreeNode(int v, TreeNode l, TreeNode r) {
			this.val = v;
			this.left = l;
			this.right = r;
		}
	}

	private TreeNode root;

	public void add(int v) {
		if (root == null) {
			root = new TreeNode(v);
			return;
		}
		TreeNode p = root;
		while (true) {
			if (v > p.val) {
				if (p.right == null) {
					p.right = new TreeNode(v);
					return;
				}
				p = p.right;
			} else {
				if (p.left == null) {
					p.left = new TreeNode(v);
					return;
				}
				p = p.left;
			}
		}
	}

	public void preorder(StringBuilder b) {
//		b.append(val);
//		if(left!=null)
//			left.preorder(b);
//		if(right!=null)
//			right.preorder(b);
		
	}

	public void postorder(StringBuilder b) {
//		if(left!=null)
//			left.postorder(b);
//		if(right!=null)
//			right.postorder(b);
//		b.append(val);
	}
	//sorted binary search tree
	public void inorder(StringBuilder b) { //x+y
//		if(left!=null)
//			left.inorder(b);
//		b.append(val);
//		if(right!=null)
			//right.inorder(b);
	}

	public static void main(String[] args) {
		BinaryTreePractice nb = new BinaryTreePractice();
		nb.add(3);
	}
}
