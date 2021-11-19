
package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import tn.esprit.spring.entities.enumerations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="Events")
public class Events implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdEvent")
	private Long IdEvent;
	@Column(name="NameEvent")
	private String NameEvent;

	@Enumerated(EnumType.STRING)
	@Column(name="TypeEvent")
	private TypeEvent TypeEvent;
	@Temporal(TemporalType.DATE)
	@Column(name="DateEvent")
	private Date DateEvent;
	@Column(name="CapacityEvent")
	private int CapacityEvent;
	@Column(name="PriceEvent")
	private float PriceEvent;
	
	@Column(name="Image")
	private String Image;

	@ManyToOne
	KinderGarten KinderGarten;

	public Long getIdEvent() {
		return IdEvent;
	}

	public void setIdEvent(Long idEvent) {
		IdEvent = idEvent;
	}

	public String getNameEvent() {
		return NameEvent;
	}

	public void setNameEvent(String nameEvent) {
		NameEvent = nameEvent;
	}

	public TypeEvent getTypeEvent() {
		return TypeEvent;
	}

	public void setTypeEvent(TypeEvent typeEvent) {
		TypeEvent = typeEvent;
	}

	public Date getDateEvent() {
		return DateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		DateEvent = new Date();
	}

	public int getCapacityEvent() {
		return CapacityEvent;
	}

	public void setCapacityEvent(int capacityEvent) {
		CapacityEvent = capacityEvent;
	}

	public float getPriceEvent() {
		return PriceEvent;
	}

	public void setPriceEvent(float priceEvent) {
		PriceEvent = priceEvent;
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
		return "Events [IdEvent=" + IdEvent + ", NameEvent=" + NameEvent + ", TypeEvent=" + TypeEvent + ", DateEvent="
				+ DateEvent + ", CapacityEvent=" + CapacityEvent + ", PriceEvent=" + PriceEvent + ", KinderGarten="
				+ KinderGarten.getIdKinderGarten() + "]";
	}

	

	public Events(Long idEvent, String nameEvent, tn.esprit.spring.entities.enumerations.TypeEvent typeEvent,
			Date dateEvent, int capacityEvent, float priceEvent, String image,
			tn.esprit.spring.entities.KinderGarten kinderGarten) {
		super();
		IdEvent = idEvent;
		NameEvent = nameEvent;
		TypeEvent = typeEvent;
		DateEvent = dateEvent;
		CapacityEvent = capacityEvent;
		PriceEvent = priceEvent;
		Image = image;
		KinderGarten = kinderGarten;
	}
	
	
	public Events(String nameEvent, tn.esprit.spring.entities.enumerations.TypeEvent typeEvent,
			Date dateEvent, int capacityEvent, float priceEvent, String image,
			tn.esprit.spring.entities.KinderGarten kinderGarten) {
		super();
		NameEvent = nameEvent;
		TypeEvent = typeEvent;
		DateEvent = dateEvent;
		CapacityEvent = capacityEvent;
		PriceEvent = priceEvent;
		Image = image;
		KinderGarten = kinderGarten;
	}


	
	
	
	public Events(Long idEvent, String nameEvent, tn.esprit.spring.entities.enumerations.TypeEvent typeEvent,
			Date dateEvent, int capacityEvent, float priceEvent, String image) {
		super();
		IdEvent = idEvent;
		NameEvent = nameEvent;
		TypeEvent = typeEvent;
		DateEvent = dateEvent;
		CapacityEvent = capacityEvent;
		PriceEvent = priceEvent;
		Image = image;
	}
	public Events( String nameEvent, tn.esprit.spring.entities.enumerations.TypeEvent typeEvent,
			Date dateEvent, int capacityEvent, float priceEvent, String image) {
		super();
		NameEvent = nameEvent;
		TypeEvent = typeEvent;
		DateEvent = dateEvent;
		CapacityEvent = capacityEvent;
		PriceEvent = priceEvent;
		Image = image;
	}


	public Events() {
		super();
	}

	
	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
	
	



}