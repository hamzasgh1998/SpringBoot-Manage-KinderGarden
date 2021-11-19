package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationRecService {

	private JavaMailSender JavaMailSender;
	
	@Autowired
	public NotificationRecService(JavaMailSender javaMailSender){
		this.JavaMailSender=javaMailSender;
	}
	
	public void sendNotification(String email) throws MailException
	{
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom("yassmine.fekih15@gmail.com");
		mail.setSubject("Complaint");
		mail.setText("Your complaint has been well received.We will contact you for more details!");
		
		JavaMailSender.send(mail);
	}
}
