package Diagnosis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class show_Diagnosis extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					show_Diagnosis frame = new show_Diagnosis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public show_Diagnosis() {
		setBounds(100, 100, 450, 300);

	}

}
