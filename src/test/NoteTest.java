package test;

import static org.junit.Assert.*;
import music_handler.Note;

import org.junit.Test;

public class NoteTest {
	@Test
	public void toStringTest(){
		String key = "C";
		Note note = new Note(key);
		
		String textNote = new String();
		
		textNote = note.toString();
		
		assertEquals("C5", textNote);
	}
	
	@Test
	public void toStringSharpTest(){
		String key = "C";
		String intonation = "#";
		Note note = new Note(key, intonation);
		
		String textNote = new String();
		
		textNote = note.toString();
		
		assertEquals("C#5", textNote);
	}
	
	@Test
	public void toStringBemolTest(){
		String key = "C";
		String intonation = "b";
		Note note = new Note(key, intonation);
		
		String textNote = new String();
		
		textNote = note.toString();
		
		assertEquals("Cb5", textNote);
	}
	
	@Test
	public void toStringOctave(){
		String key = "C";
		int octave = 3;
		Note note = new Note(key);
		
		note.setOctave(octave);
		
		String textNote = new String();
		
		textNote = note.toString();
		
		assertEquals("C3", textNote);
	}
}
