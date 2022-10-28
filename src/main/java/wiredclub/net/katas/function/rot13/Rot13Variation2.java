package wiredclub.net.katas.function.rot13;

public class Rot13Variation2 extends Rot13 {

	private static final String ENCODER_WITH_DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		new Rot13Variation2(13).run();
	}

	public Rot13Variation2(int offset) {
		if (offset < 0 || offset >= ENCODER_WITH_DIGITS.length()) {
			throw new IllegalArgumentException("Offset must be in range (0 <= offset <= " + ENCODER_WITH_DIGITS.length() + ")");
		}
		initRotationMapping(ENCODER_WITH_DIGITS, offset);
	}

	private void run() {
		System.out.println("\nROT-13 with digits");
		String text = "H3ll0, W0rld";
		System.out.println(text + " -> " + rotationEncode(text));
	}
}
