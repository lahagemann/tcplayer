package text_handler;

public class Syllable {
	
	private String syllable;
	
	public Syllable(String syllable) {
		setSyllable(syllable);
	}
	
	/* GETTERS & SETTERS */
	
	public String getSyllable() {
		if(syllableExists())
			return syllable;
		return null;
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
		if((syllable != null) && (syllable.length() > 0)) 
			return true;
		return false;
	}

	private boolean isVowel(char letter) {
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
			return true;
		return false;
	}
	
	public String firstLetter() {
		if(syllableExists())
			return syllable.substring(0, 1);
		return null;
	}
	
	public boolean endsWithConsonant() {
		if(syllableExists()) 
			if(!isVowel(syllable.charAt(getSyllableLength()-1)))
				return true;
		return false;	
	}

}
