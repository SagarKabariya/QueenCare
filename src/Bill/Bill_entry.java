package Bill;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Bill_entry extends JInternalFrame {
	private JTextField textField;
	private JTable table_medi;
	private JTable table_room;
	Connection conn=null;
	PreparedStatement p1,p2;
	ResultSet rs1,rs2,rs3;
	private JTable table_report;
	int caseid,report_charge,dept_charge,room_charge,extra_charge,medi_charge,final_charge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill_entry frame = new Bill_entry();
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
	public Bill_entry() {
		setClosable(true);
		setFrameIcon(null);
		setTitle("Payment - Hospital Management System");
		getContentPane().setBackground(new Color(255, 153, 0));
		setBounds(100, 100, 1059, 489);
		getContentPane().setLayout(null);
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personal Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(310, 11, 723, 48);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 22, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblptname = new JLabel("");
		lblptname.setBounds(66, 23, 174, 14);
		panel.add(lblptname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBounds(587, 22, 46, 14);
		panel.add(lblAge);
		
		JLabel lblage = new JLabel("");
		lblage.setBounds(643, 22, 46, 14);
		panel.add(lblage);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(459, 22, 46, 14);
		panel.add(lblGender);
		
		JLabel lblgender = new JLabel("");
		lblgender.setBounds(515, 21, 62, 14);
		panel.add(lblgender);
		
		JLabel lblNewLabel_4 = new JLabel("Case Date:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(250, 22, 93, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblcasedate = new JLabel("");
		lblcasedate.setBounds(336, 22, 113, 14);
		panel.add(lblcasedate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Test Fee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 70, 735, 380);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDepartmentCharge = new JLabel("Department Detail");
		lblDepartmentCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartmentCharge.setBounds(10, 25, 165, 14);
		panel_1.add(lblDepartmentCharge);
		
		JLabel lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setBounds(20, 50, 130, 14);
		panel_1.add(lblDepartmentName);
		
		JLabel lblDepartmentCharge_1 = new JLabel("Department Charge");
		lblDepartmentCharge_1.setBounds(20, 70, 130, 14);
		panel_1.add(lblDepartmentCharge_1);
		
		JLabel lbldeptname = new JLabel("");
		lbldeptname.setBounds(163, 50, 92, 14);
		panel_1.add(lbldeptname);
		
		JLabel lbldeptcharge = new JLabel("");
		lbldeptcharge.setBounds(160, 70, 59, 14);
		panel_1.add(lbldeptcharge);
		
		JLabel lblReportDetail = new JLabel("Report Detail");
		lblReportDetail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReportDetail.setBounds(290, 22, 147, 20);
		panel_1.add(lblReportDetail);
		
		JLabel lblTotalReport = new JLabel("Total Reports");
		lblTotalReport.setBounds(300, 50, 104, 14);
		panel_1.add(lblTotalReport);
		
		JLabel lblTotalReportsCharge = new JLabel("Total Reports Charge");
		lblTotalReportsCharge.setBounds(300, 70, 114, 14);
		panel_1.add(lblTotalReportsCharge);
		
		JLabel lbltotrep = new JLabel("");
		lbltotrep.setBounds(442, 50, 59, 14);
		panel_1.add(lbltotrep);
		
		JLabel lbltotrepchr = new JLabel("");
		lbltotrepchr.setBounds(442, 70, 59, 14);
		panel_1.add(lbltotrepchr);
		
		JLabel lblMedicineDetail = new JLabel("Medicine Detail");
		lblMedicineDetail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMedicineDetail.setBounds(10, 191, 147, 20);
		panel_1.add(lblMedicineDetail);
		
		JLabel lblTotalAllocateMedicine = new JLabel("Total Allocate Medicine");
		lblTotalAllocateMedicine.setBounds(20, 219, 137, 14);
		panel_1.add(lblTotalAllocateMedicine);
		
		JLabel lblTotalMedicineCharge = new JLabel("Total Medicine Charge");
		lblTotalMedicineCharge.setBounds(20, 239, 130, 14);
		panel_1.add(lblTotalMedicineCharge);
		
		JLabel lbltotmedi = new JLabel("");
		lbltotmedi.setBounds(167, 219, 59, 14);
		panel_1.add(lbltotmedi);
		
		JLabel lbltotmedicharge = new JLabel("");
		lbltotmedicharge.setBounds(167, 239, 59, 14);
		panel_1.add(lbltotmedicharge);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 270, 233, 94);
		panel_1.add(scrollPane);
		
		table_medi = new JTable();
		table_medi.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Charge"
			}
		));
		scrollPane.setViewportView(table_medi);
		
		JLabel lblAdmitDetail = new JLabel("Admit Detail");
		lblAdmitDetail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdmitDetail.setBounds(290, 191, 165, 14);
		panel_1.add(lblAdmitDetail);
		
		JLabel lblAdmissionTimes = new JLabel("Total Times of Admited");
		lblAdmissionTimes.setBounds(300, 216, 130, 14);
		panel_1.add(lblAdmissionTimes);
		
		JLabel lblTotalAdmissionCharge = new JLabel("Total Admission Charge");
		lblTotalAdmissionCharge.setBounds(300, 236, 130, 14);
		panel_1.add(lblTotalAdmissionCharge);
		
		JLabel lbladmit = new JLabel("");
		lbladmit.setBounds(476, 216, 59, 14);
		panel_1.add(lbladmit);
		
		JLabel lbladmitcharge = new JLabel("");
		lbladmitcharge.setBounds(476, 236, 59, 14);
		panel_1.add(lbladmitcharge);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(290, 270, 390, 94);
		panel_1.add(scrollPane_1);
		
		table_room = new JTable();
		table_room.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room Type", "Admit Date", "Release Date", "Room Charge"
			}
		));
		scrollPane_1.setViewportView(table_room);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(302, 95, 378, 85);
		panel_1.add(scrollPane_2);
		
		table_report = new JTable();
		table_report.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Report Name", "Date", "Report Charge"
			}
		));
		scrollPane_2.setViewportView(table_report);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 296, 48);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Case Id:");
		lblNewLabel.setBounds(10, 14, 46, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBounds(66, 12, 119, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(755, 70, 278, 380);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Final Payment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblList = new JLabel("Total Cost as per This Case ID");
		lblList.setBounds(10, 22, 161, 14);
		panel_3.add(lblList);
		
		JLabel lblDepartmentCharge_2 = new JLabel("Department Charge");
		lblDepartmentCharge_2.setBounds(10, 47, 115, 14);
		panel_3.add(lblDepartmentCharge_2);
		
		JLabel lblLabReportCharge = new JLabel("Lab Report Charge");
		lblLabReportCharge.setBounds(10, 72, 115, 14);
		panel_3.add(lblLabReportCharge);
		
		JLabel lblAdmissionCharge = new JLabel("Admission Charge");
		lblAdmissionCharge.setBounds(10, 97, 115, 14);
		panel_3.add(lblAdmissionCharge);
		
		JLabel lblExtraCharge = new JLabel("Extra Charge");
		lblExtraCharge.setBounds(10, 147, 115, 14);
		panel_3.add(lblExtraCharge);
		
		JLabel lblTotalCharge = new JLabel("Total Charge");
		lblTotalCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalCharge.setBounds(10, 201, 115, 25);
		panel_3.add(lblTotalCharge);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setForeground(new Color(0, 0, 0));
		panel_4.setBounds(164, 73, 7, 153);
		panel_3.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(10, 183, 233, 4);
		panel_3.add(panel_5);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(177, 22, 91, 14);
		panel_3.add(label_9);
		
		JLabel lblfinaldeptcharge = new JLabel("");
		lblfinaldeptcharge.setBounds(177, 47, 91, 14);
		panel_3.add(lblfinaldeptcharge);
		
		JLabel lblfinallabcharge = new JLabel("");
		lblfinallabcharge.setBounds(177, 72, 91, 14);
		panel_3.add(lblfinallabcharge);
		
		JLabel lblfinalroomcharge = new JLabel("");
		lblfinalroomcharge.setBounds(177, 97, 91, 14);
		panel_3.add(lblfinalroomcharge);
		
		JLabel lblfinalextracharge = new JLabel("");
		lblfinalextracharge.setBounds(177, 147, 91, 14);
		panel_3.add(lblfinalextracharge);
		
		JLabel lblfinaltotalcost = new JLabel("");
		lblfinaltotalcost.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblfinaltotalcost.setBounds(177, 201, 91, 21);
		panel_3.add(lblfinaltotalcost);
		
		JLabel lblMedicinecharge = new JLabel("Medicine Charge");
		lblMedicinecharge.setBounds(10, 122, 115, 14);
		panel_3.add(lblMedicinecharge);
		
		JLabel lblfinalmedicharge = new JLabel("");
		lblfinalmedicharge.setBounds(177, 122, 91, 14);
		panel_3.add(lblfinalmedicharge);
		
		JLabel lblSelectPaymentType = new JLabel("Select Payment Type");
		lblSelectPaymentType.setBounds(43, 249, 128, 14);
		panel_3.add(lblSelectPaymentType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"cash", "cheque"}));
		comboBox.setBounds(43, 274, 128, 20);
		panel_3.add(comboBox);


		
		JButton btnCloseCase = new JButton("Close Case");
		btnCloseCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		int response = JOptionPane.showConfirmDialog(null, "Are you sure to close this case?", "Confirm for Patient Release",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
				PreparedStatement c1;
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					c1=conn.prepareStatement("INSERT INTO `patient_payment`(`case_id`, `case_charge`, `receipt_date`, `room_charge`, `medicine_charge`, `lab_charge`, `total_charge`, `payment_type`) "
											+ "VALUES (?,?,?,?,?,?,?,?)");
					c1.setInt(1, caseid);
					c1.setInt(2, dept_charge);
					c1.setString(3, dateFormat.format(date));
					c1.setInt(4, room_charge);
					c1.setInt(5, medi_charge);
					c1.setInt(6, report_charge);
					c1.setInt(7, final_charge);
					c1.setString(8, comboBox.getSelectedItem().toString());
					
					c1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Case hase been closed and now you can print all the bill from printing department");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
						
			}
		});
		btnCloseCase.setBounds(43, 305, 200, 35);
		panel_3.add(btnCloseCase);
		
				
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					DefaultTableModel modelmedi = (DefaultTableModel)table_medi.getModel();
					modelmedi.setRowCount(0);
					
					DefaultTableModel modelreport = (DefaultTableModel)table_report.getModel();
					modelreport.setRowCount(0);
					
					DefaultTableModel modelroom = (DefaultTableModel)table_room.getModel();
					modelroom.setRowCount(0);
					
					caseid=Integer.valueOf(textField.getText());
					p1=conn.prepareStatement("select count(ptd.p_id),ptd.p_first_name,ptd.p_gender,ptd.p_age,cm.date_of_case,dp.dept_name,dp.case_charge "
							+ "from patient_detail ptd, case_main cm, department dp "
							+ "where ptd.p_id=cm.p_id AND cm.dept_id=dp.dept_id "
							+ "AND cm.case_id ="+caseid);
					rs1=p1.executeQuery();
					rs1.first();
					if(rs1.getInt(1)==1)
					{
						lblptname.setText(rs1.getString(2));
						lblgender.setText(rs1.getString(3));
						lblage.setText(rs1.getString(4));
						lblcasedate.setText(rs1.getString(5));
						lbldeptname.setText(rs1.getString(6));
						lbldeptcharge.setText(rs1.getString(7));
						dept_charge=Integer.valueOf(rs1.getString(7));
						lblfinaldeptcharge.setText(String.valueOf(dept_charge));
						p1.clearBatch();
						p1=conn.prepareStatement("select lr.report_name,br.test_date,lr.fee from lab_report lr,blood_report br,case_main cm where cm.case_id=br.case_id AND lr.LR_id=5 AND cm.case_id="+caseid);
						rs1.first();
						rs1=p1.executeQuery();
						rs1.first();
						int temp=0,temp2=0;
						while(rs1.next())
						{
							temp=temp+Integer.valueOf(rs1.getString(3));
							temp2++;
							modelreport.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(3)});
						}
						
						p1.clearBatch();
						p1=conn.prepareStatement("select lr.report_name,sr.test_date,lr.fee from lab_report lr,sonography_report sr,case_main cm where cm.case_id=sr.case_id AND lr.LR_id=4 AND cm.case_id="+caseid);
						rs1.first();
						rs1=p1.executeQuery();
						rs1.first();
						int temp3=0;
						while(rs1.next())
						{
							temp3=temp3+Integer.valueOf(rs1.getString(3));
							temp2++;
							modelreport.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(3)});
						}
						//JOptionPane.showMessageDialog(null, rs1.getString(1));
						
						lbltotrep.setText(String.valueOf((temp2)));
						lbltotrepchr.setText(String.valueOf((temp+temp3)));
						report_charge=temp+temp3;
						lblfinallabcharge.setText(String.valueOf(report_charge));
						
						p1.clearBatch();
						p1=conn.prepareStatement("select pm.* from case_main cm, patient_diagnosis pd, "
								+ "patient_medicine pm where cm.case_id=pd.case_id "
								+ "AND pd.pt_diagnosis_id=pm.pt_diagnosis_id AND cm.case_id="+caseid);
						rs1.first();
						rs1=p1.executeQuery();
						
						int temp5=0;
						int temp6=0;
						while(rs1.next())
						{
							temp5=temp5+Integer.valueOf(rs1.getString(5));
							temp6++;
							modelmedi.addRow(new Object[]{rs1.getString(2),rs1.getString(5)});
						}
						lbltotmedi.setText(String.valueOf(temp6));
						lbltotmedicharge.setText(String.valueOf(temp5));
						medi_charge=temp5;
						lblfinalmedicharge.setText(String.valueOf(medi_charge));
					
						//room charge count

						p2=conn.prepareStatement("SELECT count(`in_p_id`),in_patient_detail .* FROM `in_patient_detail` WHERE `case_id` ="+caseid);
						rs2=p2.executeQuery();
						rs2.first();
						if(rs2.getInt(1)==1)
						{
							int response = JOptionPane.showConfirmDialog(null, "Do you want to Relese this patient?", "Confirm for Patient Release",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
									if (response == JOptionPane.YES_OPTION) {
									
													DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
													Date date = new Date();
													p2.clearBatch();
													p2=conn.prepareStatement("INSERT INTO `out_patient_detail`"
															+ "(`case_id`, `room_no`, `Admit_date`, `Dis_date`) "
															+ "VALUES (?,?,?,?)");
													p2.setInt(1, rs2.getInt(3));
													p2.setInt(2, rs2.getInt(4));
													p2.setString(3, rs2.getString(5));
													p2.setString(4, dateFormat.format(date));
													p2.executeUpdate();
													p2.clearBatch();
													p2=conn.prepareStatement("delete from in_patient_detail where case_id="+caseid);
													p2.executeUpdate();
													JOptionPane.showMessageDialog(null, "Patient hase been discharged");
									}

						}
						else
						{
							p2.clearBatch();
							p2=conn.prepareStatement("select rm.room_type,op.Admit_date,op.Dis_date,"
									+ "((datediff(op.Dis_date,op.Admit_date)+1)*(rm.room_charge))"
									+ "from room rm, out_patient_detail op where op.room_no=rm.room_no and op.case_id="+caseid);
							rs3=p2.executeQuery();
							int temp7=0,tempsum=0;
							while(rs3.next())
							{	
								temp7++;
								tempsum=tempsum+rs3.getInt(4);
								modelroom.addRow(new Object[]{rs3.getString(1),rs3.getString(2),rs3.getString(3),rs3.getString(4)});
							}
							room_charge=tempsum;
							lbladmitcharge.setText(String.valueOf(room_charge));
							lbladmit.setText(String.valueOf(temp7));
						}
						lblfinalroomcharge.setText(String.valueOf(room_charge));
						final_charge=room_charge+medi_charge+dept_charge+report_charge;
						lblfinaltotalcost.setText(String.valueOf(final_charge));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Your Enter Wrong CASE ID");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(195, 11, 89, 23);
		panel_2.add(btnNewButton);
	}
}
