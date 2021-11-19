package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Prod")
	private Long idProd;
	@Column(name = "NomProd")
	private String nomProd;
	@Column(name = "Description")
	private String description;
	@Column(name = "Couleur")
	private String couleur;
	@Column(name = "Image")
	private String image;
	@Column(name = "Prix")
	private float prix;
	@Column(name = "Quantite")
	private int Quantite;

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Products() {
		super();
	}

	public Products(Long idProd, String nomProd, String description, String couleur, String image, float prix,
			int quantite, Category_Products category) {
		super();
		this.idProd = idProd;
		this.nomProd = nomProd;
		this.description = description;
		this.couleur = couleur;
		this.image = image;
		this.prix = prix;
		Quantite = quantite;
		this.category = category;
	}

	public Products(String nomProd, String description, String couleur, String image, float prix, int quantite,
			Category_Products category) {
		super();

		this.nomProd = nomProd;
		this.description = description;
		this.couleur = couleur;
		this.image = image;
		this.prix = prix;
		Quantite = quantite;
		this.category = category;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	KinderGartenAdmin KinderGartenAdmin;

	

	@ManyToOne(cascade = CascadeType.ALL)
	private Category_Products category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private OfferProducts offer;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
	private Set<ItemList> itemList;

	public OfferProducts getOffer() {
		return offer;
	}

	public void setOffer(OfferProducts offer) {
		this.offer = offer;
	}
	@JsonBackReference
	public Set<ItemList> getItemList() {
		return itemList;
	}

	public void setItemList(Set<ItemList> itemList) {
		this.itemList = itemList;
	}

	public KinderGartenAdmin getKinderGartenAdmin() {
		return KinderGartenAdmin;
	}

	public void setKinderGartenAdmin(KinderGartenAdmin kinderGartenAdmin) {
		KinderGartenAdmin = kinderGartenAdmin;
	}

	
	public Category_Products getCategory() {
		return category;
	}

	public void setCategory(Category_Products category) {
		this.category = category;
	}

	
}
