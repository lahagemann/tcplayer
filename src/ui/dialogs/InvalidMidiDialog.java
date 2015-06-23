package ui.dialogs;

import javax.swing.JOptionPane;

public class InvalidMidiDialog {
	
	private String message;
	
	public InvalidMidiDialog() {
		setMessage();
		create();
	}
	
	private void setMessage() {
		this.message = "ERROR: could not open MIDI file.\n\nPlease choose another file.";
	}
	
	private void create() {
		JOptionPane.showMessageDialog(null,this.message);
	}

}
