package Appointment;

import Connect.*;
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

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class Appointment_show extends JInternalFrame {
	private JTable table;
	Connection conn=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	private JTable table_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment_show frame = new Appointment_show();
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
	public Appointment_show() {
		setTitle("Appointment Checking List");
		conn=ConnectionManager.getConnection();
		setBounds(100, 100, 1036, 500);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 1000, 382);
		desktopPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table_1);
		table_1.setRowHeight(25);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Appointment ID", "Case ID", "Doctor", "Appointment Date", "Time Slot", "Status"
			}
		));
		
		JLabel lblAppointmentDate = new JLabel("Appointment Date");
		lblAppointmentDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAppointmentDate.setBounds(10, 11, 135, 40);
		desktopPane.add(lblAppointmentDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(157, 11, 141, 38);
		desktopPane.add(dateChooser);
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(86);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(114);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(113);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(133);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(85);
			

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String dd = fmt.format(dateChooser.getDate());
				try {
					st=conn.prepareStatement("select * from appointment where app_date like '"+dd+"'");
					rs=st.executeQuery();

					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);
			    	try {
						while(rs.next())
						{
						model.addRow(new Object[]{rs.getString("app_id"),rs.getString("Case_id"),rs.getString("doc_id"),rs.getString("app_date"),rs.getString("time_slot"),rs.getString("status")});
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
		btnNewButton.setBounds(310, 11, 113, 38);
		desktopPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(897, 11, 113, 40);
		desktopPane.add(btnClose);
	}
}
