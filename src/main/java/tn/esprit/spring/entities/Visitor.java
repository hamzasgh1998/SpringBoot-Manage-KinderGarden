package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Visitor")
public class Visitor implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="adresseIp")
	private String adresseIp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresseIp() {
		return adresseIp;
	}

	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", adresseIp=" + adresseIp + "]";
	}

	public Visitor() {
	}
	
	public Visitor(Long id, String adresseIp) {
		super();
		this.id = id;
		this.adresseIp = adresseIp;
	}
	
	public Visitor(String adresseIp) {
		super();
		this.adresseIp = adresseIp;
	}

	
	
}
