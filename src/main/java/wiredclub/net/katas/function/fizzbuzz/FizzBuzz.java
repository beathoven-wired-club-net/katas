package wiredclub.net.katas.function.fizzbuzz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see <a href="https://builtin.com/software-engineering-perspectives/fizzbuzz">How to Solve FizzBuzz</a>
 * <br/>
 * <br/>
 * <b>How to Identify the Best FizzBuzz Solution</b>
 * <br/>
 * <ul>
 * <li>Am I repeating myself?</li>
 * <li>How can I play to the strengths of my chosen language?</li>
 * <li>Is the code I’m writing easy to maintain?</li>
 * </ul>
 * Answering these questions won’t just help you write a good FizzBuzz solution,
 * they’ll make you a better programmer.
 *
 * @author beathoven@wired-club.net
 */
public class FizzBuzz {

	private static final Logger LOG = LoggerFactory.getLogger(FizzBuzz.class);

	public static final String FIZZ = "Fizz";
	public static final String BUZZ = "Buzz";

	protected static final int N = 100;

	protected boolean[] fizz;
	protected boolean[] buzz;

	public FizzBuzz() {
		fizz = new boolean[N + 1];
		buzz = new boolean[N + 1];
	}

	public void run() {
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

	protected void out() {
		for (int i = 1; i <= N; i++) {
			if (fizz[i] || buzz[i]) {
				System.out.println((fizz[i] ? FIZZ : "") + (buzz[i] ? BUZZ : ""));
			} else {
				System.out.println(i);
			}
		}
	}
}
