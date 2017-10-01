package Mail.Jm;



import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import java.util.Properties;

public class AuthMail {


   public String Send(String SMTP_HOST_NAME, String username, String password, String tomailid, String reqpass,
		   String emailFrom, String emailFromOptional, String emailSubject, String emailBody
		   ) throws Exception {

       Properties props = new Properties();
       props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.host", SMTP_HOST_NAME);
       props.put("mail.smtp.auth", "true");
       
       //Date today = Calendar.getInstance().getTime();
       //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
       //String folderName = formatter.format(today);
       
       final String SMTP_AUTH_USER = username;
       final String SMTP_AUTH_PWD = password;
       Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
           }
       });
       
       //mailSession.setDebug(true);
       Transport transport = mailSession.getTransport();

       MimeMessage message = new MimeMessage(mailSession);
       message.setSubject(emailSubject);
       message.setContent(emailBody, "text/plain");
       message.setFrom(new InternetAddress(emailFrom, emailFromOptional));
       message.addRecipient(Message.RecipientType.TO,
               new InternetAddress(tomailid));
       //message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(ccmailid));

       transport.connect();
       transport.sendMessage(message,
       message.getRecipients(Message.RecipientType.TO));
       transport.close();
       if (mailSession.equals(false)) {
    	   String value = tomailid+" - Not done";
    	   return value;
       } else{
    	   String value = tomailid+" - Done";
    	   return value;
       }
   }

}
