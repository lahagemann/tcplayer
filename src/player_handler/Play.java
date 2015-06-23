package player_handler;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.Player;

public class Play {
	
	private ManagedPlayer player;
	private String music;
	private String midiPath;
	private Sequencer sequencer;
	
	public Play(String music, String fileName) throws IOException, MidiUnavailableException, InvalidMidiDataException {
		this.player = new ManagedPlayer();
		setMusic(music);
		setMidiPath(fileName);
		createMidiFile();
		setSequencer();
	}
	
	public void setMusic(String music) {
		this.music = music.trim();
	}
	
	public void setMidiPath(String fileName) {
		this.midiPath = System.getProperty("user.dir")+"/data/midi/"+fileName+".mid";
	}
	
	private void createMidiFile() throws IOException {
		Pattern pattern = new Pattern(this.music);
		pattern.save(new File(this.midiPath));
	}
	
	private void setSequencer() throws MidiUnavailableException, InvalidMidiDataException {
		this.sequencer = MidiSystem.getSequencer();
	    Sequence song =  new Player().getSequence(music);
	    this.sequencer.setSequence(song);
	}
	
	public void play() throws InvalidMidiDataException, MidiUnavailableException {
		if(player.isPaused())
			player.resume();
		else
			player.start(this.sequencer.getSequence());
	}
	
	public void pause() {
		if(player.isPlaying())
			player.pause();
	}
	
	public void stop() {
		if(player.isPlaying() || player.isPaused())
			player.finish();
	}
}
