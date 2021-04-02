package learning.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import learning.email.protocol.SMTPProperties;

public class Email {

	public static void emailSending(String to, String title, String msg) {
		try {
			Properties properties = SMTPProperties.loadProperties();

			final String username = properties.getProperty("username.credential"),
					password = properties.getProperty("password.credential");

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			session.setDebug(true);

			Address[] toUser = InternetAddress.parse(to);
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(title);
			message.setText(msg);

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
