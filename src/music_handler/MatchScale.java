package music_handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import properties.ScaleEnum;




public class MatchScale {
	
	List<Note> listOfNotes;
	
	public MatchScale(List<Note> listOfNotes) {
		setListOfNotes(listOfNotes);
	}
	
	/* GETTERS & SETTERS */
	
	public List<Note> getListOfNotes() {
		return this.listOfNotes;
	}
	
	public void setListOfNotes(List<Note> listOfNotes) {
		this.listOfNotes = listOfNotes;
	}
	
	
	/* CLASS METHODS */
	
	
	public String getMatchedScale() {
		List<String> textScale = getTextScale();
		
		int highestMatch = 0;
		String matchedScale = "";
		
		for (ScaleEnum scale : ScaleEnum.values()) {
			List<String> parsedScale = parseScale(scale.getScale());
			int numberOfMatches = compareScales(parsedScale, textScale);
			
			if(numberOfMatches > highestMatch) {
				highestMatch = numberOfMatches;
				matchedScale = scale.getNameOfScale();
			}
		}
		return matchedScale;
	}
	
	public List<String> getTextScale() {
		List<String> scale = new ArrayList<String>();
		
		Map<String,Integer> scores = getNoteOccurrences(this.listOfNotes);
		
		List<Integer> noteScores = selectMostUsedNotes(new ArrayList<Integer>(scores.values()));
		
		for (int i = 0; i < noteScores.size(); i++) {
			for (String note : scores.keySet()) {
				if(scores.get(note) == noteScores.get(i))
					if(!scale.contains(note))
						scale.add(note);
			}
		}
		
		return scale;
	}
	
	public List<String> parseScale(String listOfKeys){
		return Arrays.asList(listOfKeys.split(" "));
	}

	private List<Integer> selectMostUsedNotes(List<Integer> noteScores) {
		Collections.sort(noteScores, Collections.reverseOrder());
		noteScores = noteScores.subList(0, 6);
		return noteScores;
	}
	
	private Map<String,Integer> getNoteOccurrences(List<Note> text) {
		Map<String,Integer> scores = new HashMap<String,Integer>();
		
		for (Note note : text) {
			if(scores.containsKey(note.getKeyWithIntonation())){
				Integer oldValue = scores.get(note.getKeyWithIntonation());
				scores.put(note.getKeyWithIntonation(), oldValue++);
			}
			else
				scores.put(note.getKeyWithIntonation(), 1);
		}
		return scores;
	}
	
	public int compareScales(List<String> trueScale, List<String> scaleFromText) {
		int matches = 0;
		for (String note : scaleFromText) 
			if(trueScale.contains(note))
				matches++;					
		return matches;
	}
	

}
