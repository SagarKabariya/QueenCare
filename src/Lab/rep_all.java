package Lab;

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
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class rep_all extends JInternalFrame {
	Connection conn=null;
	ResultSet rs;
	private JTable table;
	private JTable table_2;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rep_all frame = new rep_all();
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
	public rep_all() {
		setBounds(100, 100, 1215, 491);
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
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Doctor ID", "date", "Amount","Report Name", "normal", "result", "remark","status"
					}
				));
			

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 42, 1179, 387);
			desktopPane.add(scrollPane);
			
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("Today List");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
						Date date = new Date();
						PreparedStatement p1=conn.prepareStatement("select l.doc_id,l.date,l.amount,lr.report_name,ld.normal,ld.result,ld.remark,ld.status "
								+ "from lab l,lab_report lr,lab_details ld "
								+ "where lr.LR_id=ld.LR_id AND l.lab_id=ld.lab_id "
								+ "AND l.date like '"+dateFormat.format(date)+"'");
									
										rs=p1.executeQuery();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						model.setRowCount(0);
				    	try {
							while(rs.next())
							{
model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
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
			btnNewButton.setBounds(147, 11, 127, 23);
			desktopPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Last 3 Month");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
						Date date = new Date();
						
						 Calendar cal = Calendar.getInstance();
						  java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("yyyy-MM-dd 00:00:00");
						  String dd_c = fmt1.format(date);
						  Date d = fmt1.parse(dd_c);
							 cal.setTime(d);
							 cal.add(Calendar.MONTH,-3);
							 
						PreparedStatement p2=conn.prepareStatement("select l.doc_id,l.date,l.amount,lr.report_name,ld.normal,ld.result,ld.remark,ld.status "
								+ "from lab l,lab_report lr,lab_details ld "
								+ "where lr.LR_id=ld.LR_id AND l.lab_id=ld.lab_id "
								+ "AND l.date between '"+d+"' AND '"+dateFormat.format(date)+"'");
						ResultSet rs2=p2.executeQuery();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						model.setRowCount(0);
				    	
							while(rs2.next())
							{
								model.addRow(new Object[]{rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6),rs2.getString(7),rs2.getString(8)});
							}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_1.setBounds(284, 11, 120, 23);
			desktopPane.add(btnNewButton_1);
			
			JButton btnNewButton_3 = new JButton("Clear");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
				}
			});
			btnNewButton_3.setBounds(414, 11, 137, 23);
			desktopPane.add(btnNewButton_3);
			
			JButton btnYesterday = new JButton("Yesterday ");
			btnYesterday.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
					Date date = new Date();
					
						 
//					PreparedStatement p2=conn.prepareStatement("select l.doc_id,l.date,l.amount,lr.report_name,ld.normal,ld.result,ld.remark,ld.status "
//							+ "from lab l,lab_report lr,lab_details ld "
//							+ "where lr.LR_id=ld.LR_id AND l.lab_id=ld.lab_id "
//							+ "AND l.date between '"+d+"' AND '"+dateFormat.format(date)+"'");
					//ResultSet rs2=p2.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
			    	
//						while(rs2.next())
//						{
//							model.addRow(new Object[]{rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6),rs2.getString(7),rs2.getString(8)});
//						}
//					
//				} catch (SQLException e11) {
//					// TODO Auto-generated catch block
//					e11.printStackTrace();
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				}
			});
			btnYesterday.setBounds(10, 11, 127, 23);
			desktopPane.add(btnYesterday);
			
	}

}
