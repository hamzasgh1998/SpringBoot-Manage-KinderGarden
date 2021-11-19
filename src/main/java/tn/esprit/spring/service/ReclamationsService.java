package tn.esprit.spring.service;
import java.util.List;

import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.Reclamation;

public interface ReclamationsService {
	
	List<Reclamation> getAllReclamations();
	Reclamation addReclamation(Reclamation rec);
	//Reclamation addReclamation(Reclamation rec, Parent parent);
	public void affectIdParentReclamation(long idParent, Reclamation rec);
	List<Reclamation> addReclamations(List<Reclamation> reclamations);
	Reclamation getReclamationById(Long id);
	String deleteReclamation(Long id);
	Reclamation updateReclamation(Reclamation rec);
	List<Reclamation> findByTypeReclamation(String type);
	List<Reclamation> findByStatue(boolean statue);
	String addReputationComments(Long idComment, Long idKinderGarten);
	String addReputationRates(Long idPost, Long idKinderGarten);
	String addReputationReclamations(Long idReclamation, Long idKinderGarten);
	String getReputation(Long idKinderGarten);
}
