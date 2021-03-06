package oldFiles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import eg.edu.alexu.csd.datastructure.mailServer.FolderManagerBIN;

public class LoginGUI extends JFrame{
	
	GridBagConstraints gc;
	JLabel emailLabel, passwordLabel;
	JLabel emailErrorMessage, passwordErrorMessage;
	JTextField emailField, passwordField;
	JButton btn;
	
	
	public LoginGUI() {
		super("Log In");
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		//Creating the Components
		emailLabel = new JLabel("Email : ");
		passwordLabel = new JLabel("Password : ");
		
		emailErrorMessage = new JLabel("");
		passwordErrorMessage = new JLabel("");
		
		emailField = new JTextField(25);
		passwordField = new JTextField(25);
		btn = new JButton("Login");
				
		
		
		//Border
		Border outsideBorder = BorderFactory.createEmptyBorder(40, 25, 50, 25);
		Border insideBorder = BorderFactory.createTitledBorder("Login");
		getRootPane().setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		
		
		//Layout Manager
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		
		//Adding the Components into the cells
		////////////////////  FIRST ROW  //////////////////////////////
		setGridCell(0,0);
		gc.anchor = GridBagConstraints.LINE_END;
		add(emailLabel, gc);
		
		setGridCell(1,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(emailField, gc);
		
		setGridCell(2,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(emailErrorMessage, gc);
		
		
		////////////////////  SECOND ROW  //////////////////////////////
		setGridCell(0,1);
		gc.anchor = GridBagConstraints.LINE_END;
		add(passwordLabel, gc);
		
		setGridCell(1,1);
		gc.anchor = GridBagConstraints.LINE_START;
		add(passwordField, gc);
		
		setGridCell(2,1);
		gc.anchor = GridBagConstraints.LINE_START;
		add(passwordErrorMessage, gc);
		
		//////////////////// THIRD ROW  //////////////////////////////
		setGridCell(0,2);
		
		gc.gridwidth = 2;
		// ^ This means that the cell (0,2) , will have a width of two cells
		gc.anchor = GridBagConstraints.CENTER;
		add(btn, gc);
		
 
		
		 
		
		//Listeners
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email, password;
				email = emailField.getText();
				password = passwordField.getText();
				
				//TODO CHECK EMAIL FORMAT
				if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
					emailErrorMessage.setText("Please enter a valid email address");
					return;
				}
				else 
					emailErrorMessage.setText("");
				
				if (password.contentEquals("")) {
					passwordErrorMessage.setText("Please enter a password");
					return;
				}
				else 
					passwordErrorMessage.setText("");
				
				FolderManagerBIN.printUsers();
			}});
	}
	
	
	public void setGridCell(int x, int y) {
		gc.gridx = x;
		gc.gridy = y;
	}
	
	public static void Run() {
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				new LoginGUI();
			}
		});
	}
}
