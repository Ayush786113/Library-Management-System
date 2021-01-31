import java.awt.EventQueue;
import java.time.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Lend_Book {

	public JFrame frmSpiritLibrary;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Lend_Book() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmSpiritLibrary = new JFrame();
		frmSpiritLibrary.setTitle("Spirit Library - Lend Book");
		frmSpiritLibrary.setBounds(100, 100, 680, 491);
		frmSpiritLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpiritLibrary.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrower's Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 25, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lend Date");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(27, 119, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Return Date");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(27, 166, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Lend and Update");
		btnNewButton.setBounds(441, 357, 143, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Borrowed Book Details");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(27, 72, 207, 36);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox brbook = new JComboBox();
		lblNewLabel_1_2.setLabelFor(brbook);
		LinkedList<String> books = new Database().booklist();
		for(String book : books)
		{
			brbook.addItem(book);
		}
		brbook.setBounds(262, 75, 322, 34);
		frmSpiritLibrary.getContentPane().add(brbook);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpiritLibrary.dispose();
				new Library_Main_Page().frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(27, 357, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_1);
		
		JComboBox brname = new JComboBox();
		lblNewLabel.setLabelFor(brname);
		for(String member : new Database().updateMemberlist())
		{
			brname.addItem(member);
		}
		brname.setBounds(262, 34, 322, 27);
		frmSpiritLibrary.getContentPane().add(brname);
		
		JLabel lenddate = new JLabel("");
		lenddate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lenddate.setForeground(Color.WHITE);
		lenddate.setBounds(262, 126, 322, 29);
		frmSpiritLibrary.getContentPane().add(lenddate);
		lenddate.setText(LocalDate.now().toString());
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel_1.setLabelFor(frmSpiritLibrary.getContentPane());
		lblNewLabel_1.setBounds(0, 0, 664, 452);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String book = brbook.getSelectedItem().toString();
				String name = brname.getSelectedItem().toString();
				String lenddatetext = lenddate.getText();
				String returndatetext = "";
				try {
					new Database().create("lending");
					new Database().lenddatabase(book, name, lenddatetext, returndatetext);
					new Database().lendbook(book);
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Databases Updated");
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
	}
}
