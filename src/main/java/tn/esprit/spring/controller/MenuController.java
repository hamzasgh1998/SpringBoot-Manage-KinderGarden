package tn.esprit.spring.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.entities.enumerations.Days;
import tn.esprit.spring.entities.enumerations.Plat;
import tn.esprit.spring.entities.enumerations.TypeActivity;
import tn.esprit.spring.service.MenuService;

@Scope(value = "session")
@Controller(value = "menuController") // Name of the bean in Spring IoC
@ELBeanName(value = "menuController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class MenuController {

	@Autowired
	MenuService MenuService;
	
	private Long IdMenuToBeUpdated;
	private Plat Plat;
	private Days Day;
	private float Energetic_value;
	
	
	
	public Plat[] getPlat() {return Plat.values();}
	public Days[] getDay() {return Day.values();}
	
	private List<tn.esprit.spring.entities.Menu> Menu;



	public Long getIdMenuToBeUpdated() {
		return IdMenuToBeUpdated;
	}
	public void setIdMenuToBeUpdated(Long idMenuToBeUpdated) {
		IdMenuToBeUpdated = idMenuToBeUpdated;
	}
	public float getEnergetic_value() {
		return Energetic_value;
	}
	public void setEnergetic_value(float energetic_value) {
		Energetic_value = energetic_value;
	}
	public List<tn.esprit.spring.entities.Menu> getMenu() {
		return MenuService.retrieveMenu();
	}
	public void setMenu(List<tn.esprit.spring.entities.Menu> menu) {
		Menu = menu;
	}
	public void setPlat(Plat plat) {
		Plat = plat;
	}
	public void setDay(Days day) {
		Day = day;
	}
	
	

	
	
	
	public String addMenu() {
		String navigateTo ="null";

	//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		MenuService.addOrUpdateMenu(new tn.esprit.spring.entities.Menu(Plat, Day, Energetic_value, null)) ;
		return "null"; 
	}  

	public String removeMenu(Long employeId) {
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			MenuService.deleteMenu(employeId);
		return navigateTo; 
	} 

	public String displayMenu(Menu emp) 
	{
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		this.setDay(emp.getDay());
		this.setIdMenuToBeUpdated(emp.getIdMenu());
		this.setPlat(emp.getPlat());
		this.setEnergetic_value(emp.getEnergetic_value());		

		return navigateTo; 

	} 

	public String updateMenu() 
	{ 
			String navigateTo = "null";
		
		//if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			MenuService.addOrUpdateMenu(new tn.esprit.spring.entities.Menu(IdMenuToBeUpdated, Plat, Day, Energetic_value, null) {
			}) ;
		
		return navigateTo; 

	} 
	

}
