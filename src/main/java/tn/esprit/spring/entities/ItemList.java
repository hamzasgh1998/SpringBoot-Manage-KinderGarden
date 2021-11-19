package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tn.esprit.spring.entities.enumerations.Status;
@Entity
@Table(name="ItemList")
public class ItemList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;

	private int quantity;
	private float price;
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	 private Status status;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	

	

	@ManyToOne
	
	private Products products ;
	
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	@ManyToOne
	
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}


	
	public ItemList(int quantity, long price, LocalDate date, Status status, Products products) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.status = status;
		this.products = products;
	}
	
	
	
	

	public ItemList(Long id, int quantity, float price, LocalDate date, Status status) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.status = status;
	}
	
	

	public ItemList() {
		super();
	}

	public ItemList(int quantity, float price, LocalDate date, Status status) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.status = status;
	}




	

}