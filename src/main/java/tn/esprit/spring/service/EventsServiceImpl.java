package tn.esprit.spring.service;

import java.util.List;
import java.util.Properties;
import java.util.function.DoubleConsumer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Color;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.awt.Color;
import java.io.FileNotFoundException;
import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.hibernate.annotations.Parent;
import org.primefaces.model.diagram.endpoint.ImageEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EventsRepository;
import 	tn.esprit.spring.repository.UserRepository;

@Service
public class EventsServiceImpl implements EventsService{
	
	@Autowired
	EventsRepository EventsRepository; 
	
	@Autowired
	UserRepository UserRepository; 
	

	@Override
	public List<Events> retrieveAllEvents() {
		return (List<Events>) EventsRepository.findAll();

	}

	@Override
	public Events addEvents(Events u) {
		return EventsRepository.save(u);
	}

	@Override
	public void deleteEvents(Long id) {
		EventsRepository.deleteById(id);		
	}

	@Override
	public Events updateEvents(Events u) {
		return EventsRepository.save(u);

	}

	@Override
	public Events retrieveEvents(Long id) {
		return EventsRepository.findById(id).get();

	}



	@Override
	public List<Events> FindEventsSortedByPriceEvent() {
	return EventsRepository.FindEventsSortedByPriceEvent();
	}

	@Override
	public Long addOrUpdateEvent(Events E) {
		EventsRepository.save(E);
		return E.getIdEvent();
	}

	@Override
	public void addphoto(long idpost, String img) {
		EventsRepository.addPhoto(idpost,img);
		
	}

	@Override
	public boolean Sendmail(long userid) throws DocumentException ,IOException {
		
		
		String filename="C:\\pdf\\db.pdf";
		Document doucment = new Document();
		
		 try {

			PdfWriter.getInstance(doucment, new FileOutputStream(filename));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		
		// Image image = Toolkit.getDefaultToolkit().createImage("image/notif.png");
		 
		 try {
			 doucment.open();
			 Paragraph para=new Paragraph("");
			 PdfPTable table = new PdfPTable(5);
			 Font font = FontFactory.getFont(FontFactory.COURIER_OBLIQUE);
		
			 font.setColor(255,0,0);
			 font.setSize(25);

			 Font font2 = FontFactory.getFont(FontFactory.TIMES_ITALIC);
			 font2.setColor(12,12,12);
		        font2.setSize(15);
		         
		        Paragraph p = new Paragraph("List of Events", font);
		        p.setAlignment(Paragraph.ALIGN_CENTER);
		
		        Image back=Image.getInstance("background.jpg");
		        back.scaleAbsolute(1000f, 1000f);

		        back.setAbsolutePosition(0, 0);

			       doucment.add(back);
		      
		        doucment.add(p);
			 	

	        	
		        
		        
		       
		      
			      

		        
		        
		        for (Events Events : EventsRepository.findAll()) {
		        	 
		        	Paragraph p3 = new Paragraph(""+" - "+"Name Event :"+Events.getNameEvent()+"\n", font2);
		        	   Paragraph p4 = new Paragraph(""+" - "+"Price Event :"+Events.getPriceEvent()+" Dt"+"\n", font2);
		        	   Paragraph p5 = new Paragraph(""+" - "+"Date Event :"+Events.getDateEvent()+"\n", font2);
		        	   Paragraph p6 = new Paragraph(""+" - "+"Capacity Event :"+Events.getCapacityEvent()+"\n", font2);
		        	
		        	   Image image=Image.getInstance(Events.getImage());
		               image.scaleAbsolute(100f, 100f);
		        	   Paragraph p7 = new Paragraph("   - - - - - - -  "+"\n", font2);


				        doucment.add(p3);
				        doucment.add(p4);
				        doucment.add(p5);
				        doucment.add(p6);
		     	        doucment.add(image);
				        doucment.add(p7);




		        }
		        
		        
		        
		        
		        
		        
		        
		        doucment.add(table);
		        
		        
				
		//	doucment.add(para);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 
		 
		 doucment.close();
	

		final String username = "ur email@gmail.com";
		final String password = "password";
		String fromEmail = "JAVA";
		String toEmail=UserRepository.findById(userid).get().getEmail();
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Dear parent, this is our events");
		//	msg.setText(EventsRepository.findAll().toString());
			
			
			
			//Transport.send(msg);
			
			
			Multipart emailContent = new MimeMultipart();

			
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Hope to see you in our events ");
			
			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			try {
				pdfAttachment.attachFile(filename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);

			
			System.out.println("Sent message");
			return true;
		}
		catch (MessagingException e) {
			e.printStackTrace();
		} 
		
		
		return false;
	}

	@Override
	public void UserParticipeEvent(Long IdUser, Long IdEvent) {
Events EventEntity= EventsRepository.findById(IdEvent).get();
EventEntity.setCapacityEvent(EventEntity.getCapacityEvent()-1);
User UserEntity=UserRepository.findById(IdUser).get();
UserEntity.setEvents(EventEntity);
UserRepository.save(UserEntity);
EventsRepository.save(EventEntity);

	}

	@Override
	public int countparticipant(Long IdEvent) {
		return EventsRepository.countparticipant(IdEvent);
	}

	@Override
	public List<Events> FindEventsByNameKinderGarten(String Name) {
		return EventsRepository.FindEventsByNameKinderGarten(Name);
	}
	
	
	
	
	
	
	

	
	

}
