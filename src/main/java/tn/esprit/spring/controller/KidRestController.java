package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Kid;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.*;

@RestController
public class KidRestController {
	@Autowired
	KidService kidService;
	
	// http://localhost:8082/SpringMVC/servlet/GetKid
	@GetMapping("/GetKid")
	 @ResponseBody
	 public List<Kid> getKid() {
	 return kidService.retrieveAllKids();
	 }
	
	// http://localhost:8082/SpringMVC/servlet/retrieveKid/{idKid}
	 @GetMapping("/retrieveKid/{idKid}")
	 @ResponseBody
	 public Kid retrieveKid(@PathVariable("idKid") Long idKid) {
	 return kidService.retrieveKids(idKid);
	 }
	 
	 // Ajouter User : http://localhost:8082/SpringMVC/servlet/AddActivity
	 @PostMapping("/AddKid")
	 @ResponseBody
	 public Kid addKid(@RequestBody Kid k) {
		 kidService.addOrUpdateKid(k);
	 return k;
	 }
	 
		// http://localhost:8082/SpringMVC/servlet/RemoveKid/{idKid}
	  @DeleteMapping("/RemoveKid/{idKid}") 
	  @ResponseBody
	  public void removeKid(@PathVariable("idKid") Long idKid) {
		  kidService.deleteKids(idKid);
	  }
	 
	  // http://localhost:8082/SpringMVC/servlet/ModifyKid
	  @PutMapping("/ModifyKid")
	  @ResponseBody
	  public Kid modifyKid(@RequestBody Kid kid) {
		  kidService.addOrUpdateKid(kid);
	  return kid;
	 
	  }
	  
	  // http://localhost:8081/SpringMVC/servlet/FindKidSortedByAdressKid
		 @GetMapping("/FindKidSortedByAdressKid")
		 @ResponseBody
		 public List<Kid> FindKidSortedByAdressKid() {
			return kidService.FindKidSortedByAdressKid();
				
		 }
		 
		  // http://localhost:8081/SpringMVC/servlet/FindKidSortedByNameKid
			 @GetMapping("/FindKidSortedByNameKid")
			 @ResponseBody
			 public List<Kid> FindKidSortedByNameKid() {
				return kidService.FindKidSortedByNameKid();
					
			 }
}
