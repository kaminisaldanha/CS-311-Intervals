import org.junit.Test;

import static org.junit.Assert.*;

public class endpointTests {
	private RBTree rb;


    @Test
    public void testGetValue() {
        Endpoint endpoint = new Endpoint(4, -1);
        assertEquals(4, endpoint.getValue());
    }

    @Test
    public void testGetP() {
        Endpoint endpoint = new Endpoint(4, -1);
        assertEquals(-1, endpoint.getP());
    }
    
    @Test
	public void testP() {
		Intervals intervals = new Intervals();

		intervals.intervalInsert(0, 4); 
		intervals.intervalInsert(1, 6); 
		intervals.intervalInsert(3, 9);
		intervals.intervalInsert(7, 11);
		rb = intervals.getRBTree();
		assertEquals(-1, rb.getRoot().getP());
		assertEquals(1, rb.getRoot().getLeft().getP());
		assertEquals(1, rb.getRoot().getLeft().getLeft().getP());
		assertEquals(1, rb.getRoot().getLeft().getRight().getP());
		assertEquals(1, rb.getRoot().getRight().getP());
		assertEquals(-1, rb.getRoot().getRight().getLeft().getP());
		assertEquals(-1, rb.getRoot().getRight().getRight().getP());
		assertEquals(-1, rb.getRoot().getRight().getRight().getRight().getP()); 
	}

}