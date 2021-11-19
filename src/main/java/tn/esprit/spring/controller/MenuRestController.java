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

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.entities.enumerations.Days;
import tn.esprit.spring.service.MenuService;
@RestController
public class MenuRestController {
	@Autowired
	MenuService MenuService;
	// http://localhost:8081/SpringMVC/servlet/getMenu
	@GetMapping("/GetMenu")
	 @ResponseBody
	 public List<Menu> getMenu() {
	 return MenuService.retrieveMenu();
	
	 }

	// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	 @GetMapping("/retrieveMenu/{user-id}")
	 @ResponseBody
	 public Menu retrieveMenu(@PathVariable("user-id") Long userId) {
	 return MenuService.retrieveMenu(userId);
	
	 }

	 // Ajouter User : http://localhost:8081/SpringMVC/servlet/AddActivity
	 @PostMapping("/addMenu")
	 @ResponseBody
	 public String addMenu(@RequestBody Menu u) {
		 MenuService.addOrUpdateMenu(u);

		 return " Menu added";
	 }
	 
	 
	 
	 
	// http://localhost:8081/SpringMVC/servlet/RemoveActivity/{user-id}
	  @DeleteMapping("/removeMenu/{user-id}")
	  @ResponseBody
	  public void removeMenu(@PathVariable("user-id") Long userId) {
		  MenuService.deleteMenu(userId);
	  }
	 
	  // http://localhost:8081/SpringMVC/servlet/ModifyActivity
	  @PutMapping("/modifyMenu")
	  @ResponseBody
	  public Menu modifyMenu(@RequestBody Menu Menu) {
		  MenuService.addOrUpdateMenu(Menu);
	  return Menu;
	 
	  }
	  
	  
		 
	  // http://localhost:8081/SpringMVC/servlet/Calories/day
	  @GetMapping("/Calories/{day}")
	  @ResponseBody
	  public String CountEnergeticsPerDay(@PathVariable("day") String userId) {
		 Float x= MenuService.CountEnergeticsPerDay(userId);
	 // return x;
	  
	  
	  return 				 x+" Calories On "+userId;

	 
	  }
	  
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
		 @GetMapping("/FindMenuByNameKinderGarten/{user-id}")
		 @ResponseBody
		 public List<Menu> 	  FindMenuByNameKinderGarten(@PathVariable("user-id") String userId) {
		 return MenuService.FindMenuByNameKinderGarten(userId);
		
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 @GetMapping("/MenuPerDay/{user-id}")
		 @ResponseBody
		 public List<Menu> 	  MenuPerDay(@PathVariable("user-id") String userId) {
		 return MenuService.MenuPerDay(userId);
		
		 }
		 
		 
}
