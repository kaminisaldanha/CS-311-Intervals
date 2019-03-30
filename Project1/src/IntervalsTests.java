import static org.junit.Assert.*;

import org.junit.Test;

public class IntervalsTests {

	@Test
	public void IntervalsTest1() {
		
		Intervals interval = new Intervals();
		interval.intervalInsert(0, 4);
		System.out.println(interval.getRBTree().getSize());
		//assertEquals(interval.getRBTree().getSize(), 2);
	}

}
