package wiredclub.net.katas.function.russianpawnmultiplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RussianPawnMultiplication {

	private static final Logger LOG = LoggerFactory.getLogger(RussianPawnMultiplication.class);

	public static void main(String[] args) {
		new RussianPawnMultiplication().run();
	}

	public RussianPawnMultiplication() {
	}

	public void run() {
		System.out.println("\nRussian Pawn Multiplication");
		System.out.println("47 * 42 = " + mul(47, 42));
	}

	int mul(int x, int y) {
		int sum = 0;

		while (x > 0) {
			if (x % 2 == 1) {
				sum += y;
			}

			x = x >> 1;
			y = y << 1;

			// LOG.debug("x: {} | y: {} | sum: {}", x, y, sum);
		}

		return sum;
	}
}
