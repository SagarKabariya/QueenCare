package PatientCase;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Statement;
import Connect.ConnectionManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Case_class extends JInternalFrame {
	private JTextField txtfname;
	private JTextField txtlname;
	private JTable table;
	private Connection con = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Case_class frame = new Case_class();
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
	public Case_class() {
		
		con = ConnectionManager.getConnection();
		setClosable(true);
		setTitle("Find Patient Case File");
		setBounds(100, 100, 1050, 462);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1037, 430);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblThisFormWill = new JLabel("This Form will help you to find Case File");
		lblThisFormWill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThisFormWill.setBounds(12, 13, 358, 30);
		panel.add(lblThisFormWill);
		
		JLabel lblEnterFirstName = new JLabel("Enter First name");
		lblEnterFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterFirstName.setBounds(12, 73, 135, 16);
		panel.add(lblEnterFirstName);
		
		JLabel lblEnterLastName = new JLabel("Enter Last Name");
		lblEnterLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterLastName.setBounds(12, 131, 135, 16);
		panel.add(lblEnterLastName);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtfname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				txtlname.requestFocusInWindow();
			}
		});
		txtfname.setBounds(168, 71, 180, 30);
		panel.add(txtfname);
		txtfname.setColumns(10);
		txtfname.requestFocusInWindow();
		
		txtlname = new JTextField();
		txtlname.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtlname.setBounds(168, 121, 180, 30);
		panel.add(txtlname);
		txtlname.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(380, 70, 97, 77);
		panel.add(btnFind);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 177, 1001, 240);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Case ID", "First Name", "Last Name", "Doctor Name", "Case Filed Date", "Appointment Date"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
		
			}
		});
		btnClose.setBounds(489, 70, 97, 77);
		panel.add(btnClose);

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st;
				try {
					st=con.prepareStatement("SELECT cm.case_id,pd.p_first_name, pd.p_last_name,cm.doc_id, cm.date_of_case,ap.app_date "
							+ "FROM patient_detail pd, case_main cm left JOIN appointment ap on cm.case_id = ap.case_id "
							+ "where pd.p_first_name like '"+txtfname.getText()+"' AND pd.p_last_name like '"+txtlname.getText()+"' order by ap.app_date desc ");
					ResultSet rs=st.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					while(rs.next())
					{
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		txtlname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			btnFind.requestFocusInWindow();	
			}
		});
		
	}
}
