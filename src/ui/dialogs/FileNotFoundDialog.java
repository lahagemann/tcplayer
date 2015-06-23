package ui.dialogs;

import javax.swing.JOptionPane;

public class FileNotFoundDialog {
	private String message;
	
	public FileNotFoundDialog() {
		setMessage();
		create();
	}
	
	private void setMessage() {
		this.message = "ERROR: there is a problem with the file you loaded.\n\nPlease try again with a different file.";
	}
	
	private void create() {
		JOptionPane.showMessageDialog(null,this.message);
	}
}
