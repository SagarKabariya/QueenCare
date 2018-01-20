package Lab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Lab_main extends JInternalFrame {
	private JTextField pt_id;
	private JTextField pt_name;
	Connection conn=null;
	PreparedStatement st,st2,st3,stin,pp3,fill=null;
	ResultSet rs,rs2,rs3,rs4,fillrs = null;
	int count=0;
	int amt=0;
	ArrayList jlist = new ArrayList();
	ArrayList fee = new ArrayList();
	ArrayList all = new ArrayList();
	ArrayList id = new ArrayList();
	ArrayList idget = new ArrayList();
	private JTable table_1;
	private JTextField txtother;
	private JTextField txtotherrs;
	int othon=0;
	private JTable table;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab_main frame = new Lab_main();
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
	public Lab_main() {
		
		 try{
				Class.forName("com.mysql.jdbc.Driver");
			    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
			 }catch(Exception e1){
				 e1.printStackTrace();
			 }
		
		setClosable(true);
		setTitle("Lab Reports");
		setBounds(100, 100, 872, 604);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(408, 237, 424, 176);
		desktopPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 382, 154);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Report Name", "Fee"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(408, 22, 424, 204);
		desktopPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblYourTotalReport = new JLabel("Your Total Report is");
		lblYourTotalReport.setBounds(9, 151, 107, 14);
		panel_4.add(lblYourTotalReport);
		
		JButton btnTakeReport = new JButton("Take Report");
		btnTakeReport.setBounds(244, 170, 165, 23);
		panel_4.add(btnTakeReport);
		JButton btnNewButton = new JButton("Count");
		btnNewButton.setBounds(19, 170, 140, 23);
		btnTakeReport.setVisible(false);
		panel_4.add(btnNewButton);
		
		JLabel lblYourTotalReport_1 = new JLabel("Your Total Report Amount");
		lblYourTotalReport_1.setBounds(221, 151, 144, 14);
		panel_4.add(lblYourTotalReport_1);
		
		
		
		txtother = new JTextField();
		txtother.setBounds(9, 120, 209, 20);
		panel_4.add(txtother);
		txtother.setColumns(10);
		txtotherrs = new JTextField();
		txtotherrs.setBounds(279, 120, 86, 20);
		panel_4.add(txtotherrs);
		txtotherrs.setColumns(10);
		
		JLabel lblRs = new JLabel("Rs");
		lblRs.setBounds(244, 123, 25, 14);
		panel_4.add(lblRs);
		
		txtother.setVisible(false);
		lblRs.setVisible(false);
		txtotherrs.setVisible(false);
		
		JCheckBox chckbxNeededOtherKind = new JCheckBox("Needed Other kind of Report");
		chckbxNeededOtherKind.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				txtother.setVisible(true);
				lblRs.setVisible(true);
				txtotherrs.setVisible(true);
				
			}
		});
		chckbxNeededOtherKind.setBounds(6, 93, 262, 23);
		panel_4.add(chckbxNeededOtherKind);
		
		JLabel lblSelectReport = new JLabel("Select Report");
		lblSelectReport.setBounds(9, 7, 131, 23);
		panel_4.add(lblSelectReport);
		lblSelectReport.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblcount = new JLabel("");
		lblcount.setBounds(139, 151, 46, 14);
		panel_4.add(lblcount);
		
		JLabel lblamt = new JLabel("");
		lblamt.setBounds(363, 151, 46, 14);
		panel_4.add(lblamt);
		
		JCheckBox chk6 = new JCheckBox("Baichemistry ");
		chk6.setBounds(6, 37, 97, 23);
		panel_4.add(chk6);
		
		JCheckBox chk3 = new JCheckBox("Stool");
		chk3.setBounds(104, 37, 97, 23);
		panel_4.add(chk3);
		
		JCheckBox chk5 = new JCheckBox("Blood");
		chk5.setBounds(213, 37, 60, 23);
		panel_4.add(chk5);
		
		JCheckBox chk2 = new JCheckBox("Urin");
		chk2.setBounds(294, 37, 60, 23);
		panel_4.add(chk2);
		
		JCheckBox chk8 = new JCheckBox("Colonoscopy");
		chk8.setBounds(6, 63, 97, 23);
		panel_4.add(chk8);
		
		JCheckBox chk7 = new JCheckBox("Gastroscopy");
		chk7.setBounds(104, 63, 97, 23);
		panel_4.add(chk7);
		
		JCheckBox chk9 = new JCheckBox("ECG");
		chk9.setBounds(213, 63, 60, 23);
		panel_4.add(chk9);
		
		JCheckBox chk4 = new JCheckBox("Sonography");
		chk4.setBounds(294, 63, 97, 23);
		panel_4.add(chk4);
		
		JCheckBox chk1 = new JCheckBox("X-Ray");
		chk1.setBounds(358, 37, 60, 23);
		panel_4.add(chk1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk1.isSelected()==isSelected)
				{
					//JOptionPane.showMessageDialog(null, "selected");
					int a =(int) fee.get(0);
					amt=amt+a;
					all.add(1);
					count++;
					//JOptionPane.showMessageDialog(null, "amt is"+amt);
					//JOptionPane.showMessageDialog(null, "all is "+all);
				}
				if(chk2.isSelected()==isSelected)
				{
					int a = (int) fee.get(1);
					amt=amt+a;
					all.add(2);
					count++;
				}
				if(chk3.isSelected()==isSelected)
				{
					int a = (int) fee.get(2);
					amt=amt+a;
					all.add(3);
					count++;
				}
				if(chk4.isSelected()==isSelected)
				{
					int a = (int) fee.get(3);
					amt=amt+a;
					all.add(4);
					count++;
				}
				if(chk5.isSelected()==isSelected)
				{
					int a = (int) fee.get(4);
					amt=amt+a;
					all.add(5);
					count++;
				}
				if(chk6.isSelected()==isSelected)
				{
					int a = (int) fee.get(5);
					amt=amt+a;
					all.add(6);
					count++;
				}
				if(chk7.isSelected()==isSelected)
				{
					int a = (int) fee.get(6);
					amt=amt+a;
					all.add(7);
					count++;
				}
				if(chk8.isSelected()==isSelected)
				{
					int a = (int) fee.get(7);
					amt=amt+a;
					all.add(8);
					count++;
				}
				if(chk9.isSelected()==isSelected)
				{
					int a = (int) fee.get(8);
					amt=amt+a;
					all.add(9);
					count++;
				}
				
				if(chckbxNeededOtherKind.isSelected()==true)
				{
					count++;
					amt=amt+Integer.valueOf(txtotherrs.getText());
				}
			lblcount.setText(String.valueOf(count));
			lblamt.setText(String.valueOf(amt));
			btnTakeReport.setVisible(true);
			}
		});
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(20, 425, 811, 138);
		desktopPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblSelectedReport = new JLabel("Doctor Prefered Report List");
		lblSelectedReport.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblSelectedReport.setBounds(10, 11, 259, 20);
		panel_6.add(lblSelectedReport);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 42, 781, 77);
		panel_6.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Biochemistry", "Stool", "Boold", "Colonoscopy", "Gastroscopy", "Urine", "X-ray", "Sonography", "ECG","Other"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("1 = Doctor Suggested And 0 = Not Required");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(242, 17, 281, 14);
		panel_6.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 22, 378, 204);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
		dateChooser.setBounds(183, 157, 165, 20);
		panel.add(dateChooser);
		
		JComboBox cmb_doc_id = new JComboBox();
		cmb_doc_id.setBounds(183, 131, 165, 20);
		panel.add(cmb_doc_id);
		
		JLabel lbl_add_date = new JLabel("");
		lbl_add_date.setBounds(183, 103, 165, 20);
		panel.add(lbl_add_date);
		
		
		
		JLabel lblPatiendId = new JLabel("Case ID");
		lblPatiendId.setBounds(20, 42, 134, 20);
		panel.add(lblPatiendId);
		
		JLabel lblPatiendName = new JLabel("Patiend Name");
		lblPatiendName.setBounds(20, 73, 134, 20);
		panel.add(lblPatiendName);
		
		JLabel lblAdmissionDate = new JLabel("Admission Date");
		lblAdmissionDate.setBounds(20, 104, 134, 20);
		panel.add(lblAdmissionDate);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setBounds(20, 132, 134, 20);
		panel.add(lblDoctorId);
		
		JLabel lblDate = new JLabel("Date Of Report");
		lblDate.setBounds(20, 158, 134, 20);
		panel.add(lblDate);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblReport.setBounds(10, 11, 97, 20);
		panel.add(lblReport);
		
		
		pt_name = new JTextField();
		pt_name.setBounds(183, 72, 165, 20);
		panel.add(pt_name);
		pt_name.setColumns(10);
		
		pt_id = new JTextField();
		pt_id.setBounds(183, 41, 165, 20);
		panel.add(pt_id);
		pt_id.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBounds(10, 11, 23, 552);
		desktopPane.add(panel_3);

		try {
			fill=conn.prepareStatement("select report_name,fee,LR_id from lab_report");
			fillrs=fill.executeQuery();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setRowCount(0);
			while(fillrs.next())
			{
			fee.add(Integer.valueOf(fillrs.getString(2)));
			model.addRow(new Object[]{fillrs.getString(1),fillrs.getString(2)});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(354, 11, 259, 417);
		desktopPane.add(panel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(803, 11, 46, 552);
		desktopPane.add(panel_5);
		panel_5.setBackground(Color.ORANGE);

		pt_id.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					st=conn.prepareStatement("select p.p_first_name,c.date_of_case from patient_detail p, case_main c "
							+ "where p.p_id=c.p_id AND c.case_id="+pt_id.getText()+"");
					rs=st.executeQuery();
					rs.first();
					pt_name.setText(rs.getString(1));
					lbl_add_date.setText(rs.getString(2));
					
					 PreparedStatement p1;
					 p1=conn.prepareStatement("select d.doc_id from doctor d,case_main c where d.dept_id=c.dept_id AND c.case_id="+pt_id.getText()+"");
					ResultSet rp1=p1.executeQuery();
						
					while(rp1.next())
					{
					cmb_doc_id.addItem(rp1.getString(1));
					}
					PreparedStatement t1;
					t1=conn.prepareStatement("SELECT `bio_chemistry`,`stool`,`blood`,`colonoscopy`,`gastroscopy`,`urine`,`xray`,`sonography`,`ecg`,`other` "
							+ "FROM `patient_diagnosis` WHERE `case_id` = "+Integer.valueOf(pt_id.getText())
							+ " order by `diagnosis_date` desc limit 1");
					ResultSet tr1=t1.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);
					while(tr1.next())
					{
					model.addRow(new Object[]{tr1.getString(1),tr1.getString(2),tr1.getString(3),tr1.getString(4),tr1.getString(5),tr1.getString(6),tr1.getString(7),tr1.getString(8),tr1.getString(9),tr1.getString(10)});
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		btnTakeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
				
				String abc=cmb_doc_id.getSelectedItem().toString();
				
				 java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
				 String dd_c = fmt1.format(dateChooser.getDate());
				  
				 try {
					PreparedStatement p2=conn.prepareStatement("insert into lab"
								+ "(case_id,doc_id,date,amount)"
								+ "values(?,?,?,?)");
					
					p2.setInt(1,Integer.valueOf(pt_id.getText()));
					p2.setString(2, abc);
					p2.setString(3, dd_c);
					p2.setInt(4, amt);
					//System.out.println(p2);
					p2.executeUpdate();
					PreparedStatement p3=conn.prepareStatement("select lab_id from lab order by lab_id desc limit 1");
					ResultSet r3;
					r3=p3.executeQuery();
					r3.first();
					//System.out.println(r3.getString(1));
					int lab_id=Integer.valueOf(r3.getString(1));
				PreparedStatement ins;
				
					for(int i=0;i<count;i++)
					{
						ins=conn.prepareStatement("INSERT INTO `lab_details`"
								+ "(`lab_id`, `LR_id`) "
								+ "VALUES (?,?)");
						ins.setInt(1, lab_id);
						ins.setInt(2,(int) all.get(i));
						ins.executeUpdate();
						
					}
					
					//pp3.executeUpdate();
					JOptionPane.showMessageDialog(null,"Report generated success");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
						}
						else
						{
							
						}
			}
		});
	}
}