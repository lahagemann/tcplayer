package hyphenator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchScale {
	
	List<Note> text;
	
	public MatchScale(List<Note> text) {
		setText(text);
	}
	
	/* GETTERS & SETTERS */
	
	public List<Note> getText() {
		return text;
	}
	
	public void setText(List<Note> text) {
		this.text = text;
	}
	
	
	/* CLASS METHODS */
	
	
	public String match() {
		List<String> textScale = getAScaleFromText();
		
		int highestMatch = 0;
		String matchedScale = "";
		
		//arrumar essa parte aqui
		for (String key : properties) {
			List<String> scale = getScaleFromProperties(key);
			int match = matchScales(scale, textScale);
			
			if(match > highestMatch) {
				highestMatch = match;
				matchedScale = key;
			}
		}
		return matchedScale;
	}
	
	//esse método tá zoado e vai ficar a coisa mais feia da terra, se tu puder arrumar 
	public List<String> getAScaleFromText() {
		List<String> scale = new ArrayList<String>();
		
		Map<String,Integer> scores = getNoteOccurrences(text);
		
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
	
	public List<String> getScaleFromProperties(String key){
		//fazer a parte que importa as properties
		return Arrays.asList("properties".split(" "));
	}

	private List<Integer> selectMostUsedNotes(List<Integer> noteScores) {
		Collections.sort(noteScores, Collections.reverseOrder());
		noteScores = noteScores.subList(0, 6);
		return noteScores;
	}
	
	private Map<String,Integer> getNoteOccurrences(List<Note> text) {
		Map<String,Integer> scores = new HashMap<String,Integer>();
		
		for (Note note : text) {
			if(scores.containsKey(note.getKey())){
				Integer oldValue = scores.get(note.getKey());
				scores.put(note.getKey(), oldValue++);
			}
			else
				scores.put(note.getKey(), 1);
		}
		return scores;
	}
	
	public int matchScales(List<String> trueScale, List<String> scaleFromText) {
		int matches = 0;
		for (String note : scaleFromText) 
			if(trueScale.contains(note))
				matches++;					
		return matches;
	}
	

}
