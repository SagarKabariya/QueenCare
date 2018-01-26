package Doctor;

import Connect.*;
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

public class update_doctor extends JInternalFrame {
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
					update_doctor frame = new update_doctor();
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
	private JTextField txtfind;
	
	public update_doctor() {
		getContentPane().setBackground(Color.ORANGE);
		setClosable(true);
		
		try{
			conn=ConnectionManager.getConnection();
			st=conn.prepareStatement("select dept_id,dept_name from department");
		    	rs=st.executeQuery();
		 }catch(Exception e1){
			 e1.printStackTrace();
		 }
		setBounds(100, 100, 990, 520);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 85, 949, 382);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDept = new JLabel("Department Name:");
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDept.setBounds(12, 15, 174, 31);
		panel.add(lblDept);
		
		JComboBox cmb_dept = new JComboBox();
		cmb_dept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_dept.setBounds(208, 15, 299, 31);
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
		lblNewLabel.setBounds(12, 69, 174, 25);
		panel.add(lblNewLabel);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtfname.setBounds(208, 59, 299, 35);
		panel.add(txtfname);
		txtfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLastName.setBounds(12, 122, 174, 24);
		panel.add(lblLastName);
		
		txtlname = new JTextField();
		txtlname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtlname.setColumns(10);
		txtlname.setBounds(208, 111, 299, 35);
		panel.add(txtlname);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContactNo.setBounds(12, 172, 174, 28);
		panel.add(lblContactNo);
		
		txtcont = new JTextField();
		txtcont.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtcont.setColumns(10);
		txtcont.setBounds(208, 159, 299, 41);
		panel.add(txtcont);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(12, 256, 174, 28);
		panel.add(lblAddress);
		
		JLabel lblNewLabel_1 = new JLabel("Qualification:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(12, 297, 174, 23);
		panel.add(lblNewLabel_1);
		
		txtqua = new JTextField();
		txtqua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtqua.setColumns(10);
		txtqua.setBounds(208, 293, 299, 35);
		panel.add(txtqua);
		
		JLabel lblNewLabel_2 = new JLabel("Gender:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(547, 63, 91, 19);
		panel.add(lblNewLabel_2);
		
		JRadioButton rbmale = new JRadioButton("Male");
		rbmale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbmale.setBounds(722, 59, 91, 23);
		panel.add(rbmale);
		
		JRadioButton rbfemale = new JRadioButton("Female");
		rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbfemale.setBounds(825, 59, 91, 23);
		panel.add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(547, 23, 91, 19);
		panel.add(lblNewLabel_3);
		
		txtage = new JTextField();
		txtage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtage.setBounds(722, 13, 209, 32);
		panel.add(txtage);
		txtage.setColumns(10);
		
		JLabel lblFromTime = new JLabel("From Time:");
		lblFromTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFromTime.setBounds(547, 110, 116, 23);
		panel.add(lblFromTime);
		

		JLabel lblCheckUp = new JLabel("Check Up:");
		lblCheckUp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCheckUp.setBounds(547, 163, 116, 25);
		panel.add(lblCheckUp);
		
		
		JTextArea txtadd = new JTextArea();
		txtadd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtadd.setWrapStyleWord(true);
		txtadd.setRows(4);
		txtadd.setBounds(208, 213, 299, 71);
		panel.add(txtadd);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 41));
		label.setBounds(819, 83, 17, 50);
		panel.add(label);
		
		txtMm1 = new JTextField();
		txtMm1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMm1.setBounds(961, 64, -40, 20);
		panel.add(txtMm1);
		txtMm1.setColumns(10);
		
		JComboBox cmb_from_min = new JComboBox();
		cmb_from_min.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_from_min.setModel(new DefaultComboBoxModel(new String[] {"00", "10", "15", "20", "25", "30", "40", "45", "50", "60"}));
		cmb_from_min.setBounds(840, 96, 91, 40);
		panel.add(cmb_from_min);
		
		JComboBox cmb_from_hour = new JComboBox();
		cmb_from_hour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_from_hour.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cmb_from_hour.setBounds(722, 96, 91, 40);
		panel.add(cmb_from_hour);
		
