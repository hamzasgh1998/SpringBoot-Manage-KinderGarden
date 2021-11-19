package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Events;
@Repository
public interface EventsRepository extends CrudRepository <Events,Long>{

	@Query(value="SELECT * FROM Events Order By price_event",nativeQuery =true)
	public List<Events> FindEventsSortedByPriceEvent();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Events p  SET IMAGE = :img where p.ID_EVENT = :id_post",nativeQuery = true)
	public int addPhoto(@Param ("id_post")Long IdPost,@Param ("img") String img);

	@Query(value="	SELECT COUNT(*) FROM User u where u.events_id_event=:id_evt",nativeQuery =true)
	public int countparticipant(@Param ("id_evt")Long IdEvent);

	

@Query(value="SELECT * FROM Events where name_event=?1",nativeQuery =true)
public List<Events> FindEventsByNameKinderGarten(String Name);
	
}
