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
        intervals = new Intervals();
        ExamplefromAssignment();
        assertEquals(3, intervals.findPOM());
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
