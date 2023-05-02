import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SizeTestStudent {

	@Test
	public void testValues() {
		Size[] expectedValues = { Size.SMALL, Size.MEDIUM, Size.LARGE };
		assertArrayEquals(expectedValues, Size.values());
	}

	@Test
	public void testValueOf() {
		assertEquals(Size.SMALL, Size.valueOf("SMALL"));
		assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"));
		assertEquals(Size.LARGE, Size.valueOf("LARGE"));
		try {
			Size.valueOf("EXTRA_LARGE");
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("No enum constant Size.EXTRA_LARGE", e.getMessage());
		}
		try {
			Size.valueOf(null);
			fail("Expected NullPointerException to be thrown");
		} catch (NullPointerException e) {
			assertEquals("Name is null", e.getMessage());
		}
	}
}
