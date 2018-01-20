package Bill;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class Bill_link extends JInternalFrame {
	private JTextField textField;
	Connection conn=null;
	PreparedStatement p1;
	ResultSet rs1;
	private JTable table_f;
	private JTable table_s;
	private JTable table_t;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill_link frame = new Bill_link();
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
	public Bill_link() {
		setTitle("Bill Printing");
		setBounds(100, 100, 789, 535);
		getContentPane().setLayout(null);
		
		 PrinterJob job = PrinterJob.getPrinterJob();
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		
		JLabel lblEnterCaseId = new JLabel("Enter Case ID for printing the bills");
		lblEnterCaseId.setFont(new Font("Gadugi", Font.BOLD, 15));
		lblEnterCaseId.setBounds(10, 11, 251, 21);
		getContentPane().add(lblEnterCaseId);
		
		textField = new JTextField();
		textField.setBounds(10, 49, 118, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("Medicine Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//panel_medi.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(10, 133, 118, 40);
		getContentPane().add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JButton btnLabReportBill = new JButton("Lab Report Bill");
		btnLabReportBill.setBounds(10, 235, 118, 40);
		getContentPane().add(btnLabReportBill);
		btnLabReportBill.setVisible(false);
		
		JButton btnAdmitBill = new JButton("Admit Bill");
		btnAdmitBill.setBounds(10, 184, 118, 40);
		getContentPane().add(btnAdmitBill);
		btnAdmitBill.setVisible(false);
		
		JButton btnFinalBill = new JButton("Final Bill");
		btnFinalBill.setBounds(10, 286, 118, 40);
		getContentPane().add(btnFinalBill);
		btnFinalBill.setVisible(false);	
		
		JButton btnPrintTheBill = new JButton("Print The Bill");
		btnPrintTheBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				int caseid=Integer.valueOf(textField.getText());
				p1=conn.prepareStatement("select count(case_id),patient_payment.* from patient_payment where case_id="+caseid);
				rs1=p1.executeQuery();
				rs1.first();
				if(rs1.getInt(1)>0)
				{
					if(rs1.getInt(6)>0){btnAdmitBill.setVisible(true);}
					if(rs1.getInt(7)>0)	{btnNewButton.setVisible(true);}
					if(rs1.getInt(8)>0)	{btnLabReportBill.setVisible(true);}
					if(rs1.getInt(9)>0)	{btnFinalBill.setVisible(true);}
					btnFinalBill.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "System does not find any CASE ID in payment history, check your correct CASE ID OR First Generate bill from Billing DESK");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				
			}
		});
		btnPrintTheBill.setBounds(10, 80, 118, 23);
		getContentPane().add(btnPrintTheBill);
		
		JPanel panel_final = new JPanel();
		panel_final.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_final.setLayout(null);
		panel_final.setBounds(138, 46, 628, 373);
		getContentPane().add(panel_final);
		
		JLabel label = new JLabel("QueenCare Hospital PVT. LTD.");
		label.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		label.setBounds(334, 10, 286, 28);
		panel_final.add(label);
		
		JLabel label_1 = new JLabel("Henry Square, CG Road, Ahmedabad");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(373, 42, 252, 20);
		panel_final.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(352, 42, 268, 2);
		panel_final.add(separator);
		
		JLabel label_2 = new JLabel("Patient Name");
		label_2.setBounds(10, 48, 111, 14);
		panel_final.add(label_2);
		
		JLabel lblptname = new JLabel("<dynamic> <dynamic>");
		lblptname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblptname.setBounds(138, 48, 113, 14);
		panel_final.add(lblptname);
		
		JLabel lblptph = new JLabel((String) null);
		lblptph.setBounds(507, 220, 113, 14);
		panel_final.add(lblptph);
		
		JLabel lblptage = new JLabel((String) null);
		lblptage.setBounds(504, 142, 38, 14);
		panel_final.add(lblptage);
		
		JLabel lblcasedate = new JLabel((String) null);
		lblcasedate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcasedate.setBounds(138, 30, 92, 14);
		panel_final.add(lblcasedate);
		
		JLabel label_9 = new JLabel("Case Date");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(10, 30, 111, 14);
		panel_final.add(label_9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 73, 600, 2);
		panel_final.add(separator_1);
		
		JLabel label_20 = new JLabel("Total Amount");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_20.setBounds(25, 279, 127, 20);
		panel_final.add(label_20);
		
		JLabel lblfinal = new JLabel((String) null);
		lblfinal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblfinal.setBounds(250, 279, 101, 20);
		panel_final.add(lblfinal);
		
		JLabel label_22 = new JLabel("Patient Signature");
		label_22.setBounds(244, 318, 107, 14);
		panel_final.add(label_22);
		
		JLabel label_23 = new JLabel("Autority Signature");
		label_23.setBounds(31, 318, 107, 14);
		panel_final.add(label_23);
		
		JLabel lblptbg = new JLabel((String) null);
		lblptbg.setBounds(504, 167, 38, 14);
		panel_final.add(lblptbg);
		
		JLabel lblptdept = new JLabel((String) null);
		lblptdept.setBounds(504, 191, 86, 14);
		panel_final.add(lblptdept);
		
		JLabel lblrcdate = new JLabel((String) null);
		lblrcdate.setBounds(138, 10, 92, 14);
		panel_final.add(lblrcdate);
		
		JLabel label_29 = new JLabel("Receipt Date");
		label_29.setBounds(10, 10, 111, 14);
		panel_final.add(label_29);
		
		JLabel lblFinalBill = new JLabel("Final Bill");
		lblFinalBill.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFinalBill.setBounds(256, 77, 92, 28);
		panel_final.add(lblFinalBill);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(37, 107, 62, 14);
		panel_final.add(lblCategory);
		
		JLabel lblCategoryCharge = new JLabel("Category charge");
		lblCategoryCharge.setBounds(244, 107, 113, 14);
		panel_final.add(lblCategoryCharge);
		
		JLabel lbldeptch = new JLabel("");
		lbldeptch.setBounds(214, 142, 92, 14);
		panel_final.add(lbldeptch);
		
		JLabel lblmedich = new JLabel("");
		lblmedich.setBounds(214, 167, 92, 14);
		panel_final.add(lblmedich);
		
		JLabel lbllabch = new JLabel("");
		lbllabch.setBounds(214, 191, 92, 14);
		panel_final.add(lbllabch);
		
		JLabel lbladch = new JLabel("");
		lbladch.setBounds(214, 220, 92, 14);
		panel_final.add(lbladch);
		
		JLabel lblDepartmentCharge = new JLabel("Department Charge");
		lblDepartmentCharge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDepartmentCharge.setBounds(31, 142, 182, 14);
		panel_final.add(lblDepartmentCharge);
		
		JLabel lblLabCharge = new JLabel("Lab Charge");
		lblLabCharge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLabCharge.setBounds(31, 191, 182, 14);
		panel_final.add(lblLabCharge);
		
		JLabel lblMedicineCharge = new JLabel("Medicine Charge");
		lblMedicineCharge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMedicineCharge.setBounds(31, 167, 182, 14);
		panel_final.add(lblMedicineCharge);
		
		JLabel lblRoomCharge = new JLabel("Room Charge");
		lblRoomCharge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRoomCharge.setBounds(31, 216, 182, 14);
		panel_final.add(lblRoomCharge);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(383, 142, 62, 14);
		panel_final.add(lblAge);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(383, 167, 92, 14);
		panel_final.add(lblBloodGroup);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(383, 191, 77, 14);
		panel_final.add(lblDepartment);
		
		JLabel lblContactNo = new JLabel("Contact NO");
		lblContactNo.setBounds(383, 218, 77, 14);
		panel_final.add(lblContactNo);
		
		JButton btnPrint = new JButton("print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			}
		});
		btnPrint.setBounds(658, 419, 89, 23);
		getContentPane().add(btnPrint);
		
		JPanel panel_medi = new JPanel();
		panel_medi.setLayout(null);
		panel_medi.setBounds(139, 46, 627, 448);
		getContentPane().add(panel_medi);
		
		JLabel label_5 = new JLabel("QueenCare Hospital PVT. LTD.");
		label_5.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		label_5.setBounds(324, 11, 286, 28);
		panel_medi.add(label_5);
		
		JLabel label_6 = new JLabel("Henry Square, CG Road, Ahmedabad");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(363, 43, 252, 20);
		panel_medi.add(label_6);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(342, 43, 268, 2);
		panel_medi.add(separator_2);
		
		JLabel label_7 = new JLabel("Patient Name");
		label_7.setBounds(7, 49, 111, 14);
		panel_medi.add(label_7);
		
		JLabel m_lbl_ptname = new JLabel("<dynamic> <dynamic>");
		m_lbl_ptname.setFont(new Font("Tahoma", Font.BOLD, 12));
		m_lbl_ptname.setBounds(128, 49, 113, 14);
		panel_medi.add(m_lbl_ptname);
		
		JLabel label_18 = new JLabel((String) null);
		label_18.setBounds(495, 92, 113, 14);
		panel_medi.add(label_18);
		
		JLabel m_lbl_csdate = new JLabel((String) null);
		m_lbl_csdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		m_lbl_csdate.setBounds(128, 31, 92, 14);
		panel_medi.add(m_lbl_csdate);
		
		JLabel label_24 = new JLabel("Case Date");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_24.setBounds(7, 31, 111, 14);
		panel_medi.add(label_24);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 74, 600, 2);
		panel_medi.add(separator_3);
		
		JLabel label_38 = new JLabel("Total Amount");
		label_38.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_38.setBounds(291, 392, 127, 20);
		panel_medi.add(label_38);
		
		JLabel m_lbl_bill_total = new JLabel((String) null);
		m_lbl_bill_total.setFont(new Font("Tahoma", Font.BOLD, 14));
		m_lbl_bill_total.setBounds(495, 392, 101, 20);
		panel_medi.add(m_lbl_bill_total);
		
		JLabel label_40 = new JLabel("Patient Signature");
		label_40.setBounds(156, 423, 107, 14);
		panel_medi.add(label_40);
		
		JLabel label_41 = new JLabel("Autority Signature");
		label_41.setBounds(21, 423, 107, 14);
		panel_medi.add(label_41);
		
		JLabel label_44 = new JLabel((String) null);
		label_44.setBounds(494, 192, 86, 14);
		panel_medi.add(label_44);
		
		JLabel m_lbl_rcdate = new JLabel((String) null);
		m_lbl_rcdate.setBounds(128, 11, 92, 14);
		panel_medi.add(m_lbl_rcdate);
		
		JLabel label_47 = new JLabel("Receipt Date");
		label_47.setBounds(7, 11, 111, 14);
		panel_medi.add(label_47);
		
		JLabel lblMedicineBill = new JLabel("Medicine Bill");
		lblMedicineBill.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMedicineBill.setBounds(214, 78, 120, 28);
		panel_medi.add(lblMedicineBill);
		
		table_f = new JTable();
		table_f.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Charge"
			}
		));
		table_f.setBounds(21, 108, 182, 273);
		panel_medi.add(table_f);
		
		table_s = new JTable();
		table_s.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Charge"
			}
		));
		table_s.setBounds(224, 108, 182, 273);
		panel_medi.add(table_s);
		
		table_t = new JTable();
		table_t.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Charge"
			}
		));
		table_t.setBounds(428, 108, 182, 273);
		panel_medi.add(table_t);
		panel_medi.setVisible(false);
		panel_final.setVisible(false);
		btnFinalBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_final.setVisible(true);

				try {
					p1=conn.prepareStatement("select pt.p_first_name,pt.p_last_name,pt.p_age,pt.p_bloodgroup,pt.p_contact,d.dept_name,cm.date_of_case,py.* "
							+ "from patient_detail pt, department d, patient_payment py, case_main cm "
							+ "where pt.p_id=cm.p_id AND cm.dept_id=d.dept_id AND cm.case_id=py.case_id AND "
							+ "cm.case_id="+textField.getText());
					rs1=p1.executeQuery();
					rs1.first();
					lblptname.setText(rs1.getString(1)+" "+rs1.getString(2));
					lblptage.setText(rs1.getString(3));
					lblptbg.setText(rs1.getString(4));
					lblptph.setText(rs1.getString(5));
					lblptdept.setText(rs1.getString(6));
					lblcasedate.setText(rs1.getString(7));
					lblrcdate.setText(rs1.getString(11));
					lbldeptch.setText(rs1.getString(10));
					lbladch.setText(rs1.getString(12));
					lblmedich.setText(rs1.getString(13));
					lbllabch.setText(rs1.getString(14));
					lblfinal.setText(rs1.getString(15));
					int total =Integer.valueOf(rs1.getString(10))+Integer.valueOf(rs1.getString(11))+Integer.valueOf(rs1.getString(12))+Integer.valueOf(rs1.getString(13));
					lblfinal.setText(String.valueOf(total));
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
