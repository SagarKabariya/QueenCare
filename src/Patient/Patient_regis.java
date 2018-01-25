package Patient;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.jmx.snmp.Timestamp;
import com.toedter.calendar.JDateChooser;

import Connect.ConnectionManager;
import javafx.scene.control.ComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Patient_regis extends JInternalFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	private JTextField weight;
	private JTextField address;
	private JTextField contact;
	String dd,dd_c;
	
	Connection conn=null;
	PreparedStatement st,stdept=null;
	ResultSet rs,r1,rs5=null;
	PreparedStatement p1,p2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_regis frame = new Patient_regis();
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
	public Patient_regis() {
		
		setClosable(true);
		setFrameIcon(new ImageIcon("F:\\Eduction\\Vinayak\\Vinayak & matir\\Project Store room\\icons\\AddCat.png"));
		setBackground(new Color(255, 140, 0));
		 conn=ConnectionManager.getConnection();
		setTitle("Patient Information");
	
		setBounds(100, 100, 897, 487);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(12, 13, 861, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBounds(96, 5, 0, 0);
		panel.add(label);
		
		JLabel lblPatientRegistation = new JLabel("Patient Registation");
		lblPatientRegistation.setBackground(new Color(135, 206, 250));
		lblPatientRegistation.setFont(new Font("Charlemagne Std", Font.PLAIN, 25));
		lblPatientRegistation.setBounds(24, 3, 371, 35);
		panel.add(lblPatientRegistation);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblFirstName.setBounds(24, 51, 124, 35);
		panel.add(lblFirstName);
		
		fname = new JTextField();
		fname.setBounds(171, 51, 224, 33);
		panel.add(fname);
		fname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblLastName.setBounds(24, 97, 124, 31);
		panel.add(lblLastName);
		
		lname = new JTextField();
		lname.setBounds(171, 97, 224, 33);
		panel.add(lname);
		lname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAge.setBounds(24, 143, 124, 33);
		panel.add(lblAge);
		
		age = new JTextField();
		age.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					int uid = Integer.parseInt(age.getText());						                      
					} catch (Exception z) { 
						JOptionPane.showMessageDialog(null, "Please Enter Only Numbers. NO CHARCTERS ALLOW",
								"User ID error", JOptionPane.ERROR_MESSAGE);
						age.setText("");
						return;
					}
			}
		});
		age.setBounds(171, 143, 224, 33);
		panel.add(age);
		age.setColumns(10);

		
		JLabel lblBgroup = new JLabel("B_group:");
		lblBgroup.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblBgroup.setBounds(24, 185, 124, 35);
		panel.add(lblBgroup);

		
		
		JLabel lblWeight = new JLabel("Weight:(KG)");
		lblWeight.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblWeight.setBounds(24, 239, 124, 29);
		panel.add(lblWeight);
		
		weight = new JTextField();
		weight.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					int uid = Integer.parseInt(weight.getText());						                      
					} catch (Exception z) { 
						JOptionPane.showMessageDialog(null, "Please Enter Only Numbers. NO CHARCTERS ALLOW",
								"User ID error", JOptionPane.ERROR_MESSAGE);
						weight.setText("");
						return;
					}
			}
		});
		weight.setBounds(171, 233, 224, 35);
		panel.add(weight);
		weight.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblGender.setBounds(428, 53, 124, 29);
		panel.add(lblGender);
		
		JRadioButton mrb = new JRadioButton("Male");
		buttonGroup.add(mrb);
		mrb.setFont(new Font("Dialog", Font.PLAIN, 20));
		mrb.setBounds(564, 56, 109, 23);
		panel.add(mrb);
		
		JRadioButton frb = new JRadioButton("Female");
		buttonGroup.add(frb);
		frb.setFont(new Font("Dialog", Font.PLAIN, 20));
		frb.setBounds(724, 56, 109, 23);
		panel.add(frb);
		
		ButtonGroup bg = new ButtonGroup();
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAddress.setBounds(428, 100, 124, 31);
		panel.add(lblAddress);
		
		JLabel lblConatctNo = new JLabel("Contact No:");
		lblConatctNo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblConatctNo.setBounds(428, 234, 124, 34);
		panel.add(lblConatctNo);
		
		contact = new JTextField();
		contact.setBounds(564, 237, 269, 27);
		panel.add(contact);
		contact.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Merried", "Single", "Separated", "Divorced", "Widowed"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(171, 283, 224, 29);
		panel.add(comboBox);
		
		JComboBox cmbBG = new JComboBox();
		cmbBG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbBG.setModel(new DefaultComboBoxModel(new String[] {"O +", "O -", "A +", "A -", "B +", "B -", "AB +", "AB -"}));
		cmbBG.setBounds(171, 189, 224, 35);
		panel.add(cmbBG);
		
		
		JButton btnRegister = new JButton("Register Patient");
		btnRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String umar=age.getText();
				String.valueOf(umar);
				JDateChooser dc = new JDateChooser();
				String vajan=weight.getText();
				String.valueOf(vajan);
				
				int jati;
				
				if(frb.isSelected())				{
	               jati=1;
				}else{
					jati = 0;
				}
				
				 try{
					 	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				    	st=conn.prepareStatement("insert into patient_detail"
				    			+"(p_first_name,p_last_name,p_age,p_bloodgroup,p_weight,p_gender,p_address,p_contact,maratial_status,regi_date)"
				    			+"values(?,?,?,?,?,?,?,?,?,?)");
				    	st.setString(1,fname.getText().toString());
				    	st.setString(2,lname.getText().toString());
				    	st.setString(3,umar);
				    	st.setString(4,(String)cmbBG.getSelectedItem());
				    	st.setString(5,vajan);
				    	st.setInt(6,jati);
				    	st.setString(7,address.getText().toString());
				    	st.setString(8,contact.getText().toString());
				    	st.setString(9, (String) comboBox.getSelectedItem());
				    	st.setString(10,timeStamp);
				
				    	int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
				    	st.executeUpdate();	
				    	JOptionPane.showMessageDialog(null, "Patient Registration Success","Patient Registration",JOptionPane.PLAIN_MESSAGE);
				    	dispose();
						}

				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			}
		});
		btnRegister.setBounds(564, 289, 268, 54);
		panel.add(btnRegister);
		
		address = new JTextField();
		address.setBounds(564, 97, 267, 123);
		panel.add(address);
		address.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(682, 368, 151, 33);
		panel.add(btnCancel);
		
		JLabel lblM = new JLabel("Marital Status");
		lblM.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblM.setBounds(24, 281, 141, 31);
		panel.add(lblM);
		
	}
}