package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.repository.ActivitiesRepository;
import tn.esprit.spring.repository.EventsRepository;
import tn.esprit.spring.repository.KinderGartenRepository;
import tn.esprit.spring.repository.MenuRepository;

@Service
public class KinderGartenServiceImpl implements KinderGartenService {
	@Autowired
	KinderGartenRepository KinderGartenRepository;
	@Autowired
	MenuRepository MenuRepository;
	@Autowired
	ActivitiesRepository ActivitiesRepository;
	@Autowired
	EventsRepository EventsRepository;
	@Override
	public List<KinderGarten> retrieveKinderGarten() {
		return (List<KinderGarten>) KinderGartenRepository.findAll();

	}

	@Override
	public KinderGarten addKinderGarten(KinderGarten u) {
	return	KinderGartenRepository.save(u);
	}

	@Override
	public void deleteKinderGarten(Long id) {
		KinderGartenRepository.deleteById(id);		
	}

	@Override
	public KinderGarten updateKinderGarten(KinderGarten u) {
		return	KinderGartenRepository.save(u);

	}

	@Override
	public KinderGarten retrieveKinderGarten(Long id) {
		return KinderGartenRepository.findById(id).get();

	}

	@Override
	public void affecterMenuAKinderGarten(Long IdMenu, Long IdKinderGarten) {
		KinderGarten KinderEntity = KinderGartenRepository.findById(IdKinderGarten).get();
		Menu MenuEntity = MenuRepository.findById(IdMenu).get();
		MenuEntity.setKinderGarten(KinderEntity);
		MenuRepository.save(MenuEntity);
	}

	@Override
	public void affecterActivityAKinderGarten(Long IdAct, Long IdKinderGarten) {
		KinderGarten KinderEntity = KinderGartenRepository.findById(IdKinderGarten).get();
		Activities ActivitiesEntity = ActivitiesRepository.findById(IdAct).get();
		ActivitiesEntity.setKinderGarten(KinderEntity);
		ActivitiesRepository.save(ActivitiesEntity);
	}

	@Override
	public void affecterEventAKinderGarten(Long IdEvt, Long IdKinderGarten) {
		KinderGarten KinderEntity = KinderGartenRepository.findById(IdKinderGarten).get();
		Events EventsEntity = EventsRepository.findById(IdEvt).get();
		EventsEntity.setKinderGarten(KinderEntity);
		EventsRepository.save(EventsEntity);
	}

	

	@Override
	public Long addOrUpdateKinderGarten(KinderGarten KG) {
		KinderGartenRepository.save(KG);
		return KG.getIdKinderGarten();
	}

	@Override
	public List<String> OrderByAddress() {
		return KinderGartenRepository.OrderByAddress();
	}

	@Override
	public List<KinderGarten> FindKinderGartenByNameKinderGarten(String Name) {
		return KinderGartenRepository.FindKinderGartenByNameKinderGarten(Name);
	}


}
