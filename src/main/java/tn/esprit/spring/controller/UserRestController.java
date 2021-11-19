package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.xmp.impl.Base64;

import tn.esprit.spring.entities.KinderGartenAdmin;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserService;

import java.util.List;

import javax.mail.MessagingException;


@RestController
public class UserRestController {

	@Autowired
	UserService userService;
    

	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	 @ResponseBody
	 public List<User> getUsers() {
	 return userService.retrieveAllUsers();
	
	 }
	
	
	
	
	@GetMapping("/getUserByName/{user-id}")
	 @ResponseBody
	 public User getUserByName(@PathVariable("user-id") String idUser) {
	 return userService.getUserByName(idUser);
	
	 }
	// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	 @GetMapping("/retrieve-user/{user-id}")
	 @ResponseBody
	 public User retrieveUser(@PathVariable("user-id") Long idUser) {
	 return userService.retrieveUser(idUser);
	
	 }
	 
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	 @GetMapping("/retrieve-parent/{user-id}")
	 @ResponseBody
	 public Parent retrieveParent(@PathVariable("user-id") Long idUser) {
	 return userService.retrieveParent(idUser);
	
	 }
	 
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	 @GetMapping("/retrieve-kinderGartenAdmin/{user-id}")
	 @ResponseBody
	 public KinderGartenAdmin retrieveKinderGartenAdmin(@PathVariable("user-id") Long idUser) {
	 return userService.retrieveKinderGartenAdmin(idUser);
	
	 }
	 
	 /*
	 // Ajouter User : http://localhost:8081/SpringMVC/servlet/add-user
	 @PostMapping("/add-user")
	 @ResponseBody
	 public User addUser(@RequestBody User u) {
	 User user = userService.addUser(u);
	
	 return user;
	 }*/
	 
	 @PostMapping("/add-user")
	 @ResponseBody
	 public User addUser(@RequestBody User u) {
	 User user = userService.addUser(u);	
	 return user;
	 }
	 
	 @PostMapping("/add-parent")
	 @ResponseBody
	 public Parent addParent(@RequestBody Parent p) {
	 Parent parent = userService.addParent(p);	
	 return parent;
	 }
	 
	 @PostMapping("/add-KinderGartenAdmin")
	 @ResponseBody
	 public KinderGartenAdmin addKinderGartenAdmin(@RequestBody KinderGartenAdmin ka) {
		 KinderGartenAdmin kinderGartenAdmin = userService.addKinderGartenAdmin(ka);	
	 return kinderGartenAdmin;
	 }
	 
		// http://localhost:8081/SpringMVC/servlet/remove-user/{user-id}
	  @DeleteMapping("/remove-user/{user-id}")
	  @ResponseBody
	  public void removeUser(@PathVariable("user-id") Long idUser) {
	  userService.deleteUser(idUser);
	  }
	  
	  // http://localhost:8081/SpringMVC/servlet/modify-user
	  @PutMapping("/modify-user")
	  @ResponseBody
	  public User modifyUser(@RequestBody User user) {
	  return userService.updateUser(user);
	 
	  }
	  
	  // http://localhost:8081/SpringMVC/servlet/modify-parent
	  @PutMapping("/modify-parent")
	  @ResponseBody
	  public Parent updateParent(@RequestBody Parent parent) {
	  return (Parent) userService.updateParent(parent);
	 
	  }
	  
	  // http://localhost:8081/SpringMVC/servlet/modify-KinderGartenAdmin
	  @PutMapping("/modify-KinderGartenAdmin")
	  @ResponseBody
	  public KinderGartenAdmin updateKinderGartenAdmin(@RequestBody KinderGartenAdmin kinderGartenAdmin) {
	  return (KinderGartenAdmin) userService.updateKinderGartenAdmin(kinderGartenAdmin);
	 
	  }
	  
	  // http://localhost:8081/SpringMVC/servlet/GetUserSortedByNameUser
		@GetMapping("/GetUserSortedByNameUser")
		 @ResponseBody
		 public List<User> FindUserSortedByNameUser() {
			return userService.FindUserSortedByNameUser();
			
		 }
		
	  // http://localhost:8081/SpringMVC/servlet/GetUserSortedByTypeParent
		 @GetMapping("/GetUserSortedByTypeParent")
		 @ResponseBody
		 public List<User> FindUserSortedByTypeParent() {
			return userService.FindUserSortedByTypeParent();
			
		 }
		 
