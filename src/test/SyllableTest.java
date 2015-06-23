package test;

import static org.junit.Assert.*;

import org.junit.Test;

import text_handler.text.Syllable;

public class SyllableTest {
	@Test
	public void firstLetterCTest(){
		String syl = "can";
		Syllable syllable = new Syllable(syl);
		String firstLetter = new String();
		
		firstLetter = syllable.firstLetter();
		
		assertEquals("c", firstLetter);
	}
	
	@Test
	public void endsWithConsonantTrueTest(){
		String syl = "can";
		Syllable syllable = new Syllable(syl);
		Boolean endsWithConsonant = false;
		
		endsWithConsonant = syllable.endsWithConsonant();
		
		assertEquals(true, endsWithConsonant);
	}
}
