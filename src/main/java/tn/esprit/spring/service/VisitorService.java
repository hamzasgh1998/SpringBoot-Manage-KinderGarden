package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.*;

public interface VisitorService {
	 List<Visitor> retrieveAllVisitors();
	 Visitor addVisitor(Visitor v);
	 void deleteVisitors(Long id);
	 Visitor updateVisitors(Visitor v);
	 Visitor retrieveVisitors(Long id);
	 
	 public Long addOrUpdateVisitor(Visitor visitor);

}
