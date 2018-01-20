package Lab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class lab_print extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	Connection conn=null;
	ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab_print frame = new lab_print();
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
	public lab_print() {
		setClosable(true);
		setBounds(100, 100, 1226, 444);
		 try{
				Class.forName("com.mysql.jdbc.Driver");
			    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
			 }catch(Exception e1){
				 e1.printStackTrace();
			 }

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 84, 1190, 319);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 26, 1167, 282);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Doctor ID", "date", "Amount","Report Name", "normal", "result", "remark","status" 
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(159, 11, 909, 62);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Case ID");
		lblNewLabel.setBounds(186, 23, 75, 14);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				PreparedStatement p1;
				try {
	p1=conn.prepareStatement("select l.doc_id,l.date,l.amount,lr.report_name,ld.normal,ld.result,ld.remark,ld.status "
			+ "from lab l,lab_report lr,lab_details ld "
			+ "where lr.LR_id=ld.LR_id AND l.lab_id=ld.lab_id AND ld.status=1 "
			+ "AND l.case_id="+Integer.valueOf(textField.getText()));
				
					rs=p1.executeQuery();

					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
						while(rs.next())
						{
model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
						}
			    	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		textField.setBounds(267, 20, 109, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(60, 63, 1085, 31);
		desktopPane.add(panel_2);

	}
}
