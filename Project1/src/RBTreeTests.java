import static org.junit.Assert.*;

import org.junit.Test;

public class RBTreeTests {
	
	// Instance variables
    private RBTree tree;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;
    private Node node6;

    public void initialize() {
        tree = new RBTree();
        node1 = new Node(new Endpoint(1, 1));
        node2 = new Node(new Endpoint(2, 1));
        node3 = new Node(new Endpoint(3, 1));
        node4 = new Node(new Endpoint(4, 1));
        node5 = new Node(new Endpoint(5, 1));
        node6 = new Node(new Endpoint(6, 1));
    }


    @Test
    public void testGetRoot() {

        
		// Root should initially be NIL

        // Insert node, which is new root
        tree.RBInsert(node1);
        assertEquals(tree.getRoot().getKey(), 1);

        // New insert keeps the same root as before
        tree.RBInsert(node2);
        assertEquals(tree.getRoot().getKey(), 1);

        // Rotation results in new root
        tree.RBInsert(node3);
        assertEquals(tree.getRoot().getKey(), 2);
    }
    
	/**
	 * Checks if the tree is set up properly 
	 */
	@Test
	public void rootSetupCheck() {
		//creating the tree
		RBTree rbtree = new RBTree();
		//checks that the color of the root is black
		assertEquals(rbtree.getRoot().getColor(), 1);
		//checks that the size of the tree is initially 1
		assertEquals(rbtree.getSize(), 1);
		//checks that the height of the tree is initially 0
		assertEquals(rbtree.getHeight(), 0);
	}
	
	@Test
	public void addNodeTest1() {
		
		
		
	}
	

}
