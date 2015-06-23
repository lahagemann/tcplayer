package ui.buttons;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import player_handler.Play;

public class PauseButton {
	
	public JButton button;
	
	public PauseButton() {
		this.button = new JButton(""); 
		setIcon();
		setPositionAndSize();
	}



	private void setIcon() {
		ImageIcon pauseIcon = new ImageIcon(this.getClass().getResource("/resources/media-pause.png"));
		Image img = pauseIcon.getImage() ;  
		Image newimg = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		pauseIcon = new ImageIcon( newimg );
		this.button.setIcon(pauseIcon);
	}
	private void setPositionAndSize() {
		this.button.setHorizontalTextPosition(SwingConstants.CENTER);
		this.button.setVerticalTextPosition(SwingConstants.CENTER);
		this.button.setVisible(true);
		this.button.setLocation(138, 177);
		this.button.setSize(new Dimension(50, 50));
		this.button.setPreferredSize(new Dimension(50, 50));
		this.button.setAlignmentX(Component.RIGHT_ALIGNMENT);
	}
	

}
