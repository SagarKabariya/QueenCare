package Patient;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class patient_update extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_update frame = new patient_update();
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
	public patient_update() {
		setBounds(100, 100, 450, 300);

	}

}
