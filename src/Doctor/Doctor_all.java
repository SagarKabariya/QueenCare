package Doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Doctor_all extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	private JTable table_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_all frame = new Doctor_all();
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
	public Doctor_all() {
		try{
			 
			Class.forName("com.mysql.jdbc.Driver");
		    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
		    	st=conn.prepareStatement("select * from doctor");
		    	rs=st.executeQuery();
		 }catch(Exception e1){
			 e1.printStackTrace();
		 }
		setClosable(true);
		setBounds(100, 100, 1300, 500);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1290, 435);
		desktopPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Doctor_id","Department id", "First Name", "Last Name","Contact","Address","Qualification", "Gender","Age","Joining Date","from time","to time","Designation","Checkup Time","Status"
				}
			));
			
		
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
    	try {
			while(rs.next())
			{
			model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
