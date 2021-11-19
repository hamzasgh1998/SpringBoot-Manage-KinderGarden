package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Activities;


public interface ActivitiesService {
	public List<Activities> retrieveAllActivities();
	Activities addActivities(Activities a);
	 void deleteActivities(Long id);
	 Activities updateActivities(Activities u);
	 Activities retrieveActivities(Long id);
	 public List<Activities> FindActivitiesSortedByName();
	 public List<Activities> 	 FindActivitiesSortedByHourActivity();
	 public List<Activities> 	 FindActivitiesSortedByWeekDay();
	public Long addOrUpdateActivity(Activities Act) ;
	public List<Activities> FindActivitiesByNameKinderGarten(String Name);
}
