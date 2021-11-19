package tn.esprit.spring.controller;

import java.util.Date;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Kid;
import tn.esprit.spring.service.KidService;

@Scope(value = "session")
@Controller(value = "kidController") // Name of the bean in Spring IoC
@ELBeanName(value = "kidController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class KidController {

	@Autowired
	KidService kidService;
	
	private Long kidIdToBeUpdated;
	private String nameKid;
	private String lastNameKid;
	private String adresse;
	private Date dateBirthKid;
	public KidService getKidService() {
		return kidService;
	}
	public void setKidService(KidService kidService) {
		this.kidService = kidService;
	}
	public Long getKidIdToBeUpdated() {
		return kidIdToBeUpdated;
	}
	public void setKidIdToBeUpdated(Long kidIdToBeUpdated) {
		this.kidIdToBeUpdated = kidIdToBeUpdated;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateBirthKid() {
		return dateBirthKid;
	}
	public void setDateBirthKid(Date dateBirthKid) {
		this.dateBirthKid = dateBirthKid;
	}
	
	public String addKid() {
		kidService.addOrUpdateKid(new Kid(nameKid, lastNameKid, dateBirthKid, adresse));
		return "null"; 
	} 
	
	public String removeKid(Long kidId) {
		String navigateTo = "null";
	//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";
		kidService.deleteKids(kidId);
	return navigateTo; 
}
	
	public String updateKid() 
	{ 
			String navigateTo = "null";	
		//if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";
			kidService.addOrUpdateKid(new Kid(nameKid,lastNameKid, dateBirthKid, adresse));
		return navigateTo; 

	} 
	
	public String displayKid(Kid kid) 
	{
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			this.setNameKid(kid.getNameKid());
			this.setLastNameKid(kid.getLastNameKid());
			this.setDateBirthKid(kid.getDateBirthKid());
			this.setAdresse(kid.getAddressKid());
			
		return navigateTo; 

	} 
}
