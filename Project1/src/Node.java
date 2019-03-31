/**
* Represent's the nodes of the red-black tree.
* 
* @author Smruthi Sandhanam, Meghna Vaidya, and Kamini Saldanha
* 
*/
  
public class Node {
	
	private Node right, left, parent; 
	private int key, p, val, maxval, color;
	private Endpoint endpoint, emax;
	private RBTree tree;
	
	public Node(int key, int p, int ID){
		this.parent = null;
        this.left = null;
        this.right = null;
        this.key = key;
        this.p = p;
        this.val = this.calculateVal(this); 
        this.endpoint = new Endpoint(key, p);
        this.emax = null;
        this.color = 0;
	}

	/**
	 * Returns the parent of this node.
	 * @return
	 */
	public Node getParent(){
		return this.parent;
	}
	
	/**
	 * 
	 * @param sets the parent.
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * Returns the left child.
	 * @return
	 */
	public Node getLeft(){
		return left;
	}
	
	/**
	 * 
	 * @param sets the left child.
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 * Returns the right child.
	 * @return
	 */
	public Node getRight(){
		return right;
	}
	
	/**
	 * 
	 * @param sets the right child.
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	
	/**
	 * Returns the endpoint value, which is an integer.
	 * @return
	 */
	public int getKey(){
		return key;
	}
	
	/**
	 * 
	 * @param sets the endpoint value to the key.
	 */
	public void setKey(int key){
		this.key = key;
	}
	
	/**
	 * Returns the value of the function p based on this endpoint.
	 * @return
	 */
	public int getP(){
		return p;
	}
	
	/**
	 * 
	 * @param sets the value of the function p based on this endpoint
	 */
	public void setP(int p){
		this.p = p;
	}
	
	/**
	 * Returns the val of the node as described in this assignment.
	 * @return
	 */
	public int getVal(){
		return this.val;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public void setVal(Node node) {
		this.val = calculateVal(node);
	}
	
	//READ-ME: test this
	private int calculateVal(Node node) {
		
		int sum, leftSum, rightSum;
		
		//if no node p is 0
		if(node == tree.getNILNode()) {
			return 0;
		}
		
		//find P's in subtree
		leftSum = calculateVal(node.left);
		rightSum = calculateVal(node.right);
		
		//add all p's together
		sum = leftSum + rightSum + node.getP();
		return sum;
	}
	
	/**
	 * Returns the maxval of the node as described in this assignment.
	 * @return
	 */
	public int getMaxVal(){
		return maxval;
	}
	
	/**
	 * 
	 * @param sets the maxval of the node as described in this assignment.
	 */
	public void setMaxVal(int val) {
		this.maxval = val;
	}
	
	public void calculateMaxVal(Node v) {
		
		if(v == tree.getNILNode()) {
			v.maxval = 0;
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
			} else {
				this.emax = v.right.emax;
			}
			
			calculateMaxVal(v.left);
			calculateMaxVal(v.right);
		}
	}
	
	/**
	 * Returns the Endpoint object that this node represents.
	 * @return
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
	 * Returns an Endpoint object that represents emax. Calling this
	 * method on the root node will give the Endpoint object whose getValue() provides a
	 * point of maximum overlap..
	 * @return
	 */
	public Endpoint getEmax(){
		return emax;
	}
	
	/**
	 * 
	 * @param sets the Endpoint object that represents emax
	 */
	public void setEmax(Endpoint emax) {
		this.emax = emax;
	}

	private Endpoint calculateEmax(Node v) {
			return null;
	}
	/**
	 * Returns 0 if red. Returns 1 if black.
	 * @return
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
	 * @param sets the color to either 0 if red, or 1 if black
	 */
	public void setColor(int color){
			this.color = color;
	}
	
}

