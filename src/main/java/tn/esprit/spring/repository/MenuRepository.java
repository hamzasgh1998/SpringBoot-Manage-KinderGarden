package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.entities.enumerations.Days;

public interface MenuRepository extends CrudRepository <Menu,Long> {
	@Query(value="SELECT SUM(energetic_value) FROM Menu Where day= ?1",nativeQuery =true)
	public float CountEnergeticsPerDay(String d);
	@Query(value="SELECT * FROM Menu Where day= ?1",nativeQuery =true)
	public List<Menu> MenuPerDay(String d);
	
	
	
	@Query(value="SELECT * FROM Menu where plat=?1",nativeQuery =true)
	public List<Menu> FindMenuByNameKinderGarten(String Name);
}
