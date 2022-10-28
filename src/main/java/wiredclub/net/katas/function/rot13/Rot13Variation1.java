package wiredclub.net.katas.function.rot13;

public class Rot13Variation1 extends Rot13 {

	public static void main(String[] args) {
		new Rot13Variation1(0).run();
	}

	public Rot13Variation1(int offset) {
		if (offset < 0 || offset >= ENCODER_DEFAULT.length()) {
			throw new IllegalArgumentException("Offset must be in range (0 <= offset <= " + ENCODER_DEFAULT.length() + ")");
		}
		initRotationMapping(ENCODER_DEFAULT, offset);
	}

	private void run() {
		System.out.println("\nROT-0");
		String text = "Hällo, Wörld";
		System.out.println(text + " -> " + rotationEncode(text));
	}
}
