package wiredclub.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzz {

	private static final Logger LOG = LoggerFactory.getLogger(FizzBuzz.class);

	public static final String FIZZ = "Fizz";
	public static final String BUZZ = "Buzz";

	private static final int N = 100;

	final boolean[] fizz = new boolean[N + 1];
	final boolean[] buzz = new boolean[N + 1];

	public FizzBuzz() {
		original();
		alternative();
	}

	public void original() {
		System.out.println("\nFizzBuzz Original");
		markAllDividers();
		out();
	}

	void markAllDividers() {
		markAllNumbersDividesDigit(3, fizz);
		markAllNumbersDividesDigit(5, buzz);
	}

	private void markAllNumbersDividesDigit(int inc, boolean[] values) {
		for (int i = 0; i <= N; i = i + inc) {
			values[i] = true;
		}
	}

	private void out() {
		for (int i = 1; i <= N; i++) {
			if (fizz[i] || buzz[i]) {
				System.out.println((fizz[i] ? FIZZ : "") + (buzz[i] ? BUZZ : ""));
			} else {
				System.out.println(i);
			}
		}
	}


	// ----- ALTERNATIVE -----

	public void alternative() {
		System.out.println("\nFizzBuzz Alternative");
		markAllDividers();
		markAllNumbersContainsDigits();
		out();
	}

	void markAllNumbersContainsDigits() {
		markAllNumbersContainsDigit(3, fizz);
		markAllNumbersContainsDigit(5, buzz);
	}

	private void markAllNumbersContainsDigit(int digit, boolean[] values) {
		String d = String.valueOf(digit);
		// LOG.debug("digit as string: {}", d);
		for (int i = 0; i <= N; i++) {
			if (containsDigit(i, d)) {
				values[i] = true;
			}
		}
	}

	boolean containsDigit(int number, String digit) {
		String n = String.valueOf(number);
		// LOG.debug("number as string: {}", n);
		return n.contains(digit);
	}

}
