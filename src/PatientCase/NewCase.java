package PatientCase;

import Connect.*;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class NewCase extends JInternalFrame {

	private JPanel contentPane;
	String dd,dd_c;
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
					NewCase frame = new NewCase();
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
	public NewCase() {
		
		setFrameIcon(new ImageIcon("F:\\Eduction\\Vinayak\\Vinayak & matir\\Project Store room\\icons\\AddCat.png"));
		setBackground(new Color(255, 140, 0));
		conn=ConnectionManager.getConnection();
		setClosable(true);
		setTitle("Patient Information");
	
		setBounds(100, 100, 1200, 387);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup bg = new ButtonGroup();
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Patient Detail", TitledBorder.ABOVE_TOP, TitledBorder.TOP, null, Color.yellow));
		panel_1.setBounds(12, 13, 1160, 331);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFirstname = new JLabel("First_Name");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstname.setBounds(30, 34, 84, 24);
		panel_1.add(lblFirstname);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(124, 31, 164, 27);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName_1.setBounds(30, 74, 84, 20);
		panel_1.add(lblLastName_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(124, 71, 164, 27);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactNo.setBounds(344, 39, 89, 20);
		panel_1.add(lblContactNo);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(435, 36, 122, 27);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 1138, 143);
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
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();	
				try{
				    	st=conn.prepareStatement("select * from patient_detail where p_first_name like '"+textField.getText()+"' AND p_last_name like '"+textField_1.getText()+"' AND p_contact like '"+textField_2.getText()+"'");
				    	//System.out.println(st);
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
		btnSearch.setBounds(435, 68, 122, 35);
		panel_1.add(btnSearch);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPatientId.setBounds(30, 273, 84, 14);
		panel_1.add(lblPatientId);
		
		txt_p_id = new JTextField();
		txt_p_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_p_id.setBounds(124, 270, 166, 20);
		panel_1.add(txt_p_id);
		txt_p_id.setColumns(10);
		
		JDateChooser dc_2 = new JDateChooser();
		dc_2.setBounds(524, 276, 166, 20);
		panel_1.add(dc_2);
		
		JLabel lblDateOfCase = new JLabel("Date of Case");
		lblDateOfCase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateOfCase.setBounds(423, 273, 89, 23);
		panel_1.add(lblDateOfCase);
		
		JLabel lblValidityOfCase = new JLabel("Validity of Case");
		lblValidityOfCase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValidityOfCase.setBounds(724, 276, 109, 14);
		panel_1.add(lblValidityOfCase);
		
		JComboBox cmb_valid = new JComboBox();
		cmb_valid.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cmb_valid.setBounds(837, 273, 39, 20);
		panel_1.add(cmb_valid);
		
		JLabel lblinMonth = new JLabel("*(In month)");
		lblinMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblinMonth.setForeground(Color.RED);
		lblinMonth.setBounds(792, 303, 84, 14);
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
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
									UIManager.put("OptionPane.minimumSize",new Dimension(500,200)); 
									JOptionPane.showMessageDialog(null, "Case Genarating Success, Screen will close automaticaly after clik on OK button.","Case Genarating Success",JOptionPane.PLAIN_MESSAGE);	
									
									
							}
				} catch (SQLException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
			}
		});
		btnGenerateTheCase.setBounds(996, 265, 152, 52);
		panel_1.add(btnGenerateTheCase);
		
		
	}
}