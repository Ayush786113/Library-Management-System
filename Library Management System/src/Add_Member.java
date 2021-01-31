import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Add_Member {

	public JFrame frmSpiritLibrary;
	private JTextField nametxt;
	private JTextField agetxt;
	private JTextField scltxt;
	private JTextField phtxt;
	private String name, age, school, phone;


	/**
	 * Create the application.
	 */
	public Add_Member() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpiritLibrary = new JFrame();
		frmSpiritLibrary.setTitle("Spirit Library - Add Member");
		frmSpiritLibrary.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmSpiritLibrary.setBounds(100, 100, 687, 496);
		frmSpiritLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpiritLibrary.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(32, 33, 52, 24);
		frmSpiritLibrary.getContentPane().add(lblNewLabel);
		
		nametxt = new JTextField();
		lblNewLabel.setLabelFor(nametxt);
		nametxt.setBounds(113, 37, 223, 20);
		frmSpiritLibrary.getContentPane().add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBounds(32, 89, 52, 24);
		frmSpiritLibrary.getContentPane().add(lblAge);
		
		agetxt = new JTextField();
		lblAge.setLabelFor(agetxt);
		agetxt.setColumns(10);
		agetxt.setBounds(113, 93, 223, 20);
		frmSpiritLibrary.getContentPane().add(agetxt);
		
		JLabel lblNewLabel_1_1 = new JLabel("School");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(32, 143, 60, 24);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_1);
		
		scltxt = new JTextField();
		lblNewLabel_1_1.setLabelFor(scltxt);
		scltxt.setColumns(10);
		scltxt.setBounds(113, 147, 223, 20);
		frmSpiritLibrary.getContentPane().add(scltxt);
		
		JButton btnNewButton = new JButton("Update Member");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Update_Member().frmSpiritLibrary.setVisible(true);
					frmSpiritLibrary.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
		btnNewButton.setBounds(536, 423, 125, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = nametxt.getText();
				age = agetxt.getText();
				school = scltxt.getText();
				phone = phtxt.getText();
				try {
					String message = new Database().addMember(name, age, school, phone);
					JOptionPane.showMessageDialog(frmSpiritLibrary, message);
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
		btnNewButton_1.setBounds(422, 423, 93, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phone");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(32, 202, 60, 24);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_1_1);
		
		phtxt = new JTextField();
		lblNewLabel_1_1_1.setLabelFor(phtxt);
		phtxt.setColumns(10);
		phtxt.setBounds(113, 206, 223, 20);
		frmSpiritLibrary.getContentPane().add(phtxt);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpiritLibrary.dispose();
				new Library_Main_Page().frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(32, 423, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametxt.setText("");
				agetxt.setText("");
				scltxt.setText("");
				phtxt.setText("");
			}
		});
		btnNewButton_3.setBounds(309, 423, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel_1.setLabelFor(frmSpiritLibrary.getContentPane());
		lblNewLabel_1.setBounds(0, 0, 671, 457);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1);
	}
}
