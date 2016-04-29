import static org.junit.Assert.*;

import org.junit.Test;

public class GreatDistanceTest {

	@Test
	public void distanceTest() {
		double result = CalendarEvent.greatCircleDistance(21.315902,-157.803327,21.285002,-157.835698);
		assertEquals(Double.doubleToLongBits(2.976789541640794),Double.doubleToLongBits(result));//miles
		assertEquals(Double.doubleToLongBits(4.790687580090436),Double.doubleToLongBits(result/0.62137));//kilometers
	}

}
