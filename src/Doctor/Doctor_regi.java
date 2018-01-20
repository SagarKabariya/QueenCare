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
		setClosable(true);
		
		try{
			 
			Class.forName("com.mysql.jdbc.Driver");
		    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
		    	st=conn.prepareStatement("select dept_id,dept_name from department");
		    	rs=st.executeQuery();
		 }catch(Exception e1){
			 e1.printStackTrace();
		 }
		setBounds(100, 100, 1037, 529);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 15, 313, 477);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDoctorRegistartion = new JLabel("Doctor Registartion");
		lblDoctorRegistartion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDoctorRegistartion.setBounds(115, 11, 138, 14);
		panel.add(lblDoctorRegistartion);
		
		JLabel lblDept = new JLabel("Department Name:");
		lblDept.setBounds(10, 39, 91, 14);
		panel.add(lblDept);
		
		JComboBox cmb_dept = new JComboBox();
		cmb_dept.setBounds(115, 36, 170, 20);
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
		lblNewLabel.setBounds(10, 61, 66, 14);
		panel.add(lblNewLabel);
		
		txtfname = new JTextField();
		txtfname.setBounds(115, 64, 170, 20);
		panel.add(txtfname);
		txtfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 98, 59, 14);
		panel.add(lblLastName);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(115, 95, 170, 20);
		panel.add(txtlname);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(10, 124, 59, 14);
		panel.add(lblContactNo);
		
		txtcont = new JTextField();
		txtcont.setColumns(10);
		txtcont.setBounds(115, 121, 170, 20);
		panel.add(txtcont);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 180, 59, 14);
		panel.add(lblAddress);
		
		JLabel lblNewLabel_1 = new JLabel("Qualification:");
		lblNewLabel_1.setBounds(10, 237, 66, 14);
		panel.add(lblNewLabel_1);
		
		txtqua = new JTextField();
		txtqua.setColumns(10);
		txtqua.setBounds(115, 234, 170, 20);
		panel.add(txtqua);
		
		JLabel lblNewLabel_2 = new JLabel("Gender:");
		lblNewLabel_2.setBounds(10, 262, 46, 14);
		panel.add(lblNewLabel_2);
		
		JRadioButton rbmale = new JRadioButton("Male");
		rbmale.setBounds(115, 258, 59, 23);
		panel.add(rbmale);
		
		JRadioButton rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(187, 258, 72, 23);
		panel.add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setBounds(10, 287, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtage = new JTextField();
		txtage.setBounds(115, 284, 170, 20);
		panel.add(txtage);
		txtage.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Joining Date:");
		lblNewLabel_4.setBounds(10, 312, 66, 14);
		panel.add(lblNewLabel_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(115, 306, 170, 20);
		panel.add(dateChooser);
		
		JLabel lblFromTime = new JLabel("From Time:");
		lblFromTime.setBounds(10, 337, 91, 14);
		panel.add(lblFromTime);
		

		JLabel lblCheckUp = new JLabel("Check Up:");
		lblCheckUp.setBounds(10, 362, 92, 14);
		panel.add(lblCheckUp);
		
		
		JTextArea txtadd = new JTextArea();
		txtadd.setWrapStyleWord(true);
		txtadd.setRows(4);
		txtadd.setBounds(115, 152, 170, 71);
		panel.add(txtadd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Doctor Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(360, 15, 610, 299);
		getContentPane().add(panel_1);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(187, 331, 17, 20);
		panel.add(label);
		
		txtMm1 = new JTextField();
		txtMm1.setBounds(259, 337, -40, 20);
		panel.add(txtMm1);
		txtMm1.setColumns(10);
		
		JComboBox cmb_from_min = new JComboBox();
		cmb_from_min.setModel(new DefaultComboBoxModel(new String[] {"00", "10", "15", "20", "25", "30", "40", "45", "50", "60"}));
		cmb_from_min.setBounds(214, 334, 64, 20);
		panel.add(cmb_from_min);
		
		JComboBox cmb_from_time = new JComboBox();
		cmb_from_time.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cmb_from_time.setBounds(115, 337, 60, 20);
		panel.add(cmb_from_time);
		
		JLabel label_1 = new JLabel("Designation:");
		label_1.setBounds(10, 416, 66, 14);
		panel.add(label_1);
		
		JComboBox cmb_desig = new JComboBox();
		cmb_desig.setBounds(115, 412, 170, 23);
		panel.add(cmb_desig);
		
		JLabel label_2 = new JLabel("To Time:");
		label_2.setBounds(10, 391, 91, 14);
		panel.add(label_2);
		
		JComboBox cmb_chk = new JComboBox();
		cmb_chk.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "25", "30", "40", "45", "50", "60"}));
		cmb_chk.setBounds(115, 359, 104, 20);
		panel.add(cmb_chk);
		
		JComboBox cmb_end_time = new JComboBox();
		cmb_end_time.setBounds(115, 381, 104, 20);
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
					
								
								sttime=cmb_from_time.getSelectedItem().toString()+":"+cmb_from_min.getSelectedItem().toString()+":00";
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
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(62, 173, 46, 14);
		panel_1.add(lblTime);
		
		
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
					if(rbmale.isSelected()==true)
					{
						jati=0;
					}
					if(rbfemale.isSelected()==true)
					{
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
			    	
//			    	st.setString(11,a);
//			    	st.setString(12,b);
			    	st.setString(13,cmb_desig.getSelectedItem().toString());
			    	st.setString(14,chk);
			    	st.setInt(15,0);
			    	
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
		btnDoctorRegister.setBounds(115, 446, 130, 20);
		panel.add(btnDoctorRegister);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(321, 15, 19, 477);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(350, 15, 10, 477);
		getContentPane().add(panel_3);
		
		
		
		
		

	}
}
