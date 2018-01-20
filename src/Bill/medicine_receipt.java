package Bill;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class medicine_receipt extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medicine_receipt frame = new medicine_receipt();
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
	public medicine_receipt() {
		setBounds(100, 100, 450, 300);

	}

}
