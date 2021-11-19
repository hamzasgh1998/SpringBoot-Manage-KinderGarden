package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Category_Products;

@Repository
public interface CategoryRepository extends CrudRepository <Category_Products,Long>  {
	


}
