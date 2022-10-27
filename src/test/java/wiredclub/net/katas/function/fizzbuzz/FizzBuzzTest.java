package wiredclub.net.katas.function.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

	@Test
	public void markAllDividers() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		fizzBuzz.markAllDividers();

		for (int i = 0; i <= 100; i++) {
			assertEquals(i % 3 == 0, fizzBuzz.fizz[i]);
			assertEquals(i % 5 == 0, fizzBuzz.buzz[i]);
		}
	}

	@Test
	public void markAllNumbersContainsDigits() {
		FizzBuzzAlternative fizzBuzz = new FizzBuzzAlternative();
		fizzBuzz.markAllNumbersContainsDigits();

		for (int i = 0; i <= 100; i++) {
			String number = String.valueOf(i);

			assertEquals(number.contains("3"), fizzBuzz.fizz[i]);
			assertEquals(number.contains("5"), fizzBuzz.buzz[i]);
		}
	}
}