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

public class Play {
	
	private ManagedPlayer player;
	private String music;
	private String midiPath;
	private Sequencer sequencer;
	
	public Play(String music, String fileName) throws IOException, MidiUnavailableException, InvalidMidiDataException {
		setMidiPath(fileName);
		createMidiFile();
		setSequencerWithMidiFile();
	}
	
	public void setMidiPath(String fileName) {
		this.midiPath = System.getProperty("user.dir")+"/data/midi/"+fileName+".mid";
	}
	
	private void createMidiFile() throws IOException {
		Pattern pattern = new Pattern(this.music);
		pattern.save(new File(this.midiPath));
	}
	
	private void setSequencerWithMidiFile() throws MidiUnavailableException, InvalidMidiDataException, IOException {
		Sequencer sequencer = MidiSystem.getSequencer();
		
	    Sequence song = MidiSystem.getSequence(new File(this.midiPath));
	    sequencer.setSequence(song);
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
