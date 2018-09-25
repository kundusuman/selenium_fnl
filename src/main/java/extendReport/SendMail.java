package extendReport;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.PasswordAuthentication;

public class SendMail 
{
	public static void main(String message1[])
	{
		System.out.println(TestSendMail.sendMain("suman","auto","sumankundudecember@gmail.com","C:\\Users\\M1047073\\eclipse-workspace\\suman\\test-output\\ExtendReport08_22_2018_14_06_11_116.html"));		
		
		
		
		
		
	}
	
	
}
