package ui.buttons;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import player_handler.Play;

public class StopButton {
	
	public JButton button;
	
	public StopButton(Play play) {
		this.button = new JButton(""); 
		setIcon();
		setPositionAndSize();
		setAction(play);
	}
	
	private void setIcon() {
		ImageIcon stopIcon = new ImageIcon(this.getClass().getResource("/resources/media-stop.png"));
		Image stopImg = stopIcon.getImage() ;  
		Image newStopImg = stopImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		stopIcon = new ImageIcon( newStopImg );
		this.button.setIcon(stopIcon);
	}
	
	private void setPositionAndSize() {
		this.button.setHorizontalTextPosition(SwingConstants.CENTER);
		this.button.setVerticalTextPosition(SwingConstants.CENTER);
		this.button.setVisible(true);
		this.button.setSize(new Dimension(50, 50));
		this.button.setPreferredSize(new Dimension(50, 50));
		this.button.setAlignmentX(1.0f);
		this.button.setBounds(262, 177, 50, 50);
	}
	
	
	
	private void setAction(Play play) {
		this.button.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play.pause();
			}
		}));
	}
}
