package test;

import static org.junit.Assert.*;
import music_handler.MatchScale;
import music_handler.Note;

import org.junit.Test;

import java.util.List;

import java.util.ArrayList;

import properties.ScaleEnum;

public class MatchScaleTest {
	
	@Test
	public void createMatchScaleTest(){
		ArrayList<Note> listOfNotes = new ArrayList<Note>();
		
		MatchScale matchScale = new MatchScale(listOfNotes);
		
		assertNotNull(matchScale);	
	}
	
	@Test
	public void parseScaleTest(){
		String notes = ScaleEnum.CMAJ.getScale();
		List<Note> listOfNotes = new ArrayList<Note>();
		List<String> notesArray = new ArrayList<String>();
		List<String> newNotesArray = new ArrayList<String>();
		
		notesArray.add("C");
		notesArray.add("D");
		notesArray.add("E");
		notesArray.add("F");
		notesArray.add("G");
		notesArray.add("A");
		notesArray.add("B");
		
		MatchScale matchScale = new MatchScale(listOfNotes);
		
		newNotesArray = matchScale.parseScale(notes);
		
		int i = 0;
		for(String note : notesArray){
			assertEquals(note, newNotesArray.get(i));
			
			i++;
		}
	}
	
	
	
	@Test
	public void getTextScaleTest(){
		List<Note> listOfNotes = new ArrayList<Note>();
		MatchScale matchScale = new MatchScale(listOfNotes);

		List<String> scale = new ArrayList<String>();
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
		
		scale = matchScale.getTextScale();
		
		assertEquals("A", scale.get(0));
		assertEquals("B", scale.get(1));
		assertEquals("C", scale.get(2));
		assertEquals("D", scale.get(3));
		assertEquals("E", scale.get(4));
		assertEquals("F", scale.get(5));
		assertEquals("G", scale.get(6));

	}
	
	@Test
	public void getMatchedScaleTest(){
		List<Note> listOfNotes = new ArrayList<Note>();
		
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
		
		MatchScale matchScale = new MatchScale(listOfNotes);
		
		String scale = new String();
		
		scale = matchScale.getMatchedScale();
		
		assertEquals("Cmaj", scale);
	}
}
