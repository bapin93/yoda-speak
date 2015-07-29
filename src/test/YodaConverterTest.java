package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.YodaConverter;

public class YodaConverterTest {
	/**
	 * 
	 */
	@Test
	public void test() {
		YodaConverter converter = new YodaConverter();
		String initial = "This string will be converted.";
		String translated = converter.translate(initial);
		assertTrue(translated.equalsIgnoreCase("Will be converted, this string."));
	}
}
