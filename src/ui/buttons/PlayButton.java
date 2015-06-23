package ui.buttons;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import player_handler.Play;
import ui.dialogs.InvalidMidiDialog;

public class PlayButton {
	
	public JButton button;
	
	public PlayButton(Play play) {
		this.button = new JButton(""); 
		setIcon();
		setPositionAndSize();
		setAction(play);
	}
	
	private void setIcon() {
		ImageIcon playIcon = new ImageIcon(this.getClass().getResource("/resources/media-play.png"));
		Image playImg = playIcon.getImage();  
		Image newPlayImg = playImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		playIcon = new ImageIcon( newPlayImg );
		this.button.setIcon(playIcon);
	}
	
	private void setPositionAndSize() {
		this.button.setHorizontalTextPosition(SwingConstants.CENTER);
		this.button.setVerticalTextPosition(SwingConstants.CENTER);
		this.button.setVisible(true);
		this.button.setSize(new Dimension(50, 50));
		this.button.setPreferredSize(new Dimension(50, 50));
		this.button.setAlignmentX(1.0f);
		this.button.setBounds(200, 177, 50, 50);
	}
	
	private void setAction(Play play) {
		this.button.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					play.play();
				} catch (InvalidMidiDataException | MidiUnavailableException e1) {
					InvalidMidiDialog i = new InvalidMidiDialog();
				}
			}
		}));
	}

}
