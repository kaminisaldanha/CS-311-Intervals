
public class Intervals {

	private int intervalID;
	private RBTree rbtree;
	
	public Intervals(){
		this.intervalID = 0;
		this.rbtree = new RBTree();
	}
	
	/**
	 * Adds the interval with the left endpoint a and right endpoint b to the collection of intervals. Each newly assigned interval 
	 * is assigned a ID which is consecutive (i.e. the ID of the interval on the ith call should be i) 
	 * @param a is the left endpoint a to be added to the collection of intervals into the red black tree
	 * @param b is the right endpoint a to be added to the collection of intervals into the red black tree
	 */
	public void intervalInsert(int a, int b){
		
		Node node1 = new Node();
		node1.setKey(a);
		node1.setP(1); //it is the left endpoint
		
		Node node2 = new Node();
		node2.setKey(b);
		node2.setP(-1); //it is the right endpoint
		
		//every interval should be assigned a new ID
		this.intervalID++;
		
		//adding nodes into RBTree
		rbtree.RBInsert(node1);
		rbtree.RBInsert(node2);
	}
	
	public boolean intervalDelete(int intervalID){
		return false;
	}
	
	public int findPOM(){
		
		
		return -1;	
	}
	
	public RBTree getRBTree(){
		return rbtree;
	}
}
