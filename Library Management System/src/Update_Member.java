import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Update_Member {

	public JFrame frmSpiritLibrary;
	private JTextField updtdata;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Update_Member() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmSpiritLibrary = new JFrame();
		frmSpiritLibrary.setTitle("Spirit Library - Update Existing Member");
		frmSpiritLibrary.setBounds(100, 100, 689, 490);
		frmSpiritLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpiritLibrary.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 31, 89, 35);
		frmSpiritLibrary.getContentPane().add(lblNewLabel);
		
		JComboBox updtname = new JComboBox();
		lblNewLabel.setLabelFor(updtname);
		updtname.setBounds(232, 30, 379, 40);
		frmSpiritLibrary.getContentPane().add(updtname);
		for(String name : new Database().updateMemberlist())
		{
			updtname.addItem(name);
		}
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCategory.setBounds(23, 105, 89, 35);
		frmSpiritLibrary.getContentPane().add(lblCategory);
		
		JComboBox updtcategory = new JComboBox();
		lblCategory.setLabelFor(updtcategory);
		updtcategory.setBounds(232, 104, 379, 40);
		frmSpiritLibrary.getContentPane().add(updtcategory);
		updtcategory.addItem("Select Update Category");
		updtcategory.addItem("Age");
		updtcategory.addItem("School");
		updtcategory.addItem("Phone");
		
		JLabel lblUpdate = new JLabel("Update Data");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUpdate.setBounds(23, 190, 115, 35);
		frmSpiritLibrary.getContentPane().add(lblUpdate);
		
		updtdata = new JTextField();
		lblUpdate.setLabelFor(updtdata);
		updtdata.setBounds(232, 183, 379, 42);
		frmSpiritLibrary.getContentPane().add(updtdata);
		updtdata.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = updtname.getSelectedItem().toString();
				String feild = updtcategory.getSelectedItem().toString();
				String data = updtdata.getText();
				try {
					new Database().updateMember(name, feild, data);
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Member Updated Successfully");
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
		btnNewButton.setBounds(522, 306, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add_Member().frmSpiritLibrary.setVisible(true);
				frmSpiritLibrary.dispose();
			}
		});
		btnNewButton_1.setBounds(23, 306, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel_1.setLabelFor(frmSpiritLibrary.getContentPane());
		lblNewLabel_1.setBounds(0, 0, 673, 451);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1);
	}
}
