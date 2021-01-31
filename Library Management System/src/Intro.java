import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Intro {

	private JFrame frame;	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro window = new Intro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public Intro() throws InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize() throws InterruptedException {
		frame = new JFrame();
		frame.setBounds(50, 50, 1290, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ayush Ghosal\\Downloads\\spirit library.gif"));
		lblNewLabel.setLabelFor(frame.getContentPane());
		lblNewLabel.setBounds(0, 0, 1280, 749);
		frame.getContentPane().add(lblNewLabel);
		Timer timer = new Timer();
		timer.schedule(new frameCall(), 13000);
		
	}
	
	class frameCall extends TimerTask
	{
		@Override
		public void run() {
			new Library_Main_Page().frame.setVisible(true);
			frame.dispose();
		}
	}
}
