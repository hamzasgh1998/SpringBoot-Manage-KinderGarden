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
import tn.esprit.spring.entities.Visitor;
import tn.esprit.spring.service.VisitorService;

@RestController
public class VisitorRestController {

	@Autowired
	VisitorService visitorService;
	
	// http://localhost:8082/SpringMVC/servlet/GetVisitor
	@GetMapping("/GetVisitor")
	 @ResponseBody
	 public List<Visitor> getVisitor() {
	 return visitorService.retrieveAllVisitors();
	 }
	
	// http://localhost:8082/SpringMVC/servlet/retrieveVisitor/{id}
	 @GetMapping("/retrieveVisitor/{id}")
	 @ResponseBody
	 public Visitor retrieveVisitor(@PathVariable("idKid") Long id) {
	 return visitorService.retrieveVisitors(id);
	 }
	
	 // Ajouter User : http://localhost:8082/SpringMVC/servlet/AddVisitor
	 @PostMapping("/AddVisitor")
	 @ResponseBody
	 public Visitor AddVisitor(@RequestBody Visitor v) {
		 visitorService.addOrUpdateVisitor(v);
	 return v;
	 }
	 
		// http://localhost:8082/SpringMVC/servlet/RemoveVisitor/{id}
	  @DeleteMapping("/RemoveVisitor/{id}")
	  @ResponseBody
	  public void RemoveVisitor(@PathVariable("id") Long id) {
		  visitorService.deleteVisitors(id);
	  }
	 
	  // http://localhost:8082/SpringMVC/servlet/ModifyVisitor
	  @PutMapping("/ModifyVisitor")
	  @ResponseBody
	  public Visitor modifyVisitor(@RequestBody Visitor visitor) {
		  visitorService.addOrUpdateVisitor(visitor);
	  return visitor;
	 
	  }
}
