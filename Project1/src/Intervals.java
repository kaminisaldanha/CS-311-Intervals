
public class Intervals {

	private int intervalID;
	public RBTree rbtree;
	
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
		
		//setting the val for node 1 and 2
//		node1.setVal(rbtree, node1); 
//		node2.setVal(rbtree, node2); 
		
		//every interval should be assigned a new ID
		this.intervalID++;
		
		//adding nodes into RBTree
		rbtree.RBInsert(node1);
		rbtree.RBInsert(node2);
		//updating val, maxVal, emax for all nodes
		rbtree.updateNode(rbtree, rbtree.getRoot());

	}
	
	public boolean intervalDelete(int intervalID){
		int intervalToDelete = intervalID;
		
		Node leftEnd = findID(rbtree.getRoot(), intervalToDelete, 1);
		Node rightEnd = findID(rbtree.getRoot(), intervalToDelete, -1);
		
		rbtree.RBDelete(leftEnd);
        rbtree.RBDelete(rightEnd);
        return false;
		
	}
	
	public int findPOM(){
		return getRBTree().getRoot().getEmax().getValue();	
	}
	
	public RBTree getRBTree(){
		return rbtree;
	}
	
	public static void main(String [] args) {
		int points[][] = {{0, 4}, {1, 6}, {3, 9}, {7, 11}};
		Intervals intv = new Intervals();
		
		for(int i=0; i<points.length; i++) {
			//System.out.println("Inserting: "+ Arrays.toString(points[i]));
			intv.intervalInsert(points[i][0], points[i][1]);
		}
		System.out.println("POM is: "+ intv.findPOM()); //Should return 3.
	}
	
	private static Node findID(Node node, int ID, int end) 
	{
		Node intervalIDNode;
		Node nil = null;
		
		if(ID == node.getIntervalID() && end == node.getEndpoint().getP()) 
		{
			intervalIDNode = node;
			return intervalIDNode;
		}
		else {
			
			findID(node.getRight(), ID, end);
			
			findID(node.getLeft(), ID, end);
			
		}
		return null;
	}
	
}
