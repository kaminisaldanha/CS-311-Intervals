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
	private Node nil;
	
	/**
	 * RB Tree constructor. It initializes nil node as well.
	 */
	public RBTree() {

		//setting nil node to be black
		nil = new Node(0, 0, 0);
		nil.setColor(1);
		
		root = nil; //to start with
		nil.setLeft(nil);	
		nil.setRight(nil);		
		nil.setParent(nil);		

		//intialize the size and height of tree
		size = 0;
	}
	
	/**
	 * Returns the root of the tree.
	 * @return
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/**
	 * Sets node to root of tree
	 * @param n - node to set to root
	 */
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
	
	/**
	 * Sets the number of internal nodes in the tree
	 * @param size - number to set as number of internal nodes
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	
	/**
	 * Returns the height of the tree.
	 * @return
	 */
	public int getHeight() { 
		return getHeight(root);
	}
	
	/**
	 * Returns the height of the tree
	 * @param node - node from which to start counting height
	 * @return
	 */
	public int getHeight(Node node) {
		if (node == this.nil) {return 0;}

		// find the height of each subtree
		int left = getHeight(node.getLeft());
		int right = getHeight(node.getRight());

		return Math.max(left, right) + 1;
	}

	
	
	/**
	 * To insert a node into the red black tree
	 * @param insert - node to insert in to tree
	 */
	public void RBInsert(Node insert) {
		
		Node y = this.nil;
		Node x = this.root;
		
		while(x != this.nil) {
			y = x;
			if(insert.getKey() < x.getKey()) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
			
		insert.setParent(y);
		
		if(y == this.nil) {
			root = insert;
		} else if(insert.getKey() < y.getKey()) {
			y.setLeft(insert);
		} else {
			y.setRight(insert);
		}
		
		insert.setLeft(this.nil);
		insert.setRight(this.nil);
		insert.setColor(0);
		RBInsertFixup(insert);
			
		size++;
	}
	
	/**
	 * 
	 * @param z
	 */
	private void RBInsertFixup(Node insert) {
		
		while(insert.getParent().getColor() == 0) {
			
			if(insert.getParent() == insert.getParent().getParent().getLeft()) {
				Node y = insert.getParent().getParent().getRight();
				if(y.getColor() == 0) {
					insert.getParent().setColor(1); //case 1
					y.setColor(1); //case 1
					insert.getParent().getParent().setColor(0); //case 1
					insert = insert.getParent().getParent(); //case 1
				} else {
					
					if(insert == insert.getParent().getRight()) {
						insert = insert.getParent(); //case 2
						LeftRotate(insert); //case 2
					}
		
					insert.getParent().setColor(1); //case 3
					insert.getParent().getParent().setColor(0); //case 3
					RightRotate(insert.getParent().getParent()); //case 3
					
				}
				
			} else {
				Node y = insert.getParent().getParent().getLeft(); 
				if(y.getColor() == 0) {
					insert.getParent().setColor(1); //case 1
					y.setColor(1); //case 1
					insert.getParent().getParent().setColor(0); //case 1
					insert = insert.getParent().getParent(); //case 1
				} else {
					
					if(insert == insert.getParent().getLeft()) {
						insert = insert.getParent(); //case 2
						RightRotate(insert); //case 2
					}
					
					insert.getParent().setColor(1); //case 3
					insert.getParent().getParent().setColor(0); //case 3
					LeftRotate(insert.getParent().getParent()); //case 3	
				}
			}
		}
		
		this.root.setColor(1);
	}
	
	/**
	 * 
	 * @param x
	 */
	private void LeftRotate(Node x) 
	{
		Node y = x.getRight();
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
		
	}
	
	/**
	 * 
	 * @param x
	 */ 
	private void RightRotate(Node x) {
		
		Node y = x.getLeft();
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
	}

	/**
	 * Deleting a node from a RB Tree
	 * @param z is the node you want to delete from the RB Tree
	 */
	public void RBDelete(Node z) {
		
		Node x;
		Node y = z;
		int yOrigColor = y.getColor();
		
		if(z.getLeft() == this.nil) {
			x = z.getRight();
			RBTransplant(z, z.getRight());
		} 
		else if(z.getRight() == this.nil) {
			x = z.getLeft();
			RBTransplant(z, z.getLeft());
		} 
		else {
			y = Minimum(z.getRight());
			yOrigColor = y.getColor();
			x = y.getRight();
			
			if(y.getParent() == z) {
				x.setParent(y);
			} 
			else {
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
	}
	
	/**
	 * Returns the minimum key-value from a subtree rooted at the node x 
	 * @param x is the node at the root of the subtree you are finding the minimum key-value for
	 * @return
	 */
	private Node Minimum(Node x) {
		
		while(x.getLeft() != this.nil) {
			x = x.getLeft();
		}
		
		return x;
	}


	/**
	 * Recoloured nodes and rotated to make sure that red-black properties hold for new tree.
	 * @param z
	 */
	private void RBDeleteFixup(Node z) {
		while (z != this.getRoot() && z.getColor() == 1) 
		{
			if (z == z.getParent().getLeft()) 
			{
				Node w = z.getParent().getRight();
				if (w.getColor() == 0) 
				{
					w.setColor(1); //Case 1
					z.getParent().setColor(0); //Case 1
					LeftRotate(z.getParent()); //Case 1
					w = z.getParent().getRight(); //Case 1
				}
				if (w.getLeft().getColor() == 1 && w.getRight().getColor() == 1)
				{
					w.setColor(0); //Case 2
					z = z.getParent(); //Case 2
				}
				else 
				{
					if (w.getRight().getColor() == 1) 
					{
						w.getLeft().setColor(1); //Case 3
						w.setColor(0); //Case 3
						RightRotate(w); //Case 3
						w = z.getParent().getRight(); //Case 3
					}
					w.setColor(z.getParent().getColor()); //Case 4
					z.getParent().setColor(1); //Case 4
					w.getRight().setColor(1); //Case 4
					LeftRotate(z.getParent()); //Case 4
					z = this.getRoot(); //Case 4
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
	private void RBTransplant(Node u, Node v) 
	{
		if (u.getParent() == this.getNILNode()) 
		{
			this.root = v;
		}
		else if (u == u.getParent().getLeft()) 
		{
			u.getParent().setLeft(v);
		}
		else 
		{
			u.getParent().setRight(v);
		}
		v.setParent(u.getParent());
	}
	
	public void updateNode(RBTree tree, Node node) {
		
		if(node == tree.getNILNode()) {
			node.setMaxVal(tree);
			return;
		}
		else {
			updateNode(tree, node.getLeft());
			updateNode(tree, node.getRight());
			node.setVal(this, node);
			node.setMaxVal(this);
		}
	}
}
