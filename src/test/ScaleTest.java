package test;

import static org.junit.Assert.*;
import music_handler.MatchScale;
import music_handler.Note;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class MatchScaleTest {
	
	@Test
	public void createMatchScaleTest(){
		ArrayList<Note> listOfNotes = new ArrayList<Note>();
		String positivness = "positive";
		
		MatchScale matchScale = new MatchScale(listOfNotes, positivness);
		
		assertNotNull(matchScale);	
	}
	
	@Test
	public void getMatchedScaleTest(){
		List<Note> listOfNotes = new ArrayList<Note>();
		String positiveness = "positive";
		
		List<String> textListOfNotes = new ArrayList<String>();
		
		textListOfNotes.add("A"); 
		textListOfNotes.add("D");
		textListOfNotes.add("C");
		textListOfNotes.add("D");
		textListOfNotes.add("E");
		textListOfNotes.add("F");
		textListOfNotes.add("G");
		textListOfNotes.add("E");
		textListOfNotes.add("B");
		textListOfNotes.add("C");
		textListOfNotes.add("C");
		textListOfNotes.add("G");
		textListOfNotes.add("B");
		textListOfNotes.add("D");
		
		for(String noteName : textListOfNotes){
			Note note = new Note(noteName);
			listOfNotes.add(note);
		}
		
		MatchScale matchScale = new MatchScale(listOfNotes, positiveness);
		
		String scale = new String();
		
		scale = matchScale.getMatchedScale();
		
		assertEquals("Cmaj", scale);
	}
}
