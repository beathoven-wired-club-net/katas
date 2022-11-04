package wiredclub.net.katas.application.loccount;

import java.util.stream.Stream;

public class CountUtils {

	/**
	 * Counts the number of lines in a stream.
	 *
	 * @param stream Stream of file
	 * @return number of lines of file
	 */
	public long countLines(Stream<String> stream) {
		return stream.count();
	}

	/**
	 * Counts the number of lines in a stream which are not blank and do not start with a simple comment (//).
	 *
	 * @param stream Stream of file
	 * @return number of code lines of file
	 */
	public long countLinesOfCode(Stream<String> stream) {
		return stream
				.filter(line -> !line.isBlank())
				.filter(line -> !line.matches("\\s*//.*"))
				.count();
	}
}
