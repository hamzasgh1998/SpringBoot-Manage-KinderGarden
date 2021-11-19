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
import javax.persistence.OneToOne;

@Entity
public class Reputation implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdReputation")
	private Long IdReputation;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Reputation")
	private Set<Comments> Comments;
	
	@OneToOne(mappedBy="Reputation")
	private KinderGarten KinderGarten;

}
