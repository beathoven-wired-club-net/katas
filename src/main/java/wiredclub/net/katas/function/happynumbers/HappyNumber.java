package wiredclub.net.katas.function.happynumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	private static final Logger LOG = LoggerFactory.getLogger(HappyNumber.class);

	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Happy_number">Happy number</a>
	 */
	private static final Set<Integer> SAD_NUMBERS_LOOP = new HashSet<>();

	static {
		SAD_NUMBERS_LOOP.add(4);
		SAD_NUMBERS_LOOP.add(16);
		SAD_NUMBERS_LOOP.add(37);
		SAD_NUMBERS_LOOP.add(58);
		SAD_NUMBERS_LOOP.add(89);
		SAD_NUMBERS_LOOP.add(145);
		SAD_NUMBERS_LOOP.add(42);
		SAD_NUMBERS_LOOP.add(20);
	}

	public static void main(String[] args) {
		new HappyNumber().run();
	}

	public HappyNumber() {
	}

	private void run() {
		int number = 19;
		System.out.println(number + " is a " + (isHappyNumber(number) ? "happy" : "sad") + " number");
	}

	boolean isHappyNumber(int number) {
		while (number > 1 && !SAD_NUMBERS_LOOP.contains(number)) {
			number = calculateSumOfDigitSquares(number);
		}
		return number == 1;
	}

	int calculateSumOfDigitSquares(int number) {
		String n = String.valueOf(number);

		int sum = 0;
		for (char c : n.toCharArray()) {
			int digit = c - '0';
			sum += digit * digit;
		}

		return sum;
	}
}
