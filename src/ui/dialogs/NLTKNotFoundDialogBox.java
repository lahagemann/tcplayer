package ui.dialogs;

import javax.swing.JOptionPane;

public class NLTKNotFoundDialogBox {
	
	private String message;
	
	public NLTKNotFoundDialogBox() {
		setMessage();
		create();
	}
	
	private void setMessage() {
		this.message = "ERROR: NLTK library is not installed.\n\n"
				+ "To install NLTK, please type the following line into your terminal:\n\n"
				+ "\"sudo pip install -U nltk\"";
	}
	
	private void create() {
		JOptionPane.showMessageDialog(null,this.message);
	}
}
