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
    
    @Test
	public void addTest1() {
		
    		Node node1 = new Node(4, 0, 0);
    		Node node2 = new Node(5, 0 ,0);
    		
    		tree.RBInsert(node1);
    		tree.RBInsert(node2);
    		
    		assertEquals(tree.getSize(), 2);
    		assertEquals(tree.getRoot().getKey(), 4);
//    		assertEquals(tree.getRoot().getColor(), 1);
    	
	}
	

}
