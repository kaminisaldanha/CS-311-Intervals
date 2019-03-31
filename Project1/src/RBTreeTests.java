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
