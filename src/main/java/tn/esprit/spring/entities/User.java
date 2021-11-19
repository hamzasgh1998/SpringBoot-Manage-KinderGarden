package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="User")
public class User implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idUser")
	protected Long idUser;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="lastName")
	protected String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateBirth")
	protected Date dateBirth;
	
	@Column(name="address")
	protected String address;
	
	@Column(name="email")
	protected String email;
	
	@Column(name="password")
	protected String password;

	@Column(name="numTel")
	protected int numTel;
	
	
	//@Transient
	//protected String token;
	

	@ManyToOne
	//@JsonIgnore
	Events Events ;
	
	
	public Events getEvents() {
		return Events;
	}

	public void setEvents(Events events) {
		Events = events;
	}

/*	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", lastName=" + lastName + ", dateBirth=" + dateBirth
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", numTel=" + numTel
				+ ", token=" + token + "]";
	}*/
	
	

	public Long getIdUser() {
		return idUser;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", lastName=" + lastName + ", dateBirth=" + dateBirth
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", numTel=" + numTel + "]";
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}


	/*public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}*/

	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long idUser, String name, String lastName, Date dateBirth, String address, int numTel/*, String token*/) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.numTel = numTel;
		//this.token = token;
	}
	
	public User(String name, String lastName, Date dateBirth, String address, int numTel/*, String token*/) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.numTel = numTel;
		//this.token = token;
	}
	
	public User(Long idUser, String name, String lastName, Date dateBirth, String address, String email,
			String password, int numTel) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.numTel = numTel;

	}
	
	public User(String name, String lastName, Date dateBirth, String address, String email,
			String password, int numTel) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.numTel = numTel;
	}




	
	
}
