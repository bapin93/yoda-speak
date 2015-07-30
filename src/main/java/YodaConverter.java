package main.java;

/**
 * @author andres
 *
 */
public class YodaConverter {
	/**
	 * no-args constructor
	 */
	public YodaConverter(){

	}

	/**
	 * @param sentence
	 * @return sentence translated to yoda-speak
	 */
	public String translate(String sentence){
		String converted = "";
		
		String [] words = sentence.split(" ");
		if(sentence.contains("and")){
			for(int i = 4; i < words.length; i++){
				converted += words[i] + " ";
			}
		} else {
			for(int i = 2; i < words.length; i++){
				converted += words[i] + " ";
			}
		}
		converted = converted.trim();
		if(converted.endsWith(".") || converted.endsWith("?") || converted.endsWith("!")){
			converted = converted.substring(0, converted.length() -1);
		}

		if(sentence.contains("and")){
			converted += ", " + words[0] + " " + words[1] + " " + words[2] + " " + words[3] + ".";
		} else {
		converted += ", " + words[0] + " " + words[1] + ".";
		}
		converted = converted.toLowerCase();
		if(converted.contains("i'm") || converted.contains("I'm")){
			converted = converted.toLowerCase();
			converted = converted.replaceAll("i'm", "I am");
		} else if(sentence.contains(" i ")){
			sentence = sentence.replaceAll(" i ", " I ");
		}
		converted = Character.toUpperCase(converted.charAt(0)) + converted.substring(1);
		return converted;
	}
}