	  // http://localhost:8081/SpringMVC/servlet/GetUserSortedByTypeKinderGartenAdmin
		 @GetMapping("/GetUserSortedByTypeKinderGartenAdmin")
		 @ResponseBody
		 public List<User> FindUserSortedByTypeKinderGartenAdmin() {
			return userService.FindUserSortedByTypeKinderGartenAdmin();
				
		 } 
		 
	  // http://localhost:8081/SpringMVC/servlet/GetUserSortedByTypeUser
		 @GetMapping("/GetUserSortedByTypeUser")
		 @ResponseBody
		 public List<User> FindUserSortedByTypeUser() {
			return userService.FindUserSortedByTypeUser();
				
		 } 
		 
		 // Ajouter Mail : http://localhost:8081/SpringMVC/servlet/sendSimpleEmail
		 @PostMapping("/sendSimpleEmail")
		 @ResponseBody
		 public void sendSimpleEmail() {
		 userService.sendSimpleEmail("ameni.merhben@esprit.tn", "Confirmation", "Your Account has been confirmed");
		
		 }
		 
		 // Ajouter Mail : http://localhost:8081/SpringMVC/servlet/sendEmailWithAttachement
		 @PostMapping("/sendEmailWithAttachement")
		 @ResponseBody
		 public void sendEmailWithAttachement() throws MessagingException {
		 userService.sendEmailWithAttachement("ameni.merhben@esprit.tn", "Confirmation", "Your Account has been confirmed", "C:\\Users\\DELL\\Pictures\\Confirm.GIF");
		
		 }
		 
		 
		
		  @GetMapping("/home")
		  public String home() {
		      return "Welcome";
		  }
		 
			/* // Ajouter authenticateUser : http://localhost:8081/SpringMVC/servlet/authenticate
		 @PostMapping("/authenticate")
		 @ResponseBody
		 public void authenticate() {
	     	 userService.authenticate("admin","admin");
			 }*/
		  
			/* @PostMapping("/authenticate")
			 @ResponseBody
			 public User authenticate() {
		     return	 userService.authenticate("admin","admin");
				 }*/

		  
		  
		 // Ajouter authenticateUser : http://localhost:8081/SpringMVC/servlet/authenticateUser
		 /* @PostMapping("/authenticateUser")
		 @ResponseBody
		 public String authenticateUser(@RequestBody User u) {
	     	// userService.authenticateUser();
			 // return userService.authenticateUser(u.getName(),u.getPassword());
			  if (userService.authenticateUser(u).size()==0)
			  {
				  return "authetication failed";
			  }
			  else
			  {
			return "authetication succes "+userService.authenticateUser(u);
			}
			 }*/
			 
			 @PostMapping("/authenticateUser")
			 @ResponseBody
			 public User authenticateUser(@RequestBody User u) {
		     	// userService.authenticateUser();
				 // return userService.authenticateUser(u.getName(),u.getPassword());
			User us=userService.authenticateUser(u);
			if (us== null)
				return null;
			
			return us;
				 }
			 
			 @PostMapping("/authenticateParent")
			 @ResponseBody
			 public Parent authenticateParent(@RequestBody Parent u) {
		     	// userService.authenticateUser();
				 // return userService.authenticateUser(u.getName(),u.getPassword());
			User us=userService.authenticateUser(u);
			if (us== null)
				return null;
			
			return (Parent) us;
				 }
			 
			 @PostMapping("/authenticateKinderGartenAdmin")
			 @ResponseBody
			 public KinderGartenAdmin authenticateKinderGartenAdmin(@RequestBody KinderGartenAdmin u) {
		     	// userService.authenticateUser();
				 // return userService.authenticateUser(u.getName(),u.getPassword());
			User us=userService.authenticateUser(u);
			if (us== null)
				return null;
			
			return (KinderGartenAdmin) us;
				 }



		  
		  @PutMapping("/affecterKidAParent/{user-id1}/{user-id}")
		  @ResponseBody
		  public void affecterKidAParent(@PathVariable("user-id1") Long userId1,@PathVariable("user-id") Long userId) {
			  userService.affecterKidAParent(userId1, userId);
		 
		  }
		  
}


