package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.service.ProductsService;

@RestController
public class ProductsRestcontroller {

	@Autowired
	ProductsService productsService;
	
	

	@GetMapping("/GetProduct/{idProd}")
	 @ResponseBody
	 public Products GetProduct(@PathVariable("idProd") long idProd) {
	 return productsService.getProduct(idProd);
	}

	@GetMapping("/GetAllProducts")
	 @ResponseBody
	 public List<Products> getAllProducts() {
	 return productsService.getAllProducts();
	}
	 @GetMapping("/GetProductsbyName/{Name}")
	 @ResponseBody
	 public List <Products>  GetProductsbyOffreValue (@PathVariable("Name") String Name) {
	 return productsService.getProductsByName(Name);
	 }
	 
	 @GetMapping("/GetProductsbyPrixDESC")
	 @ResponseBody
	 public List <Products>  GetProductsbyPrixDESC()  {
	 return productsService.getProductsByPrixDESC();
	 }
	 @GetMapping("/GetProductsbyPrixASC")
	 @ResponseBody
	 public List <Products>  GetProductsbyPrixASC()  {
	 return productsService.getProductsByPrixASC();
	 }
	
	 @GetMapping("/GetProductsbyCategoryId/{Category-id}")
	 @ResponseBody
	 public List <Products> getProductsByCategoryId (@PathVariable("Category-id") long id_Catgeory) {
	 return productsService.getProductsByCategory(id_Catgeory);
	
	 }
	
	 
	 
	 
	 
	 @GetMapping("/GetProductsbyCategoryName/{Category-Name}")
	 @ResponseBody
	 public List <Products>  getProductsByCategoryName (@PathVariable("Category-Name") String name) {
	 return productsService.getProductsByCategoryName(name);
	
	 }
	 
	 @GetMapping("/GetProductsbyOffreID/{Idoffer}")
	 @ResponseBody
	 public List <Products>  GetProductsbyOffreID (@PathVariable("Idoffer") long Idoffer) {
	 return productsService.getProductsByOffer(Idoffer);
	
	 }
	 @GetMapping("/GetProductsbyOffreValue/{value}")
	 @ResponseBody
	 public List <Products>  GetProductsbyOffreValue (@PathVariable("value") int value) {
	 return productsService.getProductsByOfferValeur(value);
	
	 }
	 
	
	 @DeleteMapping("/RemoveProducts/{Products-id}")
	  @ResponseBody
	  public void removeProductss(@PathVariable("Products-id") long productsId) {
		 productsService.deleteProducts(productsId);
	  }
	 
	  // http://localhost:8081/SpringMVC/servlet/ModifyActivity
	 @PutMapping(value ="/UpdateProducts", consumes = MediaType.APPLICATION_JSON_VALUE)
	  
	  @ResponseBody
	  public Products UpdateProducts(@RequestBody Products P) {
		 
	  return productsService.updateProducts(P);
	 
	  }
	  
	  @PutMapping(value = "/affecterProduitASCategorieId/{idprod}/{idScat}") 
		public void affecterProduitASCategorie(@PathVariable("idprod") long produitId, @PathVariable("idScat") long id_cat) {
			productsService.affecterProdCat(produitId, id_cat);

		}
	  
	  
	
	  
	  @PutMapping(value = "/affecterProduitAsOfferValue/{idprod}/{id_Offer}") 
		public Products affecterProduitAsOfferValue(@PathVariable("idprod") long produitId, @PathVariable("id_Offer") long id_Offer) {
		return productsService.affecterProOffer(produitId, id_Offer);

		}  
	  
	 /* 
	  @PostMapping("/AddProducts2/{AdminId}")
		 
		 @ResponseBody
		 public ResponseEntity<String> addProducts (@PathVariable("AdminId") long AdminId,String nomProd, String description, String couleur, @RequestParam("image") MultipartFile image,float prix, int quantite,long Idcat  )   {
		 return productsService.ajouterProduit2(nomProd, description, couleur, image, prix, quantite, AdminId, Idcat);
		
		 }	  
		 */
	  /*
	  @PostMapping("/AddProducts/{AdminId}")
		 
		 @ResponseBody
		 public ResponseEntity<String> addProducts (@PathVariable("AdminId") long AdminId,String nomProd, String description, String couleur, @RequestParam("image") MultipartFile image,float prix, int quantite  )   {
		 return productsService.ajouterProduit(nomProd, description, couleur, image, prix, quantite, AdminId);
		
		 }	  */
	 
	  @PostMapping("/AddProductwithcat")
		 
		 @ResponseBody
		 public Products AddProductwithcat ( @RequestBody Products Prod  )   {
		 return productsService.addProduct(Prod);
		
		 }	  
	 
	  
	  }
