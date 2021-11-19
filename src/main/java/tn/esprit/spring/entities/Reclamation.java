package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reclamation implements Serializable{
	
	@ManyToOne
	Parent Parent;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdReclamation")
	private Long IdReclamation;
	
	@Column(name="ReclamationDate")
	private Date ReclamationDate; 
	
	@Column(name="Subject")
	private String Subject;
	
	@Column(name="Description")
	private String Description;
	
//	@Column(name="Photo")
//	private String Photo;
	
	@Column(name="TypeReclamation")
	private String TypeReclamation;
	
	@Column(name="Statue")
	private boolean Statue;
	
	public Parent getParent() {
		return Parent;
	}

	public void setParent(Parent parent) {
		Parent = parent;
	}

	public Long getIdReclamation() {
		return IdReclamation;
	}

	public void setIdReclamation(Long idReclamation) {
		IdReclamation = idReclamation;
	}

	public Date getReclamationDate() {
		return ReclamationDate;
	}

	public void setReclamationDate(Date reclamationDate) {
		ReclamationDate = new Date();
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTypeReclamation() {
		return TypeReclamation;
	}

	public void setTypeReclamation(String typeReclamation) {
		TypeReclamation = typeReclamation;
	}

	public boolean isStatue() {
		return Statue;
	}

	public void setStatue(boolean statue) {
		Statue = statue;
	}

	
	
	

}
