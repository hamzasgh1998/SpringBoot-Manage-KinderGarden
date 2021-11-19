package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Products;


@Repository
public interface ProductsRepository  extends CrudRepository <Products,Long> {

	@Query(value="SELECT * FROM Products Order By Prix DESC",nativeQuery =true)
	public List<Products> FindPrixSortedByPrixDESC();
	
	@Query(value="SELECT * FROM Products Order By Prix ASC",nativeQuery =true)
	public List<Products> FindPrixSortedByPrixASC();

	public List<Products> findByCategoryIdCategory(long idCategory);

	//@Query(value = "SELECT * FROM Products l WHERE l.name_category  LIKE ?1% ", nativeQuery = true)
	public List<Products> findByCategoryNameCategory(String Name);
	@Query(value = "SELECT * FROM Products l WHERE  l.offer_id_offer=?1 ", nativeQuery = true)
	public List<Products> findByOfferProductsIdOffer(long idoffer);
	
	/*@Query(value = "SELECT * FROM Products l WHERE  l.valeur=?1 ", nativeQuery = true)
	public List <Products> findByOfferProductsValeur(int Valeur);
	*/
	@Query(value = "SELECT * FROM Products  WHERE  nom_Prod LIKE ?1% ", nativeQuery = true)
	public List <Products > findByNomProd(String Name);
	public List<Products>findByOfferValeur(int valeur);
	
	
	
	
	
}
