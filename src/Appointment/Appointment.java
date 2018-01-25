 package Appointment;

import Connect.ConnectionManager;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
public class Appointment extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField Pt_id;

	Connection conn=null;
	PreparedStatement st,st2,st3,st4,stin,stdept,t1=null;
	ResultSet rs,rs2,rs3,rs4,rs5 = null;
	int cc=0;
	private JTable table;
	String selectedData = null;
	String dd;
	String a;
	String abc;
	String passid=null;
	private JTextField txtgetid;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment();
					frame.setVisible(true);
					//frame.setDefaultCloseOperation(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}

	public Appointment() {
		setTitle("Appointment Booking");
		
		conn=ConnectionManager.getConnection();
		 
		setClosable(true);
		setBounds(100, 100, 1012, 365);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_77274109700108");
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(12, 16, 123, 25);
		panel.add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(110, 15, 153, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(298, 14, 123, 28);
		panel.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(401, 15, 153, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNo.setBounds(669, 18, 116, 20);
		panel.add(lblMobileNo);
		
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();	
				try{
					st=conn.prepareStatement("select c.date_of_case,c.case_id,p.p_id,c.validity_of_case,p.p_first_name,p.p_last_name,p.p_gender,p.p_contact from case_main c,patient_detail p where p.p_id=c.p_id AND p.p_first_name like '"+textField.getText()+"%' AND p.p_last_name like '"+textField_1.getText()+"%'");
					rs=st.executeQuery();
				    model.setRowCount(0);
					while(rs.next()){
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
					}
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			}
		});
		textField_2 = new JTextField();
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();		
				try{st=conn.prepareStatement("select c.date_of_case,c.case_id,p.p_id,c.validity_of_case,p.p_first_name,p.p_last_name,p.p_gender,p.p_contact from case_main c,patient_detail p where p.p_id=c.p_id AND p.p_contact like '"+textField_2.getText()+"'");
					rs=st.executeQuery();
				    model.setRowCount(0);
					while(rs.next()){
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
						}
				
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			}
		});
		textField_2.setBounds(770, 17, 153, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "name_77280432277305");
		panel_1.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Case ID:");
		lblPatientId.setBounds(62, 61, 56, 14);
		panel_1.add(lblPatientId);
		
		Pt_id = new JTextField();
		Pt_id.setEditable(false);
		Pt_id.setBounds(206, 58, 86, 20);
		panel_1.add(Pt_id);
		Pt_id.setColumns(10);
	
		JLabel lblNewLabel = new JLabel("Appointment Date:");
		lblNewLabel.setBounds(62, 95, 113, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblDocterName = new JLabel("Docter Name:");
		lblDocterName.setBounds(62, 123, 67, 14);
		panel_1.add(lblDocterName);
		
		JComboBox cmb_time = new JComboBox();
		cmb_time.setBounds(206, 153, 178, 20);
		panel_1.add(cmb_time);
		
		JComboBox cmb_doc_name = new JComboBox();
		cmb_doc_name.setModel(new DefaultComboBoxModel(new String[] {""}));
		cmb_doc_name.setBounds(206, 120, 178, 20);
		panel_1.add(cmb_doc_name);
	     
		JDateChooser dateChooser = new JDateChooser();		
		dateChooser.setBounds(206, 95, 178, 20);
		panel_1.add(dateChooser);	
	
		  cmb_doc_name.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent event) {
	            	 
	           JComboBox comboBox = (JComboBox) event.getSource();
	             Object item = event.getItem();
	             if (event.getStateChange() == ItemEvent.SELECTED) {
	                	a=cmb_doc_name.getSelectedItem().toString();
	                	cmb_time.removeAllItems();
	                	//JOptionPane.showMessageDialog(null, a);
	                	try {
							st2=conn.prepareStatement("select ckup_time,doc_from_time,doc_to_time from doctor where doc_id like '"+a+"'");
							rs2=st2.executeQuery();
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
								while(rs2.next()){
									sttime=rs2.getString("doc_from_time").toString();
									
									entime=rs2.getString("doc_to_time").toString();
									cktime =rs2.getInt("ckup_time");
									Date date1 = format.parse(sttime);
									Date date2 = format.parse(entime);
									long difference = date2.getTime() - date1.getTime();
									long tt=(difference/(60*1000));
									ttr = (int) (tt/cktime);
								}
								 String newTime = null;
								 String myTime=sttime;	
								for(int i=1;i<=ttr;i++)
								{
								 Date d = df.parse(myTime);
								 al1.add(myTime);
								 cal.setTime(d);
								 cal.add(Calendar.MINUTE, cktime);
								 myTime = df.format(cal.getTime());
								}
								
							//	JOptionPane.showMessageDialog(null,appo_dc());
								java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
								dd = fmt.format(dateChooser.getDate());
								
								st3=conn.prepareStatement("select `time_slot` from appointment where `app_date` like '"+dd+"' AND doc_id like '"+cmb_doc_name.getSelectedItem().toString()+"'");
								
								rs3=st3.executeQuery();
								cmb_time.removeAllItems();
								while(rs3.next()){
									al2.add(rs3.getString("time_slot"));
								}
								
				 List<String> sourceList = new ArrayList<String>(al1);
				List<String> destinationList = new ArrayList<String>(al2);


					  sourceList.removeAll( destinationList );
					  
					  for(int j=0;j<sourceList.size();j++)
					  {	
						  cmb_time.addItem(sourceList.get(j));  
					  }								
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	            }
	  		 
	        });
		 
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(62, 156, 46, 14);
		panel_1.add(lblTime);
	
		JButton btnMakeAppointment = new JButton("Make Appointment");
		btnMakeAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try{
					
					String q="update case_main set doc_id = ? where case_id = ?";
		  			t1=conn.prepareStatement(q);
		  			t1.setString(1, a);
		  			t1.setInt(2,Integer.valueOf(Pt_id.getText()));
					  
		  			t1.executeUpdate();
					 stin=conn.prepareStatement("insert into appointment"
				    			+"(case_id,doc_id,app_date,time_slot,status)"
				    			+"values(?,?,?,?,?)");
				    	stin.setInt(1,Integer.valueOf(Pt_id.getText().toString()));
				    	stin.setString(2,a);
				    	stin.setString(3,dd);
				    	stin.setString(4,cmb_time.getSelectedItem().toString());
				    	stin.setInt(5, 0);
				    	
				    	System.out.println(stin);
				    	//System.out.println("inserted data");
				    	int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
							   stin.executeUpdate();
							   JOptionPane.showMessageDialog(null, "Appointment conformed","Appontment",JOptionPane.PLAIN_MESSAGE);	 
						 }
				 }catch(Exception e1){
					 System.out.println("not succ");
				 }
				 
			}
		});
		btnMakeAppointment.setBounds(206, 183, 178, 23);
		panel_1.add(btnMakeAppointment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 59, 972, 175);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Case Date", "Case_ID", "patient id", "Valid upto", "first name", "last name", "gender", "contact"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(73);
		scrollPane.setViewportView(table);
		
		JLabel lblEnterPatientId = new JLabel("Enter Case ID");
		lblEnterPatientId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterPatientId.setBounds(44, 261, 153, 24);
		panel.add(lblEnterPatientId);
		
		txtgetid = new JTextField();
		txtgetid.setBounds(172, 258, 153, 33);
		panel.add(txtgetid);
		txtgetid.setColumns(10);
		
		JButton btnGoForTake = new JButton("Go for take appointment ");
		btnGoForTake.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoForTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passid=txtgetid.getText();
				String.valueOf(passid);
		        
		        PreparedStatement p1;
				try {
					p1=conn.prepareStatement("select d.doc_id from doctor d,case_main c where d.dept_id=c.dept_id AND c.case_id="+Integer.valueOf(passid));
						ResultSet rp1=p1.executeQuery();
						
					while(rp1.next())
					{
					cmb_doc_name.addItem(rp1.getString(1));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				panel.setVisible(false);
		        panel_1.setVisible(true);	
		        Pt_id.setText(passid);
			}
		});
		
		btnGoForTake.setBounds(337, 256, 240, 35);
		panel.add(btnGoForTake);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOr.setBounds(606, 17, 51, 22);
		panel.add(lblOr);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setBounds(887, 247, 97, 50);
		panel.add(btnClose);
        	
	}	
}
