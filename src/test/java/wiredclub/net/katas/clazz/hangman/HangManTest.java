package wiredclub.net.katas.clazz.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HangManTest {

	@Test
	public void guessLetter() {
		assertEquals("-e-e---e-", new HangMan("Developer").guessLetter('e'));
		assertEquals("D--------", new HangMan("Developer").guessLetter('d'));
	}
}
