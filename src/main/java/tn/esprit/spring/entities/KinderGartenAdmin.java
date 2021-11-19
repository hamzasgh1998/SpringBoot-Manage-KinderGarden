package tn.esprit.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class KinderGartenAdmin extends User {
	
	@Column(name="formation")
	private String formation;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="KinderGartenAdmin")
	private Set<Comments> Comments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="KinderGartenAdmin")
	private Set<Posts> Posts;
	

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="KinderGartenAdmin")
	private Set<Products> Products;
	
	
	@OneToOne
	private KinderGarten KinderGarten;

	@Override
	public String toString() {
		return "KinderGartenAdmin [formation=" + formation + "]";
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public KinderGartenAdmin(String formation) {
		super();
		this.formation = formation;
	}
	
	public KinderGartenAdmin() {
	}
	
	public KinderGartenAdmin(String name, String lastName, Date dateBirth, String address, String email,
			String password, int numTel, String formation) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.numTel = numTel;
		this.formation = formation;
	}
	
	public KinderGartenAdmin(Long idUser, String name, String lastName, Date dateBirth, String address, String email,
			String password, int numTel, String formation) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.numTel = numTel;
		this.formation = formation;

	}
	
}
