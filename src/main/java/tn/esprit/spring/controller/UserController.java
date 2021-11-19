package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserService;

@Scope(value = "session")
@Controller(value = "userController") // Name of the bean in Spring IoC
@ELBeanName(value = "userController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class UserController {

	@Autowired
	UserService userService;

	
	private User authenticatedUser;	
	private String login; 
	private String password;
	private User user;
	private Boolean loggedIn;
	private String name;
	private String lastName;
	private boolean role;
	private Date dateBirth;
	private int numTel;
	private String address;
	private String email;
	private Long userIdToBeUpdated;
	private List<User> users;
	
	public User getAuthenticatedUser() {
		return authenticatedUser;
	}
	
	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}




	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public Long getUserIdToBeUpdated() {
		return userIdToBeUpdated;
	}

	public void setUserIdToBeUpdated(Long userIdToBeUpdated) {
		this.userIdToBeUpdated = userIdToBeUpdated;
	}

	/*public List<User> getUsers() {
		return users;
	}*/

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public void updateUser()
	{ 
		userService.addOrUpdateUser(new User(name, lastName, dateBirth, address,email,password,numTel)); 
	}
	
	/*public void removeUser(Long userId)
	{
		userService.deleteUserById(userId);
	}*/
	public List<User> getAllUsers() {
		users = userService.getAllUsers();
	return users;
	}
	
	public void addUser() {
		userService.addOrUpdateUser(new User(name, lastName, dateBirth, address,email,password,numTel));
	}
	
	public void displayUser(User u) {
		userService.displayUser(u);
		
		this.setName(u.getName());
		this.setLastName(u.getLastName());
		this.setDateBirth(u.getDateBirth());
		this.setAddress(u.getAddress());
		this.setEmail(u.getEmail());
		this.setPassword(u.getPassword());
		this.setNumTel(u.getNumTel());
		this.setUserIdToBeUpdated(u.getIdUser());

	}
	
	public String doLogout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login.xhtml?faces-redirect=true";
	}
	
	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser=userService.authenticate(login, password);
		 if (authenticatedUser != null ) {
		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =

		new FacesMessage("Login Failed: please check your username/password and try again.");

		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
	


	
}

