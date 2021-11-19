package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.KinderGarten;
@Repository
public interface KinderGartenRepository extends CrudRepository <KinderGarten,Long>{
	@Query(value="SELECT address,name_kinder_garten FROM kinder_garten Group By name_kinder_garten Order By address",nativeQuery =true)
	public List<String> OrderByAddress();
	
	
	@Query(value="SELECT * FROM kinder_garten where name_kinder_garten=?1",nativeQuery =true)
	public List<KinderGarten> FindKinderGartenByNameKinderGarten(String Name);

}
