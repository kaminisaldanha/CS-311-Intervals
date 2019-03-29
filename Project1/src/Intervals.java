
public class Intervals {

	private int intervalID;
	private RBTree rbtree;
	
	public Intervals(){
		this.intervalID = 0;
		this.rbtree = new RBTree();
	}
	
	public void intervalInsert(int a, int b){
		
		Node node1 = new Node();
		node1.setKey(a);
		
		Node node2 = new Node();
		node2.setKey(b);
		
		this.intervalID++;
		
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
