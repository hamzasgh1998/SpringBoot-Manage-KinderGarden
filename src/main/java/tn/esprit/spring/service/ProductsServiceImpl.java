package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.KinderGartenAdmin;
import tn.esprit.spring.entities.OfferProducts;
import tn.esprit.spring.entities.Posts;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.OfferProductsRepository;
import tn.esprit.spring.repository.ProductsRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	ProductsRepository productsRepository;
 
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	OfferProductsRepository offerProductsRepository;
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
    StorageService storageService;
	
	
	
	
	
	
	@Override
	public Products addProduct(Products P) {
		 
		return productsRepository.save(P);
	}
	
	
	/*
	@Override
	public Products addProducts(String nomProd, String description, String couleur,String image,float prix, int quantite,long Idcat) {
	     Category_Products cat = categoryRepository.findById(Idcat).get();
	     System.out.println(cat.getNameCategory()+"*****************************************");
		Products P =new Products (nomProd,description,couleur,image,prix,quantite,cat);
		return productsRepository.save(P);
	}
*/

	@Override
	public OfferProducts ajouterOffer(OfferProducts Offer) {
		// Products p = productsRepository.findById(prod.getId_Prod()).get();
		// prod.setCategory_Products(categoryRepository.findById(id_cat).get());
		// Category_Products c
		return offerProductsRepository.save(Offer);
	}
	/*
	@Override
	public  ResponseEntity<String> ajouterProduit(String nomProd, String description, String couleur, MultipartFile image,float prix, int quantite,long IdAdmin) {
        String message = "";
        try {
        KinderGartenAdmin  KG = (KinderGartenAdmin) userRepository.findById(IdAdmin).get();
        storageService.store(image);
        
        files.add(image.getOriginalFilename());
        
        Products  P =new Products( nomProd, description, couleur, image.getOriginalFilename(), prix, quantite, KG);
        productsRepository.save(P);
        message = "You successfully uploaded " + image.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e) {
            message = "FAIL to upload " + image.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
        
	}*/
	@Override
	public Products getProduct(long idProd) {

		return productsRepository.findById(idProd).get();
	}

	@Override
	public List<Products> getAllProducts() {

		return (List<Products>) productsRepository.findAll();
	}

	@Override

	public void deleteProducts(long id_Prod) {
		productsRepository.deleteById(id_Prod);
	}

	@Override

	public Products updateProducts(Products Prod) {

		return productsRepository.save(Prod);

	}

	@Override
	public void affecterProdCat(long id_prod, long id_cat) {
		Products p = productsRepository.findById(id_prod).get();
		Category_Products cat = categoryRepository.findById(id_cat).get();
		p.setCategory(cat);
		productsRepository.save(p);
	}

	@Override
	public void affecterProdCatName(long id_prod, Category_Products cat) {
		Products p = productsRepository.findById(id_prod).get();
		p.setCategory(cat);
		productsRepository.save(p);
	}

	@Override
	public List<Products> getProductsByCategory(long idCategory) {
		return productsRepository.findByCategoryIdCategory(idCategory);
	}

	@Override
	public List<Products> getProductsByCategoryName(String name) {
		return productsRepository.findByCategoryNameCategory(name);
	}

	@Override
	public Products affecterProOffer(long id_prod, long id_Offer) {
		Products p = productsRepository.findById(id_prod).get();
		OfferProducts Offer = offerProductsRepository.findById(id_Offer).get();
		p.setOffer(Offer);
		 return productsRepository.save(p);
	}

	@Override

	public List<Products> getProductsByOffer(long Idoffer) {
		return productsRepository.findByOfferProductsIdOffer(Idoffer);
	}

	@Override
	public List<Products> getProductsByOfferValeur(int Valeur) {
		return productsRepository.findByOfferValeur(Valeur);
	}
	@Override
	public List<Products> getProductsByName(String Name) {
		return productsRepository.findByNomProd(Name);
	}
	@Override
	public List<Products> getProductsByPrixDESC() {
		return productsRepository.FindPrixSortedByPrixDESC();
	}
	@Override
	public List<Products> getProductsByPrixASC() {
		return productsRepository.FindPrixSortedByPrixASC();
	}
	List<String> files = new ArrayList<String>();
	
	/*
	@Override
	public  ResponseEntity<String> ajouterProduit2(String nomProd, String description, String couleur, MultipartFile image,float prix, int quantite,long IdAdmin,long Idcat) {
        String message = "";
        try {
        KinderGartenAdmin  KG = (KinderGartenAdmin) userRepository.findById(IdAdmin).get();
        Category_Products cat = categoryRepository.findById(Idcat).get();
        storageService.store(image);
        
        files.add(image.getOriginalFilename());
        
        Products  P =new Products( nomProd, description, couleur, image.getOriginalFilename(), prix, quantite, KG, cat);
        productsRepository.save(P);
        message = "You successfully uploaded " + image.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e) {
            message = "FAIL to upload " + image.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
        
	}
	*/
	//affichage file
        public List<String> getListFiles( ) {
            List<String> fileNames = files
                    .stream().map(fileName -> MvcUriComponentsBuilder
                            .fromMethodName(ProductsService.class, "getFile", fileName).build().toString())
                    .collect(Collectors.toList());
            return files;
	}


		
	
	
	
	
	
	
	
	

	
}
