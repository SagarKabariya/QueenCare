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
import java.text.ParseException;
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

import com.toedter.calendar.JDateChooser;

public class Patient_regis extends JInternalFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	private JTextField weight;
	private JTextField address;
	private JTextField conatct;
	String dd,dd_c;
	private JTextField bgroup;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	Connection conn=null;
	PreparedStatement st,stdept=null;
	ResultSet rs,r1,rs5=null;
	PreparedStatement p1,p2;
	private JTextField txt_p_id;
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
		
		setFrameIcon(new ImageIcon("F:\\Eduction\\Vinayak\\Vinayak & matir\\Project Store room\\icons\\AddCat.png"));
		setBackground(new Color(255, 140, 0));
		 try{Class.forName("com.mysql.jdbc.Driver");
			    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
			 }catch(Exception e1){
				 e1.printStackTrace();
			 }
		setClosable(true);
		setTitle("Patient Information");
	
		setBounds(100, 100, 1200, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(10, 11, 285, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(96, 5, 0, 0);
		panel.add(label);
		
		JLabel lblPatientRegistation = new JLabel("Patient Registation");
		lblPatientRegistation.setBackground(new Color(135, 206, 250));
		lblPatientRegistation.setFont(new Font("Trajan Pro", Font.PLAIN, 17));
		lblPatientRegistation.setBounds(50, 4, 212, 35);
		panel.add(lblPatientRegistation);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 50, 71, 22);
		panel.add(lblFirstName);
		
		fname = new JTextField();
		fname.setBounds(96, 51, 166, 20);
		panel.add(fname);
		fname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 83, 71, 22);
		panel.add(lblLastName);
		
		lname = new JTextField();
		lname.setBounds(96, 84, 166, 20);
		panel.add(lname);
		lname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 117, 46, 14);
		panel.add(lblAge);
		
		age = new JTextField();
		age.setBounds(96, 115, 166, 20);
		panel.add(age);
		age.setColumns(10);

		
		JLabel lblBgroup = new JLabel("B_group:");
		lblBgroup.setBounds(10, 142, 63, 14);
		panel.add(lblBgroup);
		
		bgroup = new JTextField();
		bgroup.setBounds(96, 139, 166, 20);
		panel.add(bgroup);
		bgroup.setColumns(10);

		
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(10, 178, 71, 14);
		panel.add(lblWeight);
		
		weight = new JTextField();
		weight.setBounds(96, 175, 166, 20);
		panel.add(weight);
		weight.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 203, 46, 14);
		panel.add(lblGender);
		
		JRadioButton mrb = new JRadioButton("Male");
		mrb.setBounds(96, 202, 63, 23);
		panel.add(mrb);
		
		JRadioButton frb = new JRadioButton("Female");
		frb.setBounds(161, 202, 109, 23);
		panel.add(frb);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(mrb);
		bg.add(frb);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 228, 63, 14);
		panel.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(96, 225, 166, 20);
		panel.add(address);
		address.setColumns(10);
		
		JLabel lblConatctNo = new JLabel("Conatct No:");
		lblConatctNo.setBounds(10, 253, 71, 14);
		panel.add(lblConatctNo);
		
		conatct = new JTextField();
		conatct.setBounds(96, 250, 166, 20);
		panel.add(conatct);
		conatct.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 278, 46, 14);
		panel.add(lblDate);
		
		JDateChooser dc = new JDateChooser();
		dc.setBounds(96, 272, 166, 20);
		panel.add(dc);
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String umar=age.getText();
				String.valueOf(umar);
				
				String vajan=weight.getText();
				String.valueOf(vajan);
				
				int jati;
				String hobbie=null;
				if(frb.isSelected())				{
	               jati=1;
				}else{
					jati = 0;
				}
				
				 try{
					 
				    	java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
						dd = fmt.format(dc.getDate());
						
				    	st=conn.prepareStatement("insert into patient_detail"
				    			+"(p_first_name,p_last_name,p_age,p_bloodgroup,p_weight,p_gender,p_address,p_contact,regi_date)"
				    			+"values(?,?,?,?,?,?,?,?,?)");
				    	st.setString(1,fname.getText().toString());
				    	st.setString(2,lname.getText().toString());
				    	st.setString(3,umar);
				    	st.setString(4,bgroup.getText().toString());
				    	st.setString(5,vajan);
				    	st.setInt(6,jati);
				    	st.setString(7,address.getText().toString());
				    	st.setString(8,conatct.getText().toString());
				    	st.setString(9,dd);
				    	
				    	System.out.println(st);
				    	int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
				    	st.executeUpdate();	
				    	JOptionPane.showMessageDialog(null, "Patient Registration Success","Patient Registration",JOptionPane.PLAIN_MESSAGE);
						}
				    	//System.out.println("inserted data");
				    	
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			}
		});
		btnRegister.setBounds(96, 315, 89, 23);
		panel.add(btnRegister);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Patient Detail", TitledBorder.ABOVE_TOP, TitledBorder.TOP, null, Color.yellow));
		panel_1.setBounds(293, 11, 881, 362);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFirstname = new JLabel("First_Name");
		lblFirstname.setBounds(30, 16, 84, 14);
		panel_1.add(lblFirstname);
		
		textField = new JTextField();
		textField.setBounds(124, 13, 122, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(30, 44, 73, 14);
		panel_1.add(lblLastName_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 44, 122, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setBounds(30, 75, 73, 14);
		panel_1.add(lblContactNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 72, 122, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 861, 128);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Patient_id","First Name", "Last Name", "Age", "Blood Group", "Weight", "Gender", "Address", "Contact", "Register Date"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();	
				try{
				    	st=conn.prepareStatement("select * from patient_detail where p_first_name like '"+textField.getText()+"' AND p_last_name like '"+textField_1.getText()+"' AND p_contact like '"+textField_2.getText()+"'");
					
				    	rs=st.executeQuery();
				    	model.setRowCount(0);
					while(rs.next()){
						model.addRow(new Object[]{rs.getString("p_id"),rs.getString("p_first_name"),rs.getString("p_last_name"),rs.getString("p_age"),rs.getString("p_bloodgroup"),rs.getString("p_weight"),rs.getString("p_gender"),rs.getString("p_address"),rs.getString("p_contact"),rs.getString("regi_date")});
						
					}
				
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			
			}
		});
		btnSearch.setBounds(273, 72, 89, 20);
		panel_1.add(btnSearch);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(30, 273, 84, 14);
		panel_1.add(lblPatientId);
		
		txt_p_id = new JTextField();
		txt_p_id.setBounds(124, 270, 166, 20);
		panel_1.add(txt_p_id);
		txt_p_id.setColumns(10);
		JDateChooser dc_2 = new JDateChooser();
		dc_2.setBounds(124, 332, 166, 20);
		panel_1.add(dc_2);
		
		JLabel lblDateOfCase = new JLabel("Date of Case");
		lblDateOfCase.setBounds(30, 329, 89, 23);
		panel_1.add(lblDateOfCase);
		
		JLabel lblValidityOfCase = new JLabel("Validity of Case");
		lblValidityOfCase.setBounds(333, 273, 109, 14);
		panel_1.add(lblValidityOfCase);
		
		JComboBox cmb_valid = new JComboBox();
		cmb_valid.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cmb_valid.setBounds(446, 270, 39, 20);
		panel_1.add(cmb_valid);
		
		JLabel lblinMonth = new JLabel("*(In month)");
		lblinMonth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblinMonth.setForeground(Color.RED);
		lblinMonth.setBounds(495, 273, 84, 14);
		panel_1.add(lblinMonth);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 301, 166, 20);
		panel_1.add(comboBox);
		try {
			stdept=conn.prepareStatement("select * from department");
	    	rs5=stdept.executeQuery();
			while(rs5.next())
			{
				String dn = rs5.getString("dept_id")+" = "+rs5.getString("dept_name");
				comboBox.addItem(dn);
			}
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(30, 304, 89, 14);
		panel_1.add(lblDepartment);
		
		JButton btnGenerateTheCase = new JButton("Generate the Case");
		btnGenerateTheCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		    	int pp=Integer.valueOf(txt_p_id.getText());
		    	try {
					p2=conn.prepareStatement("insert into case_main"
							+ "(p_id,dept_id,date_of_case,validity_of_case,status)"
							+ "values(?,?,?,?,?)");
					
					String de=comboBox.getSelectedItem().toString();
					char dee=de.charAt(0);
					String abc=Character.toString(dee);
					
					 Calendar cal = Calendar.getInstance();
					  java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
					  dd_c = fmt1.format(dc_2.getDate());
					  Date d = fmt1.parse(dd_c);
						 cal.setTime(d);
						 cal.add(Calendar.MONTH,Integer.valueOf(cmb_valid.getSelectedItem().toString()));
			    	p2.setInt(1,pp);
			    	p2.setInt(2,Integer.valueOf(abc));
			    	p2.setString(3, dd_c);
			    	p2.setString(4, fmt1.format(cal.getTime()));
			    	p2.setInt(5, 0);
			    	System.out.println(p2);
			    	int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm for case",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (response == JOptionPane.YES_OPTION) {
									p2.executeUpdate();
									JOptionPane.showMessageDialog(null, "Case Genarating Success","Case Genarating",JOptionPane.PLAIN_MESSAGE);					
							}
				} catch (SQLException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
			}
		});
		btnGenerateTheCase.setBounds(333, 300, 152, 52);
		panel_1.add(btnGenerateTheCase);
		
		
	}
}