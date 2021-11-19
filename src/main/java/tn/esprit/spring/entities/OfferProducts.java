package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="OfferProducts")
public class OfferProducts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID_Offer")
	private Long idOffer;
	@Column(name="valeur")
	private int valeur;
	
	
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	
	public OfferProducts(Long idOffer, int valeur) {
		super();
		this.idOffer = idOffer;
		this.valeur = valeur;
		
	}
	
	public OfferProducts(int valeur) {
		super();
		this.valeur = valeur;
	}
	public OfferProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="offer")
	private Set<Products> Products;
	@JsonBackReference
public Set<Products> getProducts() {
		return Products;
	}
	public void setProducts(Set<Products> products) {
		Products = products;
	}
	public Long getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(Long idOffer) {
		this.idOffer = idOffer;
	}
	
	
}
