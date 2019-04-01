import java.util.ArrayList;
import java.util.List;

public class Intervals {
	
	/**
	 * Value of intervalID
	 */
	private int intervalID;
	
	/**
	 * Red-Black tree used
	 */
	public RBTree rbtree;
	
	/**
	 * Intervals constructor, set intervalID and tree
	 */
	public Intervals(){
		this.intervalID = 1;
		this.rbtree = new RBTree();
	}
	
	/**
	 * Adds the interval with the left endpoint a and right endpoint b to the collection of intervals. Each newly assigned interval 
	 * is assigned a ID which is consecutive (i.e. the ID of the interval on the ith call should be i) 
	 * @param a is the left endpoint a to be added to the collection of intervals into the red black tree
	 * @param b is the right endpoint a to be added to the collection of intervals into the red black tree
	 */
	public void intervalInsert(int a, int b){
		
		//intializing node
		Node node1 = new Node(a, 1, this.intervalID); //left endpoint
		Node node2 = new Node(b, -1, this.intervalID); //right endpoint 
		
		//every interval should be assigned a new ID
		this.intervalID++;
		
		//adding nodes into RBTree
		rbtree.RBInsert(node1);
		rbtree.RBInsert(node2);
		//updating val, maxVal, emax for all nodes
		rbtree.updateNode(rbtree, rbtree.getRoot());

	}
	
	/**
	 *  Deletes the interval whose ID is intervalID. 
	 *  Returns true if deletion was successful.
	 * @param intervalID
	 * @return
	 */
	public boolean intervalDelete(int intervalID){
		
		List<Node> toDelete = new ArrayList<Node>();
		findID(rbtree.getRoot(), intervalID, toDelete);
		
		if(toDelete.size() == 0) {return false;} 
		else {
			rbtree.RBDelete(toDelete.get(0));
			rbtree.RBDelete(toDelete.get(1));
			rbtree.updateNode(rbtree, rbtree.getRoot());
			return true;
		}
	}

	/**
	 * Finds the endpoint that has maximum overlap and returns its value. 
	 * @return
	 */
	public int findPOM(){
		return getRBTree().getRoot().getEmax().getValue();	
	}
	
	/**
	 * Returns the red-black tree used, which is an object of type RBTree.
	 * @return
	 */
	public RBTree getRBTree(){
		return rbtree;
	}
	
	/**
	 * Suggest method for testing
	 * @param args
	 */
	public static void main(String [] args) {
		int points[][] = {{0, 4}, {1, 6}, {3, 9}, {7, 11}};
		Intervals intv = new Intervals();
		
		for(int i=0; i<points.length; i++) {
			//System.out.println("Inserting: "+ Arrays.toString(points[i]));
			intv.intervalInsert(points[i][0], points[i][1]);
		}
		System.out.println("POM is: "+ intv.findPOM()); //Should return 3.
	}
	
	/**
	 * Helper method for intervalDelee
	 * @param node - node to start the recursive method
	 * @param ID - interval node id to fine
	 * @param toDelete - list of nodes of tree to delete
	 */
	private void findID(Node node, int ID, List<Node> toDelete) 
	{
		if(node == rbtree.getNILNode()) {
			return;
		} else {
			
			if(node.getIntervalID() == ID) {
				toDelete.add(node);
			}
			
			findID(node.getLeft(), ID, toDelete);
			findID(node.getRight(), ID, toDelete);
			
			
		}	
	}
	
}
