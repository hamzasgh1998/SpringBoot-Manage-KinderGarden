package tn.esprit.spring.controller;

import java.util.Date;
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
import tn.esprit.spring.entities.Events;

import tn.esprit.spring.entities.enumerations.TypeEvent;
import tn.esprit.spring.service.EventsService;

@Scope(value = "session")
@Controller(value = "eventsController") // Name of the bean in Spring IoC
@ELBeanName(value = "eventsController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class EventsController {
	@Autowired
	EventsService EventsService;
	
	
	private Long EventIdToBeUpdated;
	private String NameEvent;
	private TypeEvent TypeEvent;
	private Date DateEvent;
	private int CapacityEvent;
	private float PriceEvent;
	private String Image;

	public TypeEvent[] getTypeEvent(){return TypeEvent.values();}
	private List<Events> Events;
	public EventsService getEventsService() {
		return EventsService;
	}
	public void setEventsService(EventsService eventsService) {
		EventsService = eventsService;
	}
	public Long getEventIdToBeUpdated() {
		return EventIdToBeUpdated;
	}
	public void setEventIdToBeUpdated(Long eventIdToBeUpdated) {
		EventIdToBeUpdated = eventIdToBeUpdated;
	}
	public String getNameEvent() {
		return NameEvent;
	}
	public void setNameEvent(String nameEvent) {
		NameEvent = nameEvent;
	}
	public Date getDateEvent() {
		return DateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		DateEvent = dateEvent;
	}
	public int getCapacityEvent() {
		return CapacityEvent;
	}
	public void setCapacityEvent(int capacityEvent) {
		CapacityEvent = capacityEvent;
	}
	public float getPriceEvent() {
		return PriceEvent;
	}
	public void setPriceEvent(float priceEvent) {
		PriceEvent = priceEvent;
	}
	public List<Events> getEvents() {
		return EventsService.retrieveAllEvents();
	}
	public void setEvents(List<Events> events) {
		Events = events;
	}
	public void setTypeEvent(TypeEvent typeEvent) {
		TypeEvent = typeEvent;
	}
	
	
	public String addEvents() {
		String navigateTo ="null";

	//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		EventsService.addOrUpdateEvent(new Events(NameEvent, TypeEvent, DateEvent, CapacityEvent, PriceEvent,Image));
		return "null"; 
	}  

	public String removeEvents(Long employeId) {
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			EventsService.deleteEvents(employeId);
		return navigateTo; 
	} 

	public String displayEvents(Events emp) 
	{
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			this.setCapacityEvent(emp.getCapacityEvent());
			this.setDateEvent(emp.getDateEvent());
			this.setEventIdToBeUpdated(emp.getIdEvent());
			this.setNameEvent(emp.getNameEvent());
			this.setPriceEvent(emp.getPriceEvent());
			this.setTypeEvent(emp.getTypeEvent());
			
		

		return navigateTo; 

	} 

	public String updateEvents() 
	{ 
			String navigateTo = "null";
		
		//if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			EventsService.addOrUpdateEvent(new Events(EventIdToBeUpdated,NameEvent, TypeEvent, DateEvent, CapacityEvent, PriceEvent,Image));

		return navigateTo; 

	} 


}
