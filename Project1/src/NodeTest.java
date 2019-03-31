import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	
	// Instance variables
//    private Node node1;
//    private Node node2;
//    private Node node3;
//    
//    private Endpoint end1;
	
	private RBTree rb;

    @Before
    public void initialize() {
    	
    		int points[][] = {{0, 4}, {1, 6}, {3, 9}, {7, 11}};
		Intervals interval = new Intervals();
		this.rb = interval.getRBTree();
		
		for(int i=0; i<points.length; i++) {
			interval.intervalInsert(points[i][0], points[i][1]);
		}
    }
    
    @Test
    public void testTreeSetUp() {
    		assertEquals(this.rb.getRoot().getKey(), 4);
    		assertEquals(this.rb.getRoot().getLeft().getKey(), 1);
    		assertEquals(this.rb.getRoot().getRight().getKey(), 7);
    }
    
    
    
//    @Test
//    public void getParentTest() {
//    	node1.setParent(node2);
//    	assertEquals(node2, node1.getParent());
//    }
//    
//    @Test
//    public void getLeft() {
//    	node2.setLeft(node1);
//    	assertEquals(node1, node2.getLeft());
//    	
//    }
//    
//    @Test
//    public void getRightTest() {
//    	node2.setRight(node3);
//    	assertEquals(node3, node2.getRight());
//    }
//    
//    @Test
//    public void getKeyTest() {
//    	node1.setKey(5);
//    	assertEquals(5, node1.getKey());
//    }
//    
//    @Test
//    public void getPTest() {
//    	node1.setP(-1);
//    	assertEquals(-1, node1.getP());
//    }
//    
//    @Test
//    public void getValTest() {
//    	
//    }
//    
//    @Test
//    public void getMaxVal(){
//    	//TODO
//    }
//    
//    @Test
//    public void getEndpoint(){ //Double check if this done right
//    	node1.setEndpoint(end1);
//    	assertEquals(end1, node1.getEndpoint());
//    	
//    }
//    
//    @Test
//    public void getEmax(){
//    	//TODO
//    }
//    
//    @Test
//    public void getColor(){
//    	node1.setColor(0);
//    	node2.setColor(1);
//    	assertEquals(0, node1.getColor());
//    	assertEquals(1, node2.getColor());
//    }
    
}
