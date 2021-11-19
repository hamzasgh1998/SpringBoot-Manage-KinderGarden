package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import tn.esprit.spring.entities.enumerations.Days;
@Entity
@Table(name="Menu")


public class Menu implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdMenu")
	private Long IdMenu;
	@Enumerated(EnumType.STRING)
	@Column(name="Plat")
	private tn.esprit.spring.entities.enumerations.Plat Plat;
	@Enumerated(EnumType.STRING)
	@Column(name="Day")
	private Days Day;
	@Column(name="Energetic_value")
	private float Energetic_value;

	
	
	
	

	@ManyToOne 
	KinderGarten KinderGarten;






	public Long getIdMenu() {
		return IdMenu;
	}






	public void setIdMenu(Long idMenu) {
		IdMenu = idMenu;
	}


















	public Menu(Long idMenu, tn.esprit.spring.entities.enumerations.Plat plat, Days day,
			tn.esprit.spring.entities.KinderGarten kinderGarten) {
		super();
		IdMenu = idMenu;
		Plat = plat;
		Day = day;
		KinderGarten = kinderGarten;
	}






	public tn.esprit.spring.entities.enumerations.Plat getPlat() {
		return Plat;
	}






	public void setPlat(tn.esprit.spring.entities.enumerations.Plat plat) {
		Plat = plat;
	}





	//@JsonManagedReference
	public KinderGarten getKinderGarten() {
		return KinderGarten;
	}






	public void setKinderGarten(KinderGarten kinderGarten) {
		KinderGarten = kinderGarten;
	}






	@Override
	public String toString() {
		return "Menu [IdMenu=" + IdMenu + ", Plat=" + Plat + ", Day=" + Day + ", KinderGarten=" + KinderGarten.getIdKinderGarten() + "]";
	}











	public Menu() {
		super();
	}






	public Days getDay() {
		return Day;
	}






	public void setDay(Days day) {
		Day = day;
	}






	public Menu(tn.esprit.spring.entities.enumerations.Plat plat, Days day, float energetic_value,
			tn.esprit.spring.entities.KinderGarten kinderGarten) {
		super();
		Plat = plat;
		Day = day;
		Energetic_value = energetic_value;
		KinderGarten = kinderGarten;
	}

	


	public Menu(tn.esprit.spring.entities.enumerations.Plat plat, Days day, float d) {
		super();
		Plat = plat;
		Day = day;
		Energetic_value = d;}






	public float getEnergetic_value() {
		return Energetic_value;
	}






	public void setEnergetic_value(float energetic_value) {
		Energetic_value = energetic_value;
	}






	public Menu(Long idMenu, tn.esprit.spring.entities.enumerations.Plat plat, Days day, float energetic_value,
			tn.esprit.spring.entities.KinderGarten kinderGarten) {
		super();
		IdMenu = idMenu;
		Plat = plat;
		Day = day;
		Energetic_value = energetic_value;
		KinderGarten = kinderGarten;
	}



	
	
	
	
	
	
	
	
	
	

}
