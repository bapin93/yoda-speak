package main.java;


public class YodaClient {
	private static String NEW_LINE = "\n";
	public static void main(String[] args) {
		YodaConverter yoda = new YodaConverter();
		String sentence = "i'm going to convert this string, to yoda-language soon.";

		System.out.println(NEW_LINE + "Basic Translate:" + NEW_LINE + 
				yoda.basicTranslate(sentence) + NEW_LINE);	
		System.out.println("Part Of Speech Tagger Translate:" + NEW_LINE +
				yoda.speechTaggerTranslate(sentence) + NEW_LINE);
	}
}
