package wiredclub.net.katas.clazz.hangman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HangMan {

	private static final Logger LOG = LoggerFactory.getLogger(HangMan.class);

	private final String word;
	private final Set<Character> guessedLetters = new HashSet<>();

	public static void main(String[] args) {
		new HangMan("Developer").run();
	}

	public HangMan(String word) {
		this.word = word;
	}

	private void run() {
		for (char letter : "uenoradlpv".toCharArray()) {
			System.out.println(guessLetter(letter));
		}
	}

	String guessLetter(char letter) {
		guessedLetters.add(Character.toUpperCase(letter));

		StringBuilder out = new StringBuilder();
		for (char c : word.toCharArray()) {
			out.append(guessedLetters.contains(Character.toUpperCase(c)) ? c : '-');
		}

		return out.toString();
	}
}
