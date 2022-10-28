package wiredclub.net.katas.function.rot13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13Test {

	@Test
	public void rotationEncodeRot13() {
		assertEquals("URYYB, JBEYQ!", new Rot13().rotationEncode("Hello, World!"));
	}

	@Test void transform() {
		Rot13 rot13 = new Rot13();

		assertEquals("ae", rot13.transform("ä"));
		assertEquals("AE", rot13.transform("Ä"));
		assertEquals("oe", rot13.transform("ö"));
		assertEquals("OE", rot13.transform("Ö"));
		assertEquals("ue", rot13.transform("ü"));
		assertEquals("UE", rot13.transform("Ü"));
		assertEquals("ss", rot13.transform("ß"));
	}

	@Test
	public void rotationEncodeVariableOffset() {
		assertEquals("ABC", new Rot13Variation1(0).rotationEncode("ABC"));
		assertEquals("BCD", new Rot13Variation1(1).rotationEncode("ABC"));
		assertEquals("NOP", new Rot13Variation1(13).rotationEncode("ABC"));
		assertEquals("YZA", new Rot13Variation1(24).rotationEncode("ABC"));
		assertEquals("ZAB", new Rot13Variation1(25).rotationEncode("ABC"));
		assertEquals("HAL", new Rot13Variation1(25).rotationEncode("IBM"));
	}

	@Test
	public void rotationEncodeVariableOffsetWithNumbers() {
		assertEquals("ABC", new Rot13Variation2(0).rotationEncode("ABC"));
		assertEquals("BCD", new Rot13Variation2(1).rotationEncode("ABC"));
		assertEquals("NOP", new Rot13Variation2(13).rotationEncode("ABC"));
		assertEquals("YZ0", new Rot13Variation2(24).rotationEncode("ABC"));
		assertEquals("Z01", new Rot13Variation2(25).rotationEncode("ABC"));
		assertEquals("9AB", new Rot13Variation2(35).rotationEncode("ABC"));
	}
}