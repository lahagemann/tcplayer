package music_handler;

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
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getIntonation() {
		return this.intonation;
	}
	
	public void setIntonation(String intonation) {
		this.intonation = intonation;
	}

	public String getKeyWithIntonation(){
		return this.getKey() + this.getIntonation();
	}
	
	public int getOctave() {
		return this.octave;
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
		return this.getKey() + this.getIntonation() + this.getOctave();
	}


}
