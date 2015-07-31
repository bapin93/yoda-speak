package main.java;


public class YodaClient {
	
	public static void main(String[] args) {
		YodaConverter yoda = new YodaConverter();
		String sentence = "i'm going to convert this string, to yoda-language.";
		
		System.out.println(yoda.basicTranslate(sentence));	
		System.out.println(yoda.speechTaggerTranslate(sentence));
		
		
		
	}
}
