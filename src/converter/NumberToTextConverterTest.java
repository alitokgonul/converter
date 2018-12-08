package converter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberToTextConverterTest {

	@Test
	void test() {
		NumberToTextConverter converter = new NumberToTextConverter();
		assertEquals("zero", converter.convertNumberToText(0));
		assertEquals("six", converter.convertNumberToText(6));
		assertEquals("ten", converter.convertNumberToText(10));
		assertEquals("fifteen", converter.convertNumberToText(15));
		assertEquals("one hundred", converter.convertNumberToText(100));
		assertEquals("one thousand one", converter.convertNumberToText(1001));
		assertEquals("ninety nine thousand one hundred two", converter.convertNumberToText(99102));
		assertEquals("one hundred thousand", converter.convertNumberToText(100000));
		assertEquals("nine million nine hundred one thousand twenty", converter.convertNumberToText(9901020));
		assertEquals("ten million one thousand twenty three", converter.convertNumberToText(10001023));
		assertEquals("two hundred twelve million one thousand twenty three", converter.convertNumberToText(212001023));
	}

}
