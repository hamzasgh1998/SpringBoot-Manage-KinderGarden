package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="KinderGarten")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="kinder_garten_id_kinder_garten")
public class KinderGarten implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdKinderGarten")
	private Long IdKinderGarten;
	@Column(name="NameKinderGarten")
	private String NameKinderGarten;
	@Column(name="Address")
	private String Address;
	@Column(name="Descritpion")
	private String Descritpion;
	@Temporal(TemporalType.DATE)
	@Column(name="CreationDate")
	private Date CreationDate;
	@Column(name="Tel")
	private String Tel;
	@Column(name="NbEmployees")
	private int NbEmployees;
	@Column(name="Price")
	private float Price;
	@Column(name="Email")
	private String Email;
	@Column(name="Capacity")
	private int Capacity;

	@Column(name="ReputationComments")
	private int ReputationComments;
	@Column(name="ReputationReclamations")
	private int ReputationReclamations;
	@Column(name="ReputationRates")
	private int ReputationRates;
	@Column(name="Canteenn")
	private boolean Canteenn;
	
	
	/*
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, mappedBy="KinderGarten")
	@JsonIgnore
	private Set<Menu> Menu;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, mappedBy="KinderGarten")
	@JsonIgnore
	private Set<Activities> Activities;/*

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, mappedBy="KinderGarten")
	@JsonIgnore
	private Set<Events> Events;
	
*/
	
	
	@OneToOne
	private Reputation Reputation;
	
	@OneToOne(mappedBy="KinderGarten")
	private KinderGartenAdmin KinderGartenAdmin;

	public Long getIdKinderGarten() {
		return IdKinderGarten;
	}

	public void setIdKinderGarten(Long idKinderGarten) {
		IdKinderGarten = idKinderGarten;
	}

	public String getNameKinderGarten() {
		return NameKinderGarten;
	}

	public void setNameKinderGarten(String nameKinderGarten) {
		NameKinderGarten = nameKinderGarten;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDescritpion() {
		return Descritpion;
	}

	public void setDescritpion(String descritpion) {
		Descritpion = descritpion;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = new Date();
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public int getNbEmployees() {
		return NbEmployees;
	}

	public void setNbEmployees(int nbEmployees) {
		NbEmployees = nbEmployees;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int getReputationComments() {
		return ReputationComments;
	}

	public void setReputationComments(int reputationComments) {
		ReputationComments = reputationComments;
	}

	public int getReputationReclamations() {
		return ReputationReclamations;
	}

	public void setReputationReclamations(int reputationReclamations) {
		ReputationReclamations = reputationReclamations;
	}

	public int getReputationRates() {
		return ReputationRates;
	}

	public void setReputationRates(int reputationRates) {
		ReputationRates = reputationRates;
	}

	public boolean isCanteenn() {
		return Canteenn;
	}

	public void setCanteenn(boolean canteenn) {
		Canteenn = canteenn;
	}
/*
	public Set<Menu> getMenu() {
		return Menu;
	}
	public void setMenu(Set<Menu> menu) {
		Menu = menu;
	}
	public Set<Events> getEvents() {
		return Events;
	}

	public void setEvents(Set<Events> events) {
		Events = events;
	}
*/
	public Reputation getReputation() {
		return Reputation;
	}

	public void setReputation(Reputation reputation) {
		Reputation = reputation;
	}

	public KinderGartenAdmin getKinderGartenAdmin() {
		return KinderGartenAdmin;
	}

	public void setKinderGartenAdmin(KinderGartenAdmin kinderGartenAdmin) {
		KinderGartenAdmin = kinderGartenAdmin;
	}

	@Override
	public String toString() {
		return "KinderGarten [IdKinderGarten=" + IdKinderGarten + ", NameKinderGarten=" + NameKinderGarten
				+ ", Address=" + Address + ", Descritpion=" + Descritpion + ", CreationDate=" + CreationDate + ", Tel="
				+ Tel + ", NbEmployees=" + NbEmployees + ", Price=" + Price + ", Email=" + Email + ", Capacity="
				+ Capacity + ", ReputationComments=" + ReputationComments + ", ReputationReclamations="
				+ ReputationReclamations + ", ReputationRates=" + ReputationRates + ", Canteenn=" + Canteenn + /*", Menu="
				+ Menu + ", Activities=" + Activities + ", Events=" + Events + */", Reputation=" + Reputation
				+ ", KinderGartenAdmin=" + KinderGartenAdmin + "]";
	}

	public KinderGarten(Long idKinderGarten, String nameKinderGarten, String address, String descritpion,
			Date creationDate, String tel, int nbEmployees, float price, String email, int capacity,
			int reputationComments, int reputationReclamations, int reputationRates, boolean canteenn,
			Set<tn.esprit.spring.entities.Menu> menu, Set<tn.esprit.spring.entities.Activities> activities,
			Set<tn.esprit.spring.entities.Events> events, tn.esprit.spring.entities.Reputation reputation,
			tn.esprit.spring.entities.KinderGartenAdmin kinderGartenAdmin) {
		super();
		IdKinderGarten = idKinderGarten;
		NameKinderGarten = nameKinderGarten;
		Address = address;
		Descritpion = descritpion;
		CreationDate = creationDate;
		Tel = tel;
		NbEmployees = nbEmployees;
		Price = price;
		Email = email;
		Capacity = capacity;
		ReputationComments = reputationComments;
		ReputationReclamations = reputationReclamations;
		ReputationRates = reputationRates;
		Canteenn = canteenn;
	//	Menu = menu;
		//Activities = activities;
	//	Events = events;
		Reputation = reputation;
		KinderGartenAdmin = kinderGartenAdmin;
	}

	public KinderGarten() {
		super();
	}

	public KinderGarten(String nameKinderGarten, String address, String descritpion, Date creationDate, String tel,
			int nbEmployees, float price, String email, int capacity, int reputationComments,
			int reputationReclamations, int reputationRates, boolean canteenn, Set<tn.esprit.spring.entities.Menu> menu,
			Set<tn.esprit.spring.entities.Activities> activities, Set<tn.esprit.spring.entities.Events> events,
			tn.esprit.spring.entities.Reputation reputation,
			tn.esprit.spring.entities.KinderGartenAdmin kinderGartenAdmin) {
		super();
		NameKinderGarten = nameKinderGarten;
		Address = address;
		Descritpion = descritpion;
		CreationDate = creationDate;
		Tel = tel;
		NbEmployees = nbEmployees;
		Price = price;
		Email = email;
		Capacity = capacity;
		ReputationComments = reputationComments;
		ReputationReclamations = reputationReclamations;
		ReputationRates = reputationRates;
		Canteenn = canteenn;
	//	Menu = menu;
	//	Activities = activities;
		//Events = events;
		Reputation = reputation;
		KinderGartenAdmin = kinderGartenAdmin;
	}

	public KinderGarten(String nameKinderGarten, String address, String descritpion, Date creationDate, String tel,
			int nbEmployees, float price, String email, int capacity, boolean canteenn,
			tn.esprit.spring.entities.KinderGartenAdmin kinderGartenAdmin) {
		super();
		NameKinderGarten = nameKinderGarten;
		Address = address;
		Descritpion = descritpion;
		CreationDate = creationDate;
		Tel = tel;
		NbEmployees = nbEmployees;
		Price = price;
		Email = email;
		Capacity = capacity;
		Canteenn = canteenn;
		KinderGartenAdmin = kinderGartenAdmin;
	}

	
	
	
	
	
}