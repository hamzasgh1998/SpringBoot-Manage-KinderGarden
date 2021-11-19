package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.OfferProducts;
import tn.esprit.spring.entities.Products;

public interface OfferProductsService {

	
	OfferProducts addOffer(OfferProducts Offer);

	OfferProducts updateOffer(OfferProducts Offer);

	List<OfferProducts> retrieveAllOffer();



	void DeleteOffer(long id_Offer);

	OfferProducts GetOffer(long idOffer);
	
	
	
}
