package Bill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Bill_main extends JFrame {
	private JTextField textField;
	Connection conn=null;
	PreparedStatement p1;
	ResultSet rs1;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill_main frame = new Bill_main();
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
	public Bill_main() {
		setFont(new Font("ICBM SS-20", Font.BOLD, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bill_main.class.getResource("/Images/hospital23.png")));
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Bill Printing Section - Hospital Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1012, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.textInactiveText);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 135, 271);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JButton btnmedi = new JButton("Medicine Bill");
		btnmedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnmedi.setBounds(20, 108, 89, 30);
		panel.add(btnmedi);
		
		JButton btnLabBill = new JButton("LAB Bill");
		btnLabBill.setBounds(20, 148, 89, 30);
		panel.add(btnLabBill);
		
		JButton btnAdmissionBill = new JButton("Room Bill");
		btnAdmissionBill.setBounds(20, 189, 89, 30);
		panel.add(btnAdmissionBill);
		
		JButton btnFinalBill = new JButton("Final Bill");
		btnFinalBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final_bill fb = new final_bill();
				desktopPane.add(fb);
				fb.setVisible(true);
			}
		});
		btnFinalBill.setBounds(20, 230, 89, 30);
		panel.add(btnFinalBill);
		
		textField = new JTextField();
		textField.setBounds(23, 11, 86, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		btnAdmissionBill.setVisible(false);
		btnFinalBill.setVisible(false);
		btnmedi.setVisible(false);
		btnLabBill.setVisible(false);
		JButton btnShowBills = new JButton("Show Bills");
		btnShowBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int caseid=Integer.valueOf(textField.getText());
					p1=conn.prepareStatement("select count(case_id),patient_payment.* from patient_payment where case_id="+caseid);
					rs1=p1.executeQuery();
					rs1.first();
					if(rs1.getInt(1)>0)
					{
						if(rs1.getInt(6)>0){btnAdmissionBill.setVisible(true);}
						if(rs1.getInt(7)>0)	{btnmedi.setVisible(true);}
						if(rs1.getInt(8)>0)	{btnLabBill.setVisible(true);}
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
		btnShowBills.setBounds(10, 53, 111, 30);
		panel.add(btnShowBills);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(145, 0, 841, 341);
		desktopPane.add(panel_1);
	}
}
