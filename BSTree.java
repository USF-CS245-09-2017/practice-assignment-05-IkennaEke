public class BSTree{

	
	private class BSTNode {
		public Comparable data; 
		public BSTNode left; 
		public BSTNode right;  

		BSTNode(Comparable newdata) {
			data = newdata;
		}
	}
	
	private BSTNode root; 

	
	public void insert(Comparable elem) {
		root = insert(root, elem);
	}
	
	private BSTNode insert(BSTNode tree, Comparable elem) {
		if (tree == null) {
			return new BSTNode(elem);
		}
		if (elem.compareTo(tree.data) < 0) {
			tree.left = insert(tree.left, elem);
			return tree;
		} else {
			tree.right = insert(tree.right, elem);
			return tree;
		}
	}

	public boolean find(Comparable elem) {
		return find(root, elem);
	}
	
	private boolean find(BSTNode tree, Comparable elem) {
		if (tree == null)
			return false;
		if (elem.compareTo(tree.data) == 0)
			return true;
		if (elem.compareTo(tree.data) < 0)
			return find(tree.left, elem);
		else
			return find(tree.right, elem);
	}

	public void delete(Comparable elem) {
		root = delete(root, elem);
	}
	
	private BSTNode delete(BSTNode tree, Comparable elem) {
		if (tree == null)
			return null;
		if (tree.data.compareTo(elem) == 0) {
			if (tree.left == null)
				return tree.right;
			else if (tree.right == null)
				return tree.left;
			else {
				if (tree.right.left == null) { 
					tree.data = tree.right.data;
					tree.right = tree.right.right;
					return tree;
				} else {
					tree.data = removeSmallest(tree.right);
					return tree;
				}
			}
		} else if (elem.compareTo(tree.data) < 0) {
			tree.left = delete(tree.left, elem);
			return tree;
		} else {
			tree.right = delete(tree.right, elem);
			return tree;
		}
	}

	private Comparable removeSmallest(BSTNode tree) {
		if (tree.left.left == null) {
			Comparable smallest = tree.left.data;
			tree.left = tree.left.right;
			return smallest;
		} else {
			return removeSmallest(tree.left);
		}
	}

	
	public String toStringInOrder() {
		return toStringInOrder(root).trim();
	}
	
	private String toStringInOrder(BSTNode tree) {
		String line = "";
		if (tree != null) {
			line +=  toStringInOrder(tree.left) + " ";
			line += tree.data + " ";
			line += toStringInOrder(tree.right)+ " ";
		}
		return line.trim();
	}

	
	public String toStringPreOrder() {
		return toStringPreOrder(root).trim();
	}



	private String toStringPreOrder(BSTNode tree) {
		String line = "";
		if (tree != null) {
			line += tree.data + " ";
			line += toStringPreOrder(tree.left);
			line += toStringPreOrder( tree.right);
		}
		return line;
	}
}
