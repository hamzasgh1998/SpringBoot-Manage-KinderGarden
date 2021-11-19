package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.Posts;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ReclamationsRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.CommentsRepository;
import tn.esprit.spring.repository.KinderGartenRepository;
import tn.esprit.spring.repository.PostsRepository;

@Service
 public class ReclamationsServiceImpl implements ReclamationsService {

	@Autowired
	private ReclamationsRepository reclamationsRepository;
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Autowired
	private KinderGartenRepository kinderGartenRepository;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private UserRepository usersRepository;
	
	/*@Override
	public void affectIdParentReclamation(Long idParent, Reclamation rec) {
		User parent = usersRepository.findById(idParent).get();
		
		rec.setParent(parent);		
	}*/
	
	@Override
	public Reclamation addReclamation(Reclamation rec) {
		return reclamationsRepository.save(rec);
	}

	@Override
	public List<Reclamation> addReclamations(List<Reclamation> reclamations) {
		return (List<Reclamation>)reclamationsRepository.saveAll(reclamations);
	}

	@Override
	public List<Reclamation> getAllReclamations() {
		return (List<Reclamation>)reclamationsRepository.findAll();
	}
	
	@Override
	public Reclamation getReclamationById(Long id) {
		return reclamationsRepository.findById(id).orElse(null);
	}


	@Override
	public String deleteReclamation(Long id) {
		reclamationsRepository.deleteById(id);
		return "reclamation removed!!"+id;
	}

	@Override
	public Reclamation updateReclamation(Reclamation rec) {
		Reclamation existingRec=reclamationsRepository.findById(rec.getIdReclamation()).orElse(null);
		existingRec.setReclamationDate(rec.getReclamationDate());
		existingRec.setSubject(rec.getSubject());
		existingRec.setDescription(rec.getDescription());
		existingRec.setTypeReclamation(rec.getTypeReclamation());
		existingRec.setStatue(rec.isStatue());
		return reclamationsRepository.save(rec);
	}

	@Override
	public List<Reclamation> findByTypeReclamation(String type) {
		return reclamationsRepository.findByTypeReclamation(type);
	}

	@Override
	public List<Reclamation> findByStatue(boolean statue) {
		return reclamationsRepository.findByStatue(statue);
	}

	@Override
	public String addReputationComments(Long idComment, Long idKinderGarten) {
		Comments comment=commentsRepository.findById(idComment).get();
		KinderGarten kinder=kinderGartenRepository.findById(idKinderGarten).get();
		if(comment!=null)
		{
			kinder.setReputationComments(kinder.getReputationComments()+1);
			kinderGartenRepository.save(kinder);
			return "reputation added";
		}
		return "problem";
	}

	@Override
	public String addReputationRates(Long idPost, Long idKinderGarten) {
		Posts post=postsRepository.findById(idPost).get();
		KinderGarten kinder=kinderGartenRepository.findById(idKinderGarten).get();
		if((post!=null) && (post.getNbrLike()>post.getNbrDislike()))
		{
			kinder.setReputationRates(kinder.getReputationRates()+1);
			kinderGartenRepository.save(kinder);
			return "reputation added";
		}
		return "problem";
	}

	@Override
	public String addReputationReclamations(Long idReclamation, Long idKinderGarten) {
		Reclamation reclamation=reclamationsRepository.findById(idReclamation).get();
		KinderGarten kinder=kinderGartenRepository.findById(idKinderGarten).get();
		if(reclamation!=null)
		{
			kinder.setReputationReclamations(kinder.getReputationReclamations()+1);
			kinderGartenRepository.save(kinder);
			return "reputation added";
		}
		return "problem";
	}

	@Override
	public String getReputation(Long idKinderGarten) {
		KinderGarten kinder=kinderGartenRepository.findById(idKinderGarten).get();
		return "The kindergarten "+kinder.getNameKinderGarten()+" has "+kinder.getReputationComments()
		+" comments "+kinder.getReputationReclamations()+" reclamations ";
	}

	@Override
	public void affectIdParentReclamation(long idParent, Reclamation rec) {
		// TODO Auto-generated method stub
		
	}
}
