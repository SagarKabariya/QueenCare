package org.main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Appointment.Appointment;
import Appointment.Appointment_show;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Admit.Admit_main;
import Analysis.Report_desk;
import Bill.Bill_entry;
import Bill.Bill_link;
import Diagnosis.Patient_history;
import Doctor.Doctor_all;
import Doctor.Doctor_regi;
import Lab.Blood_report;
import Lab.Blood_report_display;
import Lab.Lab_main;
import Lab.lab_pen_print;
import Lab.rep_all;
import Lab.sono_report_display;
import Lab.sonography_report;
import Patient.Patient_All;
//import Patient.Patient_regi;
import Patient.Patient_regis;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	
	static MainFrm frame = new MainFrm();
	private JTextField txtid;
	private JTextField txtpass;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	public void mshow() {
		Panel p = new Panel();
		p.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public MainFrm() {
				
		setFont(new Font("911 Porscha Laser Italic", Font.PLAIN, 15));
		setForeground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/Images/electrocardiogram2.png")));
		setTitle("Queen Care Hospital Management System");
		
		setBounds(100, 100, 1365, 731);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.ORANGE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JButton btnCloseAppication = new JButton("Close Application");
		btnCloseAppication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		JPanel Login = new JPanel();
		Login.setBounds(0, 0, 1365, 278);
		Login.setBackground(new Color(255, 99, 71));
		desktopPane.add(Login);
		Login.setLayout(null);
		
		JPanel Admin = new JPanel();
		Admin.setBounds(0, 0, 1365, 315);
		desktopPane.add(Admin);
		Admin.setBackground(new Color(0, 128, 128));
		Admin.setLayout(null);			
	
		
							
								JPanel Recp = new JPanel();
								Recp.setBounds(0, 0, 1365, 345);
								Recp.setBackground(new Color(154, 205, 50));
								desktopPane.add(Recp);
								Recp.setLayout(null);
								
								JPanel Lab = new JPanel();
								Lab.setBounds(0, 0, 1365, 375);
								Lab.setBackground(new Color(255, 140, 0));
								desktopPane.add(Lab);
								Lab.setLayout(null);
									
								
									JMenuBar menuBar = new JMenuBar();
									menuBar.setBounds(0, 0, 1365, 28);
									menuBar.setBackground(Color.LIGHT_GRAY);
									Admin.add(menuBar);
									
									JMenu mnOldPatient = new JMenu("Old Patient");
									menuBar.add(mnOldPatient);
									
									JMenuItem mntmFindYourCase = new JMenuItem("Find your case");
									mntmFindYourCase.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											
										}
									});
									mnOldPatient.add(mntmFindYourCase);
									
									JMenuItem mntmFindPatient = new JMenuItem("Find Patient");
									mntmFindPatient.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Patient_regis pr1 = new Patient_regis();
											desktopPane.add(pr1);
											pr1.setVisible(true);
										}
									});
									mnOldPatient.add(mntmFindPatient);
									
									JMenu mnNewPatient = new JMenu("New Patient");
									menuBar.add(mnNewPatient);
									
									JMenuItem mntmRegister = new JMenuItem("Register");
									mntmRegister.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Patient_All pr = new Patient_All();
											Patient_regis pr2 = new Patient_regis();
											desktopPane.add(pr2);
											pr2.setVisible(true);
										}
									});
									mnNewPatient.add(mntmRegister);
									
									JMenuItem mntmShowAllPatient = new JMenuItem("Show All Patient");
									mntmShowAllPatient.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Patient_All pr3 = new Patient_All();
											desktopPane.add(pr3);
											pr3.setVisible(true);
										}
									});
									mnNewPatient.add(mntmShowAllPatient);
									
									JMenu mnAppointment = new JMenu("Appointment");
									menuBar.add(mnAppointment);
									
									JMenuItem mntmTakeAppointment = new JMenuItem("Take Appointment");
									mntmTakeAppointment.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
										Appointment ap = new Appointment();
										desktopPane.add(ap);
										ap.setVisible(true);
										}
									});
									mnAppointment.add(mntmTakeAppointment);
									
									JMenuItem mntmFindYourAppointment = new JMenuItem("Find Your Appointment");
									mntmFindYourAppointment.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Appointment_show ap2 = new Appointment_show();
											desktopPane.add(ap2);
											ap2.setVisible(true);
										}
									});
									mnAppointment.add(mntmFindYourAppointment);
									
									JMenuItem mntmPatientDiagonsis = new JMenuItem("Patient Diagonsis");
									mntmPatientDiagonsis.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
										Patient_history ph=new Patient_history();
										desktopPane.add(ph);
										ph.setVisible(true);
										}
									});
									mnAppointment.add(mntmPatientDiagonsis);
									
									JMenu mnDoctors = new JMenu("Doctors");
									menuBar.add(mnDoctors);
									
									JMenuItem mntmNewDoctor = new JMenuItem("New Doctor");
									mntmNewDoctor.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
										Doctor_regi dr = new Doctor_regi();
										desktopPane.add(dr);
										dr.setVisible(true);
										}
									});
									mnDoctors.add(mntmNewDoctor);
									
									JMenuItem mntmFindOrUpdate = new JMenuItem("Find Or update");
									mntmFindOrUpdate.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Doctor_all dl = new Doctor_all();
											desktopPane.add(dl);
											dl.setVisible(true);
										}
									});
									mnDoctors.add(mntmFindOrUpdate);
									
									JMenu mnLabDepartment = new JMenu("Lab Department");
									menuBar.add(mnLabDepartment);
									
									JMenuItem mntmTakeReport = new JMenuItem("Take Report");
									mntmTakeReport.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
										Lab_main lm = new Lab_main();
										desktopPane.add(lm);
										lm.setVisible(true);
										}
									});
									mnLabDepartment.add(mntmTakeReport);
									
									JMenuItem mntmShowPendingReports = new JMenuItem("Show Pending Reports");
									mntmShowPendingReports.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
										lab_pen_print lpr = new lab_pen_print();
										desktopPane.add(lpr);
										lpr.setVisible(true);
										}
									});
									mnLabDepartment.add(mntmShowPendingReports);
									
									JMenuItem mntmShowAllReports = new JMenuItem("Show All Reports");
									mntmShowAllReports.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											rep_all rall = new rep_all();
											desktopPane.add(rall);
											rall.setVisible(true);
										}
									});
									mnLabDepartment.add(mntmShowAllReports);
									
									JMenu mnFillReports = new JMenu("Fill Reports");
									mnLabDepartment.add(mnFillReports);
									
									JMenuItem mntmBloodReport = new JMenuItem("Blood Report");
									mntmBloodReport.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Blood_report br = new Blood_report();
											desktopPane.add(br);
											br.setVisible(true);
										}
									});
									mnFillReports.add(mntmBloodReport);
									
									JMenuItem mntmSonographyReport = new JMenuItem("Sonography Report");
									mntmSonographyReport.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
										sonography_report sonor= new sonography_report();
										desktopPane.add(sonor);
										sonor.setVisible(true);
										}
									});
									mnFillReports.add(mntmSonographyReport);
									
									JMenu mnShowPatientReport = new JMenu("Show Patient Report");
									menuBar.add(mnShowPatientReport);
									
									JMenuItem mntmNewMenuItem = new JMenuItem("Blood Report");
									mnShowPatientReport.add(mntmNewMenuItem);
									
									JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sonography Report");
									mntmNewMenuItem_1.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											sono_report_display srd = new sono_report_display();
											desktopPane.add(srd);
											srd.setVisible(true);
										}
									});
									mnShowPatientReport.add(mntmNewMenuItem_1);
									
									JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gastroscophy Report");
									mnShowPatientReport.add(mntmNewMenuItem_2);
									
									JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cooming Soon ");
									mnShowPatientReport.add(mntmNewMenuItem_3);
									mntmNewMenuItem.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Blood_report_display brd = new Blood_report_display();
											desktopPane.add(brd);
											brd.setVisible(true);
										}
									});
									
									JMenu mnRoomAlloction = new JMenu("Room Alloction");
									menuBar.add(mnRoomAlloction);
									
									JMenuItem mntmRoomDesk = new JMenuItem("Room Desk");
									mntmRoomDesk.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Admit_main am = new Admit_main();
											desktopPane.add(am);
											am.setVisible(true);
										}
									});
									mnRoomAlloction.add(mntmRoomDesk);
									
									JMenu mnBilling = new JMenu("Billing Desk");
									menuBar.add(mnBilling);
									
									JMenuItem mntmBill = new JMenuItem("Generate Bill");
									mntmBill.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Bill_entry bill = new Bill_entry();
											desktopPane.add(bill);
											bill.setVisible(true);
										}
									});
									mntmBill.setIcon(null);
									mnBilling.add(mntmBill);
									
									JMenuItem mntmPrintBill = new JMenuItem("Print Bill");
									mntmPrintBill.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Bill_link bl = new Bill_link();
											desktopPane.add(bl);
											bl.setVisible(true);
										}
									});
									mnBilling.add(mntmPrintBill);
									
									JMenu mnReports = new JMenu("Reports");
									menuBar.add(mnReports);
									
									JMenu mnPatientDiagnosis = new JMenu("Patient Diagnosis");
									menuBar.add(mnPatientDiagnosis);
									
									JMenuItem mntmTest = new JMenuItem("Diagnosis Reports");
									mnPatientDiagnosis.add(mntmTest);
									mntmTest.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											Report_desk rdk = new Report_desk();
											desktopPane.add(rdk);
											rdk.setVisible(true);
										}
									});
									
									JMenu mnAdvanceSearch = new JMenu("Advance Search");
									menuBar.add(mnAdvanceSearch);
									
									JMenu mnAttention = new JMenu("Help Desk");
									menuBar.add(mnAttention);
									
									JLabel lblAdminOnly = new JLabel("Admin Only");
									lblAdminOnly.setBounds(28, 278, 200, 37);
									lblAdminOnly.setForeground(new Color(255, 250, 250));
									lblAdminOnly.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 14));
									Admin.add(lblAdminOnly);
									
									//JButton button = new JButton(new ImageIcon("../QueenCare/__MACOSX/1 (1).png"));
				
				
				JLabel lblLoginYourSelf = new JLabel("Login your self");
				lblLoginYourSelf.setForeground(new Color(255, 255, 255));
				lblLoginYourSelf.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
				lblLoginYourSelf.setBounds(434, 60, 200, 32);
				Login.add(lblLoginYourSelf);
				
				JLabel lblName = new JLabel("User Name");
				lblName.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 17));
				lblName.setBounds(532, 136, 102, 26);
				Login.add(lblName);
				
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 17));
				lblPassword.setBounds(532, 185, 102, 32);
				Login.add(lblPassword);
				
				textField = new JTextField();
				textField.setBounds(666, 139, 200, 26);
				Login.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(666, 191, 200, 26);
				Login.add(textField_1);
				
				JButton btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//JOptionPane.showMessageDialog(null, "Admin");
						if(Integer.valueOf(textField.getText())==1){
						Login.setVisible(false);
						Admin.setVisible(true);
						}
						else if(Integer.valueOf(textField.getText())==2){
							
						}
						else {Login.setVisible(false);
							Admin.setVisible(false);
							Recp.setVisible(true);
							//JOptionPane.showMessageDialog(null, "Your duffer");
							}
						
					
					}
				});
				btnLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
				btnLogin.setBackground(new Color(128, 128, 128));
				btnLogin.setBounds(723, 228, 89, 32);
				Login.add(btnLogin);
			
				JMenuBar menuBar_1 = new JMenuBar();
				menuBar_1.setBounds(0, 0, 1349, 28);
				Recp.add(menuBar_1);
				
				JMenu mnPatient = new JMenu("Patient");
				menuBar_1.add(mnPatient);
				
				JMenuItem mntmNewPatinet = new JMenuItem("New Patinet");
				mnPatient.add(mntmNewPatinet);
				
				JMenuItem mntmShowAllPatinet = new JMenuItem("Show All Patient");
				mnPatient.add(mntmShowAllPatinet);
				
				JMenuItem mntmUpdatePatinent = new JMenuItem("Update Patient");
				mnPatient.add(mntmUpdatePatinent);
				
				JMenu mnCase = new JMenu("Case generate");
				menuBar_1.add(mnCase);
				
				JMenuItem mntmFindYourCase_1 = new JMenuItem("Find your case");
				mnCase.add(mntmFindYourCase_1);
				
				JMenuItem mntmGenerateNewCase = new JMenuItem("Generate New Case");
				mnCase.add(mntmGenerateNewCase);
				
				JMenuItem mntmUpdateCase = new JMenuItem("Update Case Detail");
				mnCase.add(mntmUpdateCase);
				
				JMenu mnAppointment_1 = new JMenu("Appointment");
				menuBar_1.add(mnAppointment_1);
				
				JMenuItem mntmTakeAppointment_1 = new JMenuItem("Take Appointment");
				mnAppointment_1.add(mntmTakeAppointment_1);
				
				JMenuItem mntmShowAppointment = new JMenuItem("Show Appointment");
				mnAppointment_1.add(mntmShowAppointment);
				
				JMenuItem mntmCancelOrUpdate = new JMenuItem("Cancel Or Update");
				mnAppointment_1.add(mntmCancelOrUpdate);
				
				JMenu mnAdmitPatinet = new JMenu("Admit Patient");
				menuBar_1.add(mnAdmitPatinet);
				
				JMenuItem mntmAdmissionDesk = new JMenuItem("Admission desk");
				mnAdmitPatinet.add(mntmAdmissionDesk);
				
				JMenu mnBilling_1 = new JMenu("Billing desk");
				menuBar_1.add(mnBilling_1);
				
				JMenuItem mntmCoomingSoon = new JMenuItem("cooming soon");
				mnBilling_1.add(mntmCoomingSoon);
				
				
				JLabel lblRecepnist = new JLabel("Recepnist only");
				lblRecepnist.setForeground(new Color(255, 250, 250));
				lblRecepnist.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 14));
				lblRecepnist.setBounds(22, 312, 200, 30);
				Recp.add(lblRecepnist);
		
		btnCloseAppication.setBounds(1186, 640, 134, 23);
		desktopPane.add(btnCloseAppication);
					
					JButton btnLogOut = new JButton("Log Out");
					btnLogOut.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						Admin.setVisible(false);
						Recp.setVisible(false);
						Lab.setVisible(false);
						Login.setVisible(true);
						}
					});
					btnLogOut.setBounds(1042, 640, 134, 23);
					desktopPane.add(btnLogOut);
								
								JLabel lblLabOnly = new JLabel("Lab Only");
								lblLabOnly.setForeground(new Color(255, 250, 250));
								lblLabOnly.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 14));
								lblLabOnly.setBounds(22, 346, 200, 23);
								Lab.add(lblLabOnly);
								setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, textField_1, getContentPane(), desktopPane, Login, lblLoginYourSelf, lblName, lblPassword, btnLogin, Admin, menuBar, mnOldPatient, mntmFindYourCase, mntmFindPatient, mnNewPatient, mntmRegister, mntmShowAllPatient, mnAppointment, mntmTakeAppointment, mntmFindYourAppointment, mntmPatientDiagonsis, mnDoctors, mntmNewDoctor, mntmFindOrUpdate, mnLabDepartment, mntmTakeReport, mntmShowPendingReports, mntmShowAllReports, mnFillReports, mntmBloodReport, mntmSonographyReport, mnShowPatientReport, mntmNewMenuItem, mntmNewMenuItem_1, mntmNewMenuItem_2, mntmNewMenuItem_3, mnRoomAlloction, mntmRoomDesk, mnBilling, mntmBill, mnReports, mnPatientDiagnosis, mntmTest, mnAdvanceSearch, mnAttention, lblAdminOnly, Recp, menuBar_1, mnPatient, mntmNewPatinet, mntmShowAllPatinet, mntmUpdatePatinent, mnCase, mntmFindYourCase_1, mntmGenerateNewCase, mntmUpdateCase, mnAppointment_1, mntmTakeAppointment_1, mntmShowAppointment, mntmCancelOrUpdate, mnAdmitPatinet, mntmAdmissionDesk, mnBilling_1, mntmCoomingSoon, lblRecepnist, Lab, lblLabOnly, btnCloseAppication, btnLogOut}));
	}
}
