package Bill;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class bill_report extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill_report frame = new bill_report();
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
	public bill_report() {
		setBounds(100, 100, 450, 300);
		
		

	}

}
