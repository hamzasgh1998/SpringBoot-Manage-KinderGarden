package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tn.esprit.spring.entities.KinderGartenAdmin;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;

public interface UserService {
	 List<User> retrieveAllUsers();

	 User addUser(User u);
	 Parent addParent(Parent u);
	 KinderGartenAdmin addKinderGartenAdmin(KinderGartenAdmin u);
	 
	 
     User updateUser(User u);
     Parent updateParent(Parent u);
     KinderGartenAdmin updateKinderGartenAdmin(KinderGartenAdmin u);


	 public Long addOrUpdateUser(User user);
	 public Long addOrUpdateParent(Parent parent);
	 public Long addOrUpdateKinderGartenAdmin(KinderGartenAdmin kinderGartenAdmin);



     void deleteUser(Long idUser);
	 void deleteUserById(Long idUser);
	 
	 
     User retrieveUser(Long idUser);
     Parent retrieveParent(Long idUser);
     KinderGartenAdmin retrieveKinderGartenAdmin(Long idUser);



    // public User authenticateUser(String u,String u2);
     public User authenticateUser(User u);
     public Parent authenticateParent(Parent u);
     public KinderGartenAdmin authenticateKinderGartenAdmin(KinderGartenAdmin u);
	 public User authenticate(String login, String password) ;
	 public List<User> getAllUsers();
	 Optional<User> displayUser(User u);
	 
	 void  affecterKidAParent(Long idKid,Long idUser);

	public List<User> FindUserSortedByNameUser();
	public List<User> FindUserSortedByTypeParent();
	public List<User> FindUserSortedByTypeKinderGartenAdmin();
    public List<User> FindUserSortedByTypeUser();

    public void sendSimpleEmail(String toEmail, String body, String subject);
    public void sendEmailWithAttachement(String toEmail, String body, String subject,String attachement) throws MessagingException;
    
	public User getUserByName(@Param("name") String name);
	public User getUserId(Long userid);


	//public UserDetails loadUserByUserName(String name) throws UsernameNotFoundException;
}
