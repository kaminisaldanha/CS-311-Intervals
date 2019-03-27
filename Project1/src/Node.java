/**
* Represent's the nodes of the red-black tree.
* 
* @author Smruthi Sandhanam, Meghna Vaidya, and Kamini Saldanha
* 
*/
 
//Use 0 and 1 to represent the colors red and black, respectively. 
public class Node {
	
	private Node right, left, parent; 
	private int key, p, val, maxval, color, maxVal;
	private Endpoint endpoint, emax;
	private int red = 0;
	
	
	//Returns the parent of this node
	public Node getParent(){
		return null;
	}
	
	//Returns the left child
	public Node getLeft(){
		return left;
	}
	
	//Sets node to the left
	public void setLeft(Node left) {
		this.left = left;
	}
	
	//Returns the right child
	public Node getRight(){
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	//Returns the endpoint value, which is an integer
	public int getKey(){
		return key;
	}
	
	//Returns the value of the function p based on this endpoint
	public int getP(){
		return p;
	}
	
	//Returns the val of the node as described in this assignment
	public int getVal(){
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	//Returns the maxval of the node as described in this assignment
	public int getMaxVal(){
		return maxval;
	}
	
	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}
	
	//Returns the Endpoint object that this node represents.
	public Endpoint getEndpoint(){
		return endpoint;
	}
	
	//Returns an Endpoint object that represents emax. Calling this method on the root node 
	//will give the Endpoint object whose getValue() provides a point of maximum overlap
	public Endpoint getEmax(){
		return emax;
	}
	
	public void setEmax(Endpoint emax) {
		this.emax = emax;
	}
	
	//Returns 0 if red. Returns 1 if black
	public int getColor(){
		if(color == red){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public void setColor(int color){
			this.color = color;
	}
	
}

