package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<Word> dictionary;
	
	public AlienDictionary() {
		dictionary = new ArrayList<Word>();
	}
	
	public void resetDictionary() {
		dictionary.clear();
	}
	
	public void addWord(String alienWord, String translation) {
		
		Word w = new Word(alienWord,translation);
		
		if(dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(translation);
			return;
		}
		
		dictionary.add(w);
	}
	
	public String translateWord(String alienWord) {
		
		Word w = new Word(alienWord);
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		else return null;
	}
}
