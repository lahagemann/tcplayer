package hyphenator;

import java.util.List;
import java.util.Map;

public class SyllableSeparator {
	
	private List<String> text;
	
	public Map<String, List<Syllable>> syllableDictionary;
	
	private void splitTextIntoSyllables() {
		for (String word : text) {
			if(dictionaryContainsWord(word)){
				//busca a separação no dicionario
			}
			else {
				//ver o que vamos fazer
			}
		}
	}

	private boolean dictionaryContainsWord(String word) {
		if(syllableDictionary.containsKey(word))
			return true;
		return false;
	}

}
