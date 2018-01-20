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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class report_detail extends JInternalFrame {
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
					report_detail frame = new report_detail();
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
	public report_detail() {
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
		
		JLabel lblReportType = new JLabel("Report Type");
		lblReportType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReportType.setBounds(258, 25, 71, 14);
		getContentPane().add(lblReportType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Blood Report", "Sonogarpy Report"}));
		comboBox.setBounds(350, 22, 131, 20);
		getContentPane().add(comboBox);
		
		
		
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
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(150, 88, 67, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(150, 63, 67, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(150, 36, 67, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(150, 11, 67, 14);
		panel_1.add(label_7);
		
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
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(367, 88, 67, 14);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(367, 63, 67, 14);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(367, 36, 67, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(367, 11, 67, 14);
		panel_1.add(label_15);
		
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
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(584, 88, 67, 14);
		panel_1.add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(584, 63, 67, 14);
		panel_1.add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(584, 36, 67, 14);
		panel_1.add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(584, 11, 67, 14);
		panel_1.add(label_23);
		
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
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(801, 88, 67, 14);
		panel_1.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(801, 63, 67, 14);
		panel_1.add(label_29);
		
		JLabel label_30 = new JLabel("");
		label_30.setBounds(801, 36, 67, 14);
		panel_1.add(label_30);
		
		JLabel label_31 = new JLabel("");
		label_31.setBounds(801, 11, 67, 14);
		panel_1.add(label_31);
		
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
		
		JLabel label_36 = new JLabel("");
		label_36.setBounds(150, 88, 67, 14);
		panel.add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setBounds(150, 63, 67, 14);
		panel.add(label_37);
		
		JLabel label_38 = new JLabel("");
		label_38.setBounds(150, 36, 67, 14);
		panel.add(label_38);
		
		JLabel label_39 = new JLabel("");
		label_39.setBounds(150, 11, 67, 14);
		panel.add(label_39);
		
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
		
		JLabel label_44 = new JLabel("");
		label_44.setBounds(367, 88, 67, 14);
		panel.add(label_44);
		
		JLabel label_45 = new JLabel("");
		label_45.setBounds(367, 63, 67, 14);
		panel.add(label_45);
		
		JLabel label_46 = new JLabel("");
		label_46.setBounds(367, 36, 67, 14);
		panel.add(label_46);
		
		JLabel label_47 = new JLabel("");
		label_47.setBounds(367, 11, 67, 14);
		panel.add(label_47);
		
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
		
		JLabel label_52 = new JLabel("");
		label_52.setBounds(584, 88, 67, 14);
		panel.add(label_52);
		
		JLabel label_53 = new JLabel("");
		label_53.setBounds(584, 63, 67, 14);
		panel.add(label_53);
		
		JLabel label_54 = new JLabel("");
		label_54.setBounds(584, 36, 67, 14);
		panel.add(label_54);
		
		JLabel label_55 = new JLabel("");
		label_55.setBounds(584, 11, 67, 14);
		panel.add(label_55);
		
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
		
		JLabel label_60 = new JLabel("");
		label_60.setBounds(801, 88, 67, 14);
		panel.add(label_60);
		
		JLabel label_61 = new JLabel("");
		label_61.setBounds(801, 63, 67, 14);
		panel.add(label_61);
		
		JLabel label_62 = new JLabel("");
		label_62.setBounds(801, 36, 67, 14);
		panel.add(label_62);
		
		JLabel label_63 = new JLabel("");
		label_63.setBounds(801, 11, 67, 14);
		panel.add(label_63);
		
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
		
		JLabel label_68 = new JLabel("");
		label_68.setBounds(150, 88, 67, 14);
		panel_2.add(label_68);
		
		JLabel label_69 = new JLabel("");
		label_69.setBounds(150, 63, 67, 14);
		panel_2.add(label_69);
		
		JLabel label_70 = new JLabel("");
		label_70.setBounds(150, 36, 67, 14);
		panel_2.add(label_70);
		
		JLabel label_71 = new JLabel("");
		label_71.setBounds(150, 11, 67, 14);
		panel_2.add(label_71);
		
		JLabel lblClothingtimesec = new JLabel("clothing_time_sec");
		lblClothingtimesec.setBounds(227, 11, 130, 14);
		panel_2.add(lblClothingtimesec);
		
		JLabel lblClothingtimesec_1 = new JLabel("clothing_time_sec");
		lblClothingtimesec_1.setBounds(227, 36, 130, 14);
		panel_2.add(lblClothingtimesec_1);
		
		JLabel lblSecspatient = new JLabel("secs_patient_1");
		lblSecspatient.setBounds(227, 88, 130, 14);
		panel_2.add(lblSecspatient);
		
		JLabel lblProthrombintimecontrol = new JLabel("prothrombin_time_control");
		lblProthrombintimecontrol.setBounds(227, 63, 130, 14);
		panel_2.add(lblProthrombintimecontrol);
		
		JLabel label_76 = new JLabel("");
		label_76.setBounds(367, 88, 67, 14);
		panel_2.add(label_76);
		
		JLabel label_77 = new JLabel("");
		label_77.setBounds(367, 63, 67, 14);
		panel_2.add(label_77);
		
		JLabel label_78 = new JLabel("");
		label_78.setBounds(367, 36, 67, 14);
		panel_2.add(label_78);
		
		JLabel label_79 = new JLabel("");
		label_79.setBounds(367, 11, 67, 14);
		panel_2.add(label_79);
		
		JLabel lblSecspatient_1 = new JLabel("secs_patient_2");
		lblSecspatient_1.setBounds(444, 11, 130, 14);
		panel_2.add(lblSecspatient_1);
		
		JLabel lblPttkcontrol = new JLabel("pttk_control");
		lblPttkcontrol.setBounds(444, 36, 130, 14);
		panel_2.add(lblPttkcontrol);
		
		JLabel lblSalinecompleteat = new JLabel("saline_complete_at");
		lblSalinecompleteat.setBounds(444, 88, 130, 14);
		panel_2.add(lblSalinecompleteat);
		
		JLabel lblHaemolysisstartfrom = new JLabel("haemolysis_start_from");
		lblHaemolysisstartfrom.setBounds(444, 63, 130, 14);
		panel_2.add(lblHaemolysisstartfrom);
		
		JLabel label_84 = new JLabel("");
		label_84.setBounds(584, 88, 67, 14);
		panel_2.add(label_84);
		
		JLabel label_85 = new JLabel("");
		label_85.setBounds(584, 63, 67, 14);
		panel_2.add(label_85);
		
		JLabel label_86 = new JLabel("");
		label_86.setBounds(584, 36, 67, 14);
		panel_2.add(label_86);
		
		JLabel label_87 = new JLabel("");
		label_87.setBounds(584, 11, 67, 14);
		panel_2.add(label_87);
		
		JLabel lblClotretractiontimecrt = new JLabel("clot_retraction_time_crt");
		lblClotretractiontimecrt.setBounds(661, 11, 130, 14);
		panel_2.add(lblClotretractiontimecrt);
		
		JLabel lblLecells = new JLabel("le_cells");
		lblLecells.setBounds(661, 36, 130, 14);
		panel_2.add(lblLecells);
		
		JLabel lblStatus = new JLabel("status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStatus.setBounds(661, 88, 130, 14);
		panel_2.add(lblStatus);
		
		JLabel lblEsrplatelets = new JLabel("esr_platelets");
		lblEsrplatelets.setBounds(661, 63, 130, 14);
		panel_2.add(lblEsrplatelets);
		
		JLabel label_92 = new JLabel("");
		label_92.setBounds(801, 88, 67, 14);
		panel_2.add(label_92);
		
		JLabel label_93 = new JLabel("");
		label_93.setBounds(801, 63, 67, 14);
		panel_2.add(label_93);
		
		JLabel label_94 = new JLabel("");
		label_94.setBounds(801, 36, 67, 14);
		panel_2.add(label_94);
		
		JLabel label_95 = new JLabel("");
		label_95.setBounds(801, 11, 67, 14);
		panel_2.add(label_95);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==1)
				{
					bloodreport.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "0");
				}
				
//				try {
//					st=conn.prepareStatement("select * from blood_report where case_id like '"+textField.getText()+"'");
//					rs=st.executeQuery();
//
//					
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		btnNewButton.setBounds(514, 21, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
