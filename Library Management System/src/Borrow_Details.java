import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Borrow_Details {

	public JFrame frmSpiritLibrary;
	private JTable table;


	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Borrow_Details() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmSpiritLibrary = new JFrame();
		frmSpiritLibrary.setTitle("Spirit Library - Borrowed Books Details");
		frmSpiritLibrary.setBounds(100, 100, 687, 467);
		frmSpiritLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpiritLibrary.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 22, 610, 361);
		frmSpiritLibrary.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		new Database().readData(table, "LendTable");
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Details().frmSpiritLibrary.setVisible(true);
					frmSpiritLibrary.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
		btnNewButton.setBounds(519, 394, 89, 23);
		frmSpiritLibrary.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel.setLabelFor(frmSpiritLibrary.getContentPane());
		lblNewLabel.setBounds(0, -3, 671, 431);
		frmSpiritLibrary.getContentPane().add(lblNewLabel);
	}
}
