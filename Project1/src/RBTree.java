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

		//setting nil node to be black
		nil = new Node();
		nil.setColor(1);
		
		root = nil; //to start with
		
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
		this.root.setColor(1);
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
	public int getHeight() { //READ-ME: not sure if this is meant to return black height.
		return this.height;
	}
	
	private int findHeight(Node root) {
		
		if(root == null) {return 0;}
		
		int leftHeight = findHeight(root.getLeft());
		int rightHeight = findHeight(root.getRight());
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	/**
	 * To insert a node into the red black tree
	 * @param z
	 */
	public void RBInsert(Node z) {
		
		Node y = this.nil;
		Node x = this.root;
		
		while(x != this.nil) {
			y = x;
			if(z.getKey() < x.getKey()) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
			
		z.setParent(y);
		
		if(y == this.nil) {
			root = z;
		} else if(z.getKey() < y.getKey()) {
			y.setLeft(z);
		} else {
			y.setRight(z);
		}
		
		z.setLeft(this.nil);
		z.setRight(this.nil);
		z.setColor(0);
		RBInsertFixup(z);
			
		size++;
		this.height = findHeight(root);
	}
	
	/**
	 * 
	 * @param z
	 */
	private void RBInsertFixup(Node z) {
		
		Node y;
		
		while(z.getParent().getColor() == 0) {
			if(z.getParent() == z.getParent().getParent().getLeft()) {
				
				y = z.getParent().getParent().getRight();
				
				if(y.getColor() == 0) {
					
					z.getParent().setColor(1);
					y.setColor(1);
					z.getParent().getParent().setColor(0);
					z = z.getParent().getParent();
					
				} else {
					
					if(z == z.getParent().getRight()) {
						z = z.getParent();
						LeftRotate(z);
					}
					
					z.getParent().setColor(1);
					z.getParent().getParent().setColor(0);
					RightRotate(z.getParent().getParent());
					
				}
			} else {
					
				y = z.getParent().getParent().getLeft();
				if(y.getColor() == 0) {
					z.getParent().setColor(1);
					y.setColor(1);
					z.getParent().getParent().setColor(0);
					z = z.getParent().getParent();
				} else {
					if(z == z.getParent().getLeft()) {
						z = z.getParent();
						LeftRotate(z);
					}
					z.getParent().setColor(1);
					z.getParent().getParent().setColor(0);
					RightRotate(z.getParent().getParent());
				}
			}
		}
		
		root.setColor(0);
		
	}
	
	/**
	 * 
	 * @param x
	 */
	private void LeftRotate(Node x) 
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
	
	/**
	 * 
	 * @param x
	 */ 
	private void RightRotate(Node x) {
		
		Node y = new Node();
		y = x.getLeft();
		x.setLeft(y.getRight());
		
		if (y.getRight() != this.getNILNode()) {
			y.getRight().setParent(x);
		}
		
		y.setParent(x.getParent());
		
		if (x.getParent() == this.getNILNode()) {
			this.setRoot(y);
		} else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRight(y);
		}
		
		y.setRight(x);
		x.setParent(y);
		nodeValueUpdate(x);
	}

	/**
	 * Deleting a node from a RB Tree
	 * @param z is the node you want to delete from the RB Tree
	 */
	public void RBDelete(Node z) {
		
		Node x;
		Node y = z;
		int yOrigColor = y.getColor();
		
		if(z.getLeft() == nil) {
			x = z.getRight();
			RBTransplant(z, z.getRight());
		} else if(z.getRight() == nil) {
			x = z.getLeft();
			RBTransplant(z, z.getLeft());
		} else {
			y = Minimum(z.getRight());
			yOrigColor = y.getColor();
			x = y.getRight();
			
			if(y.getParent() == z) {
				x.setParent(y);
			} else {
				RBTransplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			
			RBTransplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
			y.setColor(z.getColor());
		}
		
		if(yOrigColor == 0) {
			RBDeleteFixup(x);
		}
		
		size--;
		this.height = findHeight(root);
	}
	
	/**
	 * Returns the minimum key-value from a subtree rooted at the node x 
	 * @param x is the node at the root of the subtree you are finding the minimum key-value for
	 * @return
	 */
	private Node Minimum(Node x) {
		
		while(x.getLeft() != null) {
			x = x.getLeft();
		}
		
		return x;
	}


	/**
	 * Recoloured nodes and rotated to make sure that red-black properties hold for new tree.
	 * @param z
	 */
	private void RBDeleteFixup(Node z) {
		while (z != this.getNILNode() && z.getColor() == 1) 
		{
			if (z == z.getParent().getLeft()) 
			{
				Node w = z.getParent().getRight();
				if (w.getColor() == 0) 
				{
					w.setColor(1);
					z.getParent().setColor(0);
					LeftRotate(z.getParent());
					w = z.getParent().getRight();
				}
				if (w.getLeft().getColor() == 1 && w.getRight().getColor() == 1)
				{
					w.setColor(0);
					z = z.getParent();
				}
				else 
				{
					if (w.getRight().getColor() == 1) 
					{
						w.getLeft().setColor(1);
						w.setColor(0);
						RightRotate(w);
						w = z.getParent().getRight();
					}
					w.setColor(z.getParent().getColor());
					z.getParent().setColor(1);
					w.getRight().setColor(1);
					LeftRotate(z.getParent());
					z = this.getRoot();
				}
			}
			else 
			{
				Node w = z.getParent().getLeft();
				if (w.getColor() == 0) 
				{
					w.setColor(1);
					z.getParent().setColor(0);
					RightRotate(z.getParent());
					w = z.getParent().getLeft();
				}
				if (w.getLeft().getColor() == 1 && w.getRight().getColor() == 1) 
				{
					w.setColor(0);
					z = z.getParent();
				}
				else 
				{
					if (w.getLeft().getColor() == 1)
					{
						w.getRight().setColor(1);
						w.setColor(0);
						LeftRotate(w);
						w = z.getParent().getLeft();
					}
					w.setColor(z.getParent().getColor());
					z.getParent().setColor(1);
					w.getLeft().setColor(1);
					RightRotate(z.getParent());
					z = this.getRoot();
				}
			}
		}
		z.setColor(1);
	}
	
	/**
	 * 
	 * @param n
	 * @param v
	 */
	private void RBTransplant(Node n, Node v) 
	{
		if (n.getParent() == this.getNILNode()) 
		{
			this.root = v;
		}
		else if (n == n.getParent().getLeft()) 
		{
			n.getParent().setLeft(v);
		}
		else 
		{
			n.getParent().setRight(v);
		}
		v.setParent(n.getParent());
	}
	
	/**
	 * 
	 * @param x
	 */
	private void nodeValueUpdate(Node x) 
	{
		if(x == this.getNILNode()) 
		{
			x.setVal(null);
			x.setMaxVal(null);
			x.setEmax(this.getNILNode().getEmax());
		}
		else 
		{
			x.setVal(x);
			x.setMaxVal(x);
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