		JLabel label_1 = new JLabel("Designation:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(547, 272, 116, 25);
		panel.add(label_1);
		
		JComboBox cmb_desig = new JComboBox();
		cmb_desig.setModel(new DefaultComboBoxModel(new String[] {"Allergist ", "Cardiologist ", "Dentist ", "Dermatologist ", "Emergency Doctors", "Family Practitioner", "Gastroenterologist ", "Gynecologist ", "General Psychiatrist ", "Microbiologist ", "Neurosurgeons ", "Orthopedist ", "Physiologists ", "Radiologists ", "Surgeon "}));
		cmb_desig.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_desig.setBounds(721, 258, 210, 40);
		panel.add(cmb_desig);
		
		JLabel label_2 = new JLabel("To Time:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(547, 220, 116, 25);
		panel.add(label_2);
		
		JComboBox cmb_chk = new JComboBox();
		cmb_chk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_chk.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "25", "30", "40", "45", "50", "60"}));
		cmb_chk.setBounds(724, 149, 207, 40);
		panel.add(cmb_chk);
		
		JComboBox cmb_end_time = new JComboBox();
		cmb_end_time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_end_time.setBounds(721, 205, 210, 40);
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
		
		
		JButton btnDoctorUpdate = new JButton("Update");
		btnDoctorUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String doc_id=txtfname.getText()+txtlname.getText()+"_"+txtqua.getText();
					String de=cmb_dept.getSelectedItem().toString();
					char dee=de.charAt(0);
					String abc=Character.toString(dee);
					int jati = 0;
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
			    	st=conn.prepareStatement("UPDATE doctor set doc_id='"+doc_id+"', dept_id="+dee+", `doc_first_name`='"+txtfname.getText()+"',doc_last_name='"+txtlname.getText()+"',"
			    			+ "doc_contact='"+txtcont.getText()+"',doc_address='"+txtadd.getText()+"',doc_quali='"+txtqua.getText()+"',doc_gender="+jati+",doc_age="+umar+","
			    					+ "`doc_from_time`='"+timep+"',`doc_to_time`='"+(String)cmb_end_time.getSelectedItem()+"',`doc_designation`='"+cmb_desig.getSelectedItem().toString()+"',"
			    							+ "ckup_time='"+cmb_chk.getSelectedItem().toString()+"' WHERE `doc_contact`='"+txtcont.getText()+"'");
			    	
			    	
			    	System.out.println(st);
			    	int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
			    	JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    		    if (response == JOptionPane.YES_OPTION) {
			    		 st.executeUpdate();
			    		 JOptionPane.showMessageDialog(null, "Doctor Successfully Registred, Screen Will close after this screen.");
			    		 dispose();
			    	 }					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDoctorUpdate.setBounds(547, 310, 230, 39);
		panel.add(btnDoctorUpdate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(789, 313, 142, 32);
		panel.add(btnClose);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 949, 59);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDoctorRegistartion = new JLabel("Update Doctor Information");
		lblDoctorRegistartion.setBounds(12, 13, 328, 31);
		panel_1.add(lblDoctorRegistartion);
		lblDoctorRegistartion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblFirstName = new JLabel("Enter Contact Number");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(352, 20, 191, 23);
		panel_1.add(lblFirstName);
		
		txtfind = new JTextField();
		txtfind.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtfind.setBounds(555, 22, 191, 22);
		panel_1.add(txtfind);
		txtfind.setColumns(10);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					st=conn.prepareStatement("select * from doctor where doc_contact like '"+txtfind.getText()+"'");
					rs=st.executeQuery();
						if(rs.next())
						{					
							txtfname.setText(rs.getString(3));
							txtlname.setText(rs.getString(4));
							txtcont.setText(rs.getString(5));
							txtadd.setText(rs.getString(6));
							txtqua.setText(rs.getString(7));
							if(rs.getInt(8)==0)
							{rbmale.setSelected(true);
							}else{
								rbfemale.setSelected(true);
							}
							txtage.setText(rs.getString(9));
							cmb_desig.setSelectedItem(rs.getString(13));
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No Record Found in this Contact Number");
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnOpen.setBounds(758, 21, 97, 25);
		panel_1.add(btnOpen);
		
		
		
		
		

	}
}
