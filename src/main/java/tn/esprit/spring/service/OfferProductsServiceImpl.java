package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Products;
import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.OfferProducts;
import tn.esprit.spring.repository.OfferProductsRepository;
import tn.esprit.spring.repository.ProductsRepository;

@Service
public class OfferProductsServiceImpl implements OfferProductsService{
	
	@Autowired
	OfferProductsRepository offerProductsRepository;
	
	@Autowired
	ProductsRepository productsRepository;


	@Override
	public OfferProducts addOffer(OfferProducts Offer){
		return offerProductsRepository.save(Offer);
	}
	@Override
	public OfferProducts updateOffer(OfferProducts Offer){
	
		return offerProductsRepository.save(Offer);
		
	}
	@Override
	public List<OfferProducts> retrieveAllOffer() {
		return (List<OfferProducts>) offerProductsRepository.findAll();
		}

	
	
	@Override
	public OfferProducts GetOffer( long idOffer) {
		return  offerProductsRepository.findById(idOffer).get();
		}
	@Override
	public void DeleteOffer (long id_Offer){
		offerProductsRepository.deleteById(id_Offer);
	}
	
}

