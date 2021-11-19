package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.KinderGarten;

@Repository
public interface ActivitiesRepository extends CrudRepository <Activities,Long> {
@Query(value="SELECT * FROM Activities Order By name_activity",nativeQuery =true)
public List<Activities> FindActivitiesSortedByName();
@Query(value="SELECT * FROM Activities Order By week_day",nativeQuery =true)
public List<Activities> FindActivitiesSortedByWeekDay();
@Query(value="SELECT * FROM Activities Order By hour_activity",nativeQuery =true)
public List<Activities> FindActivitiesSortedByHourActivity();




@Query(value="SELECT * FROM Activities where name_activity=?1",nativeQuery =true)
public List<Activities> FindActivitiesByNameKinderGarten(String Name);

}
