package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Kid;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.KidRepository;

@Service
public class KidServiceImpl  implements KidService{
	@Autowired
	KidRepository kidRepository;
	
	@Override
	public List<Kid> retrieveAllKids() {
	return (List<Kid>) kidRepository.findAll();
	}
	
	@Override
	public Kid addKid(Kid k) {
		return kidRepository.save(k);
	}
	
	@Override
	public void deleteKids(Long idKid) {
		kidRepository.deleteById(idKid);		
	}
	
	@Override
	public Kid updateKids(Kid k) {
		return kidRepository.save(k);

	}
	
	@Override
	public Kid retrieveKids(Long idKid) {
		return kidRepository.findById(idKid).get();

	}
	
	@Override
	public Long addOrUpdateKid(Kid kid) {
		kidRepository.save(kid);
		return kid.getIdKid();
	}
	
	@Override
	public List<Kid> FindKidSortedByAdressKid() {
		return kidRepository.FindKidSortedByAdressKid();
	}
	
	@Override
	public List<Kid> FindKidSortedByNameKid() {
		return kidRepository.FindKidSortedByNameKid();
	}
}
