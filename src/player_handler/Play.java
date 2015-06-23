package player_handler;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.Player;

public class Play {
	
	private ManagedPlayer player;
	private String music;
	private Sequencer sequencer;
	
	public Play(String music) throws IOException, MidiUnavailableException, InvalidMidiDataException {
		this.player = new ManagedPlayer();
		setMusic(music);
		setSequencer();
	}
	
	public void setMusic(String music) {
		this.music = music.trim();
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
