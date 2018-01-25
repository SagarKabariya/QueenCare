package Diagnosis;
import Connect.ConnectionManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Patient_history extends JInternalFrame {
	private JTextField txtcsid;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;

	Connection conn=null;
	PreparedStatement ps1,ps2,ps3,ps4=null;
	ResultSet rs,r1,rs2=null;
	ArrayList mdlist = new ArrayList();
	
	int totmedi=0;
	int medion=0;
	private JTextField txtother;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_history frame = new Patient_history();
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
	public Patient_history() {
		setTitle("Patient Diagnosis - Hospital Management");
		setClosable(true);
		setBounds(100, 100, 1466, 732);
	
		conn=ConnectionManager.getConnection();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(32, 178, 170));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 527, 52);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterCaseId = new JLabel("Enter Case ID");
		lblEnterCaseId.setBounds(22, 11, 83, 24);
		panel.add(lblEnterCaseId);
		
		txtcsid = new JTextField();
		
		txtcsid.setBounds(115, 7, 200, 33);
		panel.add(txtcsid);
		txtcsid.setColumns(10);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(327, 11, 183, 25);
		panel.add(btnOpen);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 68, 527, 120);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblName.setBounds(10, 26, 100, 22);
		panel_1.add(lblName);
		
		JLabel lblDate = new JLabel("Date of App");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(10, 61, 100, 22);
		panel_1.add(lblDate);
		
		JLabel lblNewLabel = new JLabel("Case Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 85, 100, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lb1 = new JLabel("");
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lb1.setBounds(135, 15, 380, 41);
		panel_1.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb2.setBounds(135, 61, 200, 22);
		panel_1.add(lb2);
		
		JLabel lb3 = new JLabel("");
		lb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb3.setBounds(135, 85, 200, 22);
		panel_1.add(lb3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(549, 10, 527, 304);
		desktopPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSymptoms = new JLabel("Test");
		lblSymptoms.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSymptoms.setBounds(12, 163, 83, 46);
		panel_2.add(lblSymptoms);
		
		JCheckBox chk1 = new JCheckBox("BioChemistry");
		chk1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk1.setBounds(103, 138, 142, 23);
		panel_2.add(chk1);
		
		JCheckBox chk2 = new JCheckBox("Stool");
		chk2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk2.setBounds(392, 220, 142, 23);
		panel_2.add(chk2);
		
		JCheckBox chk7 = new JCheckBox("X-Ray");
		chk7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk7.setBounds(103, 220, 142, 23);
		panel_2.add(chk7);
		
		JCheckBox chk3 = new JCheckBox("Blood");
		chk3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk3.setBounds(103, 179, 142, 23);
		panel_2.add(chk3);
		
		JCheckBox chk5 = new JCheckBox("Gastroscopy");
		chk5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk5.setBounds(260, 138, 124, 23);
		panel_2.add(chk5);
		
		JCheckBox chk6 = new JCheckBox("Urine");
		chk6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk6.setBounds(392, 179, 166, 23);
		panel_2.add(chk6);
		
		JCheckBox chk8 = new JCheckBox("Sonography");
		chk8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk8.setBounds(260, 220, 166, 23);
		panel_2.add(chk8);
		
		JCheckBox chk9 = new JCheckBox("ECG");
		chk9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk9.setBounds(260, 179, 166, 23);
		panel_2.add(chk9);
		
		JCheckBox chk4 = new JCheckBox("Colonoscopy");
		chk4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chk4.setBounds(392, 138, 149, 23);
		panel_2.add(chk4);
		
		JLabel lblDoctore = new JLabel("Doctor");
		lblDoctore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDoctore.setBounds(12, 13, 100, 33);
		panel_2.add(lblDoctore);
		
		JLabel lblAppointmentDate = new JLabel("Department");
		lblAppointmentDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAppointmentDate.setBounds(12, 51, 100, 33);
		panel_2.add(lblAppointmentDate);
		
		JLabel lb4 = new JLabel("");
		lb4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb4.setBounds(137, 13, 200, 33);
		panel_2.add(lb4);
		
		JLabel lb5 = new JLabel("");
		lb5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb5.setBounds(137, 51, 200, 33);
		panel_2.add(lb5);
		
		JLabel lblOtherRequireTest = new JLabel("Other Require Test");
		lblOtherRequireTest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOtherRequireTest.setBounds(12, 268, 135, 23);
		panel_2.add(lblOtherRequireTest);
		
		txtother = new JTextField();
		txtother.setBounds(159, 269, 356, 22);
		panel_2.add(txtother);
		txtother.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 194, 527, 120);
		desktopPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDietAdvice = new JLabel("Diet Advice");
		lblDietAdvice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDietAdvice.setBounds(10, 37, 122, 26);
		panel_3.add(lblDietAdvice);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setRows(4);
		textArea.setBounds(142, 15, 377, 94);
		panel_3.add(textArea);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(12, 366, 1246, 317);
		desktopPane.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Medicine Name");
		lblNewLabel_1.setBounds(10, 22, 98, 19);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblPrecaution = new JLabel("Precaution");
		lblPrecaution.setBounds(10, 41, 98, 19);
		panel_5.add(lblPrecaution);
		
		JLabel lblNoofdose = new JLabel("no_of_dose");
		lblNoofdose.setBounds(10, 60, 98, 19);
		panel_5.add(lblNoofdose);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 22, 176, 20);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 40, 176, 20);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(95, 59, 176, 20);
		panel_5.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(281, 21, 189, 20);
		panel_5.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(281, 40, 189, 20);
		panel_5.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(281, 59, 189, 20);
		panel_5.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(480, 21, 167, 20);
		panel_5.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(480, 40, 167, 20);
		panel_5.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(480, 59, 167, 20);
		panel_5.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(657, 21, 155, 20);
		panel_5.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(657, 40, 155, 20);
		panel_5.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(657, 59, 155, 20);
		panel_5.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(822, 21, 168, 20);
		panel_5.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(822, 40, 168, 20);
		panel_5.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(822, 59, 168, 20);
		panel_5.add(textField_15);
		
		JLabel label_2 = new JLabel("(1)");
		label_2.setBounds(157, 0, 25, 19);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("(2)");
		label_3.setBounds(354, 0, 25, 19);
		panel_5.add(label_3);
		
		JLabel label_4 = new JLabel("(3)");
		label_4.setBounds(552, 0, 25, 19);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("(4)");
		label_5.setBounds(734, 0, 25, 19);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("(5)");
		label_6.setBounds(875, 0, 25, 19);
		panel_5.add(label_6);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(1000, 22, 176, 20);
		panel_5.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(1000, 40, 176, 20);
		panel_5.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(1000, 59, 176, 20);
		panel_5.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(87, 143, 184, 20);
		panel_5.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(87, 161, 184, 19);
		panel_5.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(87, 182, 184, 20);
		panel_5.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(281, 143, 179, 20);
		panel_5.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(281, 161, 179, 20);
		panel_5.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(281, 182, 179, 20);
		panel_5.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(480, 143, 155, 20);
		panel_5.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(480, 161, 155, 20);
		panel_5.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(480, 182, 155, 20);
		panel_5.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(657, 143, 168, 20);
		panel_5.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(657, 161, 168, 20);
		panel_5.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		textField_36.setBounds(657, 182, 168, 20);
		panel_5.add(textField_36);
		
		JLabel label_9 = new JLabel("no_of_dose");
		label_9.setBounds(10, 183, 98, 19);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("Precaution");
		label_10.setBounds(10, 162, 98, 19);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Medicine Name");
		label_11.setBounds(10, 144, 98, 19);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("(8)");
		label_12.setBounds(354, 124, 25, 19);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("(9)");
		label_13.setBounds(552, 124, 25, 19);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("(10)");
		label_14.setBounds(734, 124, 25, 19);
		panel_5.add(label_14);
		
		JLabel label = new JLabel("(7)");
		label.setBounds(157, 124, 25, 19);
		panel_5.add(label);
		
		JLabel label_1 = new JLabel("(6)");
		label_1.setBounds(1086, 0, 25, 19);
		panel_5.add(label_1);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(31, 547, 372, 14);
		desktopPane.add(label_7);
		
		JButton btnAddMedicine = new JButton("Add Medicine");
		btnAddMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_1.getText());
				mdlist.add(textField_2.getText());
				mdlist.add(textField_3.getText());
				totmedi++;
				label_7.setText("total medicine given by doctor is "+totmedi);
				btnAddMedicine.setVisible(false);
			}
		});
		btnAddMedicine.setBounds(115, 90, 130, 23);
		panel_5.add(btnAddMedicine);
		
		JButton button_1 = new JButton("Add Medicine");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_4.getText());
				mdlist.add(textField_5.getText());
				mdlist.add(textField_6.getText());
				totmedi++;
				label_7.setText("total medicine given by doctor is "+totmedi);
				button_1.setVisible(false);
			}
		});
		button_1.setBounds(317, 90, 130, 23);
		panel_5.add(button_1);
		
		JButton button_2 = new JButton("Add Medicine");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_7.getText());
				mdlist.add(textField_8.getText());
				mdlist.add(textField_9.getText());
				totmedi++;
				button_2.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_2.setBounds(500, 90, 130, 23);
		panel_5.add(button_2);
		
		JButton button_3 = new JButton("Add Medicine");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_10.getText());
				mdlist.add(textField_11.getText());
				mdlist.add(textField_12.getText());
				totmedi++;
				button_3.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_3.setBounds(667, 90, 130, 23);
		panel_5.add(button_3);
		
		JButton button_4 = new JButton("Add Medicine");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_13.getText());
				mdlist.add(textField_14.getText());
				mdlist.add(textField_15.getText());
				totmedi++;
				button_4.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_4.setBounds(847, 90, 130, 23);
		panel_5.add(button_4);
		
		JButton button_5 = new JButton("Add Medicine");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_22.getText());
				mdlist.add(textField_23.getText());
				mdlist.add(textField_24.getText());
				totmedi++;
				button_5.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_5.setBounds(1021, 90, 130, 23);
		panel_5.add(button_5);
		
		JButton button_6 = new JButton("Add Medicine");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_25.getText());
				mdlist.add(textField_26.getText());
				mdlist.add(textField_27.getText());
				totmedi++;
				button_6.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_6.setBounds(115, 206, 130, 23);
		panel_5.add(button_6);
		
		JButton button_7 = new JButton("Add Medicine");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_28.getText());
				mdlist.add(textField_29.getText());
				mdlist.add(textField_30.getText());
				totmedi++;
				button_7.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_7.setBounds(317, 213, 130, 23);
		panel_5.add(button_7);
		
		JButton button_8 = new JButton("Add Medicine");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_31.getText());
				mdlist.add(textField_32.getText());
				mdlist.add(textField_33.getText());
				totmedi++;
				button_8.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_8.setBounds(505, 213, 130, 23);
		panel_5.add(button_8);
		
		JButton button_9 = new JButton("Add Medicine");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mdlist.add(textField_34.getText());
				mdlist.add(textField_35.getText());
				mdlist.add(textField_36.getText());
				totmedi++;
				button_9.setVisible(false);
				label_7.setText("total medicine given by doctor is "+totmedi);
			}
		});
		button_9.setBounds(667, 213, 130, 23);
		panel_5.add(button_9);
		
		JLabel lblReconsoltingDate = new JLabel("Re-Consolting Date");
		lblReconsoltingDate.setBounds(847, 146, 119, 14);
		panel_5.add(lblReconsoltingDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(1000, 143, 176, 20);
		panel_5.add(dateChooser);
		
		JLabel lblReconsoltingRemark = new JLabel("Re-Consolting Remark");
		lblReconsoltingRemark.setBounds(847, 185, 119, 14);
		panel_5.add(lblReconsoltingRemark);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setRows(5);
		textArea_1.setBounds(1000, 180, 168, 126);
		panel_5.add(textArea_1);
		
		
		panel_5.setVisible(false);
		JButton button = new JButton("Needed Medicine");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_5.setVisible(true);
				medion=1;
			}
		});
		button.setBounds(10, 327, 168, 26);
		desktopPane.add(button);
		
		txtcsid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					ps1=conn.prepareStatement("select cs.date_of_case, cs.doc_id,dp.dept_name,ap.app_date,p.p_first_name,p.p_last_name "
							+ "from case_main cs, department dp, appointment ap, patient_detail p "
							+ "where p.p_id=cs.p_id AND "
							+ "cs.dept_id=dp.dept_id AND ap.case_id=cs.case_id "
							+ "AND cs.case_id = "+Integer.valueOf(txtcsid.getText()));
					//System.out.println(ps1);
					
				rs=ps1.executeQuery();
				while(rs.next()){
					if(rs.getRow()==0)
					{
						JOptionPane.showMessageDialog(null, "no row found");
						
					}
				lb1.setText(rs.getString(5)+" "+rs.getString(6));
				lb2.setText(rs.getString(4));
				lb3.setText(rs.getString(1));
				lb4.setText(rs.getString(2));
				lb5.setText(rs.getString(3));
					
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		JButton btnSubmit = new JButton("Done Appointment");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
				
				int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0;
				if(chk1.isSelected()==true){c1=1;}
				if(chk2.isSelected()==true){c2=1;}
				if(chk3.isSelected()==true){c3=1;}
				if(chk4.isSelected()==true){c4=1;}
				if(chk5.isSelected()==true){c5=1;}
				if(chk6.isSelected()==true){c6=1;}
				if(chk7.isSelected()==true){c7=1;}
				if(chk8.isSelected()==true){c8=1;}
				if(chk9.isSelected()==true){c9=1;}
				String other;
				String advice=textArea.getText();
				Date date = new Date();
				java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String dd = fmt.format(dateChooser.getDate());
				int csid=Integer.valueOf(txtcsid.getText());
				try {
					PreparedStatement p;
					p=conn.prepareStatement("INSERT INTO `patient_diagnosis`"
	+ "(`case_id`, `diagnosis_date`, `bio_chemistry`, `stool`, `blood`, `colonoscopy`, `gastroscopy`, `urine`, `xray`, `sonography`, `other`, `re_con_date`, `re_con_advice`, `ecg`) "
	+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					p.setInt(1,csid );
					p.setString(2,fmt.format(date));
					p.setInt(3,c1);
					p.setInt(4,c2);
					p.setInt(5,c3);
					p.setInt(6,c4);
					p.setInt(7,c5);
					p.setInt(8,c6);
					p.setInt(9,c7);
					p.setInt(10,c8);
					p.setString(11,txtother.getText());
					p.setString(12,dd);
					p.setString(13,textArea_1.getText());
					p.setInt(14,c9);
					System.out.println(p.toString());
					
					p.executeUpdate();
					
					ps2=conn.prepareStatement("SELECT `pt_diagnosis_id` FROM `patient_diagnosis` order by `pt_diagnosis_id`desc limit 1");
					rs2=ps2.executeQuery();
					rs2.next();
					ps3=conn.prepareStatement("INSERT INTO `patient_diet`(`pt_diagnosis_id`, `diet_advice`) VALUES (?,?)");
					ps3.setInt(1, rs2.getInt(1));
					ps3.setString(2, advice);
					
					ps3.executeUpdate();
					int d1=0,d2=1,d3=2;
					for(int i=0;i<totmedi;i++)
					{
					ps4=conn.prepareStatement("INSERT INTO `patient_medicine`"
							+ "(`pt_diagnosis_id`, `medicine_no`, `precaution`, `no_of_dose`) "
							+ "VALUES (?,?,?,?)");
					
						ps4.setInt(1, rs2.getInt(1));
						ps4.setString(2, mdlist.get(d1).toString());
						ps4.setString(3, mdlist.get(d2).toString());
						ps4.setString(4, mdlist.get(d3).toString());
						d1=d1+3;
						d2=d2+3;
						d3=d3+3;
						JOptionPane.showMessageDialog(null, ps4.toString());
						ps4.executeUpdate();
						JOptionPane.showMessageDialog(null, "Patient Information Added successfully");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		});
		btnSubmit.setBounds(1088, 307, 168, 46);
		desktopPane.add(btnSubmit);
		
		JLabel lblMedicineAdvice = new JLabel("Medicine Advice");
		lblMedicineAdvice.setBounds(187, 327, 168, 26);
		desktopPane.add(lblMedicineAdvice);
		lblMedicineAdvice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setLayout(null);
		panel_4.setBounds(10, 311, 1066, 52);
		desktopPane.add(panel_4);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(1087, 242, 168, 52);
		desktopPane.add(btnClose);
	}
}
