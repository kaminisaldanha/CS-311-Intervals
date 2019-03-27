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
	private int red = 0;
	
	public Node getParent(){
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public int getKey(){
		return key;
	}
	
	public void setKey(int key){
		this.key = key;
	}
	
	public int getP(){
		return p;
	}
	
	public void setP(int p){
		this.p = p;
	}
	
	public int getVal(){
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public int getMaxVal(){
		return maxval;
	}
	
	public void setMaxVal(int maxval) {
		this.maxval = maxval;
	}
	
	public Endpoint getEndpoint(){
		return endpoint;
	}
	public void setEndpoint(Endpoint endpoint){
		this.endpoint = endpoint;
	}
	
	public Endpoint getEmax(){
		return emax;
	}
	
	public void setEmax(Endpoint emax) {
		this.emax = emax;
	}
	
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

