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
@Table(name="Category_Products")
public class Category_Products implements Serializable {
	public Category_Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idCategory")
	private Long idCategory;
	@Column(name="NameCategory")
	private String nameCategory;
	
	
	
	
	
	
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Category_Products(Long idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}
	public Category_Products(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	 
	private Set<Products> Products;
	
	@JsonBackReference
	public Set<Products> getProducts() {
		return Products;
	}
	public void setProducts(Set<Products> products) {
		Products = products;
	}
	

}
