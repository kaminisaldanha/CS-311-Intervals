/**
 * Team members:
 * @author Smruthi Sandhanam, Meghna Vaidya, and Kamini Saldanha
 * 
 * RBTree class, maintains operations on RBTree.
 */

public class RBTree {
	
	/**
	 * The root of the RB Tree
	 */
	private Node root;
	/**
	 * The number of internal nodes in the RB Tree
	 */
	private int size;
	/**
	 * The height of the RB Tree
	 */
	private int height;
	/**
	 * The nil node in the RB Tree
	 */
	private Node nil;
	
	/**
	 * RB Tree constructor. It initializes nil node as well.
	 */
	public RBTree() {

		//intialize root and set its color to be black
		root = new Node();
		root.setColor(1);
		
		//setting nil node to be black
		nil.setColor(1);
		
		//intialize the size and height of tree
		size = 0;
		height = 0;
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
		return this.nil;
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
		return this.height;
	}
	
	/**
	 * To insert a node into the red black tree
	 * @param node
	 */
	public void RBInsert(Node node) {
		
		Node y = nil;
		Node x = root;
		
		while(x != nil) {
			
			y = x;
			if(node.getKey() < x.getKey()) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
			
			node.setParent(y);
			
			if(y == nil) {
				root = node;
			} else if(node.getKey() < y.getKey()) {
				y.setLeft(node);
			} else {
				y.setRight(node);
			}
			
			node.setLeft(nil);
			node.setColor(0);
			RBInsertFixup(node);
		}	
	}
	
	public void RBInsertFixup(Node node) {
		
		while(node.getParent().getColor() == 1) {
			
		}
		
	}
	
	public void LeftRotate(Node x) 
	{
		Node y = new Node();
		y = x.getRight();
		x.setRight(y.getLeft());
		
		if (y.getLeft() != this.getNILNode()) {
			y.getLeft().setParent(x);
		}
		
		y.setParent(x.getParent());
		
		if (x.getParent() == this.getNILNode()) {
			this.setRoot(y);
		} else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else { 
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
