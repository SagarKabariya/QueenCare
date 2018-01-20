package Lab;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Blood_report extends JInternalFrame {
	private JTextField txtcaseid;
	private JTextField textField_1;
	private JTextField txt_1;
	private JTextField txt_2;
	private JTextField txt_3;
	private JTextField txt_4;
	private JTextField txt_5;
	private JTextField txt_6;
	private JTextField txt_7;
	private JTextField txt_8;
	private JTextField txt_9;
	private JTextField txt_10;
	private JTextField txt_11;
	private JTextField txt_12;
	private JTextField txt_13;
	private JTextField txt_14;
	private JTextField txt_15;
	private JTextField txt_16;
	private JTextField txt_17;
	private JTextField txt_18;
	private JTextField txt_19;
	private JTextField txt_20;
	private JTextField txt_21;
	private JTextField txt_22;
	private JTextField txt_23;
	private JTextField txt_24;
	private JTextField txt_25;
	private JTextField txt_26;
	private JTextField txt_27;
	private JTextField txt_28;
	private JTextField txt_29;
	private JTextField txt_30;
	private JTextField txt_31;
	private JTextField txt_36;
	private JTextField txt_37;
	private JTextField txt_38;
	private JTextField txt_39;
	private JTextField txt_40;
	private JTextField txt_41;
	private JTextField txt_32;
	private JTextField txt_33;
	private JTextField txt_42;
	private JTextField txt_43;
	private JTextField txt_44;
	private JTextField txt_34;
	private JTextField txt_45;
	private JTextField txt_35;
	Connection conn=null;
	PreparedStatement ps1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blood_report frame = new Blood_report();
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
	public Blood_report() {
		setClosable(true);
		setBounds(100, 100, 699, 570);
		getContentPane().setLayout(null);
		
		 try{Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/queencare","root","");
	 }catch(Exception e1){
		 e1.printStackTrace();
	 }
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 106, 645, 434);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(20, 91, 620, 311);
		panel_1.add(panel_4);
		panel_4.setVisible(false);
		
		
		JLabel lblDirect = new JLabel("DIRECT");
		lblDirect.setBounds(16, 26, 77, 14);
		panel_4.add(lblDirect);
		
		txt_25 = new JTextField();
		txt_25.setColumns(10);
		txt_25.setBounds(147, 23, 86, 20);
		panel_4.add(txt_25);
		
		JLabel lblIndirect = new JLabel("INDIRECT");
		lblIndirect.setBounds(16, 52, 77, 14);
		panel_4.add(lblIndirect);
		
		txt_26 = new JTextField();
		txt_26.setColumns(10);
		txt_26.setBounds(147, 46, 86, 20);
		panel_4.add(txt_26);
		
		txt_27 = new JTextField();
		txt_27.setColumns(10);
		txt_27.setBounds(147, 70, 86, 20);
		panel_4.add(txt_27);
		
		JLabel lblHiv = new JLabel("HIV");
		lblHiv.setBounds(16, 101, 77, 14);
		panel_4.add(lblHiv);
		
		txt_28 = new JTextField();
		txt_28.setColumns(10);
		txt_28.setBounds(147, 98, 86, 20);
		panel_4.add(txt_28);
		
		JLabel lblHbsag = new JLabel("HBSAG");
		lblHbsag.setBounds(16, 126, 77, 14);
		panel_4.add(lblHbsag);
		
		txt_29 = new JTextField();
		txt_29.setColumns(10);
		txt_29.setBounds(147, 123, 86, 20);
		panel_4.add(txt_29);
		
		JLabel lblWidal = new JLabel("WIDAL");
		lblWidal.setBounds(16, 151, 77, 14);
		panel_4.add(lblWidal);
		
		txt_30 = new JTextField();
		txt_30.setColumns(10);
		txt_30.setBounds(147, 148, 86, 20);
		panel_4.add(txt_30);
		
		JLabel lblFoetalhaemoglobin = new JLabel("FOETAL_HAEMOGLOBIN");
		lblFoetalhaemoglobin.setBounds(16, 178, 121, 14);
		panel_4.add(lblFoetalhaemoglobin);
		
		txt_31 = new JTextField();
		txt_31.setColumns(10);
		txt_31.setBounds(147, 179, 86, 20);
		panel_4.add(txt_31);
		
		JLabel lblPlasmafibrinogen_1 = new JLabel("CLOTING_TIME_SEC");
		lblPlasmafibrinogen_1.setBounds(294, 26, 147, 14);
		panel_4.add(lblPlasmafibrinogen_1);
		
		txt_36 = new JTextField();
		txt_36.setColumns(10);
		txt_36.setBounds(461, 23, 86, 20);
		panel_4.add(txt_36);
		
		JLabel lblProthrombintimecontro = new JLabel("PROTHROMBIN_TIME_CONTROl");
		lblProthrombintimecontro.setBounds(292, 52, 159, 14);
		panel_4.add(lblProthrombintimecontro);
		
		txt_37 = new JTextField();
		txt_37.setColumns(10);
		txt_37.setBounds(461, 49, 86, 20);
		panel_4.add(txt_37);
		
		JLabel lblSecspatient = new JLabel("SECS_PATIENT_1");
		lblSecspatient.setBounds(294, 76, 147, 14);
		panel_4.add(lblSecspatient);
		
		txt_38 = new JTextField();
		txt_38.setColumns(10);
		txt_38.setBounds(461, 72, 86, 20);
		panel_4.add(txt_38);
		
		JLabel lblSecspatient_1 = new JLabel("SECS_PATIENT_2");
		lblSecspatient_1.setBounds(294, 101, 147, 14);
		panel_4.add(lblSecspatient_1);
		
		txt_39 = new JTextField();
		txt_39.setColumns(10);
		txt_39.setBounds(461, 98, 86, 20);
		panel_4.add(txt_39);
		
		JLabel lblPttkcontrol = new JLabel("PTTK_CONTROL");
		lblPttkcontrol.setBounds(294, 126, 147, 14);
		panel_4.add(lblPttkcontrol);
		
		txt_40 = new JTextField();
		txt_40.setColumns(10);
		txt_40.setBounds(461, 122, 86, 20);
		panel_4.add(txt_40);
		
		JLabel lblHaemolysisstartfrom = new JLabel("HAEMOLYSIS_START_FROM");
		lblHaemolysisstartfrom.setBounds(294, 151, 147, 14);
		panel_4.add(lblHaemolysisstartfrom);
		
		txt_41 = new JTextField();
		txt_41.setColumns(10);
		txt_41.setBounds(463, 151, 86, 20);
		panel_4.add(txt_41);
		
		JLabel lblReticulocytes = new JLabel("RETICULOCYTES");
		lblReticulocytes.setBounds(16, 207, 100, 14);
		panel_4.add(lblReticulocytes);
		
		txt_32 = new JTextField();
		txt_32.setColumns(10);
		txt_32.setBounds(147, 204, 86, 20);
		panel_4.add(txt_32);
		
		JLabel lblBleedingtimemin = new JLabel("BLEEDING_TIME_MIN");
		lblBleedingtimemin.setBounds(16, 231, 121, 14);
		panel_4.add(lblBleedingtimemin);
		
		txt_33 = new JTextField();
		txt_33.setColumns(10);
		txt_33.setBounds(147, 228, 86, 20);
		panel_4.add(txt_33);
		
		JLabel lblSalinecompleteat = new JLabel("SALINE_COMPLETE_AT");
		lblSalinecompleteat.setBounds(294, 178, 124, 14);
		panel_4.add(lblSalinecompleteat);
		
		txt_42 = new JTextField();
		txt_42.setColumns(10);
		txt_42.setBounds(461, 175, 86, 20);
		panel_4.add(txt_42);
		
		JLabel lblClotretractiontimecrt = new JLabel("CLOT_RETRACTION_TIME_CRT");
		lblClotretractiontimecrt.setBounds(294, 207, 158, 14);
		panel_4.add(lblClotretractiontimecrt);
		
		txt_43 = new JTextField();
		txt_43.setColumns(10);
		txt_43.setBounds(462, 202, 86, 20);
		panel_4.add(txt_43);
		
		JLabel lblLecells = new JLabel("LE_CELLS");
		lblLecells.setBounds(294, 231, 77, 14);
		panel_4.add(lblLecells);
		
		txt_44 = new JTextField();
		txt_44.setColumns(10);
		txt_44.setBounds(464, 227, 86, 20);
		panel_4.add(txt_44);
		
		JLabel lblBleedingtimesec = new JLabel("BLEEDING_TIME_SEC");
		lblBleedingtimesec.setBounds(16, 256, 121, 14);
		panel_4.add(lblBleedingtimesec);
		
		txt_34 = new JTextField();
		txt_34.setColumns(10);
		txt_34.setBounds(147, 253, 86, 20);
		panel_4.add(txt_34);
		
		JLabel lblEsrplatelets = new JLabel("ESR_PLATELETS");
		lblEsrplatelets.setBounds(294, 256, 100, 14);
		panel_4.add(lblEsrplatelets);
		
		txt_45 = new JTextField();
		txt_45.setColumns(10);
		txt_45.setBounds(465, 254, 86, 20);
		panel_4.add(txt_45);
		
		JLabel lblClotingtimemin = new JLabel("CLOTING_TIME_MIN");
		lblClotingtimemin.setBounds(16, 281, 121, 14);
		panel_4.add(lblClotingtimemin);
		
		txt_35 = new JTextField();
		txt_35.setColumns(10);
		txt_35.setBounds(147, 278, 86, 20);
		panel_4.add(txt_35);
		
		JLabel label_5 = new JLabel("PLASMA_FIBRINOGEN");
		label_5.setBounds(10, 76, 119, 14);
		panel_4.add(label_5);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(21, 91, 620, 311);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 45, 620, 44);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Hemoglobin:");
		lblNewLabel_3.setBounds(10, 11, 78, 14);
		panel_2.add(lblNewLabel_3);
		
		txt_1 = new JTextField();
		txt_1.setBounds(98, 8, 102, 20);
		panel_2.add(txt_1);
		txt_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setBounds(210, 11, 46, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblTlc = new JLabel("T.L.C:");
		lblTlc.setBounds(266, 11, 46, 14);
		panel_2.add(lblTlc);
		
		txt_2 = new JTextField();
		txt_2.setColumns(10);
		txt_2.setBounds(309, 8, 102, 20);
		panel_2.add(txt_2);
		
		JLabel label_3 = new JLabel("%");
		label_3.setBounds(421, 11, 46, 14);
		panel_2.add(label_3);
		
		
		JLabel lblNetu = new JLabel("NEUTROPHILS");
		lblNetu.setBounds(16, 26, 77, 14);
		panel_3.add(lblNetu);
		
		txt_3 = new JTextField();
		txt_3.setBounds(103, 23, 86, 20);
		panel_3.add(txt_3);
		txt_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DLC , 45-68%");
		lblNewLabel_5.setBounds(199, 26, 68, 14);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblLymphocytes = new JLabel("LYMPHOCYTES");
		lblLymphocytes.setBounds(16, 52, 77, 14);
		panel_3.add(lblLymphocytes);
		
		txt_4 = new JTextField();
		txt_4.setColumns(10);
		txt_4.setBounds(103, 49, 86, 20);
		panel_3.add(txt_4);
		
		JLabel lblDlc = new JLabel("DLC , 25-45%");
		lblDlc.setBounds(199, 52, 68, 14);
		panel_3.add(lblDlc);
		
		JLabel lblEosinophil = new JLabel("EOSINOPHIL");
		lblEosinophil.setBounds(16, 76, 77, 14);
		panel_3.add(lblEosinophil);
		
		txt_5 = new JTextField();
		txt_5.setColumns(10);
		txt_5.setBounds(103, 73, 86, 20);
		panel_3.add(txt_5);
		
		JLabel lblDlc_1 = new JLabel("DLC , 2-6%");
		lblDlc_1.setBounds(199, 76, 68, 14);
		panel_3.add(lblDlc_1);
		
		JLabel lblMonocytes = new JLabel("MONOCYTES");
		lblMonocytes.setBounds(16, 101, 77, 14);
		panel_3.add(lblMonocytes);
		
		txt_6 = new JTextField();
		txt_6.setColumns(10);
		txt_6.setBounds(103, 98, 86, 20);
		panel_3.add(txt_6);
		
		JLabel lblDlc_2 = new JLabel("DLC , 1-4%");
		lblDlc_2.setBounds(199, 101, 68, 14);
		panel_3.add(lblDlc_2);
		
		JLabel lblBasophils = new JLabel("BASOPHILS");
		lblBasophils.setBounds(16, 126, 77, 14);
		panel_3.add(lblBasophils);
		
		txt_7 = new JTextField();
		txt_7.setColumns(10);
		txt_7.setBounds(103, 123, 86, 20);
		panel_3.add(txt_7);
		
		JLabel lblDlc_3 = new JLabel("DLC , 1-2%");
		lblDlc_3.setBounds(199, 126, 68, 14);
		panel_3.add(lblDlc_3);
		
		JLabel lblOthers = new JLabel("OTHERS");
		lblOthers.setBounds(16, 151, 77, 14);
		panel_3.add(lblOthers);
		
		txt_8 = new JTextField();
		txt_8.setColumns(10);
		txt_8.setBounds(103, 148, 86, 20);
		panel_3.add(txt_8);
		
		JLabel lblDlc_4 = new JLabel("DLC ");
		lblDlc_4.setBounds(199, 151, 68, 14);
		panel_3.add(lblDlc_4);
		
		JLabel lblEsr = new JLabel("ESR");
		lblEsr.setBounds(16, 178, 77, 14);
		panel_3.add(lblEsr);
		
		txt_9 = new JTextField();
		txt_9.setColumns(10);
		txt_9.setBounds(103, 175, 86, 20);
		panel_3.add(txt_9);
		
		JLabel lblNewLabel_6 = new JLabel("0-10 MM IST Hr");
		lblNewLabel_6.setBounds(199, 178, 77, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel label_4 = new JLabel("PERIPHERAL_BLOOD_FILM_1");
		label_4.setBounds(294, 26, 147, 14);
		panel_3.add(label_4);
		
		txt_10 = new JTextField();
		txt_10.setColumns(10);
		txt_10.setBounds(451, 23, 86, 20);
		panel_3.add(txt_10);
		
		JLabel lblPeripheralbloodfilm = new JLabel("PERIPHERAL_BLOOD_FILM_2");
		lblPeripheralbloodfilm.setBounds(292, 52, 147, 14);
		panel_3.add(lblPeripheralbloodfilm);
		
		txt_11 = new JTextField();
		txt_11.setColumns(10);
		txt_11.setBounds(451, 49, 86, 20);
		panel_3.add(txt_11);
		
		JLabel lblHaematocritpcv = new JLabel("HAEMATOCRIT_PCV");
		lblHaematocritpcv.setBounds(294, 76, 147, 14);
		panel_3.add(lblHaematocritpcv);
		
		txt_12 = new JTextField();
		txt_12.setColumns(10);
		txt_12.setBounds(451, 73, 86, 20);
		panel_3.add(txt_12);
		
		JLabel lblTotalrbc = new JLabel("TOTAL_RBC");
		lblTotalrbc.setBounds(294, 101, 147, 14);
		panel_3.add(lblTotalrbc);
		
		txt_13 = new JTextField();
		txt_13.setColumns(10);
		txt_13.setBounds(451, 98, 86, 20);
		panel_3.add(txt_13);
		
		JLabel lblMilcmm = new JLabel("MIL/C.MM");
		lblMilcmm.setBounds(547, 101, 68, 14);
		panel_3.add(lblMilcmm);
		
		JLabel lblPlatelets = new JLabel("PLATELETS");
		lblPlatelets.setBounds(294, 126, 147, 14);
		panel_3.add(lblPlatelets);
		
		txt_14 = new JTextField();
		txt_14.setColumns(10);
		txt_14.setBounds(451, 123, 86, 20);
		panel_3.add(txt_14);
		
		JLabel lblCumm = new JLabel("CU.MM");
		lblCumm.setBounds(547, 126, 68, 14);
		panel_3.add(lblCumm);
		
		JLabel lblColourindex = new JLabel("COLOUR_INDEX");
		lblColourindex.setBounds(294, 151, 147, 14);
		panel_3.add(lblColourindex);
		
		txt_15 = new JTextField();
		txt_15.setColumns(10);
		txt_15.setBounds(451, 148, 86, 20);
		panel_3.add(txt_15);
		
		JLabel lblMchc = new JLabel("MCHC");
		lblMchc.setBounds(16, 207, 77, 14);
		panel_3.add(lblMchc);
		
		txt_16 = new JTextField();
		txt_16.setColumns(10);
		txt_16.setBounds(103, 202, 86, 20);
		panel_3.add(txt_16);
		
		JLabel lblMcv = new JLabel("MCV");
		lblMcv.setBounds(16, 231, 77, 14);
		panel_3.add(lblMcv);
		
		txt_17 = new JTextField();
		txt_17.setColumns(10);
		txt_17.setBounds(103, 228, 86, 20);
		panel_3.add(txt_17);
		
		JLabel lblNewLabel_7 = new JLabel("F1");
		lblNewLabel_7.setBounds(199, 231, 46, 14);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblMch = new JLabel("MCH");
		lblMch.setBounds(294, 178, 77, 14);
		panel_3.add(lblMch);
		
		txt_18 = new JTextField();
		txt_18.setColumns(10);
		txt_18.setBounds(451, 175, 86, 20);
		panel_3.add(txt_18);
		
		JLabel lblPg = new JLabel("PG");
		lblPg.setBounds(547, 178, 68, 14);
		panel_3.add(lblPg);
		
		JLabel lblTec = new JLabel("TEC");
		lblTec.setBounds(294, 207, 77, 14);
		panel_3.add(lblTec);
		
		txt_19 = new JTextField();
		txt_19.setColumns(10);
		txt_19.setBounds(451, 204, 86, 20);
		panel_3.add(txt_19);
		
		JLabel lblCumm_1 = new JLabel("CU.MM");
		lblCumm_1.setBounds(542, 207, 68, 14);
		panel_3.add(lblCumm_1);
		
		JLabel lblVec = new JLabel("VEC");
		lblVec.setBounds(294, 231, 77, 14);
		panel_3.add(lblVec);
		
		txt_20 = new JTextField();
		txt_20.setColumns(10);
		txt_20.setBounds(451, 228, 86, 20);
		panel_3.add(txt_20);
		
		JLabel lblParacytes = new JLabel("PARACYTES");
		lblParacytes.setBounds(16, 256, 77, 14);
		panel_3.add(lblParacytes);
		
		txt_21 = new JTextField();
		txt_21.setColumns(10);
		txt_21.setBounds(103, 253, 86, 20);
		panel_3.add(txt_21);
		
		JLabel lblBloodgrouping = new JLabel("BLOOD_GROUPING");
		lblBloodgrouping.setBounds(294, 256, 100, 14);
		panel_3.add(lblBloodgrouping);
		
		txt_22 = new JTextField();
		txt_22.setColumns(10);
		txt_22.setBounds(451, 253, 86, 20);
		panel_3.add(txt_22);
		
		JLabel lblNewLabel_8 = new JLabel("RH_FACTOR");
		lblNewLabel_8.setBounds(16, 281, 68, 14);
		panel_3.add(lblNewLabel_8);
		
		txt_23 = new JTextField();
		txt_23.setColumns(10);
		txt_23.setBounds(103, 278, 86, 20);
		panel_3.add(txt_23);
		
		JLabel lblRhantibodytiler = new JLabel("RH_ANTIBODY_TILER");
		lblRhantibodytiler.setBounds(294, 281, 119, 14);
		panel_3.add(lblRhantibodytiler);
		
		txt_24 = new JTextField();
		txt_24.setColumns(10);
		txt_24.setBounds(451, 278, 86, 20);
		panel_3.add(txt_24);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int response = JOptionPane.showConfirmDialog(null, "Done Filling?", "Blood Report Filling",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (response == JOptionPane.YES_OPTION) {
					 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date date = new Date();
					ps1=conn.prepareStatement("INSERT INTO `blood_report`"
							+ "(`case_id`, `test_date`, `hemoglobin`, `tlc`, `neutrophils`, `lymphocytes`, `eosinophil`, `monocytes`, `basophils`, `others`, `esr`, `peripheral_blood_film_1`, `peripheral_blood_film_2`, `haematocrit_pcv`, `total_rcb`, `platelets`, `colour_index`, `mchc`, `mcv`, `mch`, `tec`, `vec`, `paracytes`, `blood_grouping`, `rh_factor`, `rh_antibody_tiler`, `direct`, `indirect`, `plasma_fibrinogen`, `hiv`, `hbsag`, `widal`, `foetal_haemoglobin`, `reticulocytes`, `beleding_time_min`, `beleding_time_sec`, `clothing_time_min`, `clothing_time_sec`, `prothrombin_time_control`, `secs_patient_1`, `secs_patient_2`, `pttk_control`, `haemolysis_start_from`, `saline_complete_at`, `clot_retraction_time_crt`, `le_cells`, `esr_platelets`) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
					ps1.setString(20,txt_18.getText());
					ps1.setString(21,txt_19.getText());
					ps1.setString(22,txt_20.getText());
					ps1.setString(23,txt_21.getText());
					ps1.setString(24,txt_22.getText());
					ps1.setString(25,txt_23.getText());
					ps1.setString(26,txt_24.getText());
					ps1.setString(27,txt_25.getText());
					ps1.setString(28,txt_26.getText());
					ps1.setString(29,txt_27.getText());
					ps1.setString(30,txt_28.getText());
					ps1.setString(31,txt_29.getText());
					ps1.setString(32,txt_30.getText());
					ps1.setString(33,txt_31.getText());
					ps1.setString(34,txt_32.getText());
					ps1.setString(35,txt_33.getText());
					ps1.setString(36,txt_34.getText());
					ps1.setString(37,txt_35.getText());
					ps1.setString(38,txt_36.getText());
					ps1.setString(39,txt_37.getText());
					ps1.setString(40,txt_38.getText());
					ps1.setString(41,txt_39.getText());
					ps1.setString(42,txt_40.getText());
					ps1.setString(43,txt_41.getText());
					ps1.setString(44,txt_42.getText());
					ps1.setString(45,txt_43.getText());
					ps1.setString(46,txt_44.getText());
					ps1.setString(47,txt_45.getText());
					ps1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Suuccess");
							}
							
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(259, 406, 89, 23);
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
		txtcaseid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			
			}
		});
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

		
		JButton btnNewButton = new JButton("Page1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(true);
				panel_4.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Page2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(101, 11, 89, 23);
		panel_1.add(btnNewButton_1);
		
	}
}
