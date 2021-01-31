import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.Box;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Library_Main_Page {

	public JFrame frame;



	/**
	 * Create the application.
	 */
	public Library_Main_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Spirit Library");
		frame.setBounds(100, 100, 622, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add_Book().frmSpiritLibrary.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(155, 214, 112, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Member");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add_Member().frmSpiritLibrary.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(354, 214, 127, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Book or Member Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Details().frmSpiritLibrary.setVisible(true);
					frame.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Contact The Developer");
				}
				
			}
		});
		btnNewButton_2.setBounds(178, 142, 279, 47);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lend Book");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Lend_Book().frmSpiritLibrary.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Contact The Developer");
				}
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(155, 281, 112, 47);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Return Book");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Return_Book().frmSpiritLibrary.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Contact The Developer");
				}
				frame.dispose();
			}
		});
		btnNewButton_4.setBounds(360, 281, 121, 47);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel.setLabelFor(frame.getContentPane());
		lblNewLabel.setBounds(0, 0, 606, 444);
		frame.getContentPane().add(lblNewLabel);
	}
}
