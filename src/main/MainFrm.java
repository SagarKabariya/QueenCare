package main;

import PatientCase.*;
import Connect.*;
import Settings.Layout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Appointment.Appointment;
import Appointment.Appointment_show;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import Patient.patient_update;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;




public class MainFrm extends JFrame {

	private JPanel contentPane;
	
	static MainFrm frame = new MainFrm();
	private JTextField txtid;
	private JTextField txtpass;
	private JTextField txtuserid;
	private JTextField password;
	private Connection con = null;
	int width;
	int height;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
					frame.setUndecorated(true);
					//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
	public MainFrm() {
				
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
//	width=1920;
	//height=1080;

		
		
		setFont(new Font("911 Porscha Laser Italic", Font.PLAIN, 15));
		setForeground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/Images/electrocardiogram2.png")));
		setTitle("Queen Care Hospital Management System");
		setBounds(1, 1, width, height);
		
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
		btnCloseAppication.setBounds(10, (height*82)/100, 158, 54);
		desktopPane.add(btnCloseAppication);
		
		JPanel Login = new JPanel();
		Login.setBounds(0, 0, width, (height*68)/100);
		Login.setBackground(new Color(255, 99, 71));
		desktopPane.add(Login);
		Login.setLayout(null);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(255, 99, 71));
		LoginPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		LoginPanel.setBounds(((width*50)/100)-210, 13, 420, 333);
		Login.add(LoginPanel);
		LoginPanel.setLayout(null);
			
