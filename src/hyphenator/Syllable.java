package hyphenator;

public class Syllable {
	
	private String syllable;
	
	public Syllable(String syllable) {
		setSyllable(syllable);
	}
	
	/* GETTERS & SETTERS */
	
	public String getSyllable() {
		return syllable;
	}
	
	public void setSyllable(String syllable) {
		this.syllable = syllable;
	}
	
	public int getSyllableLength() {
		return syllable.length();
	}
	
	/* CLASS METHODS */
	
	public String getPattern() {
		String pattern = "";
		
		if(syllableExists()) {
			for (int i = 0; i < syllable.length(); i++) {
				if(isVowel(syllable.charAt(i)))
					pattern.concat("V");
				else
					pattern.concat("C");
			}			
		}
		return pattern;
	}

	private boolean syllableExists() {
		if(syllable != null)
			return true;
		return false;
	}

	private boolean isVowel(char letter) {
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
			return true;
		return false;
	}

}
