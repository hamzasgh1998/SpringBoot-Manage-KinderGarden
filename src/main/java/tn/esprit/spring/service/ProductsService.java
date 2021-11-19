package tn.esprit.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.OfferProducts;
import tn.esprit.spring.entities.Products;

public interface ProductsService {

	// public void addCategory(Products product, Category_Products category);
	// public Products addProducts(Products products,String category);

	List<Products> getAllProducts();

	void deleteProducts(long id_Prod);

	public void affecterProdCat(long id_prod, long id_cat);

	public List<Products> getProductsByCategory(long id_Catgeory);

	//Products ajouterProduit(Products prod);


	public List<Products> getProductsByCategoryName(String name);

	public void affecterProdCatName(long id_prod, Category_Products cat);



	Products affecterProOffer(long id_prod, long id_Offer);

	List<Products> getProductsByOffer(long Idoffer);

	OfferProducts ajouterOffer(OfferProducts Offer);

	List<Products> getProductsByOfferValeur(int Valeur);

	List<Products> getProductsByName(String Name);

	



	

	
	List<Products> getProductsByPrixDESC();

	List<Products> getProductsByPrixASC();

	

	

	//ResponseEntity<String> ajouterProduit2(String nomProd, String description, String couleur, MultipartFile image,
		//	float prix, int quantite, long IdAdmin, long Idcat);

	//ResponseEntity<String> ajouterProduit(String nomProd, String description, String couleur, MultipartFile image,
			//float prix, int quantite, long IdAdmin);

	

	Products getProduct(long idProd);


	Products updateProducts(Products Prod);




	

	

	

	Products addProduct(Products P);

	//ResponseEntity<String> ajouterProduit2(String nomProd, String description, String couleur, MultipartFile image,
			//float prix, int quantite, long Idcat);


}
