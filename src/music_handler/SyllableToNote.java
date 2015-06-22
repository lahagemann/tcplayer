package music_handler;

import java.util.ArrayList;
import java.util.List;

import properties.AlphabetEnum;
import text_handler.text.Syllable;

public class SyllableToNote {
	
	
	public List<Note> convertText(List<Syllable> text) {
		List<Note> music = new ArrayList<Note>();
		Note previous = null;
		for (Syllable syllable : text) {
			Note note = convert(syllable);
			if(previous!=null) {
				int octave = setNewOctave(note,previous);
				note.setOctave(octave);
				music.add(note);
				
			}
		}
		return music;
	}
	
	private int setNewOctave(Note note, Note previous) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Note convert(Syllable syllable) {
		Note note = null;
		
		if(syllable.getSyllable().matches("\\W"))
			return new Note("R");
		
		if(containsAnyDefaultNote(syllable)) {
			String noteName = getDefaultNote(syllable);
			if(noteName != null)
				note = new Note(noteName);
		}
		else {
			String noteName = AlphabetEnum.valueOf(syllable.firstLetter()).getCorrespondent();
			String intonation = "";
			
			intonation = getNoteIntonation(syllable);
			
			note =  new Note(noteName,intonation);
		}
		return note;
	}

	private String getNoteIntonation(Syllable syllable) {
		String intonation;
		if(syllable.endsWithConsonant())
			intonation = "#";
		else
			intonation = "b";
		return intonation;
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
				syl.contains("d") || syl.contains("e") || syl.contains("f") || syl.contains("g"))
			return true;
		return false;
	}
}
