package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;
import tn.esprit.spring.entities.enumerations.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Posts implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdPost")
	private Long IdPost;
	@Column(name="Description")
	private String Description;
	@Temporal(TemporalType.TIME)
	@Column(name="DatePost")
	private Date DatePost;
	@Enumerated(EnumType.STRING)
	@Column(name="ValidePost")
	private ValidePost ValidePost;
	@Enumerated(EnumType.STRING)
	@Column(name="Subject")
	private Subject Subject;
	@Column(name="NamePost")
	private String NamePost;
	@Column(name="NbrLike")
	private int NbrLike;
	@Column(name="NbrDislike")
	private int NbrDislike;
	@Column(name="Img")
	private String Img;
	@Column(name="nbrSignal")
	private int nbrSignal;
	
	
	
	
	@ManyToOne
	Parent Parent;
	@ManyToOne
	KinderGartenAdmin KinderGartenAdmin;
	
	@ManyToOne
	Admin Admin;

	
	
	
	
	
	public Posts(Long idPost, String description, Date datePost, tn.esprit.spring.entities.enumerations.ValidePost validePost,
			tn.esprit.spring.entities.enumerations.Subject subject, String namePost, tn.esprit.spring.entities.Parent parent,
			tn.esprit.spring.entities.KinderGartenAdmin kinderGartenAdmin, tn.esprit.spring.entities.Admin admin,int nbrLike,int nbrDislike,int nbrsignal,String img) {
		super();
		IdPost = idPost;
		Description = description;
		DatePost = datePost;
		ValidePost = validePost;
		Subject = subject;
		NamePost = namePost;
		Parent = parent;
		KinderGartenAdmin = kinderGartenAdmin;
		Admin = admin;
		NbrLike=nbrLike;
		NbrDislike=nbrDislike;
		nbrSignal=nbrsignal;
		Img=img;
	}
	
	
	public Posts(String description, Date datePost, tn.esprit.spring.entities.enumerations.ValidePost validePost,
			tn.esprit.spring.entities.enumerations.Subject subject, String namePost, tn.esprit.spring.entities.Parent parent,
			tn.esprit.spring.entities.KinderGartenAdmin kinderGartenAdmin, tn.esprit.spring.entities.Admin admin,int nbrLike,int nbrDislike,int nbrsignal,String img) {
		super();
		Description = description;
		DatePost = datePost;
		ValidePost = validePost;
		Subject = subject;
		NamePost = namePost;
		Parent = parent;
		KinderGartenAdmin = kinderGartenAdmin;
		Admin = admin;
		NbrLike=nbrLike;
		NbrDislike=nbrDislike;
		nbrSignal=nbrsignal;
		Img=img;
	}
	//Constructeur no IDPOST  no IDUSER
	public Posts(String description, Date datePost, tn.esprit.spring.entities.enumerations.ValidePost validePost,
			tn.esprit.spring.entities.enumerations.Subject subject, String namePost,int nbrLike,int nbrDislike,int nbrsignal,String img ) {
		super();
		Description = description;
		DatePost = datePost;
		ValidePost = validePost;
		Subject = subject;
		NamePost = namePost;
		NbrLike=nbrLike;
		NbrDislike=nbrDislike;
		nbrSignal=nbrsignal;
		Img=img;
	}
	
	
	

	public Posts() {
		super();
	}


	public Long getIdPost() {
		return IdPost;
	}

	public void setIdPost(Long idPost) {
		IdPost = idPost;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDatePost() {
		return DatePost;
	}

	public void setDatePost(Date datePost) {
		DatePost = new Date();
	}

	public ValidePost getValidePost() {
		return ValidePost;
	}

	public void setValidePost(ValidePost validePost) {
		ValidePost = validePost;
	}

	public Subject getSubject() {
		return Subject;
	}

	public void setSubject(Subject subject) {
		Subject = subject;
	}


	public String getNamePost() {
		return NamePost;
	}

	public void setNamePost(String namePost) {
		NamePost = namePost;
	}



	public Parent getParent() {
		return Parent;
	}

	public void setParent(User u) {
		Parent = (tn.esprit.spring.entities.Parent) u;
	}

	public KinderGartenAdmin getKinderGartenAdmin() {
		return KinderGartenAdmin;
	}

	public void setKinderGartenAdmin(User kinderGartenAdmin) {
		KinderGartenAdmin = (tn.esprit.spring.entities.KinderGartenAdmin) kinderGartenAdmin;
	}

	public Admin getAdmin() {
		return Admin;
	}

	public void setAdmin(Admin admin) {
		Admin = admin;
	}


	public int getNbrLike() {
		return NbrLike;
	}


	public void setNbrLike(int nbrLike) {
		NbrLike = nbrLike;
	}


	public int getNbrDislike() {
		return NbrDislike;
	}


	public void setNbrDislike(int nbrDislike) {
		NbrDislike = nbrDislike;
	}


	


	public int getNbrSignal() {
		return nbrSignal;
	}


	public void setNbrSignal(int nbrSignal) {
		this.nbrSignal = nbrSignal;
	}


	public String getImg() {
		return Img;
	}


	public void setImg(String img) {
		Img = img;
	}
	
	
	
	
	
	

	
	
}
