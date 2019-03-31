import static org.junit.Assert.*;

import org.junit.Test;

public class IntervalTest {
	private RBTree rb;
	
	@Test
    public void testFindPOM() { //Doesn't work
		Intervals intervals = new Intervals();

		// Simple test
        intervals.intervalInsert(1, 3);
        intervals.intervalInsert(2, 4);
        assertEquals(2, intervals.findPOM());
        intervals.intervalInsert(6, 10);
        intervals.intervalInsert(5, 11);
        intervals.intervalInsert(6, 8);
        assertEquals(6, intervals.findPOM());

        // Test from example
		Intervals interval = new Intervals();
		interval.intervalInsert(0, 4);
		interval.intervalInsert(1, 6);
		interval.intervalInsert(3, 9);
		interval.intervalInsert(7, 11);
		assertEquals(3, interval.findPOM());
	}
	
	private void ExamplefromAssignment(){
    	int points[][] = {{0, 4}, {1, 6}, {3, 9}, {7, 11}};
		Intervals interval = new Intervals();
		this.rb = interval.getRBTree();
		
		for(int i=0; i<points.length; i++) {
			interval.intervalInsert(points[i][0], points[i][1]);
		}
	}
	
	

}
