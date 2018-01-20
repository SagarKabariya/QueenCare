package Lab;

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

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class Blood_report_display extends JInternalFrame {
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
					Blood_report_display frame = new Blood_report_display();
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
	public Blood_report_display() {
		setClosable(true);
		setTitle("Blood Report Display - Hospital Management System");
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
	
	
	
	JPanel bloodreport = new JPanel();
	bloodreport.setBounds(10, 49, 914, 410);
	getContentPane().add(bloodreport);
	bloodreport.setLayout(null);
	bloodreport.setVisible(false);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel_1.setLayout(null);
	panel_1.setBounds(10, 22, 892, 113);
	bloodreport.add(panel_1);
	
	JLabel test_date = new JLabel("Test Date");
	test_date.setFont(new Font("Tahoma", Font.BOLD, 13));
	test_date.setBounds(10, 11, 130, 14);
	panel_1.add(test_date);
	
	JLabel lblHemoglobin = new JLabel("Hemoglobin");
	lblHemoglobin.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblHemoglobin.setBounds(10, 36, 130, 14);
	panel_1.add(lblHemoglobin);
	
	JLabel lblNeutrophils = new JLabel("Neutrophils");
	lblNeutrophils.setBounds(10, 88, 130, 14);
	panel_1.add(lblNeutrophils);
	
	JLabel lblTlc = new JLabel("TLC");
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
	
	JLabel lblLymphocytes = new JLabel("Lymphocytes");
	lblLymphocytes.setBounds(227, 11, 130, 14);
	panel_1.add(lblLymphocytes);
	
	JLabel lblEosinophil = new JLabel("Eosinophil");
	lblEosinophil.setBounds(227, 36, 130, 14);
	panel_1.add(lblEosinophil);
	
	JLabel lblBasophils = new JLabel("Basophils");
	lblBasophils.setBounds(227, 88, 130, 14);
	panel_1.add(lblBasophils);
	
	JLabel lblMonocytes = new JLabel("Monocytes");
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
	
	JLabel lblOthers = new JLabel("others");
	lblOthers.setBounds(444, 11, 130, 14);
	panel_1.add(lblOthers);
	
	JLabel lblEsr = new JLabel("ESR");
	lblEsr.setBounds(444, 36, 130, 14);
	panel_1.add(lblEsr);
	
	JLabel lblPeripheralbloodfilm_1 = new JLabel("peripheral_blood_film_2");
	lblPeripheralbloodfilm_1.setBounds(444, 88, 130, 14);
	panel_1.add(lblPeripheralbloodfilm_1);
	
	JLabel lblPeripheralbloodfilm = new JLabel("peripheral_blood_film_1");
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
	
	JLabel lblHaematocritpcv = new JLabel("Haematocrit_pcv");
	lblHaematocritpcv.setBounds(661, 11, 130, 14);
	panel_1.add(lblHaematocritpcv);
	
	JLabel lblTotalrcb = new JLabel("Total RCB");
	lblTotalrcb.setBounds(661, 36, 130, 14);
	panel_1.add(lblTotalrcb);
	
	JLabel lblColourindex = new JLabel("Colour Index");
	lblColourindex.setBounds(661, 88, 130, 14);
	panel_1.add(lblColourindex);
	
	JLabel lblPlatelets = new JLabel("Platelets");
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
	
	JLabel lblBloodReportDetails = new JLabel("Blood Report Details");
	lblBloodReportDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblBloodReportDetails.setBounds(10, 0, 217, 25);
	bloodreport.add(lblBloodReportDetails);
	
	JPanel panel = new JPanel();
	panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	panel.setLayout(null);
	panel.setBounds(10, 151, 892, 113);
	bloodreport.add(panel);
	
	JLabel lblMchs = new JLabel("MCHC");
	lblMchs.setBounds(10, 11, 130, 14);
	panel.add(lblMchs);
	
	JLabel lblMcv = new JLabel("MCV");
	lblMcv.setBounds(10, 36, 130, 14);
	panel.add(lblMcv);
	
	JLabel lblTec = new JLabel("TEC");
	lblTec.setBounds(10, 88, 130, 14);
	panel.add(lblTec);
	
	JLabel lblMch = new JLabel("MCH");
	lblMch.setBounds(10, 63, 130, 14);
	panel.add(lblMch);
	
	JLabel field20 = new JLabel("");
	field20.setBounds(150, 88, 67, 14);
	panel.add(field20);
	
	JLabel field19 = new JLabel("");
	field19.setBounds(150, 63, 67, 14);
	panel.add(field19);
	
	JLabel field18 = new JLabel("");
	field18.setBounds(150, 36, 67, 14);
	panel.add(field18);
	
	JLabel field17 = new JLabel("");
	field17.setBounds(150, 11, 67, 14);
	panel.add(field17);
	
	JLabel lblVec = new JLabel("VEC");
	lblVec.setBounds(227, 11, 130, 14);
	panel.add(lblVec);
	
	JLabel lblAracytes = new JLabel("Paracytes");
	lblAracytes.setBounds(227, 36, 130, 14);
	panel.add(lblAracytes);
	
	JLabel lblRhfactor = new JLabel("RH Factor");
	lblRhfactor.setBounds(227, 88, 130, 14);
	panel.add(lblRhfactor);
	
	JLabel lblParacytes = new JLabel("Blood Grouping");
	lblParacytes.setBounds(227, 63, 130, 14);
	panel.add(lblParacytes);
	
	JLabel field24 = new JLabel("");
	field24.setBounds(367, 88, 67, 14);
	panel.add(field24);
	
	JLabel field23 = new JLabel("");
	field23.setBounds(367, 63, 67, 14);
	panel.add(field23);
	
	JLabel field22 = new JLabel("");
	field22.setBounds(367, 36, 67, 14);
	panel.add(field22);
	
	JLabel field21 = new JLabel("");
	field21.setBounds(367, 11, 67, 14);
	panel.add(field21);
	
	JLabel lblRhantibodytiler = new JLabel("RH Antibody Tiler");
	lblRhantibodytiler.setBounds(444, 11, 130, 14);
	panel.add(lblRhantibodytiler);
	
	JLabel lblDirect = new JLabel("Direct");
	lblDirect.setBounds(444, 36, 130, 14);
	panel.add(lblDirect);
	
	JLabel lblPlasmaFibrinogen = new JLabel("Plasma Fibrinogen");
	lblPlasmaFibrinogen.setBounds(444, 88, 130, 14);
	panel.add(lblPlasmaFibrinogen);
	
	JLabel lblIndirect = new JLabel("Indirect");
	lblIndirect.setBounds(444, 63, 130, 14);
	panel.add(lblIndirect);
	
	JLabel field28 = new JLabel("");
	field28.setBounds(584, 88, 67, 14);
	panel.add(field28);
	
	JLabel field27 = new JLabel("");
	field27.setBounds(584, 63, 67, 14);
	panel.add(field27);
	
	JLabel field26 = new JLabel("");
	field26.setBounds(584, 36, 67, 14);
	panel.add(field26);
	
	JLabel field25 = new JLabel("");
	field25.setBounds(584, 11, 67, 14);
	panel.add(field25);
	
	JLabel lblHiv = new JLabel("HIV");
	lblHiv.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblHiv.setBounds(661, 11, 130, 14);
	panel.add(lblHiv);
	
	JLabel lblHbsag = new JLabel("HBSAG");
	lblHbsag.setBounds(661, 36, 130, 14);
	panel.add(lblHbsag);
	
	JLabel lblFoetalHaemoglobin = new JLabel("Foetal Haemoglobin");
	lblFoetalHaemoglobin.setBounds(661, 88, 130, 14);
	panel.add(lblFoetalHaemoglobin);
	
	JLabel lblWidal = new JLabel("Widal");
	lblWidal.setBounds(661, 63, 130, 14);
	panel.add(lblWidal);
	
	JLabel field32 = new JLabel("");
	field32.setBounds(801, 88, 67, 14);
	panel.add(field32);
	
	JLabel field31 = new JLabel("");
	field31.setBounds(801, 63, 67, 14);
	panel.add(field31);
	
	JLabel field30 = new JLabel("");
	field30.setBounds(801, 36, 67, 14);
	panel.add(field30);
	
	JLabel field29 = new JLabel("");
	field29.setBounds(801, 11, 67, 14);
	panel.add(field29);
	
	JPanel panel_2 = new JPanel();
	panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel_2.setLayout(null);
	panel_2.setBounds(10, 286, 892, 113);
	bloodreport.add(panel_2);
	
	JLabel lblReticulocytes = new JLabel("Reticulocytes");
	lblReticulocytes.setBounds(10, 11, 130, 14);
	panel_2.add(lblReticulocytes);
	
	JLabel lblBeledingtimemin = new JLabel("beleding_time_min");
	lblBeledingtimemin.setBounds(10, 36, 130, 14);
	panel_2.add(lblBeledingtimemin);
	
	JLabel lblClothingtimemin = new JLabel("clothing_time_min");
	lblClothingtimemin.setBounds(10, 88, 130, 14);
	panel_2.add(lblClothingtimemin);
	
	JLabel lblBeledingtimesec = new JLabel("beleding_time_sec");
	lblBeledingtimesec.setBounds(10, 63, 130, 14);
	panel_2.add(lblBeledingtimesec);
	
	JLabel field36 = new JLabel("");
	field36.setBounds(150, 88, 67, 14);
	panel_2.add(field36);
	
	JLabel field35 = new JLabel("");
	field35.setBounds(150, 63, 67, 14);
	panel_2.add(field35);
	
	JLabel field34 = new JLabel("");
	field34.setBounds(150, 36, 67, 14);
	panel_2.add(field34);
	
	JLabel field33 = new JLabel("");
	field33.setBounds(150, 11, 67, 14);
	panel_2.add(field33);
	
	JLabel lblClothingtimesec = new JLabel("clothing_time_sec");
	lblClothingtimesec.setBounds(227, 11, 130, 14);
	panel_2.add(lblClothingtimesec);
	
	JLabel lblSecspatient = new JLabel("secs_patient_1");
	lblSecspatient.setBounds(227, 63, 130, 14);
	panel_2.add(lblSecspatient);
	
	JLabel lblProthrombintimecontrol = new JLabel("prothrombin_time_control");
	lblProthrombintimecontrol.setBounds(227, 36, 130, 14);
	panel_2.add(lblProthrombintimecontrol);
	
	JLabel field40 = new JLabel("");
	field40.setBounds(367, 88, 67, 14);
	panel_2.add(field40);
	
	JLabel field39 = new JLabel("");
	field39.setBounds(367, 63, 67, 14);
	panel_2.add(field39);
	
	JLabel field38 = new JLabel("");
	field38.setBounds(367, 36, 67, 14);
	panel_2.add(field38);
	
	JLabel field37 = new JLabel("");
	field37.setBounds(367, 11, 67, 14);
	panel_2.add(field37);
	
	JLabel lblSecspatient_1 = new JLabel("secs_patient_2");
	lblSecspatient_1.setBounds(227, 88, 130, 14);
	panel_2.add(lblSecspatient_1);
	
	JLabel lblPttkcontrol = new JLabel("pttk_control");
	lblPttkcontrol.setBounds(444, 11, 130, 14);
	panel_2.add(lblPttkcontrol);
	
	JLabel lblSalinecompleteat = new JLabel("saline_complete_at");
	lblSalinecompleteat.setBounds(444, 63, 130, 14);
	panel_2.add(lblSalinecompleteat);
	
	JLabel lblHaemolysisstartfrom = new JLabel("haemolysis_start_from");
	lblHaemolysisstartfrom.setBounds(444, 36, 130, 14);
	panel_2.add(lblHaemolysisstartfrom);
	
	JLabel field44 = new JLabel("");
	field44.setBounds(584, 88, 67, 14);
	panel_2.add(field44);
	
	JLabel field43 = new JLabel("");
	field43.setBounds(584, 63, 67, 14);
	panel_2.add(field43);
	
	JLabel field42 = new JLabel("");
	field42.setBounds(584, 36, 67, 14);
	panel_2.add(field42);
	
	JLabel field41 = new JLabel("");
	field41.setBounds(584, 11, 67, 14);
	panel_2.add(field41);
	
	JLabel lblClotretractiontimecrt = new JLabel("clot_retraction_time_crt");
	lblClotretractiontimecrt.setBounds(444, 88, 130, 14);
	panel_2.add(lblClotretractiontimecrt);
	
	JLabel lblLecells = new JLabel("le_cells");
	lblLecells.setBounds(661, 11, 130, 14);
	panel_2.add(lblLecells);
	
	JLabel lblStatus = new JLabel("status");
	lblStatus.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblStatus.setBounds(661, 88, 130, 14);
	panel_2.add(lblStatus);
	
	JLabel lblEsrplatelets = new JLabel("esr_platelets");
	lblEsrplatelets.setBounds(661, 36, 130, 14);
	panel_2.add(lblEsrplatelets);
	
	JLabel field47 = new JLabel("");
	field47.setBounds(801, 88, 67, 14);
	panel_2.add(field47);
	
	JLabel field46 = new JLabel("");
	field46.setBounds(801, 36, 67, 14);
	panel_2.add(field46);
	
	JLabel field45 = new JLabel("");
	field45.setBounds(801, 11, 67, 14);
	panel_2.add(field45);
	
	
	JButton btnNewButton = new JButton("Submit");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
					bloodreport.setVisible(true);	
			try {
				st=conn.prepareStatement("select * from blood_report where case_id="+textField.getText());
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
				field20.setText(rs.getString(22));
				field21.setText(rs.getString(23));
				field22.setText(rs.getString(24));
				field23.setText(rs.getString(25));
				field24.setText(rs.getString(26));
				field25.setText(rs.getString(27));
				field26.setText(rs.getString(28));
				field27.setText(rs.getString(29));
				field28.setText(rs.getString(30));
				field29.setText(rs.getString(31));
				field30.setText(rs.getString(32));
				field31.setText(rs.getString(33));
				field32.setText(rs.getString(34));
				field33.setText(rs.getString(35));
				field34.setText(rs.getString(36));
				field35.setText(rs.getString(37));
				field36.setText(rs.getString(38));
				field37.setText(rs.getString(39));
				field38.setText(rs.getString(40));
				field39.setText(rs.getString(41));
				field40.setText(rs.getString(42));
				field41.setText(rs.getString(43));
				field42.setText(rs.getString(44));
				field43.setText(rs.getString(45));
				field44.setText(rs.getString(46));
				field45.setText(rs.getString(47));
				field46.setText(rs.getString(48));
				field47.setText(rs.getString(49));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	btnNewButton.setBounds(210, 21, 89, 23);
	getContentPane().add(btnNewButton);

	}

}
			 
