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
		sentinel = new Node();
		size = 0;
		height = 0;
		root = nil;
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
		return 0;
	}
	
	public void RBInsert() {
		
	}
	
	public void RBInsertFixup() {
		
	}
	
	public void LeftRotate(Node x) 
	{
		Node y = new Node();
		y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != this.getNILNode()) 
		{
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == this.getNILNode()) 
		{
			this.setRoot(y);
		}
		else if (x == x.getParent().getLeft()) 
		{
			x.getParent().setLeft(y);
		}
		else 
		{ 
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
		nodeValueUpdate(x);
		
	}
	
	public void RightRotate(Node x) {
		
	}
	
	public void RBDeletion(Node z) {
		
	}
	
	private void RBDeleteFixup(Node x) {
		
	}
	
	private void nodeValueUpdate(Node x) 
	{
		if(x == this.getNILNode()) 
		{
			x.setVal(0);
			x.setMaxVal(0);
			x.setEmax(this.getNILNode().getEmax());
		}
		else 
		{
			x.setVal(x.getLeft().getVal() + x.getP() + x.getRight().getVal());
			x.setMaxVal(Math.max(x.getLeft().getMaxVal(), Math.max(x.getLeft().getVal() + x.getP(), x.getLeft().getVal() + x.getP() + x.getRight().getMaxVal())));
			if(x.getLeft().getEmax() != this.getNILNode().getEmax() && x.getMaxVal() == x.getLeft().getMaxVal()) 
			{
				x.setEmax(x.getLeft().getEmax());
			}
			else if(x.getMaxVal() == (x.getLeft().getVal() + x.getP()))
			{
				x.setEmax(x.getEndpoint());
			} 
			else if (x.getRight().getEmax() != this.getNILNode().getEmax() && x.getMaxVal() == (x.getLeft().getVal() + x.getP() + x.getRight().getMaxVal())) 
			{
				x.setEmax(x.getRight().getEmax());
			}
			else 
			{
				x.setEmax(this.getNILNode().getEndpoint());
			}
			nodeValueUpdate(x.getParent());
		}
	}

}
