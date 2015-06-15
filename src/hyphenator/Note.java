package hyphenator;

public class Note {
	
	private String key;
	private String octave;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOctave() {
		return octave;
	}

	public void setOctave(String octave) {
		this.octave = octave;
	}
	
	/* CLASS METHODS */
	
	public String toString() {
		return getKey().concat(getOctave());
	}

}
