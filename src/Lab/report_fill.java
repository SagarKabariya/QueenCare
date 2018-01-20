package Lab;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class report_fill extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report_fill frame = new report_fill();
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
	public report_fill() {
		setBounds(100, 100, 450, 300);

	}

}
