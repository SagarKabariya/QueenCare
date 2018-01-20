package Lab;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class sonography_report extends JInternalFrame {
	private JTextField txtcaseid;
	private JTextField textField_1;
	private JTextField txt_1;
	private JTextField txt_2;
	private JTextField txt_3;
	private JTextField txt_4;
	private JTextField txt_5;
	private JTextField txt_6;
	private JTextField txt_7;
	private JTextField txt_12;
	private JTextField txt_13;
	private JTextField txt_14;
	private JTextField txt_15;
	private JTextField txt_16;
	private JTextField txt_8;
	private JTextField txt_9;
	private JTextField txt_10;
	private JTextField txt_11;
	Connection conn=null;
	PreparedStatement ps1;
	private JTextField txt_17;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sonography_report frame = new sonography_report();
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
	public sonography_report() {
		setClosable(true);
		getContentPane().setBackground(new Color(105, 105, 105));
		setBounds(100, 100, 699, 490);
		getContentPane().setLayout(null);
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(20, 118, 645, 329);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 12, 620, 267);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);
		
		
		JLabel lblNetu = new JLabel("L_Size");
		lblNetu.setBounds(16, 26, 77, 14);
		panel_3.add(lblNetu);
		
		txt_1 = new JTextField();
		txt_1.setBounds(103, 23, 86, 20);
		panel_3.add(txt_1);
		txt_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Liver Problem");
		lblNewLabel_5.setBounds(199, 26, 68, 14);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblLymphocytes = new JLabel("Focal_Pathology");
		lblLymphocytes.setBounds(16, 52, 86, 14);
		panel_3.add(lblLymphocytes);
		
		txt_2 = new JTextField();
		txt_2.setColumns(10);
		txt_2.setBounds(103, 49, 86, 20);
		panel_3.add(txt_2);
		
		JLabel lblDlc = new JLabel("Liver Problem");
		lblDlc.setBounds(199, 52, 68, 14);
		panel_3.add(lblDlc);
		
		JLabel lblEosinophil = new JLabel("Ihbr");
		lblEosinophil.setBounds(16, 76, 77, 14);
		panel_3.add(lblEosinophil);
		
		txt_3 = new JTextField();
		txt_3.setColumns(10);
		txt_3.setBounds(103, 73, 86, 20);
		panel_3.add(txt_3);
		
		JLabel lblDlc_1 = new JLabel("Liver Problem");
		lblDlc_1.setBounds(199, 76, 68, 14);
		panel_3.add(lblDlc_1);
		
		JLabel lblMonocytes = new JLabel("Pv");
		lblMonocytes.setBounds(16, 101, 77, 14);
		panel_3.add(lblMonocytes);
		
		txt_4 = new JTextField();
		txt_4.setColumns(10);
		txt_4.setBounds(103, 98, 86, 20);
		panel_3.add(txt_4);
		
		JLabel lblDlc_2 = new JLabel("Liver Problem");
		lblDlc_2.setBounds(199, 101, 68, 14);
		panel_3.add(lblDlc_2);
		
		JLabel lblBasophils = new JLabel("Cdb");
		lblBasophils.setBounds(16, 126, 77, 14);
		panel_3.add(lblBasophils);
		
		txt_5 = new JTextField();
		txt_5.setColumns(10);
		txt_5.setBounds(103, 123, 86, 20);
		panel_3.add(txt_5);
		
		JLabel lblOthers = new JLabel("G_Size");
		lblOthers.setBounds(16, 151, 77, 14);
		panel_3.add(lblOthers);
		
		txt_6 = new JTextField();
		txt_6.setColumns(10);
		txt_6.setBounds(103, 148, 86, 20);
		panel_3.add(txt_6);
		
		JLabel lblEsr = new JLabel("Wall_Thickness");
		lblEsr.setBounds(16, 178, 77, 14);
		panel_3.add(lblEsr);
		
		txt_7 = new JTextField();
		txt_7.setColumns(10);
		txt_7.setBounds(103, 175, 86, 20);
		panel_3.add(txt_7);
		
		JLabel lblVisualisedbowel = new JLabel("Visualised_Bowel");
		lblVisualisedbowel.setBounds(292, 76, 100, 14);
		panel_3.add(lblVisualisedbowel);
		
		txt_12 = new JTextField();
		txt_12.setColumns(10);
		txt_12.setBounds(411, 73, 86, 20);
		panel_3.add(txt_12);
		
		JLabel lblPeripheralbloodfilm = new JLabel("Pr_Capsule");
		lblPeripheralbloodfilm.setBounds(292, 101, 147, 14);
		panel_3.add(lblPeripheralbloodfilm);
		
		txt_13 = new JTextField();
		txt_13.setColumns(10);
		txt_13.setBounds(411, 98, 86, 20);
		panel_3.add(txt_13);
		
		JLabel lblHaematocritpcv = new JLabel("U_Echotexture");
		lblHaematocritpcv.setBounds(292, 126, 105, 14);
		panel_3.add(lblHaematocritpcv);
		
		txt_14 = new JTextField();
		txt_14.setColumns(10);
		txt_14.setBounds(411, 123, 86, 20);
		panel_3.add(txt_14);
		
		JLabel lblTotalrbc = new JLabel("O_Adenexal_Mass_Rt");
		lblTotalrbc.setBounds(294, 151, 115, 14);
		panel_3.add(lblTotalrbc);
		
		txt_15 = new JTextField();
		txt_15.setColumns(10);
		txt_15.setBounds(411, 148, 86, 20);
		panel_3.add(txt_15);
		
		JLabel lblPlatelets = new JLabel("O_Shape_Lt");
		lblPlatelets.setBounds(292, 178, 105, 14);
		panel_3.add(lblPlatelets);
		
		txt_16 = new JTextField();
		txt_16.setColumns(10);
		txt_16.setBounds(411, 175, 86, 20);
		panel_3.add(txt_16);
		
		JLabel lblMchc = new JLabel("Lumen");
		lblMchc.setBounds(16, 207, 77, 14);
		panel_3.add(lblMchc);
		
		txt_8 = new JTextField();
		txt_8.setColumns(10);
		txt_8.setBounds(103, 202, 86, 20);
		panel_3.add(txt_8);
		
		JLabel lblMcv = new JLabel("P_Echotexture");
		lblMcv.setBounds(16, 232, 77, 14);
		panel_3.add(lblMcv);
		
		txt_9 = new JTextField();
		txt_9.setColumns(10);
		txt_9.setBounds(103, 233, 86, 20);
		panel_3.add(txt_9);
		
		JLabel lblNewLabel_7 = new JLabel("Pancreas");
		lblNewLabel_7.setBounds(199, 232, 46, 14);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblParacytes = new JLabel("S_Echotexture");
		lblParacytes.setBounds(292, 26, 77, 14);
		panel_3.add(lblParacytes);
		
		txt_10 = new JTextField();
		txt_10.setColumns(10);
		txt_10.setBounds(410, 23, 86, 20);
		panel_3.add(txt_10);
		
		JLabel lblNewLabel_8 = new JLabel("Aorta");
		lblNewLabel_8.setBounds(292, 52, 68, 14);
		panel_3.add(lblNewLabel_8);
		
		txt_11 = new JTextField();
		txt_11.setColumns(10);
		txt_11.setBounds(410, 49, 86, 20);
		panel_3.add(txt_11);
		
		JLabel label_3 = new JLabel("Liver Problem");
		label_3.setBounds(199, 126, 68, 14);
		panel_3.add(label_3);
		
		JLabel lblGallBladder = new JLabel("Gall Bladder");
		lblGallBladder.setBounds(199, 151, 68, 14);
		panel_3.add(lblGallBladder);
		
		JLabel label_5 = new JLabel("Gall Bladder");
		label_5.setBounds(199, 178, 68, 14);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("Gall Bladder");
		label_6.setBounds(199, 207, 68, 14);
		panel_3.add(label_6);
		
		JLabel lblSpleen = new JLabel("Spleen");
		lblSpleen.setBounds(510, 26, 46, 14);
		panel_3.add(lblSpleen);
		
		JLabel lblNewLabel_3 = new JLabel("Petroperitoneal");
		lblNewLabel_3.setBounds(512, 52, 77, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel label_4 = new JLabel("Petroperitoneal");
		label_4.setBounds(512, 76, 77, 14);
		panel_3.add(label_4);
		
		JLabel lblProstate = new JLabel("Prostate");
		lblProstate.setBounds(510, 101, 77, 14);
		panel_3.add(lblProstate);
		
		JLabel lblUterus = new JLabel("Uterus");
		lblUterus.setBounds(512, 126, 77, 14);
		panel_3.add(lblUterus);
		
		JLabel lblOvaries = new JLabel("Ovaries");
		lblOvaries.setBounds(512, 151, 77, 14);
		panel_3.add(lblOvaries);
		
		JLabel label_7 = new JLabel("Ovaries");
		label_7.setBounds(512, 178, 77, 14);
		panel_3.add(label_7);
		
		JLabel lblNewLabel_4 = new JLabel("Impression");
		lblNewLabel_4.setBounds(292, 203, 68, 14);
		panel_3.add(lblNewLabel_4);
		
		txt_17 = new JTextField();
		txt_17.setColumns(10);
		txt_17.setBounds(411, 206, 86, 20);
		panel_3.add(txt_17);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date date = new Date();
					ps1=conn.prepareStatement("INSERT INTO `sonography_report`"
							+ "(`case_id`, `test_date`, `l_size`,`focal_pathology`,`ihbr`,`pv`,`cdb`,`g_size`,`wall_thickness`,`lumen`,`p_echotexture`,`s_echotecture`,`aorta`,`visualised_bowel`,`pr_capsule`,`u_echotexure`,`o_adenexal_mass_rt`,`o_shape_lt`,`impression`) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps1.setInt(1,Integer.valueOf(txtcaseid.getText()));
					ps1.setString(2,dateFormat.format(date));
					ps1.setString(3,txt_1.getText());
					ps1.setString(4,txt_2.getText());
					ps1.setString(5,txt_3.getText());
					ps1.setString(6,txt_4.getText());
					ps1.setString(7,txt_5.getText());
					ps1.setString(8,txt_6.getText());
					ps1.setString(9,txt_7.getText());
					ps1.setString(10,txt_8.getText());
					ps1.setString(11,txt_9.getText());
					ps1.setString(12,txt_10.getText());
					ps1.setString(13,txt_11.getText());
					ps1.setString(14,txt_12.getText());
					ps1.setString(15,txt_13.getText());
					ps1.setString(16,txt_14.getText());
					ps1.setString(17,txt_15.getText());
					ps1.setString(18,txt_16.getText());
					ps1.setString(19,txt_17.getText());
					ps1.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(265, 290, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 645, 71);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Case Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		txtcaseid = new JTextField();
		txtcaseid.setBounds(125, 9, 119, 20);
		panel.add(txtcaseid);
		txtcaseid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 36, 85, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 34, 119, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Test Date:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(461, 11, 60, 14);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(527, 12, 119, 14);
		panel.add(label);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBounds(301, 11, 46, 14);
		panel.add(lblAge);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(357, 11, 74, 14);
		panel.add(label_1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(301, 36, 46, 14);
		panel.add(lblGender);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(354, 36, 85, 14);
		panel.add(label_2);
		
		JButton button = new JButton("Page1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.setVisible(true);
			}
		});
		button.setBounds(20, 87, 89, 23);
		getContentPane().add(button);
		
	}
}
