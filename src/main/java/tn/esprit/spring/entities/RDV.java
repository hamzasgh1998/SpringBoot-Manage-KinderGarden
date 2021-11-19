package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RDV implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private int idRDV;
	
	@Column(name="DateRDV")
	private Date DateRDV;
	
	@Column
	private String Description;
	
	@Column
	private KinderGarten KinderGarten;


	@ManyToOne
	Parent Parent ;
	
	
}