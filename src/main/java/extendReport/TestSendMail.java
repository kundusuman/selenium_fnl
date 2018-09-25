package extendReport;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Suman Kundu
 * @Purpose Send Mail Using Gmail smtp server
 * @Date 22/8/2018
 *
 */
public class TestSendMail {
	
	public static void main(String args[])
	{
//creating a property file contains all key and value for gmail smtp server
		Properties props=new Properties();
		props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
//Starting Session 	
		Session session=Session.getDefaultInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
					return new PasswordAuthentication("suman.kundu2@mindtree.com","1ee47ca741@!#");
			}
		}
		);
		try
		{
			//Creating Mime message
				MimeMessage message=new MimeMessage(session);
				message.setFrom(new InternetAddress("suman.kundu2@mindtree.com"));
				message.setRecipient(Message.RecipientType.TO,new InternetAddress("suman.kundu2@mindtree.com"));
				message.setSubject("This message is sent from:- " );
				message.setText("Subject:-" );
			//	message.setFileName(fileAddr);
				Transport.send(message);
				
				
				System.out.println("success");
		
		}
		catch(Exception e)
		{
			System.out.println("failure");
			e.printStackTrace();
		}
	}
	}