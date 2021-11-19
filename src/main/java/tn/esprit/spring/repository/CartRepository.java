package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.ItemList;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

	

	//@Query(value = "SELECT * FROM Cart WHERE parent_id_user=?1 and status='en cours'", nativeQuery = true)
	//public Cart CartencoursparParent(long idParent);
	
	
	
	@Query(value = "SELECT * FROM Cart l WHERE  l.parent_id_user=:parent_id_user ", nativeQuery = true)
	public List <Cart> findCartbyidParent(@Param("parent_id_user")Long parent_id_user);
	@Query(value = "SELECT u FROM Cart u WHERE  parent_id_user =?1")
	public Cart findCartbyidParentone(Long parent_id_user);
}
