package hyphenator;

import java.util.Properties;

import properties.AlphabetEnum;

public class SyllableToNote {
	
	
	public Note convert(Syllable syllable) {
		if(containsAnyDefaultNote(syllable)) {
			//find number of notes & create double/single note
		}
		else {
			String note = AlphabetEnum.valueOf(syllable.firstLetter()).getCorrespondent();
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
