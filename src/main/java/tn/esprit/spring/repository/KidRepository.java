package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Kid;
import tn.esprit.spring.entities.User;

@Repository
public interface KidRepository extends CrudRepository<Kid,Long>{

	@Query(value="SELECT * FROM kid Order By address_kid",nativeQuery =true)
	public List<Kid> FindKidSortedByAdressKid();
	
	@Query(value="SELECT * FROM kid Order By name_kid",nativeQuery =true)
	public List<Kid> FindKidSortedByNameKid();
}
