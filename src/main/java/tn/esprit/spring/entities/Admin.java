package tn.esprit.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Admin extends User {
/*	@Column(name="NameAdmin")
	private String NameAdmin;
	
	@Column(name="LastAdmin")
	private String LastAdmin;
	
	@Column(name="DateBirthAdmin")
	private Date DateBirthAdmin;
	
	@Column(name="AddressAdmin")
	private String AddressAdmin;
	
	@Column(name="EmailAdmin")
	private String EmailAdmin;
	
	@Column(name="PasswordAdmin")
	private String PasswordAdmin;

	@Column(name="numTelAdmin")
	private int numTelAdmin;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Admin")
	private Set<Comments> Comments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Admin")
	private Set<Posts> Posts;*/
}
