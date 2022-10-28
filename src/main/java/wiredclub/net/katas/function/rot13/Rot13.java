package wiredclub.net.katas.function.rot13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Rot13 {

	private static final Logger LOG = LoggerFactory.getLogger(Rot13.class);

	protected static final String ENCODER_DEFAULT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	protected static final char[] ROTATION = new char[256];

	private static final Map<Character, String> TRANSFORM = new HashMap<>();

	static {
		for (char i = 0; i < 256; i++) {
			ROTATION[i] = i;
		}

		TRANSFORM.put('ä', "ae");
		TRANSFORM.put('ö', "oe");
		TRANSFORM.put('ü', "ue");
		TRANSFORM.put('ß', "ss");
		TRANSFORM.put('Ä', "AE");
		TRANSFORM.put('Ö', "OE");
		TRANSFORM.put('Ü', "UE");
	}

	public static void main(String[] args) {
		new Rot13().run();
	}

	public Rot13() {
		initRotationMapping(ENCODER_DEFAULT, 13);
	}

	protected void initRotationMapping(String encoder, int offset) {
		for (int i = 0; i < encoder.length(); i++) {
			char c = encoder.charAt(i);
			char v = encoder.charAt((i + offset) % encoder.length());
			// LOG.debug("c: {} - v: {}", c, v);
			ROTATION[c] = v;
		}
	}

	private void run() {
		System.out.println("\nROT-13");
		String text = "Hello, World";
		System.out.println(text + " -> " + rotationEncode(text));
	}

	String rotationEncode(String text) {
		return encode(transform(text).toUpperCase());
	}

	private String encode(String textToEncode) {
		StringBuilder out = new StringBuilder();

		char[] in = textToEncode.toCharArray();
		for (char c : in) {
			out.append(ROTATION[c]);
		}

		return out.toString();
	}

	String transform(String textToTransform) {
		StringBuilder out = new StringBuilder();

		char[] input = textToTransform.toCharArray();
		for (char c : input) {
			out.append(TRANSFORM.containsKey(c) ? TRANSFORM.get(c) : c);
		}

		return out.toString();
	}
}
