package thirdparty;
import java.util.Properties;  
  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.mail.internet.MimeMessage;  
  
public class Mailverification {  
public static void send(String to,String subject,String msg, boolean isHtml){  
	final String user="blood.bank.automate@gmail.com"; 
	final String pass="jumy xfet vtum hhqu";  
  
		//Get the session object    
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtps.quitwait","false");

  
	Session session = Session.getDefaultInstance(props,  
	new javax.mail.Authenticator() {  
	protected PasswordAuthentication getPasswordAuthentication() {  
	return new PasswordAuthentication(user,pass);  
		}  
	});  
	//compose message  
		try {  
		 MimeMessage message = new MimeMessage(session);  
		 message.setFrom(new InternetAddress(user));  
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		 message.setSubject(subject);  
		 if (isHtml) {
		     message.setContent(msg, "text/html");
		 } else {
		     message.setText(msg);
		 } 
		   
		 //3rd step)send message  
		 Transport.send(message);  
		  
		 //System.out.println("Done");  
		  
		 } catch (MessagingException e) {  
		    throw new RuntimeException(e);  
		 }  
      
  	}  
}  