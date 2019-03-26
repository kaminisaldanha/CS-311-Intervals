
public class Node {
	//Returns the parent of this node
	public Node getParent(){
		return null;
	}
	
	//Returns the left child
	public Node getLeft(){
		return null;
	}
	
	//Returns the right child
	public Node getRight(){
		return null;
	}
	
	//Returns the endpoint value, which is an integer
	public int getKey(){
		return -1;
	}
	
	//Returns the value of the function p based on this endpoint
	public int getP(){
		return -1;
	}
	
	//Returns the val of the node as described in this assignment
	public int getVal(){
		return -1;
	}
	
	//Returns the maxval of the node as described in this assignment
	public int getMaxVal(){
		return -1;
	}
	
	//Returns the Endpoint object that this node represents.
	public Endpoint getEndpoint(){
		return null;
	}
	
	//Returns an Endpoint object that represents emax. Calling this method on the root node 
	//will give the Endpoint object whose getValue() provides a point of maximum overlap
	public Endpoint getEmax(){
		return null;
	}
	
	//Returns 0 if red. Returns 1 if black
	public int getColor(){
		return -1;
	}
	
}

