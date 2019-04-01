import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RBTreeTests {
	
	// Instance variables
    private RBTree tree;
	private Intervals interval;


//    @Before
//    public void initialize() {
//    	
//    	int points[][] = {{0, 4}, {1, 6}, {3, 9}, {7, 11}};
//		this.interval = new Intervals();
//		this.tree = interval.getRBTree();
//		
//		for(int i=0; i<points.length; i++) {
//			interval.intervalInsert(points[i][0], points[i][1]);
//		}
//    }


    /**
     * Initially, there should be only nil nodes. Height and size are 0.
     */
   
    @Test
    public void rootTest() {
		assertEquals(tree.getRoot(), tree.getNILNode());
		assertEquals(tree.getHeight(), 0);
		assertEquals(tree.getSize(), 0);
    }
    
    /**
     * Adding 3 nodes to a red black tree. Root should have a key of 4 (color: black), root.left 
     * should have a key of 3 (color: red) and root.right should have a key of 5 (color: red).
     * Size is 3. Height should be 1. 
     */
    
    @Test
	public void addTest1() {
		
    		Node node1 = new Node(4, 0, 0);
    		Node node2 = new Node(5, 0 ,0);
    		Node node3 = new Node(3, 0, 0);
    		
    		tree.RBInsert(node1);
    		tree.RBInsert(node2);
    		tree.RBInsert(node3);
    		
    		assertEquals(tree.getSize(), 3);
    		assertEquals(tree.getRoot().getKey(), 4);
    		assertEquals(tree.getRoot().getColor(), 1);
    		assertEquals(tree.getRoot().getRight().getKey(), 5);
    		assertEquals(tree.getRoot().getRight().getColor(), 0);
    		assertEquals(tree.getRoot().getLeft().getKey(), 3);
    		assertEquals(tree.getRoot().getLeft().getColor(), 0);
	}
    
    /**
     * Adding 4 nodes to a red black tree.Root should have a key of 4 (color: black), root.left 
     * should have a key of 3 (color: black), root.right should have a key of 5 (color: black)
     * and root.right.right should have a key of 6 (color: red). Size is 4 and height should be 2.
     */
    @Test
    public void addTest2() {
    
 		Node node1 = new Node(4, 0, 0);
		Node node2 = new Node(5, 0 ,0);
		Node node3 = new Node(3, 0, 0);
		Node node4 = new Node(2, 0, 0);
		
		tree.RBInsert(node1);
		tree.RBInsert(node2);
		tree.RBInsert(node3);
		tree.RBInsert(node4);
		
		assertEquals(tree.getSize(), 4);
		assertEquals(tree.getHeight(), 3);
 		assertEquals(tree.getRoot().getKey(), 4);
		assertEquals(tree.getRoot().getColor(), 1);
		assertEquals(tree.getRoot().getLeft().getKey(), 3);
		assertEquals(tree.getRoot().getLeft().getColor(), 1);
		assertEquals(tree.getRoot().getLeft().getLeft().getKey(), 2);
		assertEquals(tree.getRoot().getLeft().getLeft().getColor(), 0);
		assertEquals(tree.getRoot().getRight().getKey(), 5);
		assertEquals(tree.getRoot().getRight().getColor(), 1);
    }
    
    @Test
    public void addTest3() {
    	
	    	Node node1 = new Node(0, 0, 0);
		Node node2 = new Node(4, 0 ,0);
		Node node3 = new Node(1, 0, 0);
		Node node4 = new Node(6, 0, 0);
		Node node5 = new Node(3, 0, 0);
		Node node6 = new Node(9, 0, 0);
		Node node7 = new Node(7, 0, 0);
		Node node8 = new Node(11, 0, 0);
		
		tree.RBInsert(node1);
		tree.RBInsert(node2);
		tree.RBInsert(node3);
		tree.RBInsert(node4);
		tree.RBInsert(node5);
		tree.RBInsert(node6);
		tree.RBInsert(node7);
		tree.RBInsert(node8);
    	
    }
    
    @Test
	public void testHeight() {
		Intervals intervals = new Intervals();

		//initial
		tree = intervals.getRBTree();
		assertEquals(0, tree.getHeight());

		// first insertion
		intervals.intervalInsert(0, 4); 
		tree = intervals.getRBTree();
		assertEquals(2, tree.getHeight());

		// second insertion
		intervals.intervalInsert(1, 6); 
		tree = intervals.getRBTree();
		assertEquals(3, tree.getHeight());

		// third insertion
		intervals.intervalInsert(3, 9);
		tree = intervals.getRBTree();
		assertEquals(4, tree.getHeight());

		// fourth insertion
		intervals.intervalInsert(7, 11);
		tree = intervals.getRBTree();
		assertEquals(4, tree.getHeight());

	}
    
    @Test
	public void testSize() {
		Intervals intervals = new Intervals();

		// initial 
		tree = intervals.getRBTree();
		assertEquals(0, tree.getSize());

		// first insertion
		intervals.intervalInsert(0, 4); 
		tree = intervals.getRBTree();
		assertEquals(2, tree.getSize());

		// second insertion
		intervals.intervalInsert(1, 6); 
		tree = intervals.getRBTree();
		assertEquals(4, tree.getSize());

		// third insertion
		intervals.intervalInsert(3, 9);
		tree = intervals.getRBTree();
		assertEquals(6, tree.getSize());

		// fourth insertion
		intervals.intervalInsert(7, 11);
		tree = intervals.getRBTree();
		assertEquals(8, tree.getSize());
	}

    @Test
    public void simpleDelete() {
    	
    	tree = new RBTree();
    	
    	Node node1 = new Node(0, 0, 0);
		Node node2 = new Node(4, 0 ,0);
		Node node3 = new Node(1, 0, 0);
		Node node4 = new Node(6, 0, 0);

    	

        // Create simple tree
	    tree.RBInsert(node1);
        tree.RBInsert(node2);
        tree.RBInsert(node3);
        tree.RBInsert(node4);

        // Delete root.left
        tree.RBDelete(node2);

        // Test tree keys
        assertEquals(3, tree.getRoot().getKey());
        assertEquals(1, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getRight().getKey());

        // Test tree parents
        //assertTrue(tree.getRoot().getParent().isNil());
        assertEquals(3, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(3, tree.getRoot().getRight().getParent().getKey());
       
        // Test size
       // assertEquals(3, tree.getSize());
    }

}
