/**
* Represent's the nodes of the red-black tree.
* 
* @author Smruthi Sandhanam, Meghna Vaidya, and Kamini Saldanha
* 
*/
  
public class Node {
	
	/**
	 * The right child of this node.
	 */
	private Node right;
	/**
	 * The left child of this node.
	 */
	private Node left;
	/**
	 * The parent of this node
	 */
	private Node parent;
	
	/**
	 * The key is the endpoint value of this node.
	 */
	private int key;
	
	/**
	 * If this node is a left endpoint then p will be +1, if it is a right endpoint p will be 
	 * -1.
	 */
	private int p;
	
	/**
	 * The sum of all the p values of the nodes in the subtree rooted at at this node.
	 */
	private int val;
	
	/**
	 * The maximum value obtained by the the expression s(l, i) for l <= i <= r where l 
	 * where l and r are the indices of the leftmost and rightmost endpoints in the subtree
	 * rooted at the node.
	 */
	private int maxval;
	
	/**
	 * The color of this node. 0 is red and 1 is black.
	 */
	private int color;
	
	/**
	 * The endpoint that this node represents.
	 */
	private Endpoint endpoint;
	
	/**
	 * Reference to an endpoint em where m is the value of i that maximizes s(l, i) over all i 
	 * such that l <= i <= r where l and r denote the leftmost and rightmost indices
	 * of the endpoints in the subtree of this node.
	 */
	private Endpoint emax;
	
	/**
	 * This is the ID of the interval that this node belongs to.
	 */
	private int intervalID;
	
	/**
	 * The constructor for the Node class. 
	 * @param key is the value of the endpoint and key for this node
	 * @param p is the value of p for this node(left endpoint = +1, right endpoint = -1)
	 * @param ID is the intervalID that this node belongs to 
	 */
	public Node(int key, int p, int ID) {
		this.parent = null;
        this.left = null;
        this.right = null;
        this.key = key;
        this.p = p;
        this.endpoint = new Endpoint(key, p);
        this.emax = null;
        this.intervalID = ID;
	}

	/**
	 * 
	 * @return the parent of this node.
	 */
	public Node getParent(){
		return this.parent;
	}
	
	/**
	 * 
	 * @param Sets the parent for this node.
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * 
	 * @return the left child of this node.
	 */
	public Node getLeft(){
		return left;
	}
	
	/**
	 * 
	 * @param Sets the left child of this node.
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 *
	 * @return the right child of this node.
	 */
	public Node getRight(){
		return right;
	}
	
	/**
	 * 
	 * @param Sets the right child of this node.
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	
	/**
	 * 
	 * @return the endpoint value, which is an integer.
	 */
	public int getKey(){
		return key;
	}
	
	/**
	 * Sets the endpoint value (key) to this key
	 * @param key
	 */
	public void setKey(int key){
		this.key = key;
	}
	
	/**
	 * 
	 * @return the value of the function p based on the endpoint of this node.
	 */
	public int getP(){
		return p;
	}
	
	/**
	 * 
	 * @param Sets the value of p based on the endpoint of this node.
	 */
	public void setP(int p){
		this.p = p;
	}
	
	/**
	 * 
	 * @return the val of this node.
	 */
	public int getVal(){
		return this.val;
	}
	
	/**
	 * Sets the val of this node based on the integer calculateVal returns
	 * @param tree is the tree this node belongs to
	 */
	public void setVal(RBTree tree) {
		this.val = calculateVal(tree, this);
	}
	
	/**
	 * Calculates the val for this node.
	 * @param tree is the tree this node belongs to
	 * @param node the node we are calculating the val for
	 * @return the sum of this node's left child val,
	 * right child val and its val.
	 */
	public int calculateVal(RBTree tree, Node node) {
		
		int sum, leftSum, rightSum;
		
		//if no node p is 0
		if(node == null || node == tree.getNILNode()) {
			return 0;
		}
		
		//find P's in subtree
		leftSum = calculateVal(tree, node.left);
		rightSum = calculateVal(tree, node.right);
		
		//add all p's together
		sum = leftSum + rightSum + node.getP();
		return sum;
	}
	
	/**
	 * 
	 * @return the max val for this node.
	 */
	public int getMaxVal(){
		return maxval;
	}
	
	/**
	 * Sets the max val for this node by calling the calculateMaxVal function
	 * @param tree
	 */
	public void setMaxValAndEmax(RBTree tree) {
		calculateMaxValAndEmax(tree, this);
	}
	
	/**
	 * Calculates the maxVal emax based on the on the maximum of the three conditions (v.left.maxval
	 * , v.left.val + v.p, v.left.val + v.p + v.right.maxval where v is the node we are calculating
	 * the maxVal and emax for.
	 * @param tree is the tree this node belongs to.
	 * @param v the node we are calculating
	 * the maxVal and emax for.
	 */
	public void calculateMaxValAndEmax(RBTree tree, Node v) {
		
		if(v == null || v == tree.getNILNode()) {
			v.maxval = 0;
			v.setEmax(tree.getNILNode().getEndpoint());
		} else {
			
			int case1 = v.left.maxval;
			int case2 = v.left.val + v.p;
			int case3 = v.left.val + v.p + v.right.maxval;
			
			int max1 = Math.max(case1, case2);
			int max2 = Math.max(max1, case3);
			v.maxval = max2;
			
			if(max2 == v.left.maxval) {
				this.emax = v.left.emax;
			} else if(max2 == v.left.val + v.p) {
				this.emax = v.endpoint;
			} else 
				this.emax = v.right.emax;
			}
	}
	
	/**
	 * 
	 * @return the Endpoint object that this node represents.
	 */
	public Endpoint getEndpoint(){
		return endpoint;
	}
	
	/**
	 * 
	 * @param sets the Endpoint object that this node represents
	 */
	public void setEndpoint(Endpoint endpoint){
		this.endpoint = endpoint;
	}
	
	/**
	 * Returns an Endpoint object that represents emax. 
	 * @return
	 */
	public Endpoint getEmax(){
		return emax;
	}
	
	/**
	 * Sets an Endpoint object that represents emax for a node.  
	 * @param emax
	 */
	public void setEmax(Endpoint emax) {
		this.emax = emax;
	}
	
	/**
	 *
	 * @return 0 if red. Returns 1 if black.
	 */
	public int getColor(){
		if(color == 0){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	/**
	 * 
	 * @param Sets the color to either 0 if red, or 1 if black.
	 */
	public void setColor(int color){
			this.color = color;
	}
	
	/**
	 * 
	 * @return the interval ID for this node.
	 */
	public int getIntervalID() {
		return this.intervalID;
	}
	
}