package Analysis;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Report_desk extends JInternalFrame {
	Connection conn=null;
	private JPanel contentPane;
	private JTextField txtid;
	private JTable table;
	PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7=null;
	ResultSet rs1,rs2,rs3,rs4,rs5,rs6,rs7=null;
	ArrayList mdlist = new ArrayList();
	int cn1=0,cn2=0,cn3=0,cn4=0,cn5=0,cn6=0,cn7=0,cn8=0;
	int caseid;
	private JTable tblsecond;
	private JTable tblfirst;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_desk frame = new Report_desk();
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
	public Report_desk() {
		setClosable(true);
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		 
		setTitle("Patient Desk - Hospital Managament System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1221, 454);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel main = new JPanel();
		main.setBackground(SystemColor.activeCaption);
		main.setBounds(10, 100, 1185, 313);
		contentPane.add(main);
		main.setLayout(null);
		
		
				
		JPanel sub = new JPanel();
		sub.setBounds(127, 11, 1048, 293);
		main.add(sub);
		sub.setLayout(new CardLayout(0, 0));
		sub.setVisible(false);
		
		final JPanel Registration = new JPanel();
		Registration.setBorder(new TitledBorder(null, "Reg.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.add(Registration, "name_3022770832852");
		Registration.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(16, 21, 58, 14);
		Registration.add(lblFirstName);				
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(16, 43, 65, 14);
		Registration.add(lblLastName);				
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(15, 66, 58, 14);
		Registration.add(lblAge);				
		JLabel lblBloodgroup = new JLabel("Blood Group:");
		lblBloodgroup.setBounds(16, 87, 90, 14);
		Registration.add(lblBloodgroup);				
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(16, 110, 58, 14);
		Registration.add(lblGender);
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(16, 131, 58, 14);
		Registration.add(lblWeight);				
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(16, 173, 58, 14);
		Registration.add(lblContactNo);				
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(16, 152, 58, 14);
		Registration.add(lblAddress);				
		JLabel lblMartialStatus = new JLabel("Martial Status:");
		lblMartialStatus.setBounds(16, 194, 90, 14);
		Registration.add(lblMartialStatus);				
		JLabel lblHusbandfatherName = new JLabel("Husband/Father Name:");
		lblHusbandfatherName.setBounds(16, 214, 112, 14);
		Registration.add(lblHusbandfatherName);				
		JLabel lblrgfname = new JLabel("");
		lblrgfname.setBounds(179, 21, 216, 14);
		Registration.add(lblrgfname);				
		JLabel lblrglname = new JLabel("");
		lblrglname.setBounds(179, 43, 216, 14);
		Registration.add(lblrglname);				
		JLabel lblrgage = new JLabel("");
		lblrgage.setBounds(179, 66, 216, 14);
		Registration.add(lblrgage);				
		JLabel lblrggender = new JLabel("");
		lblrggender.setBounds(179, 110, 216, 14);
		Registration.add(lblrggender);				
		JLabel lblrgwajan = new JLabel("");
		lblrgwajan.setBounds(179, 131, 216, 14);
		Registration.add(lblrgwajan);				
		JLabel lblrgadd = new JLabel("");
		lblrgadd.setBounds(179, 152, 216, 14);
		Registration.add(lblrgadd);				
		JLabel lblrgcontact = new JLabel("");
		lblrgcontact.setBounds(179, 173, 216, 14);
		Registration.add(lblrgcontact);				
		JLabel lblrgMstatus = new JLabel("");
		lblrgMstatus.setBounds(179, 194, 216, 14);
		Registration.add(lblrgMstatus);				
		JLabel lblrgHFname = new JLabel("");
		lblrgHFname.setBounds(179, 214, 216, 14);
		Registration.add(lblrgHFname);				
		JLabel lblrgbgrp = new JLabel("");
		lblrgbgrp.setBounds(179, 87, 216, 14);
		Registration.add(lblrgbgrp);
		
		
		final JPanel Appointment = new JPanel();
		Appointment.setBorder(new TitledBorder(null, "Appo.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.add(Appointment, "name_3051313891789");
		Appointment.setLayout(null);
		
		JLabel lblAppointmentId = new JLabel("Appointment Id");
		lblAppointmentId.setBounds(10, 34, 109, 14);
		Appointment.add(lblAppointmentId);
		JLabel lblAppointmentDate = new JLabel("Appointment Date");
		lblAppointmentDate.setBounds(10, 60, 109, 14);
		Appointment.add(lblAppointmentDate);		
		JLabel lblDoctorName = new JLabel("Doctor Name");
		lblDoctorName.setBounds(10, 86, 109, 14);
		Appointment.add(lblDoctorName);		
		JLabel lblAppointmentTime = new JLabel("Appointment Time");
		lblAppointmentTime.setBounds(10, 112, 109, 14);
		Appointment.add(lblAppointmentTime);		
		JLabel lblAppointmentStatus = new JLabel("Appointment Status");
		lblAppointmentStatus.setBounds(10, 137, 109, 14);
		Appointment.add(lblAppointmentStatus);		
		JLabel lblappid = new JLabel("");
		lblappid.setBounds(143, 34, 250, 14);
		Appointment.add(lblappid);		
		JLabel lblappdate = new JLabel("");
		lblappdate.setBounds(143, 59, 250, 14);
		Appointment.add(lblappdate);		
		JLabel lblappdoc = new JLabel("");
		lblappdoc.setBounds(143, 86, 250, 14);
		Appointment.add(lblappdoc);		
		JLabel lblapptime = new JLabel("");
		lblapptime.setBounds(143, 112, 250, 14);
		Appointment.add(lblapptime);
		
		JLabel lblappstatus = new JLabel("");
		lblappstatus.setBounds(143, 137, 250, 14);
		Appointment.add(lblappstatus);
		final JPanel Case = new JPanel();
		Case.setBorder(new TitledBorder(null, "case", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.add(Case, "name_3075138723750");
		Case.setLayout(null);		
		JLabel lblCNo = new JLabel("Department");
		lblCNo.setBounds(10, 29, 71, 14);
		Case.add(lblCNo);		
		JLabel lblCaseDate = new JLabel("Case Date");
		lblCaseDate.setBounds(10, 59, 58, 14);
		Case.add(lblCaseDate);		
		JLabel lblValiditOfFile = new JLabel("Validit Of File");
		lblValiditOfFile.setBounds(10, 90, 71, 14);
		Case.add(lblValiditOfFile);
		JLabel lblcasedept = new JLabel("");
		lblcasedept.setBounds(107, 29, 185, 14);
		Case.add(lblcasedept);
		JLabel lblcasedate = new JLabel("");
		lblcasedate.setBounds(107, 59, 185, 14);
		Case.add(lblcasedate);
		JLabel lblcasevalid = new JLabel("");
		lblcasevalid.setBounds(107, 90, 185, 14);
		Case.add(lblcasevalid);
		
		JLabel lblcasedoc = new JLabel("Doctor");
		lblcasedoc.setBounds(10, 115, 71, 14);
		Case.add(lblcasedoc);
		
		JLabel lblcasedocname = new JLabel("");
		lblcasedocname.setBounds(107, 115, 185, 14);
		Case.add(lblcasedocname);
		
		final JPanel Diagnosis = new JPanel();
		Diagnosis.setBorder(new TitledBorder(null, "Lab", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.add(Diagnosis, "name_3113556445605");
		Diagnosis.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 728, 261);
		Diagnosis.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Report Name", "Normal", "Result of report", "Remark", "Status"
			}
		));
		
		final JPanel Diet = new JPanel();
		Diet.setBorder(new TitledBorder(null, "Diet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.add(Diet, "name_3136172390125");
		Diet.setLayout(null);
		
		JLabel lblDoctorDietAdvice = new JLabel("Doctor Diet Advice");
		lblDoctorDietAdvice.setBounds(10, 28, 145, 14);
		Diet.add(lblDoctorDietAdvice);
		
		JLabel lbldiettext = new JLabel("\r\n");
		lbldiettext.setBounds(10, 53, 291, 121);
		Diet.add(lbldiettext);
		
		final JPanel Medicine = new JPanel();
		Medicine.setBorder(new TitledBorder(null, "Medicine", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.add(Medicine, "name_3136172390125");
		Medicine.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 57, 501, 210);
		Medicine.add(scrollPane_1);
		
		tblsecond = new JTable();
		tblsecond.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Precaution", "No of Dose"
			}
		));
		scrollPane_1.setViewportView(tblsecond);
		
		JLabel lblPatientHasMay = new JLabel("Patient has may be diagnosising maltiple time by doctor so you select any one Diagnosis ID as per Date");
		lblPatientHasMay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPatientHasMay.setForeground(Color.RED);
		lblPatientHasMay.setBounds(10, 21, 703, 25);
		Medicine.add(lblPatientHasMay);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 57, 210, 95);
		Medicine.add(scrollPane_2);
		
		tblfirst = new JTable();
		tblfirst.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Date"
			}
		));
		scrollPane_2.setViewportView(tblfirst);
		
		JLabel lblEnterId = new JLabel("Select ID");
		lblEnterId.setBounds(23, 169, 68, 14);
		Medicine.add(lblEnterId);
		
		JComboBox cmbmid = new JComboBox();
		cmbmid.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					ps6=conn.prepareStatement("select pm.* from patient_medicine pm"
							+ " where pm.pt_diagnosis_id="+Integer.valueOf((String) cmbmid.getSelectedItem()));
					rs6=ps6.executeQuery();
					System.out.println(ps6);
					DefaultTableModel model = (DefaultTableModel)tblsecond.getModel();
					model.setRowCount(0);
						while(rs6.next())
						{
						model.addRow(new Object[]{rs6.getString(2),rs6.getString(3),rs6.getString(4)});
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cmbmid.setBounds(96, 166, 46, 20);
		Medicine.add(cmbmid);
		
		final JPanel Bill = new JPanel();
		Bill.setBorder(new TitledBorder(null, "Bill", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.add(Bill, "name_3136172390125");
		Bill.setLayout(null);
		
		JPanel btn = new JPanel();
		btn.setBounds(10, 11, 116, 293);
		main.add(btn);
		btn.setLayout(null);
		btn.setVisible(false);
		
		JButton btnReg = new JButton("Registration\r\n");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.setVisible(true);
				Appointment.setVisible(false);
				Case.setVisible(false);
				Diet.setVisible(false);
				Medicine.setVisible(false);
			
				Diagnosis.setVisible(false);
				Bill.setVisible(false);
				cn1++;
				if(cn1==1){
				try {
				ps2=conn.prepareStatement("select pd.* from patient_detail pd, case_main cs where cs.p_id=pd.p_id AND cs.case_id="+caseid);
				rs2=ps2.executeQuery();
				rs2.next();
				lblrgfname.setText(rs2.getString(2));
				lblrglname.setText(rs2.getString(3));
				lblrgage.setText(rs2.getString(4));
				lblrgbgrp.setText(rs2.getString(5));
				lblrgwajan.setText(rs2.getString(6));
				lblrggender.setText(rs2.getString(7));
				lblrgadd.setText(rs2.getString(8));
				lblrgcontact.setText(rs2.getString(9));
				lblrgHFname.setText("working on it");
				lblrgMstatus.setText("working on it");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				}
			}
		});
		btnReg.setBounds(3, 11, 107, 23);
		btn.add(btnReg);
		
		JButton btnAppointment = new JButton("Appointment\r\n");
		btnAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.setVisible(false);
				Appointment.setVisible(true);
				Case.setVisible(false);
				Diet.setVisible(false);
				Medicine.setVisible(false);
			
				Diagnosis.setVisible(false);
				Bill.setVisible(false);
				cn2++;
				if(cn2==1){
				try {
				ps3=conn.prepareStatement("SELECT * FROM `appointment` WHERE `case_id` ="+caseid);
				rs3=ps3.executeQuery();
				rs3.next();
				
				lblappid.setText(rs3.getString(1));
				lblappdate.setText(rs3.getString(4));
				lblapptime.setText(rs3.getString(5));
				lblappdoc.setText(rs3.getString(3));
				lblappstatus.setText(rs3.getString(6));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		btnAppointment.setBounds(3, 38, 107, 23);
		btn.add(btnAppointment);
		
		JButton btnCase = new JButton("Case\r\n");
		btnCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.setVisible(false);
				Appointment.setVisible(false);
				Case.setVisible(true);
				Diet.setVisible(false);
				Medicine.setVisible(false);
			
				Diagnosis.setVisible(false);
				Bill.setVisible(false);
				
				cn3++;
				if(cn3==1){
				try {
					ps3=conn.prepareStatement("select d.dept_name,c.date_of_case,c.validity_of_case,c.doc_id from case_main c,department d where d.dept_id=c.dept_id AND c.case_id="+caseid);
					rs3=ps3.executeQuery();
					rs3.next();
					lblcasedept.setText(rs3.getString(1));
					lblcasedate.setText(rs3.getString(2));
					lblcasevalid.setText(rs3.getString(3));
					lblcasedocname.setText(rs3.getString(4));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		btnCase.setBounds(3, 65, 107, 23);
		btn.add(btnCase);
		
		JButton btnDiet = new JButton("Diet\r\n");
		btnDiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.setVisible(false);
				Appointment.setVisible(false);
				Case.setVisible(false);
				Diet.setVisible(true);
				Medicine.setVisible(false);
			
				Diagnosis.setVisible(false);
				Bill.setVisible(false);
				
				cn4++;
				if(cn4==1){
				try {
					ps4=conn.prepareStatement("SELECT da.diet_advice FROM patient_diet da,patient_diagnosis pd WHERE pd.pt_diagnosis_id=da.pt_diagnosis_id AND pd.case_id="+caseid);
					rs4=ps4.executeQuery();
					rs4.next();
					lbldiettext.setText(rs4.getString(1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				}
		});
		btnDiet.setBounds(4, 93, 106, 23);
		btn.add(btnDiet);
		
		JButton btnMedicine = new JButton("Medicine\r\n");
		btnMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.setVisible(false);
				Appointment.setVisible(false);
				Case.setVisible(false);
				Diet.setVisible(false);
				Medicine.setVisible(true);			
				Diagnosis.setVisible(false);
				Bill.setVisible(false);
				
				cn5++;
				if(cn5==1){
				try {
					ps5=conn.prepareStatement("select pd.pt_diagnosis_id,pd.diagnosis_date from patient_diagnosis pd where pd.case_id="+caseid);
					rs5=ps5.executeQuery();
					rs5.next();
					DefaultTableModel model = (DefaultTableModel)tblfirst.getModel();
					model.setRowCount(0);
						while(rs5.next())
						{
						model.addRow(new Object[]{rs5.getString(1),rs5.getString(2)});
						cmbmid.addItem(rs5.getString(1));
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		btnMedicine.setBounds(4, 119, 106, 23);
		btn.add(btnMedicine);
		
		JButton btnDiagnosis = new JButton("Diagnosis\r\n");
		btnDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.setVisible(false);
				Appointment.setVisible(false);
				Case.setVisible(false);
				Diet.setVisible(false);
				Medicine.setVisible(false);			
				Diagnosis.setVisible(true);
				Bill.setVisible(false);
				
				try {
					ps7=conn.prepareStatement("select lr.report_name,ld.normal,ld.result,ld.remark,ld.status "
							+ "from lab_report lr,lab_details ld,lab l "
							+ "where l.lab_id=ld.lab_id AND lr.LR_id=ld.LR_id AND l.case_id="+caseid);
					rs7=ps7.executeQuery();
					rs7.next();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
						while(rs7.next())
						{
						model.addRow(new Object[]{rs7.getString(1),rs7.getString(2),rs7.getString(3),rs7.getString(4),rs7.getString(5)});
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDiagnosis.setBounds(4, 145, 106, 23);
		btn.add(btnDiagnosis);
		
		JButton btnBill = new JButton("Bill\r\n");
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.setVisible(false);
				Appointment.setVisible(false);
				Case.setVisible(false);
				Diet.setVisible(false);
				Medicine.setVisible(false);
				Diagnosis.setVisible(false);
				Bill.setVisible(true);

			}
		});
		btnBill.setBounds(3, 171, 107, 23);
		btn.add(btnBill);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 8, 1205, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterCaseId = new JLabel("Enter Id:");
		lblEnterCaseId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterCaseId.setBounds(533, 14, 63, 14);
		panel.add(lblEnterCaseId);
		
		txtid = new JTextField();
		txtid.setBounds(606, 12, 145, 20);
		panel.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblSelectAnyOne = new JLabel("Select any one category for searching records");
		lblSelectAnyOne.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectAnyOne.setBounds(10, 10, 356, 20);
		panel.add(lblSelectAnyOne);
		
		JComboBox cmbpattern = new JComboBox();
		cmbpattern.setModel(new DefaultComboBoxModel(new String[] {"Select", "Find On Case ID", "Find On Patient ID"}));
		cmbpattern.setBounds(358, 12, 127, 20);
		panel.add(cmbpattern);
		
		JComboBox cmbhide1 = new JComboBox();
		cmbhide1.setModel(new DefaultComboBoxModel(new String[] {"select case id"}));
		cmbhide1.setBounds(606, 43, 145, 20);
		panel.add(cmbhide1);
		cmbhide1.setVisible(false);
		
		JButton btnhide1 = new JButton("Show Everything");
		btnhide1.setBounds(761, 42, 153, 23);
		panel.add(btnhide1);
		btnhide1.setVisible(false);
		
		JLabel lblhide2 = new JLabel("This is Case ID and you select any one case id for more information");
		lblhide2.setForeground(Color.RED);
		lblhide2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblhide2.setBounds(494, 67, 398, 14);
		panel.add(lblhide2);
		lblhide2.setVisible(false);
		
		JLabel lblhide1 = new JLabel("Select Case ID");
		lblhide1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblhide1.setBounds(494, 49, 112, 14);
		panel.add(lblhide1);
		lblhide1.setVisible(false);
		
		JButton btnShowEverything = new JButton("Show Everything");
		btnShowEverything.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int tcid= Integer.valueOf(txtid.getText());
					caseid=tcid;
					if(cmbpattern.getSelectedIndex()==2){
						ps1=conn.prepareStatement("SELECT count(`p_id`) FROM `patient_detail` WHERE p_id="+tcid);
						rs1=ps1.executeQuery();
						rs1.next();
						int c=rs1.getInt(1);
						if(c<1)
						{	
							JOptionPane.showMessageDialog(null, "No Record found for patient id "+tcid);
						}
						else
						{
							lblhide1.setVisible(true);
							lblhide2.setVisible(true);
							btnhide1.setVisible(true);
							cmbhide1.setVisible(true);
							
							ps2=conn.prepareStatement("SELECT case_id FROM `case_main` WHERE p_id="+tcid);
							rs2=ps2.executeQuery();
							
							while(rs2.next())
							{
								cmbhide1.addItem(rs2.getInt(1));
							}							
						}
					}
					else if(cmbpattern.getSelectedIndex()==1)
					{
					
						ps1=conn.prepareStatement("select count(case_id) from case_main where case_id = "+tcid);
						rs1=ps1.executeQuery();
						rs1.next();
						int c=rs1.getInt(1);
						if(c<1)
						{	
							JOptionPane.showMessageDialog(null, "No Record found for case id "+caseid);
						}
						else
						{
							sub.setVisible(true);
							btn.setVisible(true);
							
						}
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowEverything.setBounds(761, 12, 153, 23);
		panel.add(btnShowEverything);
		btnhide1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sub.setVisible(true);
				btn.setVisible(true);
			}
		});

	}
}
