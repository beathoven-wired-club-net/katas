package wiredclub.net.katas.function.fizzbuzz;

public class FizzBuzzAlternative extends FizzBuzz {

	public FizzBuzzAlternative() {
		fizz = new boolean[N + 1];
		buzz = new boolean[N + 1];
	}

	public void run() {
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
		for (int number = 0; number <= N; number++) {
			if (String.valueOf(number).contains(d)) {
				values[number] = true;
			}
		}
	}

}
