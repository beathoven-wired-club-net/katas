package wiredclub.net.katas.function.russianpawnmultiplication;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class RussianPawnMultiplicationTest {

	private static final Logger LOG = LoggerFactory.getLogger(RussianPawnMultiplicationTest.class);

	@Test
	public void mul() {
		RussianPawnMultiplication rpw = new RussianPawnMultiplication();
		assertEquals(47 * 42, rpw.mul(47, 42));

		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				int actual = rpw.mul(x, y);
				LOG.debug("x: {} | y: {} | sum: {}", x, y, actual);
				assertEquals(x * y, actual);
			}
		}
	}
}