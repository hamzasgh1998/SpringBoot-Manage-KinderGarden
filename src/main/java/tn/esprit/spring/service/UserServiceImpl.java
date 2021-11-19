package tn.esprit.spring.service;

import java.io.File;
import java.util.Date;
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
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Kid;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.KinderGartenAdmin;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.Posts;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.CommentsRepository;
import tn.esprit.spring.repository.KidRepository;
import tn.esprit.spring.repository.UserRepository;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KidRepository kidRepository; 
	
	
	@Override
	public List<User> retrieveAllUsers() {
	return (List<User>) userRepository.findAll();
	}
	
	@Override
	public User addUser(User u) {
		String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		u.setPassword(encodedString);
		return userRepository.save(u);
	}
	
	
	@Override
	public Parent addParent(Parent u) {
		//u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		u.setPassword(encodedString);
		return userRepository.save(u);
	}
	
	@Override
	public KinderGartenAdmin addKinderGartenAdmin(KinderGartenAdmin u) {
		//u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		u.setPassword(encodedString);
		return userRepository.save(u);
	}
	
	@Override
	public void deleteUser(Long idUser) {
				userRepository.deleteById(idUser);
	}
	
	@Override
	public User updateUser(User u) {
		//u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		u.setPassword(encodedString);
		return userRepository.save(u);
	}
	
	@Override
	public Parent updateParent(Parent u) {
		//u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		u.setPassword(encodedString);
		return userRepository.save(u);
	}
	
	@Override
	public KinderGartenAdmin updateKinderGartenAdmin(KinderGartenAdmin u) {
		//u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		u.setPassword(encodedString);
		return userRepository.save(u);
	}
	
	@Override
	public User retrieveUser(Long idUser) {
		return userRepository.findById(idUser).get();
	}
	
	@Override
	public Parent retrieveParent(Long idUser) {
		return (Parent) userRepository.findById(idUser).get();
	}
	
	@Override
	public KinderGartenAdmin retrieveKinderGartenAdmin(Long idUser) {
		return (KinderGartenAdmin) userRepository.findById(idUser).get();
	}

	
	@Override
	public User authenticate(String login, String password) {
			return userRepository.getUserByEmailAndPassword(login, password);
	}
	
	/*@Override
	public User authenticateUser(User u) {
			return userRepository.getUserByEmailAndPassword(u.getName(), u.getPassword());
	}*/
	
	/*@Override
	public User authenticateUser(String u, String u2) {
			return userRepository.getUserByEmailAndPassword(u,u2);
	}*/
	
	/*@Override
	public List<String> authenticateUser(User u) {
		String name=u.getName();
		String password=u.getPassword();
		
			return userRepository.getUserByNameAndPassword(name, password);
	}*/
	
	/*private static String getEncodedString(String password)
	{
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	private static String getDecodeString(String encryptedString)
	{
		//return new String (Base64.getMimeDecoder().decode(encryptedString));
		return new String(Base64.getDecoder().decode(encryptedString.getBytes()));
	}*/
	
	@Override
	public User authenticateUser(User u) {

		String name=u.getName();
			//decodedString=password;*/		
		String passwordDecoder = u.getPassword();
		System.out.println("password mch coder:" + passwordDecoder);
		String passwordCoder = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		System.out.println("password coder:" + passwordCoder);

		boolean isPasswordMatch = passwordDecoder.matches(passwordCoder);
		System.out.println("Password : " + passwordDecoder + "   passwordCoder    : " + isPasswordMatch);
		byte[] decodedBytes = Base64.getDecoder().decode(passwordCoder);
		String passwordDecoderr = new String(decodedBytes);
		System.out.println("password décoder: "+passwordDecoderr);
			return userRepository.getUserByNameAndPassword(name, passwordCoder);
	}	
	
	@Override
	public Parent authenticateParent(Parent u) {

		String name=u.getName();
			//decodedString=password;*/		
		String passwordDecoder = u.getPassword();
		System.out.println("password mch coder:" + passwordDecoder);
		String passwordCoder = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		System.out.println("password coder:" + passwordCoder);

		boolean isPasswordMatch = passwordDecoder.matches(passwordCoder);
		System.out.println("Password : " + passwordDecoder + "   passwordCoder    : " + isPasswordMatch);
		byte[] decodedBytes = Base64.getDecoder().decode(passwordCoder);
		String passwordDecoderr = new String(decodedBytes);
		System.out.println("password décoder: "+passwordDecoderr);
			return (Parent) userRepository.getUserByNameAndPassword(name, passwordCoder);
	}	
	
	@Override
	public KinderGartenAdmin authenticateKinderGartenAdmin(KinderGartenAdmin u) {

		String name=u.getName();
			//decodedString=password;*/		
		String passwordDecoder = u.getPassword();
		System.out.println("password mch coder:" + passwordDecoder);
		String passwordCoder = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
		System.out.println("password coder:" + passwordCoder);

		boolean isPasswordMatch = passwordDecoder.matches(passwordCoder);
		System.out.println("Password : " + passwordDecoder + "   passwordCoder    : " + isPasswordMatch);
		byte[] decodedBytes = Base64.getDecoder().decode(passwordCoder);
		String passwordDecoderr = new String(decodedBytes);
		System.out.println("password décoder: "+passwordDecoderr);
			return (KinderGartenAdmin) userRepository.getUserByNameAndPassword(name, passwordCoder);
	}
	
	


	
	@Override
	public Long addOrUpdateUser(User user) {
		//user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
		user.setPassword(encodedString);
		userRepository.save(user);
		return user.getIdUser();
	}
	
	@Override
	public Long addOrUpdateParent(Parent parent) {
		//parent.setPassword(new BCryptPasswordEncoder().encode(parent.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(parent.getPassword().getBytes());
		parent.setPassword(encodedString);
		userRepository.save(parent);
		return parent.getIdUser();
	}
	
	@Override
	public Long addOrUpdateKinderGartenAdmin(KinderGartenAdmin kinderGartenAdmin) {
		//kinderGartenAdmin.setPassword(new BCryptPasswordEncoder().encode(kinderGartenAdmin.getPassword()));
		String encodedString = Base64.getEncoder().encodeToString(kinderGartenAdmin.getPassword().getBytes());
		kinderGartenAdmin.setPassword(encodedString);
		userRepository.save(kinderGartenAdmin);
		return kinderGartenAdmin.getIdUser();
	}
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public void deleteUserById(Long idUser) {
			userRepository.deleteById(idUser);
	}
	
	
	@Override
	public Optional<User> displayUser(User u) {
		Long i=u.getIdUser();
		return userRepository.findById(i);

	}
	
	
	
	@Override
	public void affecterKidAParent(Long idKid, Long idUser) {
		Parent userEntity = (Parent) userRepository.findById(idUser).get();
		Kid kidEntity = kidRepository.findById(idKid).get();
		kidEntity.setParent(userEntity);
		kidRepository.save(kidEntity);
	}

	@Override
	public List<User> FindUserSortedByNameUser() {
		return userRepository.FindUserSortedByNameUser();
	}
	
	@Override
	public List<User> FindUserSortedByTypeParent() {
		return userRepository.FindUserSortedByTypeParent();
	}
	
	@Override
	public List<User> FindUserSortedByTypeKinderGartenAdmin() {
		return userRepository.FindUserSortedByTypeKinderGartenAdmin();
	}
	
	@Override
	public List<User> FindUserSortedByTypeUser() {
		return userRepository.FindUserSortedByTypeUser();
	}

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendSimpleEmail(String toEmail, String body, String subject) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("4sae4kindergarten@gmail.com");
		//message.setTo(toEmail);
		message.setTo("ameni.merhben@esprit.tn");
		//message.setText(body);
		message.setText("Your Account has been confirmed");
		//message.setSubject(subject);
		message.setSubject("Confirmation");
		
		mailSender.send(message);
		System.out.println("mail send..");
	}

	@Override
	public void sendEmailWithAttachement(String toEmail, String body, String subject, String attachement) throws MessagingException{
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		
		mimeMessageHelper.setFrom("ameni.merhben@esprit.tn");
		//mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setTo("ameni.merhben@esprit.tn");
		//mimeMessageHelper.setText(body);
		mimeMessageHelper.setText("Your Account has been confirmed");
		//mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setSubject("Confirmation");

		
		FileSystemResource fileSystem = new FileSystemResource(new File(attachement));
		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
		
		mailSender.send(mimeMessage);
		System.out.println("mail send with attachement..");
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.getUserByName(name);
	}

	@Override
	public User getUserId(Long userid) {
	return userRepository.getUserId(userid);
	}
	
	


	
	
}
