
public class BinarySearchTree {
	private TreeNode root;
	
	public TreeNode find(int d) {
		return find(root, d);
	}

	private TreeNode find(TreeNode current, int d) {
		if (current == null || current.data == d) {
			return current;
		}
		if (d < current.data) {
			return find(current.left, d);
		}
		if (d > current.data) {
			return find(current.right, d);
		}
		return null;
	}
	
	public void insert(int d) {
		insert(root, d);
	}

	private void insert(TreeNode current, int d) {
		if (current == null) {
			current = new TreeNode(d);
		}
		if (d > current.data) {
			if (current.right == null) {
				current.right = new TreeNode(d);
			}
			else {
				insert(current.right, d);
			}
		}
		else {
			if (current.left == null) {
				current.left = new TreeNode(d);
			}
			else {
				insert(current.left, d);
			}
		}
	}
	
}

