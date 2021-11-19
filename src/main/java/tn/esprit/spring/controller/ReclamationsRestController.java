package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.repository.KinderGartenRepository;
import tn.esprit.spring.repository.ReclamationsRepository;
import tn.esprit.spring.service.NotificationRecService;
import tn.esprit.spring.service.ReclamationsService;

@RestController
public class ReclamationsRestController {
	
	private Logger logger=LoggerFactory.getLogger(ReclamationsRestController.class);
	
	@Autowired
	ReclamationsService service;
	
	@Autowired
	private KinderGartenRepository kinderGartenRepository;
	
	@Autowired
	private ReclamationsRepository reclamationsRepository;
	
	@Autowired
	private NotificationRecService notificationRecService;
	
	@PostMapping("/addReclamation")
	@ResponseBody
	public String addReclamation(@RequestBody Reclamation rec){
		//return service.addReclamation(rec);
		service.addReclamation(rec);
		String email="yesmine.feki@esprit.tn";
		try{
			notificationRecService.sendNotification(email);
		}catch(MailException e){
			logger.info("Error sending email:"+ e.getMessage());
		}
		return"Success!";
	}
	
	@PostMapping("/addReclamations")
	@ResponseBody
	public List<Reclamation> addReclamations(@RequestBody List<Reclamation> recs){
		return service.addReclamations(recs);
	}
	
	@GetMapping("/reclamations")
	@ResponseBody
	public List<Reclamation> findAllRecalamtions(){
		return reclamationsRepository.FindReclamationSortedByDate();
		//return service.getAllReclamations();
	}
	
	@GetMapping("/findReclamationById/{id}")
	@ResponseBody
	public Reclamation findReclamationById(@PathVariable Long id){
		return service.getReclamationById(id);
	}
	
	@GetMapping("/getReclamationByType/{type}")
	@ResponseBody
	public List<Reclamation> getReclamationByType(@PathVariable String type){
		return service.findByTypeReclamation(type);
	}
	
	@GetMapping("/getReclamationByStatue/{statue}")
	@ResponseBody
	public List<Reclamation> getReclamationByStatue(@PathVariable boolean statue){
		return service.findByStatue(statue);
	}
	
//	public List<Reclamation> findAll(@RequestParam Optional<Long> id){
//		return reclamationsRepository.findByIdReclamation(id.orElse(1), new PageRequest(0,2));
//	}
	
	@PutMapping("/update")
	@ResponseBody
	public Reclamation updateReclamation(@RequestBody Reclamation rec){
		return service.updateReclamation(rec);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteReclamation(@PathVariable Long id){
		return service.deleteReclamation(id);
	}
	
	@GetMapping("/addReputationComments/{id1}/{id2}")
	@ResponseBody
	public String addReputationComments(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2){
		service.addReputationComments(id1,id2);
		return "success";
	}
	
	@GetMapping("/addReputationRates/{id1}/{id2}")
	@ResponseBody
	public String addReputationRates(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2){
		service.addReputationRates(id1,id2);
		return "success";
	}
	
	@GetMapping("/addReputationReclamations/{id1}/{id2}")
	@ResponseBody
	public String addReputationReclamations(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2){
		service.addReputationReclamations(id1,id2);
		return "success";
	}
	
	@GetMapping("/getReputationByKinderGarten/{id}")
	@ResponseBody
	public String getReputationByKinderGarten(@PathVariable("id") Long id){
		KinderGarten kinder=kinderGartenRepository.findById(id).get();
		return "the kindergarten "+kinder.getNameKinderGarten()+" has "+kinder.getReputationComments()+
		" comments "+kinder.getReputationRates()+" rates "+kinder.getReputationReclamations()+" reclamations";
	}
}
