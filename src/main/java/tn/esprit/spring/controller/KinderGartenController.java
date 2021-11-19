package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.service.KinderGartenService;

@Scope(value = "session")
@Controller(value = "kinderGartenController") // Name of the bean in Spring IoC
@ELBeanName(value = "kinderGartenController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class KinderGartenController {
	
	@Autowired
	KinderGartenService KinderGartenService;
	
	private Long IdKinderGartenToBeUpdated;
	private String NameKinderGarten;
	private String Address;
	private String Descritpion;
	private Date CreationDate;
	private String Tel;
	private int NbEmployees;
	private float Price;
	private String Email;
	private int Capacity;
	private int ReputationComments;
	private int ReputationReclamations;
	private int ReputationRates;
	private boolean Canteenn;
	private List<KinderGarten> KinderGartens;
	public Long getIdKinderGartenToBeUpdated() {
		return IdKinderGartenToBeUpdated;
	}
	public void setIdKinderGartenToBeUpdated(Long idKinderGartenToBeUpdated) {
		IdKinderGartenToBeUpdated = idKinderGartenToBeUpdated;
	}
	public String getNameKinderGarten() {
		return NameKinderGarten;
	}
	public void setNameKinderGarten(String nameKinderGarten) {
		NameKinderGarten = nameKinderGarten;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescritpion() {
		return Descritpion;
	}
	public void setDescritpion(String descritpion) {
		Descritpion = descritpion;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public int getNbEmployees() {
		return NbEmployees;
	}
	public void setNbEmployees(int nbEmployees) {
		NbEmployees = nbEmployees;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public int getReputationComments() {
		return ReputationComments;
	}
	public void setReputationComments(int reputationComments) {
		ReputationComments = reputationComments;
	}
	public int getReputationReclamations() {
		return ReputationReclamations;
	}
	public void setReputationReclamations(int reputationReclamations) {
		ReputationReclamations = reputationReclamations;
	}
	public int getReputationRates() {
		return ReputationRates;
	}
	public void setReputationRates(int reputationRates) {
		ReputationRates = reputationRates;
	}
	public boolean isCanteenn() {
		return Canteenn;
	}
	public void setCanteenn(boolean canteenn) {
		Canteenn = canteenn;
	}
	public List<KinderGarten> getKinderGartens() {
		return KinderGartenService.retrieveKinderGarten();
	}
	public void setKinderGartens(List<KinderGarten> kinderGartens) {
		KinderGartens = kinderGartens;
	}
	
	
	
	
	
	
	public String addKinderGarten() {
		String navigateTo ="null";

	//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		KinderGartenService.addOrUpdateKinderGarten(new KinderGarten(NameKinderGarten, Address, Descritpion, CreationDate, Tel, NbEmployees, Price, Email, Capacity, Canteenn, null)) ;
		return "null"; 
	}  

	public String removeKinderGarten(Long employeId) {
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			KinderGartenService.deleteKinderGarten(employeId);
		return navigateTo; 
	} 

	public String displayKinderGarten(KinderGarten emp) 
	{
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			this.setAddress(emp.getAddress());
			this.setCanteenn(emp.isCanteenn());
this.setCapacity(emp.getCapacity());
this.setCreationDate(emp.getCreationDate());
this.setDescritpion(emp.getDescritpion());
this.setEmail(emp.getEmail());
this.setIdKinderGartenToBeUpdated(emp.getIdKinderGarten());
this.setNbEmployees(emp.getNbEmployees());
this.setPrice(emp.getPrice());
this.setReputationComments(emp.getReputationComments());
this.setReputationRates(emp.getReputationRates());
this.setReputationReclamations(emp.getReputationReclamations());
this.setTel(emp.getTel());

		return navigateTo; 

	} 

	public String updateKinderGarten() 
	{ 
			String navigateTo = "null";
		
		//if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			KinderGartenService.addOrUpdateKinderGarten(new KinderGarten(IdKinderGartenToBeUpdated, NameKinderGarten, Address, Descritpion, CreationDate, Tel, NbEmployees, Price, Email, Capacity, ReputationComments, ReputationReclamations, ReputationRates, Canteenn, null, null, null, null, null)) ;
		
		return navigateTo; 

	} 
	

	
}
