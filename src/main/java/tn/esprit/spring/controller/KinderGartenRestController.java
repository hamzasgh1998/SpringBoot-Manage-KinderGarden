package tn.esprit.spring.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.service.KinderGartenService;
@RestController
public class KinderGartenRestController {
	@Autowired
	KinderGartenService KinderGartenService;
	
	// http://localhost:8081/SpringMVC/servlet/KinderGarten
	@GetMapping("/GetKinderGarten")
	 @ResponseBody
	 public List<KinderGarten> getKinderGarten() {
	 return KinderGartenService.retrieveKinderGarten();
	
	 }
	
	
	

	// http://localhost:8081/SpringMVC/servlet/OrderByAddress
	@GetMapping("/OrderByAddress")
	 @ResponseBody
	 public List<String> OrderByAddress() {
	 return KinderGartenService.OrderByAddress();
	
	 }
	
	
	 
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	 @GetMapping("/RetrieveKinderGarten/{user-id}")
	 @ResponseBody
	 public KinderGarten retrieveKinderGarten(@PathVariable("user-id") Long userId) {
	 return KinderGartenService.retrieveKinderGarten(userId);
	
	 }

	 // Ajouter User : http://localhost:8081/SpringMVC/servlet/AddActivity
	 @PostMapping("/AddKinderGarten")
	 @ResponseBody
	 public String addKinderGarten(@RequestBody KinderGarten u) {
		 KinderGartenService.addOrUpdateKinderGarten(u);

	 return "Kinder Garten added";
	 }
	 
	 
	 
	 
	// http://localhost:8081/SpringMVC/servlet/RemoveActivity/{user-id}
	  @DeleteMapping("/removeKinderGarten/{user-id}")
	  @ResponseBody
	  public String removeKinderGarten(@PathVariable("user-id") Long userId) {
		  KinderGartenService.deleteKinderGarten(userId);
			 return "Kinder Garten removed";

	  }
	 
	  // http://localhost:8081/SpringMVC/servlet/ModifyActivity
	  @PutMapping("/ModifyKinderGarten")
	  @ResponseBody
	  public KinderGarten ModifyKinderGarten(@RequestBody KinderGarten KinderGarten) {
		  KinderGartenService.addOrUpdateKinderGarten(KinderGarten);
	  return KinderGarten;
	 
	  }
	  
	  
	  
	  
	  
	  @PutMapping("/affecterEventAKinderGarten/{user-id1}/{user-id}")
	  @ResponseBody
	  public String affecterEventAKinderGarten(@PathVariable("user-id1") Long userId1,@PathVariable("user-id") Long userId) {
		  KinderGartenService.affecterEventAKinderGarten(userId1,userId);
	 return "Event affected to the kindergarten with succes";
	  }
	  
	  
	  
	  
	  
	  
	  @PutMapping("/affecterActivityAKinderGarten/{user-id1}/{user-id}")
	  @ResponseBody
	  public String affecterActivityAKinderGarten(@PathVariable("user-id1") Long userId1,@PathVariable("user-id") Long userId) {
		  KinderGartenService.affecterActivityAKinderGarten(userId1,userId);
			 return "Activity affected to the kindergarten with succes";

	  }
	  
	  
	  
	  
	  
	  
	  
	  @PutMapping("/affecterMenuAKinderGarten/{user-id1}/{user-id}")
	  @ResponseBody
	  public String affecterMenuAKinderGarten(@PathVariable("user-id1") Long userId1,@PathVariable("user-id") Long userId) {
		  KinderGartenService.affecterMenuAKinderGarten(userId1,userId);
			 return "Menu affected to the kindergarten with succes";

	  }
	  
	  
	  
	  
	  
		
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
		 @GetMapping("/FindKinderGartenByNameKinderGarten/{user-id}")
		 @ResponseBody
		 public List<KinderGarten> 	  FindKinderGartenByNameKinderGarten(@PathVariable("user-id") String userId) {
		 return KinderGartenService.FindKinderGartenByNameKinderGarten(userId);
		
		 }
	  
	  
	  
}
