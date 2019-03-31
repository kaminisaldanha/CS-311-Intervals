import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RBTreeTests {
	
	// Instance variables
    private RBTree tree;

    @Before
    public void initialize() {
        tree = new RBTree();       
    }


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
    
    
	

}
