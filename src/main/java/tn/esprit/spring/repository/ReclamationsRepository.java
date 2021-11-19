package tn.esprit.spring.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;

@Repository
public interface ReclamationsRepository extends CrudRepository<Reclamation, Long> {

	@Query(value="SELECT * FROM Reclamation where type_reclamation= ?1",nativeQuery =true)
	public List<Reclamation> findByTypeReclamation(String type);
	
	@Query(value="SELECT * FROM Reclamation where statue= ?1",nativeQuery =true)
	public List<Reclamation> findByStatue(boolean statue);
	
	@Query(value="SELECT * FROM Reclamation Order By reclamation_date",nativeQuery =true)
	public List<Reclamation> FindReclamationSortedByDate();
}
