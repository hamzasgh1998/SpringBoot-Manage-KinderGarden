package tn.esprit.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parent extends User {
	
	@Column(name="nbChild")
	private int nbChild;
	


	@OneToMany(cascade = CascadeType.ALL, mappedBy="Parent")
	private Set<Reclamation> Reclamation;
	
	


	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Parent")
	private Set<ChatMessage> ChatMessage;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Parent")
	private Set<RDV> RDV;
/*	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Parent")
	private Set<LigneCommande> QuantityProductParPanier;
	*/
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy="parent")
	@JsonIgnore
	private Cart Cart;
	
	
	
	/*@OneToMany(cascade=CascadeType.ALL)
	private Set<Kid> Kid;*/
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Parent")
	private Set<Kid> Kid;

/*	@Override
	public String toString() {
		return "Parent [nbChild=" + nbChild + "]";
	}*/
	
	

	public int getNbChild() {
		return nbChild;
	}

	

	@Override
	public String toString() {
		return "Parent [nbChild=" + nbChild + ", Reclamation="
				+ Reclamation + ", ChatMessage=" + ChatMessage + ", RDV=" + RDV + ", Cart=" + Cart + ", Kid=" + Kid
				+ "]";
	}


	public void setNbChild(int nbChild) {
		this.nbChild = nbChild;
	}
	



	public Set<Reclamation> getReclamation() {
		return Reclamation;
	}

	public void setReclamation(Set<Reclamation> reclamation) {
		Reclamation = reclamation;
	}

	

	public Set<ChatMessage> getChatMessage() {
		return ChatMessage;
	}

	public void setChatMessage(Set<ChatMessage> chatMessage) {
		ChatMessage = chatMessage;
	}

	public Set<RDV> getRDV() {
		return RDV;
	}

	public void setRDV(Set<RDV> rDV) {
		RDV = rDV;
	}



	public Cart getCart() {
		return Cart;
	}

	public void setCart(Cart cart) {
		Cart = cart;
	}

	public Set<Kid> getKid() {
		return Kid;
	}

	public void setKid(Set<Kid> kid) {
		Kid = kid;
	}
	
	

	public Parent(int nbChild) {
		super();
		this.nbChild = nbChild;
	}
	
	public Parent() {
	}
	public Parent(String name, String lastName, Date dateBirth, String address, String email,
			String password, int numTel, int nbChild) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.numTel = numTel;
		this.nbChild = nbChild;
	}
	
	public Parent(Long idUser, String name, String lastName, Date dateBirth, String address, String email,
			String password, int numTel, int nbChild) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.numTel = numTel;
		this.nbChild = nbChild;

	}
	
	
	
}
