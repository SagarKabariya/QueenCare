package Patient;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Connect.ConnectionManager;
import javafx.scene.control.Alert;

public class patient_update extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	private JTextField weight;
	private JTextField address;
	private JTextField contact;
	String dd,dd_c;
	private JTextField bgroup;
	
	Connection conn=null;
	PreparedStatement st,stdept=null;
	ResultSet rs,r1,rs5=null;
	PreparedStatement p1,p2;
	private JTextField txtpid;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_update frame = new patient_update();
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
	public patient_update() {
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
		panel.setBounds(12, 76, 861, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBounds(96, 5, 0, 0);
		panel.add(label);
		
		JLabel lblPatientRegistation = new JLabel("Patient Information Update");
		lblPatientRegistation.setBackground(new Color(135, 206, 250));
		lblPatientRegistation.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblPatientRegistation.setBounds(280, 5, 372, 35);
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
		age.setBounds(171, 143, 224, 33);
		panel.add(age);
		age.setColumns(10);

		
		JLabel lblBgroup = new JLabel("B_group:");
		lblBgroup.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblBgroup.setBounds(24, 185, 124, 35);
		panel.add(lblBgroup);
		
		bgroup = new JTextField();
		bgroup.setBounds(171, 189, 224, 31);
		panel.add(bgroup);
		bgroup.setColumns(10);

		
		
		JLabel lblWeight = new JLabel("Weight:(KG)");
		lblWeight.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblWeight.setBounds(24, 239, 124, 29);
		panel.add(lblWeight);
		
		weight = new JTextField();
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
		lblAddress.setBounds(428, 120, 124, 31);
		panel.add(lblAddress);
		
		JLabel lblConatctNo = new JLabel("Contact No:");
		lblConatctNo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblConatctNo.setBounds(428, 234, 124, 34);
		panel.add(lblConatctNo);
		
		contact = new JTextField();
		contact.setBounds(564, 237, 269, 27);
		panel.add(contact);
		contact.setColumns(10);
		
		
		
		JButton btnRegister = new JButton("Update Information");
		btnRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String umar=age.getText();
				String.valueOf(umar);
				
				String vajan=weight.getText();
				String.valueOf(vajan);
				
				int jati;
				
				if(frb.isSelected())				{
	               jati=1;
				}else{
					jati = 0;
				}
				
				 try{
					 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					 Date date = new Date();
					 
					   	st=conn.prepareStatement("update patient_detail set "
				    			+"p_first_name='"+fname.getText().toString()+"',p_last_name='"+lname.getText().toString()+"',p_age="+umar+",p_bloodgroup='"+bgroup.getText().toString()+"',"
				    					+ "p_weight="+vajan+",p_gender="+jati+",p_address='"+address.getText().toString()+"',p_contact="+contact.getText().toString()+",regi_date='"+dateFormat.format(date)+"' where p_id="+txtpid.getText());
				  
				    	int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
				    	st.executeUpdate();	
				    	JOptionPane.showMessageDialog(null, "Information Updated","Patient Updation",JOptionPane.PLAIN_MESSAGE);
						}
				    	//System.out.println("inserted data");
				    	
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			}
		});
		btnRegister.setBounds(575, 302, 258, 35);
		panel.add(btnRegister);
		
		address = new JTextField();
		address.setBounds(564, 117, 267, 92);
		panel.add(address);
		address.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(401, 302, 151, 33);
		panel.add(btnCancel);
		
		JLabel lblEnterPatientId = new JLabel("Enter Patient ID");
		lblEnterPatientId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterPatientId.setBounds(27, 28, 147, 25);
		contentPane.add(lblEnterPatientId);
		
		txtpid = new JTextField();
		txtpid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpid.setBounds(186, 27, 147, 36);
		contentPane.add(txtpid);
		txtpid.setColumns(10);
		
		JButton btnOpenDetails = new JButton("Open Details");
		btnOpenDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				    	st=conn.prepareStatement("select * from patient_detail where p_id ="+txtpid.getText());
				    	rs=st.executeQuery();
				    	
				    	if (!rs.next() ) {
				    	    JOptionPane.showMessageDialog(null,"Patient ID not Found");
				    	} 
				    	else{				    		
					    	fname.setText(rs.getString(2));
					    	lname.setText(rs.getString(3));
					    	age.setText(rs.getString(4));
					    	bgroup.setText(rs.getString(5));
					    	weight.setText(rs.getString(6));
					    	if(rs.getInt(7)==0)
					    	{
					    		mrb.setSelected(true);
					    	}
					    	else
					    	{
					    		frb.setSelected(true);
					    	}
					    	address.setText(rs.getString(8));
					    	contact.setText(rs.getString(9));
					    	btnOpenDetails.setEnabled(false);
				    	}
					/*while(rs.next()){
						model.addRow(new Object[]{rs.getString("p_id"),rs.getString("p_first_name"),rs.getString("p_last_name"),rs.getString("p_age"),rs.getString("p_bloodgroup"),rs.getString("p_weight"),rs.getString("p_gender"),rs.getString("p_address"),rs.getString("p_contact"),rs.getString("regi_date")});
						
					}*/
				
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			}
		});
		btnOpenDetails.setBounds(345, 28, 147, 35);
		contentPane.add(btnOpenDetails);
		
		JButton btnFindAgain = new JButton("Find Again");
		btnFindAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname.setText("");
				lname.setText("");
				age.setText("");
				bgroup.setText("");
				weight.setText("");
				buttonGroup.clearSelection();
				address.setText("");	
				contact.setText("");
				btnOpenDetails.setEnabled(true);
			}
		});
		btnFindAgain.setBounds(504, 28, 147, 35);
		contentPane.add(btnFindAgain);

	}
}
