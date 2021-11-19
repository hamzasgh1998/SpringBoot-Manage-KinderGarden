package tn.esprit.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.repository.ActivitiesRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ActivitiesServiceImpl implements ActivitiesService{

	@Autowired
	ActivitiesRepository ActivitiesRepository; 
	
	@Override
	public List<Activities> retrieveAllActivities() {
		return (List<Activities>) ActivitiesRepository.findAll();

	}

	@Override
	public Activities addActivities(Activities a) {
		return ActivitiesRepository.save(a);
	}

	@Override
	public void deleteActivities(Long id) {
		ActivitiesRepository.deleteById(id);		
	}

	@Override
	public Activities updateActivities(Activities u) {
		return ActivitiesRepository.save(u);

	}

	@Override
	public Activities retrieveActivities(Long id) {
		return ActivitiesRepository.findById(id).get();

	}

	@Override
	public List<Activities> FindActivitiesSortedByName() {
	return ActivitiesRepository.FindActivitiesSortedByName();
	}

	@Override
	public List<Activities> FindActivitiesSortedByHourActivity() {
		return ActivitiesRepository.FindActivitiesSortedByHourActivity();

	}

	@Override
	public List<Activities> FindActivitiesSortedByWeekDay() {
		return ActivitiesRepository.FindActivitiesSortedByWeekDay();

	}

	@Override
	public Long addOrUpdateActivity(Activities Act) {
		ActivitiesRepository.save(Act);
		return Act.getIdActivity();
	}

	@Override
	public List<Activities> FindActivitiesByNameKinderGarten(String Name) {
	return ActivitiesRepository.FindActivitiesByNameKinderGarten(Name);
	}

}
