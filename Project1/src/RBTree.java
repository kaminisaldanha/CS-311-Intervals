/**
 * Team members:
 * @author Smruthi Sandhanam, Meghna Vaidya, and Kamini Saldanha
 * 
 * RBTree class, maintains operations on RBTree.
 */

public class RBTree {
	
	private Node root;
	private int size;
	private Node sentinel;
	private int height;
	private Node nil;
	
	/**
	 * RB Tree constructor. It initializes nil node as well.
	 */
	public RBTree() {
		root = new Node();
		sentinel = new Node();
		size = 0;
	}
	
	/**
	 * Returns the root of the tree.
	 * @return
	 */
	public Node getRoot() {
		return this.root;
	}
	
	public void setRoot(Node n) {
		this.root = n;
	}
	
	/**
	 * Returns reference for the nil node, for the rbTree.
	 * @return
	 */
	public Node getNILNode() {
		//TODO: Modify it accordingly.
		return null;
	}
	
	/**
	 * Returns the number of internal nodes in the tree.
	 * @return
	 */
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Returns the height of the tree.
	 * @return
	 */
	public int getHeight() {
		//TODO: Modify it accordingly.
		return 0;
	}
	
	public void RBInsert() {
		
	}
	
	public void RBInsertFixup() {
		
	}
	
	public void LeftRotate(Node x) {
		
	}
	
	public void RightRotate(Node x) {
		
	}
	
	public void RBDeletion(Node z) {
		
	}
	
	private void RBDeleteFixup(Node x) {
		
	}
	

}
