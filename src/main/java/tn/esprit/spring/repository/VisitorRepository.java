package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.*;


@Repository
public interface VisitorRepository extends CrudRepository<Visitor,Long> {

}
