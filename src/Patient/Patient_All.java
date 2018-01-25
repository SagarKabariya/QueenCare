package Patient;


import Connect.ConnectionManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Patient_All extends JInternalFrame {
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
					Patient_All frame = new Patient_All();
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
	public Patient_All() {
		try{
				conn=ConnectionManager.getConnection();
		    	st=conn.prepareStatement("select * from patient_detail order by p_id");
				rs=st.executeQuery();
		 }catch(Exception e1){
			 e1.printStackTrace();
		 }
		setClosable(true);
		setBounds(100, 100, 1462, 696);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 1424, 589);
		desktopPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Age", "Blood Group", "Weight", "Gender", "Address", "Contact", "Registration Date"
			}
		));
		
		JButton btnNewButton = new JButton("Today List");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					st=conn.prepareStatement("select * from patient_detail where regi_date like '"+dateFormat.format(date)+"%'");
					
					rs=st.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);
			    	try {
						while(rs.next())
						{
						model.addRow(new Object[]{rs.getString("p_first_name"),rs.getString("p_last_name"),rs.getString("p_age"),rs.getString("p_bloodgroup"),rs.getString("p_weight"),rs.getString("p_gender"),rs.getString("p_address"),rs.getString("p_contact"),rs.getString("regi_date")});
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
			}
		});
		btnNewButton.setBounds(10, 11, 149, 34);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Last 3 Month");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					
						Date odate = java.sql.Date.valueOf(LocalDate.now().minus(3, ChronoUnit.MONTHS));
						
						 System.out.println("date"+odate);
					st=conn.prepareStatement("select * from patient_detail where regi_date between '"+odate+" 00:00:00' AND '"+dateFormat.format(date)+" 23:59:59'");
					System.out.println(st);
					rs=st.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);
			    	
						while(rs.next())
						{
						model.addRow(new Object[]{rs.getString("p_first_name"),rs.getString("p_last_name"),rs.getString("p_age"),rs.getString("p_bloodgroup"),rs.getString("p_weight"),rs.getString("p_gender"),rs.getString("p_address"),rs.getString("p_contact"),rs.getString("regi_date")});
						}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(171, 11, 149, 34);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All Desending Order");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					st=conn.prepareStatement("select * from patient_detail order by p_id desc");
					rs=st.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);
			    	try {
						while(rs.next())
						{
						model.addRow(new Object[]{rs.getString("p_first_name"),rs.getString("p_last_name"),rs.getString("p_age"),rs.getString("p_bloodgroup"),rs.getString("p_weight"),rs.getString("p_gender"),rs.getString("p_address"),rs.getString("p_contact"),rs.getString("regi_date")});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(332, 11, 204, 34);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				model.setRowCount(0);
			}
		});
		btnNewButton_3.setBounds(548, 11, 137, 34);
		desktopPane.add(btnNewButton_3);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(1073, 11, 114, 35);
		desktopPane.add(btnClose);
			
		
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
    	try {
			while(rs.next())
			{
			model.addRow(new Object[]{rs.getString("p_first_name"),rs.getString("p_last_name"),rs.getString("p_age"),rs.getString("p_bloodgroup"),rs.getString("p_weight"),rs.getString("p_gender"),rs.getString("p_address"),rs.getString("p_contact"),rs.getString("regi_date")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
