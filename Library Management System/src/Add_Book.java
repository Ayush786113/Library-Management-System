import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Component;

import javax.swing.JPopupMenu;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Add_Book {

	public JFrame frmSpiritLibrary;
	private JTextField bkname;
	private JTextField authname;
	private JTextField isbnnum;
	private String bookname, authorname, isbn, category;
	private LinkedList<String> genre;

	/**
	 * Create the application.
	 */
	public Add_Book() {
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpiritLibrary = new JFrame();
		frmSpiritLibrary.setTitle("Spirit Library - Add Book");
		frmSpiritLibrary.setBounds(100, 100, 687, 496);
		frmSpiritLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpiritLibrary.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name of the Book");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 150, 37);
		frmSpiritLibrary.getContentPane().add(lblNewLabel);
		
		bkname = new JTextField();
		lblNewLabel.setLabelFor(bkname);
		bkname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bkname.setBounds(204, 11, 445, 37);
		frmSpiritLibrary.getContentPane().add(bkname);
		bkname.setColumns(10);
		
		JLabel lblAuthorOfThe = new JLabel("Author of the Book");
		lblAuthorOfThe.setForeground(Color.WHITE);
		lblAuthorOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAuthorOfThe.setBounds(10, 84, 150, 37);
		frmSpiritLibrary.getContentPane().add(lblAuthorOfThe);
		
		JLabel lblIsbnOfThe = new JLabel("ISBN of the Book");
		lblIsbnOfThe.setForeground(Color.WHITE);
		lblIsbnOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIsbnOfThe.setBounds(10, 159, 150, 37);
		frmSpiritLibrary.getContentPane().add(lblIsbnOfThe);
		
		JLabel lblCategoryOfThe = new JLabel("Category of the Book");
		lblCategoryOfThe.setForeground(Color.WHITE);
		lblCategoryOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCategoryOfThe.setBounds(10, 238, 175, 37);
		frmSpiritLibrary.getContentPane().add(lblCategoryOfThe);
		
		authname = new JTextField();
		lblAuthorOfThe.setLabelFor(authname);
		authname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		authname.setColumns(10);
		authname.setBounds(204, 84, 445, 37);
		frmSpiritLibrary.getContentPane().add(authname);
		
		isbnnum = new JTextField();
		lblIsbnOfThe.setLabelFor(isbnnum);
		isbnnum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		isbnnum.setColumns(10);
		isbnnum.setBounds(204, 159, 445, 37);
		frmSpiritLibrary.getContentPane().add(isbnnum);
		
		JComboBox<String> bkcategory = new JComboBox<String>();
		lblCategoryOfThe.setLabelFor(bkcategory);
		for(String word : categorylist())
		{
			bkcategory.addItem(word);
		}
		bkcategory.setBounds(204, 240, 445, 37);
		frmSpiritLibrary.getContentPane().add(bkcategory);
		
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Library_Main_Page().frame.setVisible(true);
				frmSpiritLibrary.dispose();
			}
		});
		back.setBounds(560, 374, 89, 23);
		frmSpiritLibrary.getContentPane().add(back);
		
		JButton addtodatabase = new JButton("Add to Database");
		addtodatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 bookname = bkname.getText().toString();
				 authorname = authname.getText().toString();
				 isbn = isbnnum.getText().toString();
				 category = bkcategory.getSelectedItem().toString();
				 String confirm;
				try {
					confirm = new Database().insertBooks(bookname,  authorname,  isbn, category);
					JOptionPane.showMessageDialog(frmSpiritLibrary, confirm);
				} catch (SQLException | ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(frmSpiritLibrary, "Contact The Developer");
				}
			}
		});
		addtodatabase.setBounds(387, 374, 134, 23);
		frmSpiritLibrary.getContentPane().add(addtodatabase);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bkname.setText("");
				authname.setText("");
				isbnnum.setText("");
			}
		});
		reset.setBounds(242, 374, 89, 23);
		frmSpiritLibrary.getContentPane().add(reset);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\learning-3245793_1920.jpg"));
		lblNewLabel_1.setLabelFor(frmSpiritLibrary.getContentPane());
		lblNewLabel_1.setBounds(0, 0, 671, 457);
		frmSpiritLibrary.getContentPane().add(lblNewLabel_1);
	}
	
	LinkedList<String> categorylist()
	{
		genre = new LinkedList<>();
		String series = "Action_and_adventure\r\n"
				+ ""
				+ "Art/Architecture\r\n"
				+ ""
				+ "Alternate_History\r\n"
				+ "	"
				+ ""
				+ "Autobiography\r\n"
				+ ""
				+ "Anthology\r\n"
				+ "	"
				+ ""
				+ "Biography\r\n"
				+ ""
				+ "Chick_lit\r\n"
				+ "	"
				+ ""
				+ "Business/Economics\r\n"
				+ ""
				+ "Children's_Crafts/Hobbies\r\n"
				+ "	"
				+ ""
				+ ""
				+ ""
				+ "Classics\r\n"
				+ "	"
				+ ""
				+ "Cookbook\r\n"
				+ ""
				+ "Comic_Book\r\n"
				+ "	"
				+ ""
				+ "Diary\r\n"
				+ ""
				+ "Coming-of-age\r\n"
				+ "	"
				+ ""
				+ "Dictionary\r\n"
				+ ""
				+ "Crime\r\n"
				+ "	"
				+ ""
				+ "Encyclopedia\r\n"
				+ ""
				+ "Drama\r\n"
				+ "	"
				+ ""
				+ "Guide\r\n"
				+ ""
				+ "Fairytale\r\n"
				+ "	"
				+ ""
				+ "Health/Fitness\r\n"
				+ ""
				+ "Fantasy\r\n"
				+ "	"
				+ ""
				+ "History\r\n"
				+ ""
				+ "Graphic_Novel\r\n"
				+ "	"
				+ ""
				+ "Home_and_Garden\r\n"
				+ ""
				+ "Historical_Fiction\r\n"
				+ "	"
				+ ""
				+ "Humor\r\n"
				+ ""
				+ "Horror\r\n"
				+ "	"
				+ ""
				+ "Journal\r\n"
				+ ""
				+ "Mystery\r\n"
				+ "	"
				+ ""
				+ "Mathematics\r\n"
				+ ""
				+ "Paranormal_Romance\r\n"
				+ "	"
				+ ""
				+ "Memoir\r\n"
				+ ""
				+ "Picture_Book\r\n"
				+ "	"
				+ ""
				+ "Philosophy\r\n"
				+ ""
				+ "Poetry\r\n"
				+ "	"
				+ ""
				+ "Prayer\r\n"
				+ ""
				+ "Political_Thriller\r\n"
				+ "	"
				+ ""
				+ "Religion_Spirituality_and_New_Age\r\n"
				+ ""
				+ "Romance\r\n"
				+ "	"
				+ ""
				+ "Textbook\r\n"
				+ ""
				+ "Satire\r\n"
				+ "	"
				+ ""
				+ "True_Crime\r\n"
				+ ""
				+ "Science_Fiction\r\n"
				+ "	"
				+ ""
				+ "Review\r\n"
				+ ""
				+ "Short Story\r\n"
				+ "	"
				+ ""
				+ "Science\r\n"
				+ ""
				+ "Suspense\r\n"
				+ "	"
				+ ""
				+ "Self_Help\r\n"
				+ ""
				+ "Thriller\r\n"
				+ "	"
				+ ""
				+ "Sports_and_Leisure\r\n"
				+ ""
				+ "Western\r\n"
				+ "	"
				+ ""
				+ "Travel\r\n"
				+ ""
				+ "Young_Adult\r\n"
				+ "	";
		StringTokenizer st = new StringTokenizer(series);
		while(st.hasMoreTokens())
		{
			genre.add(st.nextToken());
		}
		Collections.sort(genre);
		genre.addFirst("Select Genre");
		return genre;
	}
}
