import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Details {

	public JFrame frmSpiritLibrary;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JLabel lblBooks;
	private JLabel lblNewLabel_1;
	
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Details() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmSpiritLibrary = new JFrame();
		frmSpiritLibrary.setTitle("Spirit Library - Details");
		frmSpiritLibrary.setBounds(100, 100, 676, 484);
		frmSpiritLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpiritLibrary.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 640, 175);
		frmSpiritLibrary.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Library_Main_Page().frame.setVisible(true);
				frmSpiritLibrary.dispose();
			}
		});
		btnNewButton.setBounds(561, 411, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 236, 640, 164);
		frmSpiritLibrary.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		Database database = new Database();
		database.readData(table, "Books");
		database.readData(table_1, "Members");
		
		lblNewLabel = new JLabel("Members");
		lblNewLabel.setLabelFor(scrollPane_1);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 215, 82, 23);
		frmSpiritLibrary.getContentPane().add(lblNewLabel);
		
		lblBooks = new JLabel("Books");
		lblBooks.setLabelFor(scrollPane);
		lblBooks.setForeground(Color.WHITE);
		lblBooks.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBooks.setBounds(10, 11, 63, 23);
		frmSpiritLibrary.getContentPane().add(lblBooks);
		
		JButton btnNewButton_1 = new JButton("Borrow Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Borrow_Details().frmSpiritLibrary.setVisible(true);
					frmSpiritLibrary.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
		btnNewButton_1.setBounds(353, 411, 143, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel_1.setLabelFor(frmSpiritLibrary.getContentPane());
		lblNewLabel_1.setBounds(0, 0, 660, 445);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1);
	}
}
