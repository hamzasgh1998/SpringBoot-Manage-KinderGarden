package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements VisitorService{

	@Autowired
	VisitorRepository visitorRepository;
	
	@Override
	public List<Visitor> retrieveAllVisitors() {
	return (List<Visitor>) visitorRepository.findAll();
	}
	
	@Override
	public Visitor addVisitor(Visitor v) {
		return visitorRepository.save(v);
	}
	
	@Override
	public void deleteVisitors(Long id) {
		visitorRepository.deleteById(id);		
	}
	
	@Override
	public Visitor updateVisitors(Visitor v) {
		return visitorRepository.save(v);

	}
	
	@Override
	public Visitor retrieveVisitors(Long id) {
		return visitorRepository.findById(id).get();

	}

	@Override
	public Long addOrUpdateVisitor(Visitor visitor) {
		visitorRepository.save(visitor);
		return null;
	}
}
