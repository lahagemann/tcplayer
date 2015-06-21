package music_handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import text_handler.Syllable;

public class SyllableToNote {
	
	
	public List<Note> convertText(List<Syllable> text) {
		List<Note> music = new ArrayList<Note>();
		for (Syllable syllable : text) {
			Note note = convert(syllable);
			if(note != null)
				music.add(note);
		}
		return music;
	}
	
	//deixar isso menos feio pfv
	private Note convert(Syllable syllable) {
		if(containsAnyDefaultNote(syllable)) {
			String note = getDefaultNote(syllable);
			if(note != null)
				return new Note(note);
			else
				return null;
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
	}

	private String getDefaultNote(Syllable syllable) {
		String syl = syllable.getSyllable();
		for (int i = 0; i < syl.length(); i++) {
			switch(syl.charAt(i)) {
				case 'a': return "A";
				case 'b': return "B";
				case 'c': return "C";
				case 'd': return "D";
				case 'e': return "E";
				case 'f': return "F";
				case 'g': return "G";
			}
		}
		return null;
	}

	private boolean containsAnyDefaultNote(Syllable syllable) {
		String syl = syllable.getSyllable();
		if(syl.contains("a") || syl.contains("b") || syl.contains("c") || 
				syl.contains("d") || syl.contains("e") || syl.contains("f") || syl.contains("g") )
			return true;
		return false;
	}
}
