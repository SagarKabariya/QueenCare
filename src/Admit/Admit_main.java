package Admit;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Admit_main extends JInternalFrame {
	Connection conn=null;
	PreparedStatement p1,p2;
	Hashtable hashtable = new Hashtable();
	ResultSet rs1,rs2,t1;
	private JTextField textField;
	int inpid,caseid;
	private JTable table,table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admit_main frame = new Admit_main();
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
	public Admit_main() {
		setTitle("Room Desk - Hospital Management System");
		setClosable(true);
		setBounds(100, 100, 827, 377);
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }

		 
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaptionBorder);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		JPanel showroom = new JPanel();
		showroom.setBounds(307, 11, 248, 138);
		desktopPane.add(showroom);
		showroom.setVisible(false);
		showroom.setLayout(null);
		
		JLabel lblAvailableRooms = new JLabel("Select Room");
		lblAvailableRooms.setBounds(10, 11, 183, 21);
		lblAvailableRooms.setFont(new Font("Tahoma", Font.BOLD, 21));
		showroom.add(lblAvailableRooms);
		
		JComboBox comboBox_room = new JComboBox();
		comboBox_room.setBounds(63, 73, 112, 20);
		showroom.add(comboBox_room);
		
		JLabel lblSelectTypeOf = new JLabel("Select Type of Room");
		lblSelectTypeOf.setBounds(63, 48, 130, 14);
		showroom.add(lblSelectTypeOf);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 287, 138);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTakeAddmission = new JLabel("Admission Desk");
		lblTakeAddmission.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTakeAddmission.setBounds(10, 11, 309, 21);
		panel.add(lblTakeAddmission);
		
		JLabel lblNewLabel = new JLabel("Case Number");
		lblNewLabel.setBounds(10, 46, 77, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setBounds(10, 84, 77, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblname = new JLabel("");
		lblname.setBounds(102, 84, 113, 14);
		panel.add(lblname);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setBounds(10, 109, 77, 14);
		panel.add(lblDoctorId);
		
		JLabel lbldocid = new JLabel("");
		lbldocid.setBounds(102, 109, 113, 14);
		panel.add(lbldocid);
		
		textField = new JTextField();
		textField.setBounds(97, 43, 130, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 160, 400, 173);
		desktopPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblRoomCurrentStatus = new JLabel("Room types & fare");
		lblRoomCurrentStatus.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblRoomCurrentStatus.setBounds(10, 11, 253, 21);
		panel_3.add(lblRoomCurrentStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 43, 370, 119);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room Type", "Total Bad", "Room Charge"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		
		JPanel bye = new JPanel();
		bye.setBounds(565, 11, 236, 138);
		desktopPane.add(bye);
		bye.setLayout(null);
		
		JLabel lblAddmissionDate = new JLabel("Addmission Date");
		lblAddmissionDate.setBounds(10, 54, 93, 14);
		bye.add(lblAddmissionDate);
		
		JLabel lblCaseId = new JLabel("Case Id");
		lblCaseId.setBounds(10, 79, 79, 14);
		bye.add(lblCaseId);
		
		JButton btnReleasePatient = new JButton("Release Patient");
		btnReleasePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement upinpd,upinpd2,upinpd3;
				try {
					upinpd=conn.prepareStatement("select * from in_patient_detail where in_p_id="+inpid);
					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (response == JOptionPane.YES_OPTION) {
								ResultSet temp;
								temp=upinpd.executeQuery();
								temp.first();
								DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
								Date date = new Date();
								upinpd2=conn.prepareStatement("INSERT INTO `out_patient_detail`"
										+ "(`case_id`, `room_no`, `Admit_date`, `Dis_date`) "
										+ "VALUES (?,?,?,?)");
								upinpd2.setInt(1, temp.getInt(2));
								upinpd2.setInt(2, temp.getInt(3));
								upinpd2.setString(3, temp.getString(4));
								upinpd2.setString(4, dateFormat.format(date));
								upinpd2.executeUpdate();
								
								upinpd3=conn.prepareStatement("delete from in_patient_detail where in_p_id="+inpid);
								upinpd3.executeUpdate();
								JOptionPane.showMessageDialog(null, "Patient hase been discharged");
							}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnReleasePatient.setBounds(59, 104, 114, 23);
		bye.add(btnReleasePatient);
		
		JLabel lblAdate = new JLabel("");
		lblAdate.setBounds(113, 11, 113, 14);
		bye.add(lblAdate);
		
		JLabel lblcase = new JLabel("");
		lblcase.setBounds(123, 36, 103, 14);
		bye.add(lblcase);
		
		JLabel lblDischargePatient = new JLabel("Discharge Patient");
		lblDischargePatient.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblDischargePatient.setBounds(10, 11, 216, 21);
		bye.add(lblDischargePatient);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(420, 160, 391, 173);
		desktopPane.add(panel_4);
		
		JLabel label = new JLabel("Room Current Status");
		label.setFont(new Font("Tahoma", Font.BOLD, 21));
		label.setBounds(10, 11, 253, 21);
		panel_4.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 43, 361, 119);
		panel_4.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room Type", "Case ID", "Patient Name", "Addmission Date"
			}
		));
		table_1.getColumnModel().getColumn(3).setPreferredWidth(116);
		scrollPane_1.setViewportView(table_1);
		bye.setVisible(false);
		
		try {
			
			p2=conn.prepareStatement("select room_type,no_of_bed,room_charge from room");
		
			t1=p2.executeQuery();
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		t1.previous();
    	while(t1.next()){
    		
    		model.addRow(new Object[]{t1.getString(1),t1.getString(2),t1.getString(3)});
    		comboBox_room.addItem(t1.getString(1));
    		//hashtable.put(t1.getString(1),t1.getString(5));
    	}		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			p2=conn.prepareStatement("select rm.room_type,ins.case_id,pt.p_first_name,ins.date_admission "
					+ "from in_patient_detail ins, room rm,case_main cm,patient_detail pt "
					+ "where rm.room_no=ins.room_no AND ins.case_id=cm.case_id AND cm.p_id=pt.p_id");
			ResultSet rst2=p2.executeQuery();
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
    	while(rst2.next()){
   model.addRow(new Object[]{rst2.getString(1),rst2.getString(2),rst2.getString(3),rst2.getString(4)});
    	}		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    	
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				bye.setVisible(false);
				showroom.setVisible(false);
				caseid=Integer.valueOf(textField.getText());
				try {
					p1=conn.prepareStatement("select p.p_first_name,d.doc_id "
							+ "from patient_detail p,doctor d,case_main c "
							+ "where p.p_id=c.p_id AND d.doc_id=c.doc_id "
							+ "AND c.case_id = "+caseid);
					
					rs1=p1.executeQuery();
					int c=0;
					
					while(rs1.next())
					{
					c=1;
					lblname.setText(rs1.getString(1));
					lbldocid.setText(rs1.getString(2));
					PreparedStatement inpd;
					ResultSet rspd;
					inpd=conn.prepareStatement("select count(in_p_id),in_p_id from in_patient_detail where case_id="+caseid);
					rspd=inpd.executeQuery();
					rspd.first();
					inpid=rspd.getInt(2);
					if(rspd.getInt(1)==1){
						c=1;
					}
					else{
						c=2;
					}
					}
					if(c==0){
						JOptionPane.showMessageDialog(null, "No Record Found on case id as per your need");
					}
					else if(c==2){		
						showroom.setVisible(true);
					}
					else if(c==1){
							bye.setVisible(true);
							lblAdate.setText("");
							lblcase.setText(""+caseid);
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnAdmit = new JButton("Admit");
		btnAdmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String str,str2=comboBox_room.getSelectedItem().toString();
				    Enumeration names = hashtable.keys();
				      while(names.hasMoreElements()) {
				         str = (String) names.nextElement().toString();
				         if(str.equals(str2)==true){
				        	int roomid=Integer.valueOf((String) hashtable.get(str2));
				        	 PreparedStatement insp;
				        	 try {
				        		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
								Date date = new Date();
								insp=conn.prepareStatement("INSERT INTO `in_patient_detail`"
								 		+ "(`case_id`, `room_no`, `date_admission`) "
								 		+ "VALUES (?,?,?)");
								insp.setInt(1, caseid);
								insp.setInt(2, roomid);
								insp.setString(3,dateFormat.format(date));
								int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
										JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
										if (response == JOptionPane.YES_OPTION) {
											insp.executeUpdate();
											 JOptionPane.showMessageDialog(null, "Patient Admited Successfully");
										}
									
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				         }
				      }
			}
		});
		btnAdmit.setBounds(73, 104, 89, 23);
		showroom.add(btnAdmit);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, getContentPane(), desktopPane, showroom, lblAvailableRooms, comboBox_room, lblSelectTypeOf, btnAdmit, panel, lblTakeAddmission, lblNewLabel, lblNewLabel_1, lblname, lblDoctorId, lbldocid, panel_3, lblRoomCurrentStatus, scrollPane, table, bye, lblAddmissionDate, lblCaseId, btnReleasePatient, lblAdate, lblcase, lblDischargePatient, panel_4, label, scrollPane_1, table_1}));
	}
}
