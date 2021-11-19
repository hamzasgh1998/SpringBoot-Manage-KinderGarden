package tn.esprit.spring.service;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkprograms.speech.translator.GoogleTranslate;


import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.Posts;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.PostsRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.CommentsRepository;


@Service
public class PostsServiceImpl implements PostsService {
	
	@Autowired
	PostsRepository PostsRepository; 
	@Autowired
	CommentsRepository CommentsRepository; 
	@Autowired
	UserRepository UserRepository;
	
	
	

	@Override
	public List<Posts> retrieveAllPosts() {
		
		return (List<Posts>) PostsRepository.findAll();
	}

	@Override
	public Posts addPosts(Posts p) {
		
		
		 
		 return PostsRepository.save(p);
	}

	@Override
	public void deletePosts(Long id) {
		PostsRepository.deleteById(id);
		
	}

	@Override
	public Posts updatePosts(Posts u) {
		
		return PostsRepository.save(u);
	}

	@Override
	public Posts retrievePosts(Long id) {
		
		return PostsRepository.findById(id).get();
	}

	@Override
	public void affecterCommentsAPost(Long IdComment, Long IdPost) {
		Posts PostEntity = PostsRepository.findById(IdPost).get();
		Comments CommentsEntity =CommentsRepository.findById(IdComment).get();
		CommentsEntity.setPosts(PostEntity);
		CommentsRepository.save(CommentsEntity);
		
	}

	@Override
	public int CountLikesParPosts(Long IdPost) {
		return PostsRepository.CountLikesParPosts(IdPost);
	}

	@Override
	public int CountDisLikesParPosts(Long IdPost) {
		return PostsRepository.CountDisLikesParPosts(IdPost);

	}

	

	@Override
	public int addLike(Long IdPost) {
		
		return PostsRepository.addlike(IdPost);
		
		
	}

	@Override
	public void addDislike(Long IdPost) {
		PostsRepository.addDislike(IdPost);
		
	}

	@Override
	public void dropDislike(Long IdPost) {
		
		PostsRepository.dropDislike(IdPost);
	}

	@Override
	public void dropLike(Long IdPost) {
		
		PostsRepository.droplike(IdPost);
		
	}

	@Override
	public void addSignal(Long IdPost) {
		PostsRepository.addSignal(IdPost);
		
	}

	@Override
	public boolean deleteSignaledPost(Long IdPost) {
		if (PostsRepository.findById(IdPost).get().getNbrSignal()>2)
		{
			PostsRepository.deleteById(IdPost);
			return true;
		}
		return false;
	}

	@Override
	public String TranslatePostDesc(Long IdPost) {
		String ToTranslate=PostsRepository.findById(IdPost).get().getDescription();
		String S="";
		try {
			 S=GoogleTranslate.translate("en",ToTranslate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return " traduction:  "+S;
	}

	@Override
	public String notifyUser() throws AWTException  {
		
		
		return null;	 
            // td.displayTray();
        
		
		
		
	}

	@Override
	public void addphoto(long idpost,String img) {
		PostsRepository.addPhoto(idpost,img);
		
	}

	@Override
	public boolean Sendmail(long userid) {
		
		final String username = "itskindergarten1@gmail.com";
		final String password = "ilovejava";
		String fromEmail = "ADMINSTARTION";
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
			msg.setSubject("Alerte Signal");
			msg.setText("your Post have been removed due reports from other clients please contact administrator ");
			
			
			
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
	public Posts addPosts2(Posts p,String img) {
		PostsRepository.save(p);
		PostsRepository.addPhoto(p.getIdPost(), img);
		 
		 return p;
	}

	@Override
	public Boolean BadWordsFilter(long idpost) {
		
		
		
		Boolean found=false;
		List<String> list1 = new ArrayList<String>();
		list1.add("test1"); list1.add("test2"); list1.add("test3");list1.add("test4");list1.add("test5");list1.add("test5");list1.add("test6");list1.add("test7");list1.add("test8");list1.add("test9");
		String Desc=PostsRepository.findById(idpost).get().getDescription();
		
		
		 for(int i=0; i<list1.size(); i++)
	     {
	    	  System.out.println(list1.get(i).toUpperCase());
		if( found = Arrays.asList(Desc.toUpperCase().split(" ")).contains(list1.get(i).toUpperCase()))
		 {break;}
	     }
		if(found){
		      System.out.println("bad words detected");
		      return true;
		}
		else
			System.out.println("not found");
		
		return false;
	}

	
	
	@Override
	public Long addOrUpdatePosts(Posts Post,User u) {
	
		Post.setParent(u);
		PostsRepository.save(Post);
		return Post.getIdPost();
	}
	
	@Override
	public Long addOrUpdatePostsAdmin(Posts Post, User u) {

		Post.setKinderGartenAdmin(u);
		PostsRepository.save(Post);
		return Post.getIdPost();
	}

	@Override
	public List<Posts> Reacts() {
		return (List<Posts>) PostsRepository.Reacts();
	}

	
	
	
	
	

}
