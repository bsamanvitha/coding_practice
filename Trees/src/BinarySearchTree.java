
public class BinarySearchTree {
	private TreeNode root;
	
	public TreeNode find(int d) {
		return find(root, d);
	}

	private TreeNode find(TreeNode current, int d) {
		if (current == null || current.data == d) {
			return current;
		}
		if (d > current.data) {
			return find(current.left, d);
		}
		return find(current.right, d)
	}
	
	
}

