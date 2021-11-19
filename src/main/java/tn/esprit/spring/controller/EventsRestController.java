package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EventsRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.EventsService;
import tn.esprit.spring.service.UserService;
 	 	
@RestController
public class EventsRestController {
	@Autowired
	EventsService EventsService;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	EventsRepository EventsRepository;
	// http://localhost:8081/SpringMVC/servlet/GetActivities
		@GetMapping("/GetEvents")
		 @ResponseBody
		 public List<Events> getActivities() {
		 return EventsService.retrieveAllEvents();
		
		 }
		
	
		
		@GetMapping("/GetEventsByPrice")
		 @ResponseBody
		 public List<Events> GetEventsByPrice() {
		 return EventsService.FindEventsSortedByPriceEvent();
		
		 }
	
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
		 @GetMapping("/retrieveEvents/{user-id}")
		 @ResponseBody
		 public Events retrieveActivity(@PathVariable("user-id") Long userId) {
		 return EventsService.retrieveEvents(userId);
		
		 }

		 // Ajouter User : http://localhost:8081/SpringMVC/servlet/AddActivity
		 @PostMapping("/AddEvents")
		 @ResponseBody
		 public String addActivities(@RequestBody Events u) {
			 EventsService.addOrUpdateEvent(u);

			 return " Event added";
		 }
		 
		 
		 
		 
		// http://localhost:8081/SpringMVC/servlet/RemoveActivity/{user-id}
		  @DeleteMapping("/RemoveEvents/{user-id}")
		  @ResponseBody
		  public String removeActivities(@PathVariable("user-id") Long userId) {
			  EventsService.deleteEvents(userId);
			  return "Event Removed";
		  }
		 
		  // http://localhost:8081/SpringMVC/servlet/ModifyActivity
		  @PutMapping("/ModifyEvents")
		  @ResponseBody
		  public Events modifyActivities(@RequestBody Events Events) {
		   EventsService.addOrUpdateEvent(Events);
		  return Events;
		 
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		//upload file
			//http://localhost:8082/SpringMVC/servlet/sendmail/upload/file/{post-id}
			@PostMapping(value = "/uploadImageForEvent/file/{post-id}",
				     consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
				     produces = {MediaType.APPLICATION_JSON_VALUE} )
			 @ResponseBody
				public ResponseEntity<String> uploadSingleFile(@RequestParam MultipartFile file ,@PathVariable("post-id") Long eventid)  {
				 // l.info("Request contains, File: " + file.getOriginalFilename());
				  // Add your processing logic here
				  
				  String s=("C:/pdf/image/"+file.getOriginalFilename());
				  EventsService.addphoto(eventid, s);
				  return ResponseEntity.ok("Success");
				}
		  
		  
			//Send mail
			//http://localhost:8082/SpringMVC/servlet/sendmail/
			@GetMapping("/sendmailForEvent/{user-id}")
			 @ResponseBody
			 public String SendMail(@PathVariable("user-id") Long userid) {
			 try {
				if(EventsService.Sendmail(userid))
					 return "mail sent";
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return "not sent";
			
			 }

		  
		  
			  
			  @PutMapping("/UserParticipeEvent/{user-id1}/{user-id}")
			  @ResponseBody
			  public String UserParticipeEvent(@PathVariable("user-id1") Long userId1,@PathVariable("user-id") Long userId) {
				  EventsService.UserParticipeEvent(userId1,userId);
				  Events E=EventsRepository.findById(userId).get();
				  return "User"+userId1+"has participed to the event  "+E.getNameEvent(); 
				  
			 
			  }
			  
			  
			  
			  
			  @GetMapping("/NbrParticipantParEvent/{user-id}")
			  @ResponseBody
			  public String countparticipant(@PathVariable("user-id") Long userId) {
				  
				  EventsService.countparticipant(userId);
				  int nb=				  EventsService.countparticipant(userId);
				  Events EventEntity= EventsRepository.findById(userId).get();

				  int total=nb+EventEntity.getCapacityEvent();

				  return 				  EventsService.countparticipant(userId)+" Participants dans l'evenement "+EventEntity.getNameEvent()+" Parmi "+total;

			 
			  }
			  
			  
			  
			  
				// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
				 @GetMapping("/FindEventsByNameKinderGarten/{user-id}")
				 @ResponseBody
				 public List<Events> 	  FindEventsByNameKinderGarten(@PathVariable("user-id") String userId) {
				 return EventsService.FindEventsByNameKinderGarten(userId);
				
				 }
			  
		
}
