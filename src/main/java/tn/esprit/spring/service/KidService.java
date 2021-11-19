package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Kid;
import tn.esprit.spring.entities.User;

public interface KidService {
	 List<Kid> retrieveAllKids();
	 Kid addKid(Kid k);
	 void deleteKids(Long idKid);
	 Kid updateKids(Kid k);
	 Kid retrieveKids(Long idKid);
	 
	 public Long addOrUpdateKid(Kid kid);
	 
	 public List<Kid> FindKidSortedByAdressKid();
	 public List<Kid> FindKidSortedByNameKid();




}
