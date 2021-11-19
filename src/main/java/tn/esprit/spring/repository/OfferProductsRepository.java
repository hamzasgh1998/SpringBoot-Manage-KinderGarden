package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.OfferProducts;

@Repository
public interface OfferProductsRepository extends CrudRepository<OfferProducts, Long> {
	

}
