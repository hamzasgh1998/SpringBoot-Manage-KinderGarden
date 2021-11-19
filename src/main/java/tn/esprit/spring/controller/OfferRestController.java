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


import tn.esprit.spring.entities.OfferProducts;
import tn.esprit.spring.service.OfferProductsService;

@RestController
public class OfferRestController {
	
	
	
	@Autowired
	OfferProductsService offerProductsService;
	
	@GetMapping("/GetAllOffer")
	 @ResponseBody
	 public List<OfferProducts>GetAllOffer() {
	 return offerProductsService.retrieveAllOffer();
	}
	@GetMapping("/GetOffer/{Offer-id}")
	 @ResponseBody
	 public OfferProducts GetOffer(@PathVariable("Offer-id") Long OfferId) {
	 return offerProductsService.GetOffer(OfferId);
	}
	
	 @DeleteMapping("/RemoveOffer/{Offer-id}")
	  @ResponseBody
	  public void RemoveOffer(@PathVariable("Offer-id") Long OfferId) {
		 offerProductsService.DeleteOffer(OfferId);
	  }
	 
	 @PutMapping("/UpdateOffer")
	  @ResponseBody
	  public OfferProducts UpdateOffer(@RequestBody OfferProducts OP) {
	  return offerProductsService.updateOffer(OP);
	 
	  }
	 @PostMapping("/AddOffer")
	 
	 @ResponseBody
	 public OfferProducts AddOffer(@RequestBody OfferProducts OP) {
	offerProductsService.addOffer(OP);
	 return OP;
	 }
}
