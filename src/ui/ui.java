package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.JButton;

import java.awt.Rectangle;

import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ui {

	private JFrame frmTcplayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui window = new ui();
					window.frmTcplayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTcplayer = new JFrame();
		frmTcplayer.setTitle("TCPlayer");
		frmTcplayer.setBounds(100, 100, 450, 300);
		frmTcplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton pause = new JButton("");
		ImageIcon pauseIcon = new ImageIcon(this.getClass().getResource("/resources/media-pause.png"));
		Image img = pauseIcon.getImage() ;  
		Image newimg = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		pauseIcon = new ImageIcon( newimg );
		pause.setIcon(pauseIcon);
		pause.setHorizontalTextPosition(SwingConstants.CENTER);
		pause.setVerticalTextPosition(SwingConstants.CENTER);
		pause.setVisible(true);
		pause.setLocation(138, 177);
		frmTcplayer.getContentPane().setLayout(null);
		pause.setSize(new Dimension(50, 50));
		
		pause.setPreferredSize(new Dimension(50, 50));
		pause.setAlignmentX(Component.RIGHT_ALIGNMENT);
		frmTcplayer.getContentPane().add(pause);
		
		JButton play = new JButton("");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon playIcon = new ImageIcon(this.getClass().getResource("/resources/media-play.png"));
		Image playImg = playIcon.getImage() ;  
		Image newPlayImg = playImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		playIcon = new ImageIcon( newPlayImg );
		play.setIcon(playIcon);
		play.setHorizontalTextPosition(SwingConstants.CENTER);
		play.setVerticalTextPosition(SwingConstants.CENTER);
		play.setVisible(true);
		play.setSize(new Dimension(50, 50));
		play.setPreferredSize(new Dimension(50, 50));
		play.setAlignmentX(1.0f);
		play.setBounds(200, 177, 50, 50);
		frmTcplayer.getContentPane().add(play);
		
		JButton stop = new JButton("");
		ImageIcon stopIcon = new ImageIcon(this.getClass().getResource("/resources/media-stop.png"));
		Image stopImg = stopIcon.getImage() ;  
		Image newStopImg = stopImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		stopIcon = new ImageIcon( newStopImg );
		stop.setIcon(stopIcon);
		stop.setHorizontalTextPosition(SwingConstants.CENTER);
		stop.setVerticalTextPosition(SwingConstants.CENTER);
		stop.setVisible(true);
		stop.setSize(new Dimension(50, 50));
		stop.setPreferredSize(new Dimension(50, 50));
		stop.setAlignmentX(1.0f);
		stop.setBounds(262, 177, 50, 50);
		frmTcplayer.getContentPane().add(stop);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBounds(66, 93, 200, 21);
		frmTcplayer.getContentPane().add(textPane);
		
		JButton loadFile = new JButton("load");
		loadFile.setBounds(278, 93, 100, 21);
		frmTcplayer.getContentPane().add(loadFile);
		
		JLabel lblTcplayer = new JLabel("TCPLAYER");
		lblTcplayer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTcplayer.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTcplayer.setBounds(163, 12, 174, 50);
		frmTcplayer.getContentPane().add(lblTcplayer);
	}
}
