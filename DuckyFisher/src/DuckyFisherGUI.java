import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class DuckyFisherGUI {
	String location = null;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DuckyFisherGUI window = new DuckyFisherGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	

	/**
	 * Create the application.
	 */
	public DuckyFisherGUI() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JRadioButton rdbtnDraynor = new JRadioButton("Draynor");
		JRadioButton rdbtnLumbridge = new JRadioButton("Lumbridge");
		/**
		 * Start Button
		 */
		JButton btnStartScript = new JButton("Start Script");
		btnStartScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Global.scriptStarted = true;
				if (rdbtnLumbridge.isSelected()) {
					Global.currentLocation = Global.Location.LUMBRIDGE;
				}
				if (rdbtnDraynor.isSelected()) {
					Global.currentLocation = Global.Location.DRAYNOR;
				}
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		
		
		btnStartScript.setForeground(Color.BLACK);
		btnStartScript.setBounds(118, 183, 218, 57);
		frame.getContentPane().add(btnStartScript);
		
		JLabel lblWelcomeToDucky = new JLabel("Welcome to Ducky Fisher v 1.0");
		lblWelcomeToDucky.setBackground(Color.GRAY);
		lblWelcomeToDucky.setBounds(130, 23, 194, 57);
		frame.getContentPane().add(lblWelcomeToDucky);
		
		
		
		/**
		 * Lumbridge Button
		 */
		rdbtnLumbridge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDraynor.setSelected(false);
			}
		});
		rdbtnLumbridge.setSelected(true);
		rdbtnLumbridge.setBounds(166, 92, 141, 23);
		frame.getContentPane().add(rdbtnLumbridge);
		
		/**
		 * Draynor Button
		 */
		
		
		rdbtnDraynor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLumbridge.setSelected(false);
			}
		});
		rdbtnDraynor.setBounds(166, 127, 141, 23);
		frame.getContentPane().add(rdbtnDraynor);
	}
	
	public void Locaiton(String location) {
			
		}
	}

