package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import music_handler.MusicConverter;
import player_handler.Play;
import text_handler.processer.TextProcesser;
import ui.buttons.PauseButton;
import ui.buttons.PlayButton;
import ui.buttons.StopButton;
import ui.dialogs.FileNotFoundDialog;
import ui.dialogs.InvalidMidiDialog;
import ui.dialogs.NLTKNotFoundDialogBox;

public class ui {

	private JFrame frmTcplayer;
	private TextProcesser processer;
	private MusicConverter converter;
	private Play player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui window = new ui();
					window.frmTcplayer.setVisible(true);
					File nltk = new File("/usr/local/lib/python2.7/dist-packages/nltk/");
					if(!nltk.exists() || !nltk.isDirectory()) {
						NLTKNotFoundDialogBox dialog = new NLTKNotFoundDialogBox();
						System.exit(0);
					}						
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
		
		PlayButton play = new PlayButton(player);
		PauseButton pause = new PauseButton(player);
		StopButton stop = new StopButton(player);
		
		frmTcplayer.getContentPane().setLayout(null);
		frmTcplayer.getContentPane().add(play.button);
		frmTcplayer.getContentPane().add(pause.button);
		frmTcplayer.getContentPane().add(stop.button);
		
		JTextPane file = new JTextPane();
		file.setBorder(new LineBorder(new Color(0, 0, 0)));
		file.setBounds(66, 74, 200, 21);
		frmTcplayer.getContentPane().add(file);
		
		JButton load = new JButton("load");
		load.setBounds(278, 74, 100, 21);
		load.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = File.separator+"tmp";
				JFileChooser fileChooser = new JFileChooser(new File(filename));
				fileChooser.showOpenDialog(frmTcplayer);
				File f = fileChooser.getSelectedFile();
				file.setText(f.getAbsolutePath());
				try {
					processer = new TextProcesser(f.getAbsolutePath());
					System.out.println(processer.getSyllabifiedText().size());
				} catch (IOException | InterruptedException e1) {
					FileNotFoundDialog dialog = new FileNotFoundDialog();
				}
			}
		}));
		frmTcplayer.getContentPane().add(load);
		
		JLabel lblTcplayer = new JLabel("TCPLAYER");
		lblTcplayer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTcplayer.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTcplayer.setBounds(160, 12, 174, 50);
		frmTcplayer.getContentPane().add(lblTcplayer);
		
		JButton btnCreate = new JButton("create music!");
		btnCreate.setBounds(66, 107, 313, 25);
		btnCreate.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(processer!=null) {
					converter = new MusicConverter(processer.getSyllabifiedText(), processer.getPositiveness());
					try {
						player = new Play(converter.convert(),processer.getFileName());
					} catch (IOException e1) {
						FileNotFoundDialog d = new FileNotFoundDialog();
					} catch (MidiUnavailableException e1) {
						InvalidMidiDialog m = new InvalidMidiDialog();
					} catch (InvalidMidiDataException e1) {
						InvalidMidiDialog m = new InvalidMidiDialog();
					}
				}
			}
		}));
		frmTcplayer.getContentPane().add(btnCreate);
	}
}
