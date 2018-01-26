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
		setBounds(100, 100, 1288, 569);
		getContentPane().setLayout(null);
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personal Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(379, 11, 881, 67);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 22, 71, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblptname = new JLabel("");
		lblptname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblptname.setBounds(66, 23, 174, 21);
		panel.add(lblptname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAge.setBounds(724, 17, 62, 24);
		panel.add(lblAge);
		
		JLabel lblage = new JLabel("");
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblage.setBounds(798, 13, 71, 31);
		panel.add(lblage);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGender.setBounds(514, 13, 62, 32);
		panel.add(lblGender);
		
		JLabel lblgender = new JLabel("");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblgender.setBounds(588, 17, 71, 31);
		panel.add(lblgender);
		
		JLabel lblNewLabel_4 = new JLabel("Case Date:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(250, 22, 93, 19);
		panel.add(lblNewLabel_4);
		
		JLabel lblcasedate = new JLabel("");
		lblcasedate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblcasedate.setBounds(355, 23, 133, 21);
		panel.add(lblcasedate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Test Fee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 87, 864, 433);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDepartmentCharge = new JLabel("Department Detail");
		lblDepartmentCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartmentCharge.setBounds(10, 25, 165, 14);
		panel_1.add(lblDepartmentCharge);
		
		JLabel lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDepartmentName.setBounds(20, 50, 199, 31);
		panel_1.add(lblDepartmentName);
		
		JLabel lblDepartmentCharge_1 = new JLabel("Department Charge");
		lblDepartmentCharge_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDepartmentCharge_1.setBounds(20, 125, 199, 31);
		panel_1.add(lblDepartmentCharge_1);
		
		JLabel lbldeptname = new JLabel("");
		lbldeptname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldeptname.setBounds(140, 82, 190, 31);
		panel_1.add(lbldeptname);
		
		JLabel lbldeptcharge = new JLabel("");
		lbldeptcharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldeptcharge.setBounds(140, 160, 190, 31);
		panel_1.add(lbldeptcharge);
		
		JLabel lblReportDetail = new JLabel("Report Detail");
		lblReportDetail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReportDetail.setBounds(387, 15, 147, 34);
		panel_1.add(lblReportDetail);
		
		JLabel lblTotalReport = new JLabel("Total Reports");
		lblTotalReport.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalReport.setBounds(397, 50, 178, 31);
		panel_1.add(lblTotalReport);
		
		JLabel lblTotalReportsCharge = new JLabel("Total Reports Charge");
		lblTotalReportsCharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalReportsCharge.setBounds(397, 87, 178, 26);
		panel_1.add(lblTotalReportsCharge);
		
		JLabel lbltotrep = new JLabel("");
		lbltotrep.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbltotrep.setBounds(646, 50, 169, 31);
		panel_1.add(lbltotrep);
		
		JLabel lbltotrepchr = new JLabel("");
		lbltotrepchr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbltotrepchr.setBounds(646, 87, 169, 26);
		panel_1.add(lbltotrepchr);
		
		JLabel lblMedicineDetail = new JLabel("Medicine Detail");
		lblMedicineDetail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMedicineDetail.setBounds(10, 207, 147, 20);
		panel_1.add(lblMedicineDetail);
		
		JLabel lblTotalAllocateMedicine = new JLabel("Total Allocate Medicine");
		lblTotalAllocateMedicine.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalAllocateMedicine.setBounds(10, 239, 209, 44);
		panel_1.add(lblTotalAllocateMedicine);
		
		JLabel lblTotalMedicineCharge = new JLabel("Total Medicine Charge");
		lblTotalMedicineCharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalMedicineCharge.setBounds(10, 289, 209, 24);
		panel_1.add(lblTotalMedicineCharge);
		
		JLabel lbltotmedi = new JLabel("");
		lbltotmedi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbltotmedi.setBounds(219, 249, 146, 31);
		panel_1.add(lbltotmedi);
		
		JLabel lbltotmedicharge = new JLabel("");
		lbltotmedicharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbltotmedicharge.setBounds(219, 289, 146, 24);
		panel_1.add(lbltotmedicharge);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 326, 355, 94);
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
		lblAdmitDetail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmitDetail.setBounds(387, 220, 173, 33);
		panel_1.add(lblAdmitDetail);
		
		JLabel lblAdmissionTimes = new JLabel("Total Times of Admited");
		lblAdmissionTimes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdmissionTimes.setBounds(387, 259, 252, 27);
		panel_1.add(lblAdmissionTimes);
		
		JLabel lblTotalAdmissionCharge = new JLabel("Total Admission Charge");
		lblTotalAdmissionCharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalAdmissionCharge.setBounds(387, 290, 252, 23);
		panel_1.add(lblTotalAdmissionCharge);
		
		JLabel lbladmit = new JLabel("");
		lbladmit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbladmit.setBounds(651, 259, 190, 27);
		panel_1.add(lbladmit);
		
		JLabel lbladmitcharge = new JLabel("");
		lbladmitcharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbladmitcharge.setBounds(651, 290, 190, 23);
		panel_1.add(lbladmitcharge);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(388, 326, 465, 94);
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
		scrollPane_2.setBounds(387, 126, 466, 85);
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
		panel_2.setBounds(10, 11, 357, 67);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Case Id:");
		lblNewLabel.setBounds(10, 25, 80, 19);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(102, 13, 119, 42);
		panel_2.add(textField);
		textField.setColumns(10);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(886, 91, 374, 429);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Final Payment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblList = new JLabel("Total Cost on Case ID");
		lblList.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblList.setBounds(10, 18, 184, 26);
		panel_3.add(lblList);
		
		JLabel lblDepartmentCharge_2 = new JLabel("Department Charge");
		lblDepartmentCharge_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDepartmentCharge_2.setBounds(10, 49, 184, 26);
		panel_3.add(lblDepartmentCharge_2);
		
		JLabel lblLabReportCharge = new JLabel("Lab Report Charge");
		lblLabReportCharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLabReportCharge.setBounds(10, 88, 184, 23);
		panel_3.add(lblLabReportCharge);
		
		JLabel lblAdmissionCharge = new JLabel("Admission Charge");
		lblAdmissionCharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdmissionCharge.setBounds(10, 124, 184, 25);
		panel_3.add(lblAdmissionCharge);
		
		JLabel lblExtraCharge = new JLabel("Extra Charge");
		lblExtraCharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblExtraCharge.setBounds(12, 201, 182, 30);
		panel_3.add(lblExtraCharge);
		
		JLabel lblTotalCharge = new JLabel("Total Charge");
		lblTotalCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalCharge.setBounds(55, 258, 115, 25);
		panel_3.add(lblTotalCharge);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setForeground(new Color(0, 0, 0));
		panel_4.setBounds(206, 18, 10, 265);
		panel_3.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(72, 244, 233, 4);
		panel_3.add(panel_5);
		
		JLabel label_9 = new JLabel("");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_9.setBounds(228, 18, 106, 25);
		panel_3.add(label_9);
		
		JLabel lblfinaldeptcharge = new JLabel("");
		lblfinaldeptcharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblfinaldeptcharge.setBounds(228, 49, 106, 26);
		panel_3.add(lblfinaldeptcharge);
		
		JLabel lblfinallabcharge = new JLabel("");
		lblfinallabcharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblfinallabcharge.setBounds(228, 88, 106, 18);
		panel_3.add(lblfinallabcharge);
		
		JLabel lblfinalroomcharge = new JLabel("");
		lblfinalroomcharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblfinalroomcharge.setBounds(228, 124, 115, 19);
		panel_3.add(lblfinalroomcharge);
		
		JLabel lblfinalextracharge = new JLabel("");
		lblfinalextracharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblfinalextracharge.setBounds(228, 197, 115, 26);
		panel_3.add(lblfinalextracharge);
		
		JLabel lblfinaltotalcost = new JLabel("");
		lblfinaltotalcost.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblfinaltotalcost.setBounds(224, 258, 106, 25);
		panel_3.add(lblfinaltotalcost);
		
		JLabel lblMedicinecharge = new JLabel("Medicine Charge");
		lblMedicinecharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMedicinecharge.setBounds(10, 162, 184, 26);
		panel_3.add(lblMedicinecharge);
		
		JLabel lblfinalmedicharge = new JLabel("");
		lblfinalmedicharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblfinalmedicharge.setBounds(228, 162, 115, 22);
		panel_3.add(lblfinalmedicharge);
		
		JLabel lblSelectPaymentType = new JLabel("Select Payment Type");
		lblSelectPaymentType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSelectPaymentType.setBounds(10, 304, 175, 35);
		panel_3.add(lblSelectPaymentType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"cash", "cheque"}));
		comboBox.setBounds(10, 335, 175, 35);
		panel_3.add(comboBox);


		
		JButton btnCloseCase = new JButton("Close Case");
		btnCloseCase.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		btnCloseCase.setBounds(10, 381, 200, 35);
		panel_3.add(btnCloseCase);
		
				
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		btnNewButton.setBounds(233, 15, 96, 34);
		panel_2.add(btnNewButton);
	}
}
