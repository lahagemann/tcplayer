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
			if(previous!=null && !isPause(note)) 
				note.setOctave(produceNewOctave(note,previous));
			
			music.add(note);
			
			if(!isPause(note))
				previous = note;
		}
		return music;
	}

	private boolean isPause(Note note) {
		return note.getKey().equals("R");
	}
	
	private int produceNewOctave(Note note, Note previous) {
		//this only works because the key value is a single char as a string. it would not work otherwise.
		int asciiCodeForCurrentNote = (int) note.getKey().charAt(0);
		int asciiCodeForPreviousNote = (int) previous.getKey().charAt(0);
		
		if(asciiCodeForCurrentNote - asciiCodeForPreviousNote > 3)
			return note.getOctave()+1;
		if(asciiCodeForCurrentNote - asciiCodeForPreviousNote < -3)
			return note.getOctave()-1;
		
		return note.getOctave();
	}

	private Note convert(Syllable syllable) {
		Note note = null;
		
		if(syllable.getSyllable().matches("\\W"))
			return new Note("R");
		
		if(containsAnyDefaultNote(syllable))
			note = new Note(getDefaultNote(syllable));
		else {
			String noteName = AlphabetEnum.valueOf(syllable.firstLetter().toUpperCase()).getCorrespondent();
			note =  new Note(noteName,getNoteIntonation(syllable));
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
