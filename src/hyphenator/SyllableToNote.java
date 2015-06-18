package hyphenator;

import java.util.Properties;

public class SyllableToNote {
	
	
	//deixar isso menos feio pfv
	public Note convert(Syllable syllable) {
		if(containsAnyDefaultNote(syllable)) {
			//find number of notes & create double/single note
		}
		else {
			//arrumar as properties
			Properties alphabetCorrespondent = new Properties();
			String note = alphabetCorrespondent.getProperty(syllable.firstLetter());
			String intonation = "";
			if(syllable.endsWithConsonant())
				intonation = "#";
			else
				intonation = "b";
			return new Note(note,intonation);
		}
		return null;
	}

	private boolean containsAnyDefaultNote(Syllable syllable) {
		// TODO Auto-generated method stub
		return false;
	}
}
