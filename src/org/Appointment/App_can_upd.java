package org.Appointment;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class App_can_upd extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App_can_upd frame = new App_can_upd();
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
	public App_can_upd() {
		setBounds(100, 100, 450, 300);

	}

}
