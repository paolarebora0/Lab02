package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<WordEnhanced> dictionary;
	
	
	public AlienDictionary() {
		dictionary = new ArrayList<WordEnhanced>();
	}
	
	public void resetDictionary() {
		dictionary.clear();
	}
	
	public void addWord(String alienWord, String translation) {
		
		WordEnhanced w = new WordEnhanced(alienWord,translation);
		
		if(dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(translation);
			return;
		}
		w.setTranslation(translation);
		dictionary.add(w);
	}
	
	public String translateWord(String alienWord) {
		
		WordEnhanced w = new WordEnhanced(alienWord);
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		else 
			return null;
	}
}
