package learning.email.protocol;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SMTPProperties {
	
	public static Properties loadProperties() {
		Properties properties = new Properties();
		try {
			File file = new File("src/main/java/learning/email/protocol/smtp.properties");
			InputStream is = new FileInputStream(file);
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}

