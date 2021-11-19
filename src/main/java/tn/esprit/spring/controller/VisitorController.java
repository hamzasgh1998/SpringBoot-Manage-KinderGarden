package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entities.Visitor;
import tn.esprit.spring.service.VisitorService;

@Scope(value = "session")
@Controller(value = "visitorController") // Name of the bean in Spring IoC
@ELBeanName(value = "visitorController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class VisitorController {

	@Autowired
	VisitorService visitorService;
	
	private Long visitorIdToBeUpdated;
	private String adresseIp;
	public VisitorService getVisitorService() {
		return visitorService;
	}
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}
	public Long getVisitorIdToBeUpdated() {
		return visitorIdToBeUpdated;
	}
	public void setVisitorIdToBeUpdated(Long visitorIdToBeUpdated) {
		this.visitorIdToBeUpdated = visitorIdToBeUpdated;
	}
	public String getAdresseIp() {
		return adresseIp;
	}
	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}
	
	public String addVisitor() {
		visitorService.addOrUpdateVisitor(new Visitor(adresseIp));
		return "null"; 
	} 
	
	public String removeVisitor(Long id) {
		String navigateTo = "null";
	//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";
		visitorService.deleteVisitors(id);
	return navigateTo; 
}
	
	public String updateVisitor() 
	{ 
			String navigateTo = "null";	
		//if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";
			visitorService.addOrUpdateVisitor(new Visitor(adresseIp));
		return navigateTo; 
	} 
	
	public String displayVisitor(Visitor visitor) 
	{
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";
			this.setAdresseIp(visitor.getAdresseIp());
		return navigateTo; 

	} 
}
