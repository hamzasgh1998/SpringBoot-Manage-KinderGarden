package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.ItemList;
import tn.esprit.spring.entities.Products;


public interface ItemListRepository extends CrudRepository<ItemList, Long> {
	
	
	
	@Query(value = "SELECT l FROM ItemList l WHERE (l.status='encours' OR l.status='confirmer') and l.cart.parent.idUser=?1 ")
	public List<ItemList> findAllitem(long parentid);
	
	
	@Query(value = "SELECT l FROM ItemList l WHERE l.status='encours' and l.cart.parent.idUser=?1 ")
	public List<ItemList> findbystatusEnCours(long parentid);
	
	
	@Query(value = "SELECT l FROM ItemList l WHERE l.status='confirmer' and l.cart.parent.idUser=?1 ")
	public List<ItemList> findbystatusConfirmer(long parentid);
	
	@Query(value = "SELECT * FROM ItemList l    WHERE status='encours' ", nativeQuery = true)
	public List<ItemList> findbystatus();
	
	@Query(value = "SELECT l FROM ItemList l WHERE l.status='payee' and l.cart.parent.idUser=?1 ")
	public List<ItemList> findbyStatusPayee(long parentid);
	
	
	@Query(value = "SELECT SUM (l.price) FROM ItemList l WHERE l.status='confirmer' and l.cart.parent.idUser=?1")
	public Float findbyPrixConfirmer(long parentid);
	@Query(value = "SELECT SUM (l.price) FROM ItemList l WHERE l.status='encours' and l.cart.parent.idUser=?1")
	public Float findbyPrixEnCours(long parentid);
	
	//@Query(value = "SELECT SUM (l.quantity) FROM ItemList l WHERE l.status='confirmer' and l.products.idProd=?1")
	//public Integer findMostPopularProduct(long idProd);
	//@Query(value = "SELECT l FROM ItemList l WHERE l.status='confirmer' GROUP BY l.products.idProd ORDER BY SUM(l.quantity) DESC  ")
	// public List<ItemList> MostPopularProducts();
	@Query(value = "SELECT * FROM item_list l WHERE l.status='payee' GROUP BY l.products_id_prod ORDER BY SUM(l.quantity)   DESC LIMIT 6", nativeQuery = true)
	 public List<ItemList> MostPopularProducts();
	
	
}
