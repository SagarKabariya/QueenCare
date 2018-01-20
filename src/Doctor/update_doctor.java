package Doctor;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class update_doctor extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_doctor frame = new update_doctor();
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
	public update_doctor() {
		setBounds(100, 100, 450, 300);

	}

}
