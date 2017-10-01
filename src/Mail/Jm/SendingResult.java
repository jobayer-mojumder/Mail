package Mail.Jm;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class SendingResult {

	private JFrame frmSendingEmail;
	private static JTextArea outputText = new JTextArea();
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendingResult window = new SendingResult();
					window.frmSendingEmail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SendingResult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSendingEmail = new JFrame();
		frmSendingEmail.getContentPane().setBackground(UIManager.getColor("textHighlight"));
		frmSendingEmail.setTitle("Sending Email");
		frmSendingEmail.setBounds(300, 100, 610, 445);
		frmSendingEmail.setResizable(false);
		frmSendingEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSendingEmail.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 409, 385);
		frmSendingEmail.getContentPane().add(scrollPane);
		outputText.setBackground(SystemColor.desktop);
		outputText.setEditable(false);
		outputText.setText("Sending email...\n\n");
		outputText.setForeground(new Color(0, 128, 0));
		outputText.setFont(new Font("Monospaced", Font.PLAIN, 13));
		
		scrollPane.setViewportView(outputText);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(450, 80, 101, 37);
		frmSendingEmail.getContentPane().add(btnExit);
		
		JLabel lbljobayerMojumder = new JLabel("Jobayer.pro@gmail.com");
		lbljobayerMojumder.setBounds(429, 382, 155, 14);
		frmSendingEmail.getContentPane().add(lbljobayerMojumder);
		
		JLabel lblContactUs = new JLabel("Contact us:");
		lblContactUs.setBounds(429, 357, 71, 14);
		frmSendingEmail.getContentPane().add(lblContactUs);
		
	}
	
	public static void Send( String host, String username, String password, String file, String emailFrom, String emailFromOptional, String emailSubject, String emailBody) throws Exception{
		
		main(null);
		String csvFile = file;
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] mailid = line.split(cvsSplitBy);

				//System.out.println("Email : " + mailid[0]);
				AuthMail AuthMail = new AuthMail();

				String result = AuthMail.Send(host, username, password, mailid[0], "", emailFrom, emailFromOptional, emailSubject, emailBody);
				appendNewText(result+'\n');
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void appendNewText(final String txt) {
		  SwingUtilities.invokeLater(new Runnable() {
		     public void run() {
		        outputText.setText(outputText.getText() + txt);
		       //outputText.setText(outputText.getText + "\n"+ txt); Windows LineSeparator
		     }
		  });
		}
}
