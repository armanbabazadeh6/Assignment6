import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DayTestStudent {

	@Test
	void test() {
		assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
		assertEquals(Day.TUESDAY, Day.valueOf("TUESDAY"));
		assertEquals(Day.WEDNESDAY, Day.valueOf("WEDNESDAY"));
		assertEquals(Day.THURSDAY, Day.valueOf("THURSDAY"));
		assertEquals(Day.FRIDAY, Day.valueOf("FRIDAY"));
		assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"));
		assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"));
	}

}
