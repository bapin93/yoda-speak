package test.java;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.YodaConverter;

public class YodaConverterTest {
	/**
	 * 
	 */
	@Test
	public void test() {
		YodaConverter converter = new YodaConverter();
		String initial = "This string will be converted.";
		String basicTranslated = converter.basicTranslate(initial);
		assertTrue(basicTranslated.equalsIgnoreCase("Will be converted, this string."));
	}
}
