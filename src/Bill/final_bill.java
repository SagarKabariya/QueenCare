package Bill;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class final_bill extends JInternalFrame {
int caseid;
static int id;
Connection conn=null;
PreparedStatement p1;
ResultSet rs1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final_bill frame = new final_bill();
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
	public final_bill() {
		setClosable(true);		
		setTitle("Final Bill Printing - Hospital Management System");
		setBounds(100, 100, 646, 428);
		getContentPane().setLayout(null);
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 356);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblQuuencareHospital = new JLabel("QueenCare Hospital PVT. LTD.");
		lblQuuencareHospital.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblQuuencareHospital.setBounds(334, 10, 286, 28);
		panel.add(lblQuuencareHospital);
		
		JLabel lblHenrySquareCg = new JLabel("Henry Square, CG Road, Ahmedabad");
		lblHenrySquareCg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHenrySquareCg.setBounds(373, 42, 252, 20);
		panel.add(lblHenrySquareCg);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(352, 42, 268, 2);
		panel.add(separator);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(10, 48, 71, 14);
		panel.add(lblPatientName);
		
		JLabel lblDepartment = new JLabel("Contact No");
		lblDepartment.setBounds(429, 91, 71, 14);
		panel.add(lblDepartment);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(429, 116, 38, 14);
		panel.add(lblAge);
		
		JLabel lblptname = new JLabel("");
		lblptname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblptname.setBounds(103, 48, 113, 14);
		panel.add(lblptname);
		
		JLabel lblptcontc = new JLabel("");
		lblptcontc.setBounds(505, 91, 113, 14);
		panel.add(lblptcontc);
		
		JLabel lblptage = new JLabel("");
		lblptage.setBounds(505, 116, 38, 14);
		panel.add(lblptage);
		
		JLabel lblcasedate = new JLabel("");
		lblcasedate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcasedate.setBounds(103, 30, 92, 14);
		panel.add(lblcasedate);
		
		JLabel lblCaseDate = new JLabel("Case Date");
		lblCaseDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCaseDate.setBounds(10, 30, 69, 14);
		panel.add(lblCaseDate);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 73, 600, 2);
		panel.add(separator_1);
		
		JLabel lblDepartmentCaseCharge = new JLabel("Department Case Charge");
		lblDepartmentCaseCharge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDepartmentCaseCharge.setBounds(32, 109, 167, 20);
		panel.add(lblDepartmentCaseCharge);
		
		JLabel lblLabReportCharge = new JLabel("Lab Report Charge");
		lblLabReportCharge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLabReportCharge.setBounds(32, 134, 167, 20);
		panel.add(lblLabReportCharge);
		
		JLabel lblMedicineCharge = new JLabel("Medicine Charge");
		lblMedicineCharge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMedicineCharge.setBounds(32, 159, 167, 20);
		panel.add(lblMedicineCharge);
		
		JLabel lblAdmitroomCharge = new JLabel("Admit(Room) Charge");
		lblAdmitroomCharge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdmitroomCharge.setBounds(32, 184, 167, 20);
		panel.add(lblAdmitroomCharge);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCategory.setBounds(46, 86, 101, 20);
		panel.add(lblCategory);
		
		JLabel lblChargis = new JLabel("Charges Amount");
		lblChargis.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChargis.setBounds(225, 86, 140, 20);
		panel.add(lblChargis);
		
		JLabel lbldeptchrg = new JLabel("");
		lbldeptchrg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbldeptchrg.setBounds(257, 115, 81, 14);
		panel.add(lbldeptchrg);
		
		JLabel lbllabchrg = new JLabel("");
		lbllabchrg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllabchrg.setBounds(257, 138, 81, 14);
		panel.add(lbllabchrg);
		
		JLabel lblmedichrg = new JLabel("");
		lblmedichrg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmedichrg.setBounds(257, 163, 81, 14);
		panel.add(lblmedichrg);
		
		JLabel lbladchrg = new JLabel("");
		lbladchrg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbladchrg.setBounds(257, 188, 81, 14);
		panel.add(lbladchrg);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalAmount.setBounds(32, 219, 127, 20);
		panel.add(lblTotalAmount);
		
		JLabel lbltot = new JLabel("");
		lbltot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltot.setBounds(257, 219, 101, 20);
		panel.add(lbltot);
		
		JLabel lblPatientSignature = new JLabel("Patient Signature");
		lblPatientSignature.setBounds(245, 292, 107, 14);
		panel.add(lblPatientSignature);
		
		JLabel lblAutoritySignature = new JLabel("Autority Signature");
		lblAutoritySignature.setBounds(32, 292, 107, 14);
		panel.add(lblAutoritySignature);
		
		JLabel lblptbgrp = new JLabel("");
		lblptbgrp.setBounds(505, 141, 38, 14);
		panel.add(lblptbgrp);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(429, 141, 71, 14);
		panel.add(lblBloodGroup);
		
		JLabel lblptdept = new JLabel("");
		lblptdept.setBounds(505, 165, 86, 14);
		panel.add(lblptdept);
		
		JLabel lblDepartment_1 = new JLabel("Department");
		lblDepartment_1.setBounds(429, 165, 71, 14);
		panel.add(lblDepartment_1);
		
		JLabel lblrdate = new JLabel("");
		lblrdate.setBounds(103, 10, 92, 14);
		panel.add(lblrdate);
		
		JLabel lblRecipntDate = new JLabel("Receipt Date");
		lblRecipntDate.setBounds(10, 10, 71, 14);
		panel.add(lblRecipntDate);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(488, 364, 89, 23);
		getContentPane().add(btnPrint);

		try {
			p1=conn.prepareStatement("select pt.p_first_name,pt.p_last_name,pt.p_age,pt.p_bloodgroup,pt.p_contact,d.dept_name,cm.date_of_case,py.* "
					+ "from patient_detail pt, department d, patient_payment py, case_main cm "
					+ "where pt.p_id=cm.p_id AND cm.dept_id=d.dept_id AND cm.case_id=py.case_id AND "
					+ "cm.case_id=3");
			rs1=p1.executeQuery();
			rs1.first();
			lblptname.setText(rs1.getString(1)+" "+rs1.getString(2));
			lblptage.setText(rs1.getString(3));
			lblptbgrp.setText(rs1.getString(4));
			lblptcontc.setText(rs1.getString(5));
			lblptdept.setText(rs1.getString(6));
			lblcasedate.setText(rs1.getString(7));
			lblrdate.setText(rs1.getString(11));
			lbldeptchrg.setText(rs1.getString(10));
			lbladchrg.setText(rs1.getString(12));
			lblmedichrg.setText(rs1.getString(13));
			lbllabchrg.setText(rs1.getString(14));
			lbltot.setText(rs1.getString(15));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