		JLabel lblLoginYourSelf = new JLabel("Login your self");
		lblLoginYourSelf.setBounds(109, 105, 200, 32);
		LoginPanel.add(lblLoginYourSelf);
		lblLoginYourSelf.setForeground(new Color(255, 255, 255));
		lblLoginYourSelf.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));

		JLabel lblName = new JLabel("User ID");
		lblName.setBounds(30, 150, 102, 26);
		LoginPanel.add(lblName);
		lblName.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 17));

		txtuserid = new JTextField();
		txtuserid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			try {
				int uid = Integer.parseInt(txtuserid.getText());						                      
				} catch (Exception z) { 
					JOptionPane.showMessageDialog(null, "Please Enter Only Numbers. NO CHARCTERS ALLOW",
							"User ID error", JOptionPane.ERROR_MESSAGE);
					txtuserid.setText("");
					return;
				}
				}
			});
		txtuserid.setBounds(208, 152, 200, 26);
		LoginPanel.add(txtuserid);
		txtuserid.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 205, 102, 32);
		LoginPanel.add(lblPassword);
		lblPassword.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 17));

		password = new JTextField();
		password.setBounds(208, 210, 200, 26);
		LoginPanel.add(password);
		password.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(208, 250, 200, 32);
		LoginPanel.add(btnLogin);
		btnLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		btnLogin.setBackground(new Color(128, 128, 128));

		JLabel lbluserIdCan = new JLabel("*User ID can only in Number");
		lbluserIdCan.setBounds(208, 181, 200, 16);
		LoginPanel.add(lbluserIdCan);

		JLabel lblWelcomeInQueencare = new JLabel("Welcome in QueenCare System");
		lblWelcomeInQueencare.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeInQueencare.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		lblWelcomeInQueencare.setBounds(11, 54, 397, 49);
		LoginPanel.add(lblWelcomeInQueencare);

		JButton button = new JButton("open");
		button.setBounds(791, 441, 130, 25);
		Login.add(button);
		
		JPanel Admin = new JPanel();
		Admin.setBounds(0, 0, width, (height*72)/100);
		desktopPane.add(Admin);
		Admin.setBackground(new Color(0, 128, 128));
		Admin.setLayout(null);			
		
		
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setForeground(new Color(0, 0, 0));
	    menuBar.setBounds(0, 0, width, 35);
	    menuBar.setBackground(new Color(230, 230, 250));
	    Admin.add(menuBar);

	    JMenu mnOldPatient = new JMenu("Patient Case");
	    menuBar.add(mnOldPatient);

	    JMenuItem NewCase = new JMenuItem("Generate New Case");
	    NewCase.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	NewCase nc = new NewCase();
		    	desktopPane.add(nc);
		    	nc.setVisible(true);
		    }
		    });
	    mnOldPatient.add(NewCase);
	   
	    JMenuItem mntmFindYourCase = new JMenuItem("Find your case");
	    mntmFindYourCase.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	Case_class cc = new Case_class();
		    	desktopPane.add(cc);
		    	cc.setVisible(true);
		    }
		    });
	    mnOldPatient.add(mntmFindYourCase);
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
	    Doctor.update_doctor dl = new Doctor.update_doctor();
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

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(179, (height*82)/100, 158, 51);
		btnLogOut.setVisible(false);
		
		JPanel Recp = new JPanel();
		Recp.setBounds(0, 0, width, (height*76)/100);
		Recp.setBackground(new Color(154, 205, 50));
		desktopPane.add(Recp);
		Recp.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 1349, 28);
		Recp.add(menuBar_1);
		
				JMenu mnPatient = new JMenu("Patient");
				menuBar_1.add(mnPatient);
				
						JMenuItem mntmNewPatinet = new JMenuItem("New Patinet");
						mntmNewPatinet.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								Patient_regis pr2 = new Patient_regis();
								desktopPane.add(pr2);
								pr2.setVisible(true);
							}
						});
						mnPatient.add(mntmNewPatinet);
						
								JMenuItem mntmShowAllPatinet = new JMenuItem("Show All Patient");
								mntmShowAllPatinet.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Patient_All pr3 = new Patient_All();
										desktopPane.add(pr3);
										pr3.setVisible(true);
									}
								});
								mnPatient.add(mntmShowAllPatinet);
								
										JMenuItem mntmUpdatePatinent = new JMenuItem("Update Patient");
										mntmUpdatePatinent.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
											patient_update pup = new patient_update();
											desktopPane.add(pup);
											pup.setVisible(true);
											}
										});
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

				JPanel Lab = new JPanel();
				Lab.setBounds(0, 0, width, (height*80)/100);
				Lab.setBackground(new Color(255, 140, 0));
				desktopPane.add(Lab);
				Lab.setLayout(null);
		desktopPane.add(btnLogOut);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Admin");
				try {
					con = ConnectionManager.getConnection();
					java.sql.Statement st1;
					st1 = con.createStatement();
				    ResultSet rs=st1.executeQuery("select * from users where User_id="+txtuserid.getText()+" and PASSWORD like '"+password.getText()+"'");
				  // System.out.println("select * from users where User_id="+txtuserid.getText()+" and PASSWORD like '"+password.getText()+"'");
				    if(!rs.next())
				     {
				    	 JOptionPane.showMessageDialog(null, "Wrong User ID or Password.");   	 
				     }else{
				    	 txtuserid.setText("");
				    	 password.setText("");
				    	 if(rs.getInt(6)==1)
					    	{
					    			Login.setVisible(false);
					    			Admin.setVisible(true);
					    			btnLogOut.setVisible(true);
					    	}
					    	else if(rs.getInt(6)==2)
					    	{
					    		
					    	}
					    	else if(rs.getInt(6)==3)
					    	{
					    		Login.setVisible(false);
								Admin.setVisible(false);
								Recp.setVisible(true);
								btnLogOut.setVisible(true);
					    	}	
				     }
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Doctor.update_doctor dl = new Doctor.update_doctor();
				    desktopPane.add(dl);
				    dl.setVisible(true);
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.setVisible(false);
				Recp.setVisible(false);
				Lab.setVisible(false);
				Login.setVisible(true);
				btnLogOut.setVisible(false);
			}
		});
	}
}
