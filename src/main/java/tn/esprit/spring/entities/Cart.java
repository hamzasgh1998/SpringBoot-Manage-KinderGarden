package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tn.esprit.spring.entities.enumerations.Status;
@Entity
@Table(name="Cart")
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdCart")
	private Long IdCart;
	
	private int quantite;
	private double prix;
	
	
	
	public Long getIdCart() {
		return IdCart;
	}


	public void setIdCart(Long idCart) {
		IdCart = idCart;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}








	


	
	
	
	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public Cart() {
		super();
	}



	public Cart(Long idCart, int quantite, double prix, Parent parent, Set<ItemList> itemList) {
		super();
		IdCart = idCart;
		this.quantite = quantite;
		this.prix = prix;
		this.parent = parent;
		this.itemList = itemList;
	}


	public Cart(Long idCart, int quantite, double prix ){
		super();
		IdCart = idCart;
		this.quantite = quantite;
		this.prix = prix;
	
		
	}





	public Cart(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		
	}




	@OneToOne
	@JsonIgnore
	private Parent parent;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cart")
	private Set<ItemList> itemList;


	

	public Set<ItemList> getItemList() {
		return itemList;
	}


	public void setItemList(Set<ItemList> itemList) {
		this.itemList = itemList;
	}


	
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="Parent")
	private Set<LigneCommande> QuantityProductParPanier;
}*/
	
	
	
	
}
