package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Kid")
public class Kid implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idKid")
	private Long idKid;
	
	@Column(name="nameKid")
	private String nameKid;
	
	@Column(name="lastNameKid")
	private String lastNameKid;
	
	@Column(name="dateBirthKid")
	private Date dateBirthKid;
	
	@Column(name="addressKid")
	private String addressKid;
	
	@ManyToOne
	Parent Parent;
	

	public Parent getParent() {
		return Parent;
	}

	public void setParent(Parent parent) {
		Parent = parent;
	}



	public Long getIdKid() {
		return idKid;
	}

	public void setIdKid(Long idKid) {
		this.idKid = idKid;
	}

	public String getNameKid() {
		return nameKid;
	}

	public void setNameKid(String nameKid) {
		this.nameKid = nameKid;
	}

	public String getLastNameKid() {
		return lastNameKid;
	}

	public void setLastNameKid(String lastNameKid) {
		this.lastNameKid = lastNameKid;
	}

	public Date getDateBirthKid() {
		return dateBirthKid;
	}

	public void setDateBirthKid(Date dateBirthKid) {
		this.dateBirthKid = dateBirthKid;
	}

	public String getAddressKid() {
		return addressKid;
	}

	public void setAddressKid(String addressKid) {
		this.addressKid = addressKid;
	}
	


	@Override
	public String toString() {
		return "Kid [idKid=" + idKid + ", nameKid=" + nameKid + ", lastNameKid=" + lastNameKid + ", dateBirthKid="
				+ dateBirthKid + ", addressKid=" + addressKid + ", Parent=" + Parent.getIdUser() + "]";
	}

	public Kid() {
	}
	
	public Kid(Long idKid, String nameKid, String lastNameKid, Date dateBirthKid, String addressKid) {
		super();
		this.idKid = idKid;
		this.nameKid = nameKid;
		this.lastNameKid = lastNameKid;
		this.dateBirthKid = dateBirthKid;
		this.addressKid = addressKid;
	}
	
	public Kid(String nameKid, String lastNameKid, Date dateBirthKid, String addressKid) {
		super();
		this.nameKid = nameKid;
		this.lastNameKid = lastNameKid;
		this.dateBirthKid = dateBirthKid;
		this.addressKid = addressKid;
	}

	public Kid(String nameKid, String lastNameKid, Date dateBirthKid, String addressKid,
			tn.esprit.spring.entities.Parent parent) {
		super();
		this.nameKid = nameKid;
		this.lastNameKid = lastNameKid;
		this.dateBirthKid = dateBirthKid;
		this.addressKid = addressKid;
		Parent = parent;
	}



	
	
	
	

}
