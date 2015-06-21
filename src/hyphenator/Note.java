package hyphenator;

public class Note {
	
	private String key;
	private String intonation;
	private int octave;
	
	
	public Note(String key) {
		setKey(key);
		setIntonation("");
		setDefaultOctave();
	}

	public Note(String key, String intonation) {
		setKey(key);
		setIntonation(intonation);
		setDefaultOctave();
	}

	public String getKey() {
		return key.concat(intonation);
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getIntonation() {
		return intonation;
	}
	
	public void setIntonation(String intonation) {
		this.intonation = intonation;
	}

	public int getOctave() {
		return octave;
	}

	public void setOctave(int octave) {
		this.octave = octave;
	}
	
	public void setDefaultOctave() {
		this.octave = 5;
	}
	
	
	/* CLASS METHODS */
	
	@Override
	public String toString() {
		return getKey()+octave;
	}


}
