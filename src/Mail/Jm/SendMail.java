package Mail.Jm;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.border.TitledBorder;
import java.awt.Window.Type;

public class SendMail {

	private JFrame frmSmtpEmailSender;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_6;
	private JPasswordField passwordField;
	private JTextField smtp_host_name;
	private JTextField smtp_username;
	private JTextField email_file;
	private JPasswordField smtp_password;
	private JLabel lblEmailMessage;
	private JLabel lblEmailSubject;
	private JTextField email_from;
	private JLabel lblEmailBody;
	private JTextField email_subject;
	private JTextField email_from_optional;
	private JScrollBar scrollBar;
	private JScrollPane scrollPane;
	private JButton btnReset;
	private JButton btnExit;
	private JTextArea email_body;
	private JScrollPane scrollPane_1;
	private JButton btnChoose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMail window = new SendMail();
					window.frmSmtpEmailSender.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SendMail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSmtpEmailSender = new JFrame();
		frmSmtpEmailSender.setBackground(new Color(0, 0, 255));
		frmSmtpEmailSender.setType(Type.POPUP);
		frmSmtpEmailSender.getContentPane().setForeground(new Color(0, 0, 0));
		frmSmtpEmailSender.setTitle("SMTP Email Sender");
		frmSmtpEmailSender.getContentPane().setBackground(UIManager.getColor("textHighlight"));
		frmSmtpEmailSender.getContentPane().setLayout(null);
		
		JLabel lblAutomaticEmailSend = new JLabel("SMTP Email Sender");
		lblAutomaticEmailSend.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAutomaticEmailSend.setBounds(240, 11, 243, 37);
		frmSmtpEmailSender.getContentPane().add(lblAutomaticEmailSend);
		
		JLabel lblNewLabel = new JLabel("SMTP Host Name");
		lblNewLabel.setBounds(28, 107, 110, 14);
		frmSmtpEmailSender.getContentPane().add(lblNewLabel);
		
		
		
		lblNewLabel_1 = new JLabel("SMTP Username");
		lblNewLabel_1.setBounds(28, 146, 110, 14);
		frmSmtpEmailSender.getContentPane().add(lblNewLabel_1);
		
		
		lblNewLabel_2 = new JLabel("Email File");
		lblNewLabel_2.setBounds(28, 189, 110, 14);
		frmSmtpEmailSender.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("SMTP Password");
		lblNewLabel_4.setBounds(381, 146, 97, 14);
		frmSmtpEmailSender.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("Autentication");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(306, 59, 89, 20);
		frmSmtpEmailSender.getContentPane().add(lblNewLabel_6);
		
		smtp_host_name = new JTextField();
		smtp_host_name.setBounds(171, 103, 171, 23);
		frmSmtpEmailSender.getContentPane().add(smtp_host_name);
		smtp_host_name.setColumns(10);
		
		smtp_username = new JTextField();
		smtp_username.setBounds(171, 143, 171, 23);
		frmSmtpEmailSender.getContentPane().add(smtp_username);
		smtp_username.setColumns(10);
		
		email_file = new JTextField();
		email_file.setEditable(false);
		email_file.setBounds(171, 186, 313, 23);
		frmSmtpEmailSender.getContentPane().add(email_file);
		email_file.setColumns(10);
		
		smtp_password = new JPasswordField();
		smtp_password.setBounds(488, 143, 153, 23);
		frmSmtpEmailSender.getContentPane().add(smtp_password);
		
		lblEmailMessage = new JLabel("Email Content");
		lblEmailMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmailMessage.setBounds(306, 230, 135, 20);
		frmSmtpEmailSender.getContentPane().add(lblEmailMessage);
		
		lblEmailSubject = new JLabel("Email Subject");
		lblEmailSubject.setBounds(28, 320, 110, 14);
		frmSmtpEmailSender.getContentPane().add(lblEmailSubject);
		
		email_from = new JTextField();
		email_from.setBounds(164, 282, 214, 23);
		frmSmtpEmailSender.getContentPane().add(email_from);
		email_from.setColumns(10);
		
		lblEmailBody = new JLabel("Email Body");
		lblEmailBody.setBounds(28, 357, 81, 14);
		frmSmtpEmailSender.getContentPane().add(lblEmailBody);
		
		JLabel lblEmailFrom = new JLabel("Email From");
		lblEmailFrom.setBounds(28, 285, 110, 14);
		frmSmtpEmailSender.getContentPane().add(lblEmailFrom);
		
		email_subject = new JTextField();
		email_subject.setColumns(10);
		email_subject.setBounds(164, 317, 477, 23);
		frmSmtpEmailSender.getContentPane().add(email_subject);
		
		email_from_optional = new JTextField();
		email_from_optional.setToolTipText("Email Address Optional name");
		email_from_optional.setColumns(10);
		email_from_optional.setBounds(427, 282, 214, 23);
		frmSmtpEmailSender.getContentPane().add(email_from_optional);
		
		
		
		JButton btnOk = new JButton("Send");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String host = smtp_host_name.getText();
				String username = smtp_username.getText();
				String password = smtp_password.getText();
				String file = email_file.getText();
				String emailFrom = email_from.getText();
				String emailFromOptional = email_from_optional.getText();
				String emailSubject = email_subject.getText();
				String emailBody = email_body.getText();
				
				if (host.isEmpty() || username.isEmpty() || password.isEmpty() || file.isEmpty() || emailFrom.isEmpty() || emailFromOptional.isEmpty() || emailSubject.isEmpty() ||emailBody.isEmpty()) {
					JOptionPane.showMessageDialog(frmSmtpEmailSender, "Please Fill Up all Field Correctly");
				}else {
					frmSmtpEmailSender.dispose();
					try {
						SendingResult.Send(host, username, password, file, emailFrom, emailFromOptional, emailSubject, emailBody);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnOk.setBounds(330, 486, 97, 30);
		frmSmtpEmailSender.getContentPane().add(btnOk);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 261, 674, 2);
		frmSmtpEmailSender.getContentPane().add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(10, 90, 674, 6);
		frmSmtpEmailSender.getContentPane().add(separator_2);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(98, 486, 97, 30);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				smtp_host_name.setText(null);
				smtp_password.setText(null);
				smtp_username.setText(null);
				email_file.setText(null);
				email_from.setText(null);
				email_from_optional.setText(null);
				email_subject.setText(null);
				email_body.setText(null);
			}
		});
		frmSmtpEmailSender.getContentPane().add(btnReset);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(UIManager.getColor("ToolBar.dockingBackground"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(538, 486, 89, 30);
		frmSmtpEmailSender.getContentPane().add(btnExit);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 357, 477, 93);
		frmSmtpEmailSender.getContentPane().add(scrollPane_1);
		
		email_body = new JTextArea();
		scrollPane_1.setViewportView(email_body);
		
		btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				String filename = file.getAbsolutePath();
				email_file.setText(filename);
			}
		});
		btnChoose.setBounds(538, 181, 89, 30);
		frmSmtpEmailSender.getContentPane().add(btnChoose);
		
		
		frmSmtpEmailSender.setBounds(300, 100, 700, 580);
		frmSmtpEmailSender.setResizable(false);
		frmSmtpEmailSender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
