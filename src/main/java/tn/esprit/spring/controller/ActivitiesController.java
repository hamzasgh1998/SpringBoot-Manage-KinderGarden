package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.enumerations.Days;
import tn.esprit.spring.entities.enumerations.TypeActivity;
import tn.esprit.spring.service.ActivitiesService;
@Scope(value = "session")
@Controller(value = "activitiesController") // Name of the bean in Spring IoC
@ELBeanName(value = "activitiesController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class ActivitiesController {
@Autowired
ActivitiesService ActivitiesService;
	private String NameActivity;
	private TypeActivity TypeActivity;
	private Days WeekDay;
	private Date HourActivity;
	private String teacher;
	
	public TypeActivity[] getTypeActivity() {return TypeActivity.values();}
	public Days[] getWeekDay() {return WeekDay.values();}
	private List<Activities> Activities;
	private Long ActivityIdToBeUpdated; // getter et setter

	public String getNameActivity() {
		return NameActivity;
	}
	public void setNameActivity(String nameActivity) {
		NameActivity = nameActivity;
	}
	public Date getHourActivity() {
		return HourActivity;
	}
	public void setHourActivity(Date hourActivity) {
		HourActivity = hourActivity;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public List<Activities> getActivities() {
		return ActivitiesService.retrieveAllActivities();
	}
	public void setActivities(List<Activities> activities) {
		Activities = activities;
	}
	public Long getActivityIdToBeUpdated() {
		return ActivityIdToBeUpdated;
	}
	public void setActivityIdToBeUpdated(Long activityIdToBeUpdated) {
		ActivityIdToBeUpdated = activityIdToBeUpdated;
	}
	public void setTypeActivity(TypeActivity typeActivity) {
		TypeActivity = typeActivity;
	}
	public void setWeekDay(Days weekDay) {
		WeekDay = weekDay;
	}

	
	
	
	
	
	public String addActivity() {
		String navigateTo ="null";

	//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		ActivitiesService.addOrUpdateActivity(new Activities(NameActivity, TypeActivity, WeekDay, HourActivity, teacher)) ;
		return "null"; 
	}  

	public String removeActivity(Long employeId) {
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			ActivitiesService.deleteActivities(employeId);
		return navigateTo; 
	} 

	public String displayActivity(Activities emp) 
	{
			String navigateTo = "null";
		//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			this.setNameActivity(emp.getNameActivity());
			this.setHourActivity(emp.getHourActivity());
			this.setTypeActivity(emp.getTypeActivity());
			this.setTeacher(emp.getTeacher());
			this.setWeekDay(emp.getWeekDay());
			this.setActivityIdToBeUpdated(emp.getIdActivity());
		

		return navigateTo; 

	} 

	public String updateActivity() 
	{ 
			String navigateTo = "null";
		
		//if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			ActivitiesService.addOrUpdateActivity(new Activities(ActivityIdToBeUpdated, NameActivity, TypeActivity, WeekDay, HourActivity, teacher, null));
		
		return navigateTo; 

	} 



}
