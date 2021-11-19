package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itextpdf.text.DocumentException;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Events;


public interface EventsService {
	List<Events> retrieveAllEvents();
	Events addEvents(Events u);
	 void deleteEvents(Long id);
	 Events updateEvents(Events u);
	 Events retrieveEvents(Long id);
	
	public List<Events> FindEventsSortedByPriceEvent();
	public Long addOrUpdateEvent(Events E) ;
	public void addphoto(long idpost,String img);
	public boolean Sendmail(long userid) throws DocumentException, IOException;
	 void UserParticipeEvent(Long IdUser,Long IdEvent);

		public int countparticipant(@Param ("id_evt")Long IdEvent);
		public List<Events> FindEventsByNameKinderGarten(String Name);

}

