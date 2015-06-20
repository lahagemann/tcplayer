package hyphenator_test;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;
import hyphenator.Note;
import hyphenator.MatchScale;
import java.util.ArrayList;
import java.util.Arrays;
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
		ArrayList<Note> listOfNotes = new ArrayList<Note>();
		ArrayList<String> notesArray = new ArrayList<String>();
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
		
		assertArrayEquals(notesArray, newNotesArray);
	}
}
