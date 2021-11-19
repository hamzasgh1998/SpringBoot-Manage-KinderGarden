package tn.esprit.spring;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import tn.esprit.spring.service.UserService;



@ComponentScan

@EnableWebMvc
@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class Pi4SaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pi4SaeApplication.class, args);
		
	}
	
	/*@Autowired
	private UserService us;
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException
	{
		//us.sendSimpleEmail("ameni.merhben@esprit.tn", "aa", "aa");
		us.sendEmailWithAttachement("", "test", "test", "C:\\Users\\DELL\\Pictures\\IMG_E7268.JPG");
		//C:\Users\DELL\Pictures
	}*/
	

}
