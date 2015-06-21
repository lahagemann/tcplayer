package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
		
		JTextPane file = new JTextPane();
		file.setBorder(new LineBorder(new Color(0, 0, 0)));
		file.setBounds(66, 74, 200, 21);
		frmTcplayer.getContentPane().add(file);
		
		JButton loadFile = new JButton("load");
		loadFile.setBounds(278, 74, 100, 21);	

		frmTcplayer.getContentPane().add(loadFile);
		
		JLabel lblTcplayer = new JLabel("TCPLAYER");
		lblTcplayer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTcplayer.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTcplayer.setBounds(160, 12, 174, 50);
		frmTcplayer.getContentPane().add(lblTcplayer);
		
		JButton btnCreate = new JButton("create music!");
		btnCreate.setBounds(66, 107, 313, 25);
		frmTcplayer.getContentPane().add(btnCreate);
	}
}
