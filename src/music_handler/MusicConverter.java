package music_handler;

import java.util.List;

import text_handler.text.Syllable;


public class MusicConverter {
	
	private List<Syllable> text;
	private String scale;
	private String positiveness;
	private List<Note> song;
	
	public MusicConverter(List<Syllable> text, String positiveness) {
		setText(text);
		setPositiveness(positiveness);
		setup();
	}

	public String getScale() {
		return scale;
	}

	public void setText(List<Syllable> text) {
		this.text = text;
	}
	
	public void setPositiveness(String positiveness) {
		this.positiveness = positiveness;
	}
		
	/* SETUP */
	
	private void setup() {
		setupSong();
		setupScale(this.text);
	}

	private void setupSong() {
		SyllableToNote converter = new SyllableToNote();
		this.song = converter.convertText(this.text);
	}

	private void setupScale(List<Syllable> text) {
		MatchScale matcher = new MatchScale(this.song, this.positiveness);
		this.scale = matcher.getMatchedScale();
	}
	
	public String convert() {
		String music = "K"+this.scale+" ";
		for (Note note : this.song) {
			music += (note.toString() + " ");
		}
		return music;
	}
}
