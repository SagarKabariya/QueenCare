package Lab;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class sono_report_display extends JInternalFrame {
	private JTextField textField;
	Connection conn=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sono_report_display frame = new sono_report_display();
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
	public sono_report_display() {
		setBounds(100, 100, 450, 300);

		setTitle("Sonography Report Display - Hospital Management System");
		setBounds(100, 100, 450, 300);
		try{
		Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
    	
		}catch(Exception e1){
			e1.printStackTrace();
		}
	
	setBounds(100, 100, 950, 500);
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Case Id");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblNewLabel.setBounds(27, 24, 46, 14);
	getContentPane().add(lblNewLabel);
	
	textField = new JTextField();
	textField.setBounds(83, 22, 117, 20);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	
	
	JPanel sono = new JPanel();
	sono.setBounds(10, 49, 914, 410);
	getContentPane().add(sono);
	sono.setLayout(null);
	sono.setVisible(false);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel_1.setLayout(null);
	panel_1.setBounds(10, 22, 892, 113);
	sono.add(panel_1);
	
	JLabel test_date = new JLabel("Test Date");
	test_date.setFont(new Font("Tahoma", Font.BOLD, 13));
	test_date.setBounds(10, 11, 130, 14);
	panel_1.add(test_date);
	
	JLabel lblHemoglobin = new JLabel("L size");
	lblHemoglobin.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblHemoglobin.setBounds(10, 36, 130, 14);
	panel_1.add(lblHemoglobin);
	
	JLabel lblNeutrophils = new JLabel("IHBR");
	lblNeutrophils.setBounds(10, 88, 130, 14);
	panel_1.add(lblNeutrophils);
	
	JLabel lblTlc = new JLabel("Focal Pathology");
	lblTlc.setBounds(10, 63, 130, 14);
	panel_1.add(lblTlc);
	
	JLabel field4 = new JLabel("");
	field4.setBounds(150, 88, 67, 14);
	panel_1.add(field4);
	
	JLabel field3 = new JLabel("");
	field3.setBounds(150, 63, 67, 14);
	panel_1.add(field3);
	
	JLabel field2 = new JLabel("");
	field2.setBounds(150, 36, 67, 14);
	panel_1.add(field2);
	
	JLabel field1 = new JLabel("");
	field1.setBounds(150, 11, 67, 14);
	panel_1.add(field1);
	
	JLabel lblLymphocytes = new JLabel("PV");
	lblLymphocytes.setBounds(227, 11, 130, 14);
	panel_1.add(lblLymphocytes);
	
	JLabel lblEosinophil = new JLabel("CDB");
	lblEosinophil.setBounds(227, 36, 130, 14);
	panel_1.add(lblEosinophil);
	
	JLabel lblBasophils = new JLabel("Wall_thickness");
	lblBasophils.setBounds(227, 88, 130, 14);
	panel_1.add(lblBasophils);
	
	JLabel lblMonocytes = new JLabel("G SIZE");
	lblMonocytes.setBounds(227, 63, 130, 14);
	panel_1.add(lblMonocytes);
	
	JLabel field8 = new JLabel("");
	field8.setBounds(367, 88, 67, 14);
	panel_1.add(field8);
	
	JLabel field7 = new JLabel("");
	field7.setBounds(367, 63, 67, 14);
	panel_1.add(field7);
	
	JLabel field6 = new JLabel("");
	field6.setBounds(367, 36, 67, 14);
	panel_1.add(field6);
	
	JLabel field5 = new JLabel("");
	field5.setBounds(367, 11, 67, 14);
	panel_1.add(field5);
	
	JLabel lblOthers = new JLabel("lumen");
	lblOthers.setBounds(444, 11, 130, 14);
	panel_1.add(lblOthers);
	
	JLabel lblEsr = new JLabel("p_echotexture");
	lblEsr.setBounds(444, 36, 130, 14);
	panel_1.add(lblEsr);
	
	JLabel lblPeripheralbloodfilm_1 = new JLabel("aorta");
	lblPeripheralbloodfilm_1.setBounds(444, 88, 130, 14);
	panel_1.add(lblPeripheralbloodfilm_1);
	
	JLabel lblPeripheralbloodfilm = new JLabel("S_echotecture");
	lblPeripheralbloodfilm.setBounds(444, 63, 130, 14);
	panel_1.add(lblPeripheralbloodfilm);
	
	JLabel field12 = new JLabel("");
	field12.setBounds(584, 88, 67, 14);
	panel_1.add(field12);
	
	JLabel field11 = new JLabel("");
	field11.setBounds(584, 63, 67, 14);
	panel_1.add(field11);
	
	JLabel field10 = new JLabel("");
	field10.setBounds(584, 36, 67, 14);
	panel_1.add(field10);
	
	JLabel field9 = new JLabel("");
	field9.setBounds(584, 11, 67, 14);
	panel_1.add(field9);
	
	JLabel lblHaematocritpcv = new JLabel("visualised_bowel");
	lblHaematocritpcv.setBounds(661, 11, 130, 14);
	panel_1.add(lblHaematocritpcv);
	
	JLabel lblTotalrcb = new JLabel("pr_capsule");
	lblTotalrcb.setBounds(661, 36, 130, 14);
	panel_1.add(lblTotalrcb);
	
	JLabel lblColourindex = new JLabel("o_adenexal_mass_rt");
	lblColourindex.setBounds(661, 88, 130, 14);
	panel_1.add(lblColourindex);
	
	JLabel lblPlatelets = new JLabel("u_echotexure");
	lblPlatelets.setBounds(661, 63, 130, 14);
	panel_1.add(lblPlatelets);
	
	JLabel field16 = new JLabel("");
	field16.setBounds(801, 88, 67, 14);
	panel_1.add(field16);
	
	JLabel field15 = new JLabel("");
	field15.setBounds(801, 63, 67, 14);
	panel_1.add(field15);
	
	JLabel field14 = new JLabel("");
	field14.setBounds(801, 36, 67, 14);
	panel_1.add(field14);
	
	JLabel field13 = new JLabel("");
	field13.setBounds(801, 11, 67, 14);
	panel_1.add(field13);
	
	JLabel lblBloodReportDetails = new JLabel("Sonography Report Details");
	lblBloodReportDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblBloodReportDetails.setBounds(10, 0, 284, 25);
	sono.add(lblBloodReportDetails);
	
	JPanel panel_2 = new JPanel();
	panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel_2.setLayout(null);
	panel_2.setBounds(10, 146, 892, 38);
	sono.add(panel_2);
	
	JLabel lblReticulocytes = new JLabel("o_shape_lt");
	lblReticulocytes.setBounds(10, 11, 130, 14);
	panel_2.add(lblReticulocytes);
	
	JLabel lblBeledingtimemin = new JLabel("impression");
	lblBeledingtimemin.setBounds(227, 11, 130, 14);
	panel_2.add(lblBeledingtimemin);
	
	JLabel lblBeledingtimesec = new JLabel("STATUS");
	lblBeledingtimesec.setBounds(444, 11, 130, 14);
	panel_2.add(lblBeledingtimesec);
	
	JLabel label_68 = new JLabel("");
	label_68.setBounds(150, 88, 67, 14);
	panel_2.add(label_68);
	
	JLabel field19 = new JLabel("");
	field19.setBounds(584, 11, 67, 14);
	panel_2.add(field19);
	
	JLabel field18 = new JLabel("");
	field18.setBounds(367, 11, 67, 14);
	panel_2.add(field18);
	
	JLabel field17 = new JLabel("");
	field17.setBounds(150, 11, 67, 14);
	panel_2.add(field17);
	
	
	JButton btnNewButton = new JButton("Show Report");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			sono.setVisible(true);
			try {
				st=conn.prepareStatement("select * from sonography_report where case_id="+textField.getText());
				rs=st.executeQuery();
				rs.first();
				field1.setText(rs.getString(3));
				field2.setText(rs.getString(4));
				field3.setText(rs.getString(5));
				field4.setText(rs.getString(6));
				field5.setText(rs.getString(7));
				field6.setText(rs.getString(8));
				field7.setText(rs.getString(9));
				field8.setText(rs.getString(10));
				field9.setText(rs.getString(11));
				field10.setText(rs.getString(12));
				field11.setText(rs.getString(13));
				field12.setText(rs.getString(14));
				field13.setText(rs.getString(15));
				field14.setText(rs.getString(16));
				field15.setText(rs.getString(17));
				field16.setText(rs.getString(18));
				field17.setText(rs.getString(19));
				field18.setText(rs.getString(20));
				field19.setText(rs.getString(21));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	btnNewButton.setBounds(220, 21, 117, 23);
	getContentPane().add(btnNewButton);

	}

}
