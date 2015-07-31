package main.java;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 * @author andres
 *
 */
public class YodaConverter {
	//===========================================================================
	// CONSTANTS
	//===========================================================================
	private static final String _TAGGER_MODEL = "src/main/resources/models/english-left3words-distsim.tagger";

	//===========================================================================
	// VARIABLES
	//===========================================================================
	MaxentTagger _tagger;

	//===========================================================================
	// CONSTRUCTORS
	//===========================================================================	
	/**
	 * no-args constructor
	 */
	public YodaConverter(){
		_tagger = new MaxentTagger(_TAGGER_MODEL);
	}

	//===========================================================================
	// PUBLIC METHODS
	//===========================================================================
	/**
	 * @param sentence
	 * @return sentence translated to yoda-speak
	 */
	public String basicTranslate(final String sentence){
		String result = "";

		String [] words = sentence.split(" ");
		if(sentence.contains("and")){
			for(int i = 4; i < words.length; i++){
				result += words[i] + " ";
			}
		} else {
			for(int i = 2; i < words.length; i++){
				result += words[i] + " ";
			}
		}
		result = result.trim();
		if(result.endsWith(".") || result.endsWith("?") || result.endsWith("!")){
			result = result.substring(0, result.length() -1);
		}

		if(sentence.contains("and")){
			result += ", " + words[0] + " " + words[1] + " " + words[2] + " " + words[3] + ".";
		} else {
			result += ", " + words[0] + " " + words[1] + ".";
		}
		result = result.toLowerCase();
		if(result.contains("i'm") || result.contains("I'm")){
			result = result.toLowerCase();
			result = result.replaceAll("i'm", "I am");
		}
		result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
		return result;
	}

	/**
	 * @param sentence
	 * @return sentence translated to yoda-speak
	 */
	public String speechTaggerTranslate(final String sentence) {
		String result = "";
		String taggedSentence = _tagger.tagString(sentence);
		String [] untaggedWords = sentence.split("\\s");
		String [] taggedWords = taggedSentence.split(" ");
		int splitIndex = 0;
		
		for(int i = 0; i < taggedWords.length; i ++) {
			
			taggedWords[i] += "#";
			if(taggedWords[i].substring(taggedWords[i].length() - 4, taggedWords[i].length()).matches("_VB#")) {
				splitIndex = i;
				break;
			}
		}
		if(splitIndex == 0) {
			result = "No viable split index found!";
		}
		
		for(int i = splitIndex; i < untaggedWords.length; i++) {
			if(untaggedWords[i].endsWith(".") || untaggedWords[i].endsWith("?") || untaggedWords[i].endsWith("!")){
				untaggedWords[i] = untaggedWords[i].substring(0, untaggedWords[i].length() -1);
			}
			result += untaggedWords[i] + " ";
		}
		result = result.trim();
		result += ", ";
		for(int i = splitIndex; i > 0; i--) {
			result += untaggedWords[Math.abs(i - splitIndex)] + " ";
		}
		result = result.trim();
		result += ".";
		if(result.contains("i'm") || result.contains("I'm")){
			result = result.toLowerCase();
			result = result.replaceAll("i'm", "I am");
		}
		result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
		return result;
	}
}
