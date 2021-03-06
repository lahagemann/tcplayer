package music_handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import properties.MajorScaleEnum;
import properties.MinorScaleEnum;

public class Scale {
	
	private List<Note> listOfNotes;
	private String positiveness;
	
	public Scale(List<Note> listOfNotes, String positiveness) {
		setListOfNotes(listOfNotes);
		setPositiveness(positiveness);
	}
	
	/* GETTERS & SETTERS */
	
	public List<Note> getListOfNotes() {
		return this.listOfNotes;
	}
	
	public void setListOfNotes(List<Note> listOfNotes) {
		this.listOfNotes = listOfNotes;
	}
	
	public void setPositiveness(String positiveness) {
		this.positiveness = positiveness;
	}
	
	
	/* CLASS METHODS */
	
	
	public String getScale() {
		List<String> textScale = getTextScale();
		
		
		String matchedScale = "";
		
		if(textIsPositive()) {
			matchedScale = findMajorScale(textScale, matchedScale);
		}
		else {
			matchedScale = findMinorScale(textScale, matchedScale);
		}
		return matchedScale;
	}

	private String findMinorScale(List<String> textScale, String matchedScale) {
		int highestMatch = 0;
		for (MinorScaleEnum scale : MinorScaleEnum.values()) {
			List<String> parsedScale = parseScale(scale.getScale());
			int numberOfMatches = compareScales(parsedScale, textScale);
			
			if(numberOfMatches > highestMatch) {
				highestMatch = numberOfMatches;
				matchedScale = scale.getNameOfScale();
			}
		}
		return matchedScale;
	}

	private String findMajorScale(List<String> textScale, String matchedScale) {
		int highestMatch = 0;
		for (MajorScaleEnum scale : MajorScaleEnum.values()) {
			List<String> parsedScale = parseScale(scale.getScale());
			int numberOfMatches = compareScales(parsedScale, textScale);
			
			if(numberOfMatches > highestMatch) {
				highestMatch = numberOfMatches;
				matchedScale = scale.getNameOfScale();
			}
		}
		return matchedScale;
	}

	private boolean textIsPositive() {
		return this.positiveness.equals("positive");
	}
	
	private List<String> getTextScale() {
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
	
	private List<String> parseScale(String listOfKeys){
		return Arrays.asList(listOfKeys.split(" "));
	}

	private List<Integer> selectMostUsedNotes(List<Integer> noteScores) {
		Collections.sort(noteScores, Collections.reverseOrder());
		if(noteScores.size() >= 7)
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
	
	private int compareScales(List<String> trueScale, List<String> scaleFromText) {
		int matches = 0;
		for (String note : scaleFromText) 
			if(trueScale.contains(note))
				matches++;					
		return matches;
	}
	

}
