package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.service.ActivitiesService;
@RestController
public class ActivitiesRestController {
@Autowired
ActivitiesService ActivitiesService;

	// http://localhost:8081/SpringMVC/servlet/GetActivities
	@GetMapping("/GetActivities")
	 @ResponseBody
	 public List<Activities> getActivities() {
	 return ActivitiesService.retrieveAllActivities();
	
	 }
	@GetMapping("/GetActivitiesByName")
	 @ResponseBody
	 public List<Activities> GetActivitiesByName() {
	 return ActivitiesService.FindActivitiesSortedByName();
	
	 }
	@GetMapping("/GetActivitiesByHourActivity")
	 @ResponseBody
	 public List<Activities> GetActivitiesByHourActivity() {
	 return ActivitiesService.FindActivitiesSortedByHourActivity();
	
	 }
	@GetMapping("/GetActivitiesByWeekDay")
	 @ResponseBody
	 public List<Activities> GetActivitiesByWeekDay() {
	 return ActivitiesService.FindActivitiesSortedByWeekDay();
	
	 }
	
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	 @GetMapping("/retrieveActivity/{user-id}")
	 @ResponseBody
	 public Activities retrieveActivity(@PathVariable("user-id") Long userId) {
	 return ActivitiesService.retrieveActivities(userId);
	
	 }

	 // Ajouter User : http://localhost:8081/SpringMVC/servlet/AddActivity
	 //@PostMapping("/AddActivity")
	 @RequestMapping(value = "/AddActivity" , method= RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	 @ResponseBody
	 public String addActivities(@RequestBody Activities u) {
		 ActivitiesService.addActivities(u);

		 return " Activity added";
	 }
	 
	 
	 
	 
	// http://localhost:8081/SpringMVC/servlet/RemoveActivity/{user-id}
	  @DeleteMapping("/RemoveActivity/{user-id}")
	  @ResponseBody
	  public void removeActivities(@PathVariable("user-id") Long userId) {
		  ActivitiesService.deleteActivities(userId);
	  }
	 
	  // http://localhost:8081/SpringMVC/servlet/ModifyActivity
	  @PutMapping("/ModifyActivity")
	  @ResponseBody
	  public Activities modifyActivities(@RequestBody Activities Activities) {
	  return ActivitiesService.updateActivities(Activities);
	 
	  }
	
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
		 @GetMapping("/FindActivitiesByNameKinderGarten/{user-id}")
		 @ResponseBody
		 public List<Activities> 	  FindActivitiesByNameKinderGarten(@PathVariable("user-id") String userId) {
		 return ActivitiesService.FindActivitiesByNameKinderGarten(userId);
		
		 }
	  
}
