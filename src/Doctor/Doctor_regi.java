package Doctor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class Doctor_regi extends JInternalFrame {
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtcont;
	private JTextField txtqua;
	private JTextField txtage;
	
	PreparedStatement st2,st3,stin=null;
	ResultSet rs2,rs3,rs4 = null;
	String a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_regi frame = new Doctor_regi();
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
	Connection conn=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	private JTextField txtMm1;
	
	public Doctor_regi() {
		getContentPane().setBackground(Color.ORANGE);
		setClosable(true);
		
		try{
			 
			Class.forName("com.mysql.jdbc.Driver");
		    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
		    	st=conn.prepareStatement("select dept_id,dept_name from department");
		    	rs=st.executeQuery();
		 }catch(Exception e1){
			 e1.printStackTrace();
		 }
		setBounds(100, 100, 1037, 492);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 999, 433);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDoctorRegistartion = new JLabel("Doctor Registartion");
		lblDoctorRegistartion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDoctorRegistartion.setBounds(206, 13, 267, 40);
		panel.add(lblDoctorRegistartion);
		
		JLabel lblDept = new JLabel("Department Name:");
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDept.setBounds(10, 66, 174, 31);
		panel.add(lblDept);
		
		JComboBox cmb_dept = new JComboBox();
		cmb_dept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_dept.setBounds(206, 66, 299, 31);
		panel.add(cmb_dept);
		try {
			while(rs.next())
			{
				String dn = rs.getString("dept_id")+" = "+rs.getString("dept_name");
				cmb_dept.addItem(dn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 120, 174, 25);
		panel.add(lblNewLabel);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtfname.setBounds(206, 110, 299, 35);
		panel.add(txtfname);
		txtfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLastName.setBounds(10, 173, 174, 24);
		panel.add(lblLastName);
		
		txtlname = new JTextField();
		txtlname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtlname.setColumns(10);
		txtlname.setBounds(206, 162, 299, 35);
		panel.add(txtlname);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContactNo.setBounds(10, 223, 174, 28);
		panel.add(lblContactNo);
		
		txtcont = new JTextField();
		txtcont.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtcont.setColumns(10);
		txtcont.setBounds(206, 210, 299, 41);
		panel.add(txtcont);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(10, 307, 174, 28);
		panel.add(lblAddress);
		
		JLabel lblNewLabel_1 = new JLabel("Qualification:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 348, 174, 23);
		panel.add(lblNewLabel_1);
		
		txtqua = new JTextField();
		txtqua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtqua.setColumns(10);
		txtqua.setBounds(206, 344, 299, 35);
		panel.add(txtqua);
		
		JLabel lblNewLabel_2 = new JLabel("Gender:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 403, 174, 19);
		panel.add(lblNewLabel_2);
		
		JRadioButton rbmale = new JRadioButton("Male");
		rbmale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbmale.setBounds(206, 399, 91, 23);
		panel.add(rbmale);
		
		JRadioButton rbfemale = new JRadioButton("Female");
		rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbfemale.setBounds(309, 399, 130, 23);
		panel.add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(545, 74, 91, 19);
		panel.add(lblNewLabel_3);
		
		txtage = new JTextField();
		txtage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtage.setBounds(720, 64, 209, 32);
		panel.add(txtage);
		txtage.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Joining Date:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(545, 116, 116, 20);
		panel.add(lblNewLabel_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(720, 105, 209, 31);
		panel.add(dateChooser);
		
		JLabel lblFromTime = new JLabel("From Time:");
		lblFromTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFromTime.setBounds(545, 161, 116, 23);
		panel.add(lblFromTime);
		

		JLabel lblCheckUp = new JLabel("Check Up:");
		lblCheckUp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCheckUp.setBounds(545, 214, 116, 25);
		panel.add(lblCheckUp);
		
		
		JTextArea txtadd = new JTextArea();
		txtadd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtadd.setWrapStyleWord(true);
		txtadd.setRows(4);
		txtadd.setBounds(206, 264, 299, 71);
		panel.add(txtadd);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 41));
		label.setBounds(817, 134, 17, 50);
		panel.add(label);
		
		txtMm1 = new JTextField();
		txtMm1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMm1.setBounds(961, 64, -40, 20);
		panel.add(txtMm1);
		txtMm1.setColumns(10);
		
		JComboBox cmb_from_min = new JComboBox();
		cmb_from_min.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_from_min.setModel(new DefaultComboBoxModel(new String[] {"00", "10", "15", "20", "25", "30", "40", "45", "50", "60"}));
		cmb_from_min.setBounds(838, 147, 91, 40);
		panel.add(cmb_from_min);
		
		JComboBox cmb_from_hour = new JComboBox();
		cmb_from_hour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_from_hour.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cmb_from_hour.setBounds(720, 147, 91, 40);
		panel.add(cmb_from_hour);
		
		JLabel label_1 = new JLabel("Designation:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(545, 323, 116, 25);
		panel.add(label_1);
		
		JComboBox cmb_desig = new JComboBox();
		cmb_desig.setModel(new DefaultComboBoxModel(new String[] {"Allergist ", "Cardiologist ", "Dentist ", "Dermatologist ", "Emergency Doctors", "Family Practitioner", "Gastroenterologist ", "Gynecologist ", "General Psychiatrist ", "Microbiologist ", "Neurosurgeons ", "Orthopedist ", "Physiologists ", "Radiologists ", "Surgeon "}));
		cmb_desig.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_desig.setBounds(719, 309, 210, 40);
		panel.add(cmb_desig);
		
		JLabel label_2 = new JLabel("To Time:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(545, 271, 116, 25);
		panel.add(label_2);
		
		JComboBox cmb_chk = new JComboBox();
		cmb_chk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_chk.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "25", "30", "40", "45", "50", "60"}));
		cmb_chk.setBounds(722, 200, 207, 40);
		panel.add(cmb_chk);
		
		JComboBox cmb_end_time = new JComboBox();
		cmb_end_time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_end_time.setBounds(719, 256, 210, 40);
		panel.add(cmb_end_time);		
		

		cmb_chk.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent event) {
	            	 
	                JComboBox comboBox = (JComboBox) event.getSource();
	 
	                Object item = event.getItem();
	
	                if (event.getStateChange() == ItemEvent.SELECTED) {
	                	a=cmb_chk.getSelectedItem().toString();
	                	cmb_end_time.removeAllItems();
	                	
	                	try {
							String entime=null;
							int cktime = 0;
							String sttime = null;
							ArrayList al1=new ArrayList();
							ArrayList al2=new ArrayList();
							ArrayList al3=new ArrayList();
							 SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
							 Calendar cal = Calendar.getInstance();
							 int ch=1;
							 SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
							 int ttr=0;
					
								
								sttime=cmb_from_hour.getSelectedItem().toString()+":"+cmb_from_min.getSelectedItem().toString()+":00";
								cktime = Integer.parseInt(cmb_chk.getSelectedItem().toString());
								
								int k=(24*60)/cktime;
								
								String newTime = null;
								String myTime=sttime;	
								for(int i=1;i<=k;i++)
								{
								 Date d = df.parse(myTime);
								 cmb_end_time.addItem(myTime);
								 cal.setTime(d);
								 cal.add(Calendar.MINUTE, cktime);
								 myTime = df.format(cal.getTime());
								
								 
								}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	               
	            }
	        });
		
		
		JButton btnDoctorRegister = new JButton("Doctor Register");
		btnDoctorRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					st=conn.prepareStatement("INSERT INTO doctor "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					String doc_id=txtfname.getText()+txtlname.getText()+"_"+txtqua.getText();
					String de=cmb_dept.getSelectedItem().toString();
					char dee=de.charAt(0);
					String abc=Character.toString(dee);
					int jati = 0;
					String dd;
					String timep=(String)cmb_from_hour.getSelectedItem();
					timep=timep+":"+cmb_from_min.getSelectedItem().toString()+":00";
					if(rbmale.isSelected()==true)					{
						jati=0;
					}
					if(rbfemale.isSelected()==true)					{
						jati=1;
					}
					String umar=txtage.getText();
					String.valueOf(umar);
					String chk=cmb_chk.getSelectedItem().toString();
					String.valueOf(chk);
					st.setString(1,doc_id);
			    	st.setString(2,abc);
			    	st.setString(3,txtfname.getText());
			    	st.setString(4,txtlname.getText());
			    	st.setString(5,txtcont.getText());
			    	st.setString(6,txtadd.getText());
			    	st.setString(7,txtqua.getText());
			    	st.setInt(8,jati);
			    	st.setString(9,umar);
			    	java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
			    	dd = fmt.format(dateChooser.getDate());
			    	st.setString(10,dd);
			    	st.setString(11,timep);
			    	st.setString(12,(String)cmb_end_time.getSelectedItem());
			    	st.setString(13,cmb_desig.getSelectedItem().toString());
			    	st.setString(14,cmb_chk.getSelectedItem().toString());
			    	st.setInt(15,0);
			    	System.out.println(st);
			    	int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
			    	JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    		    if (response == JOptionPane.YES_OPTION) {
			    		 st.executeUpdate();
			    		 JOptionPane.showMessageDialog(null, "Doctor Successfully Registred");
			    	 }					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDoctorRegister.setBounds(720, 362, 209, 39);
		panel.add(btnDoctorRegister);
		
		
		
		
		

	}
}
