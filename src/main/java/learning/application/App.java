package learning.application;

import learning.email.Email;

public class App {

	public static void main(String[] args) {
		String to = "studying.online@outlook.com";
		String title = "Learning JavaMail";
		String msg = "Eu ficarei muito feliz se isto estiver a funcionar.";
		
		Email.emailSending(to, title, msg);
	}

	
}
