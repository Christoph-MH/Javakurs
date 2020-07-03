package de.wbs.io;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileAuswahl {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FileAuswahl window = new FileAuswahl();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FileAuswahl window = new FileAuswahl();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public FileAuswahl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton wahl = new JButton("Datei w\u00E4hlen");
		wahl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = 
						new FileNameExtensionFilter("Textdateien"
								, "txt","html","log","docx");
				fc.setFileFilter(filter);
				int wahl = fc.showOpenDialog(frame);
				if(wahl==JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					System.out.println(file.getAbsolutePath());
					try {
						Runtime.getRuntime().exec("notepad.exe " + file.getAbsolutePath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else{
					System.out.println("Abgebrochen");
				}
			}
		});
		frame.getContentPane().add(wahl, BorderLayout.CENTER);
	}

}
