package ui.dialogs;

import javax.swing.JOptionPane;

public class ProcessingErrorDialog {
	
	private String message;
	
	public ProcessingErrorDialog() {
		setMessage();
		create();
	}
	
	private void setMessage() {
		this.message = "ERROR: there was an error processing this file.\n\n"
				+ "Please ensure that text is in english and in utf-8 encoding.";
	}
	
	private void create() {
		JOptionPane.showMessageDialog(null,this.message);
	}

}
