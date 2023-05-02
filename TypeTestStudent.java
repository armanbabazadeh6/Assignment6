import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TypeTestStudent {

	/**
	 * This test values
	 */
	@Test
	public void testValues() {
		Type[] values = Type.values();
		assertEquals(3, values.length);
		assertEquals(Type.SMOOTHIE, values[0]);
		assertEquals(Type.COFFEE, values[1]);
		assertEquals(Type.ALCOHOL, values[2]);
	}

	/**
	 * And this will testValuesOf
	 */
	@Test
	public void testValueOf() {
		assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"));
		assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
		assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"));
	}

}
