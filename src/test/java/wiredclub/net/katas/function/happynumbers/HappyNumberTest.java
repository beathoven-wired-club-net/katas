package wiredclub.net.katas.function.happynumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

	@Test
	public void calculateSumOfDigitSquares() {
		assertEquals(14, new HappyNumber().calculateSumOfDigitSquares(123));
	}

	/**
	 * @see <a href="https://mathworld.wolfram.com/HappyNumber.html">Happy number</a>
	 */
	@Test
	public void isHappyNumber() {
		assertTrue(new HappyNumber().isHappyNumber(1));
		assertFalse(new HappyNumber().isHappyNumber(2));
		assertFalse(new HappyNumber().isHappyNumber(3));
		assertFalse(new HappyNumber().isHappyNumber(4));
		assertFalse(new HappyNumber().isHappyNumber(5));
		assertFalse(new HappyNumber().isHappyNumber(6));
		assertTrue(new HappyNumber().isHappyNumber(7));
		assertFalse(new HappyNumber().isHappyNumber(8));
		assertFalse(new HappyNumber().isHappyNumber(9));
		assertTrue(new HappyNumber().isHappyNumber(10));
		assertFalse(new HappyNumber().isHappyNumber(11));
		assertFalse(new HappyNumber().isHappyNumber(12));
		assertTrue(new HappyNumber().isHappyNumber(13));
		assertFalse(new HappyNumber().isHappyNumber(14));
		assertFalse(new HappyNumber().isHappyNumber(15));
		assertFalse(new HappyNumber().isHappyNumber(16));
		assertFalse(new HappyNumber().isHappyNumber(17));
		assertFalse(new HappyNumber().isHappyNumber(18));
		assertTrue(new HappyNumber().isHappyNumber(19));
		assertFalse(new HappyNumber().isHappyNumber(20));
	}

}


