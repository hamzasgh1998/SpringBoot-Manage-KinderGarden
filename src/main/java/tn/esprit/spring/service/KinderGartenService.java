package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.KinderGarten;


public interface KinderGartenService {
	List<KinderGarten> retrieveKinderGarten();
	KinderGarten addKinderGarten(KinderGarten u);
	 void deleteKinderGarten(Long id);
	 KinderGarten updateKinderGarten(KinderGarten u);
	 KinderGarten retrieveKinderGarten(Long id);
	 void affecterMenuAKinderGarten(Long IdMenu,Long IdKinderGarten);
	 void affecterActivityAKinderGarten(Long IdAct,Long IdKinderGarten);
	 void  affecterEventAKinderGarten(Long IdEvt,Long IdKinderGarten);
		public List<KinderGarten> FindKinderGartenByNameKinderGarten(String Name);

	 
	

		
		public Long addOrUpdateKinderGarten(KinderGarten KG) ;
		public List<String> OrderByAddress();
	 
	 
	 
	 
}
