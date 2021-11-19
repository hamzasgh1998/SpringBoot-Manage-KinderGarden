package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChatMessage implements Serializable {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private int idMessage;
	@Column(name="Content")
	private String content;
	@Column(name="DateMessage")
	private Time DateMessage;
	@Column
	private Parent Destinataire;
	
	@ManyToOne
	Parent Parent;
	
}