package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Time;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Comments implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdComment")
	private Long IdComment;
	@Column(name="Content")
	private String Content;
	@Temporal(TemporalType.TIME)
	@Column(name="DateComment")
	private Date DateComment;
	@Enumerated(EnumType.STRING)
	@Column(name="ValideComment")
	private ValideComment ValideComment;
	
	
	@ManyToOne
	Admin Admin;
	
	
	@ManyToOne
	Posts Posts;
	
	
	@ManyToOne
	Parent Parent;
	
	
	@ManyToOne
	KinderGartenAdmin KinderGartenAdmin;

	
	@ManyToOne
	Reputation Reputation;


	

	

	public Comments() {
		super();
	}


	public Long getIdComment() {
		return IdComment;
	}


	public void setIdComment(Long idComment) {
		IdComment = idComment;
	}


	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}


	public Date getDateComment() {
		return DateComment;
	}


	public void setDateComment(Date dateComment) {
		DateComment = new Date();
	}


	public ValideComment getValideComment() {
		return ValideComment;
	}


	public void setValideComment(ValideComment valideComment) {
		ValideComment = valideComment;
	}


	public Admin getAdmin() {
		return Admin;
	}


	public void setAdmin(Admin admin) {
		Admin = admin;
	}


	public Posts getPosts() {
		return Posts;
	}


	public void setPosts(Posts posts) {
		Posts = posts;
	}


	public Parent getParent() {
		return Parent;
	}


	public void setParent(Parent parent) {
		Parent = parent;
	}


	public KinderGartenAdmin getKinderGartenAdmin() {
		return KinderGartenAdmin;
	}


	public void setKinderGartenAdmin(KinderGartenAdmin kinderGartenAdmin) {
		KinderGartenAdmin = kinderGartenAdmin;
	}


	public Reputation getReputation() {
		return Reputation;
	}


	public void setReputation(Reputation reputation) {
		Reputation = reputation;
	}


	public Comments(Long idComment, String content, Date dateComment, tn.esprit.spring.entities.enumerations.ValideComment valideComment,
			tn.esprit.spring.entities.Admin admin, tn.esprit.spring.entities.Posts posts,
			tn.esprit.spring.entities.Parent parent, tn.esprit.spring.entities.KinderGartenAdmin kinderGartenAdmin,
			tn.esprit.spring.entities.Reputation reputation) {
		super();
		IdComment = idComment;
		Content = content;
		DateComment = dateComment;
		ValideComment = valideComment;
		Admin = admin;
		Posts = posts;
		Parent = parent;
		KinderGartenAdmin = kinderGartenAdmin;
		Reputation = reputation;
	}


	public Comments(String content, Date dateComment, tn.esprit.spring.entities.enumerations.ValideComment valideComment) {
		super();
		Content = content;
		DateComment = dateComment;
		ValideComment = valideComment;
	}


	public Comments(String content, Date dateComment, tn.esprit.spring.entities.enumerations.ValideComment valideComment,
			tn.esprit.spring.entities.Posts posts) {
		super();
		Content = content;
		DateComment = dateComment;
		ValideComment = valideComment;
		Posts = posts;
	}



	
	
	
}
