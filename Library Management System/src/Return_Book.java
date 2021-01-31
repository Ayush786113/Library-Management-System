import java.awt.EventQueue;
import java.time.*;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Return_Book {

	public JFrame frmSpiritLibrary;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Return_Book() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmSpiritLibrary = new JFrame();
		frmSpiritLibrary.setTitle("Spirit Library - Return Book");
		frmSpiritLibrary.setBounds(100, 100, 680, 491);
		frmSpiritLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpiritLibrary.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 25, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Return Date");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(27, 119, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Return and Update");
		btnNewButton.setBounds(441, 357, 143, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book Details");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(27, 72, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox rtbook = new JComboBox();
		lblNewLabel_1_2.setLabelFor(rtbook);
		for(String book : new Database().booklist())
		{
			rtbook.addItem(book);
		}
		rtbook.setBounds(262, 75, 322, 34);
		frmSpiritLibrary.getContentPane().add(rtbook);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Late Fees");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(27, 166, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("-");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(262, 163, 322, 47);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpiritLibrary.dispose();
				new Library_Main_Page().frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(27, 357, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Calculate");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(new LateFees().calculatedays());
			}
		});
		btnNewButton_2.setBounds(262, 357, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_2);
		
		JComboBox rtname = new JComboBox();
		for(String member : new Database().updateMemberlist())
		{
			rtname.addItem(member);
		}
		rtname.setBounds(262, 34, 322, 27);
		frmSpiritLibrary.getContentPane().add(rtname);
		
		String currentDate = LocalDate.now().toString();
		
		JLabel returndate = new JLabel("");
		returndate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		returndate.setForeground(Color.WHITE);
		returndate.setBounds(262, 128, 322, 36);
		frmSpiritLibrary.getContentPane().add(returndate);
		returndate.setText(currentDate);
		
		new LateFees().setReturndate(currentDate);
		
		btnNewButton_2.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel_1.setLabelFor(frmSpiritLibrary.getContentPane());
		lblNewLabel_1.setBounds(0, 0, 664, 452);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Database().deleteData(rtbook.getSelectedItem().toString(), rtname.getSelectedItem().toString());
					new Database().returnbook(rtbook.getSelectedItem().toString());
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Database Updated");
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
	}
}
