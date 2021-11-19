package tn.esprit.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.ItemList;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.service.CartService;

@RestController
public class CartRestController {
 @Autowired 
 CartService cartService ;
 
 
 @GetMapping("/GetCart")
 @ResponseBody
 public List<Cart> getCart() {
 return (List<Cart>) cartService.retrieveAll();
 }

 @GetMapping("GetItemEnCours/{IdParent}")
 @ResponseBody
 public List<ItemList>  GetItemEnCours(@PathVariable("IdParent") long IdParent) {

 return cartService.getAllItemEncours(IdParent);
 }
 

 
 @GetMapping("GetItemConfirm/{IdParent}")
 @ResponseBody
 public List<ItemList>  GetItemconfirm(@PathVariable("IdParent") long IdParent) {

 return cartService.getAllItemConfirmer(IdParent);

 }
 @GetMapping("GetItemPayee/{IdParent}")
 @ResponseBody
 public List<ItemList>  GetItemPayee(@PathVariable("IdParent") long IdParent) {

 return cartService.getAllItemPayee(IdParent);
 }
 
 
 
 @GetMapping("GetItem/{IdItem}")
 @ResponseBody
 public ItemList  GetItem(@PathVariable("IdItem") long IdItem) {

 return cartService.getItem(IdItem);
 }
 
 
 @GetMapping("GetAllItem/{IdParent}")
 @ResponseBody
 public List<ItemList>GetAllItem(@PathVariable("IdParent") long IdParent) {

 return cartService.findItemList(IdParent);

 }
 @GetMapping("GetCartByParent/{IdParent}")
 @ResponseBody
 public Cart GetCartByParent (@PathVariable("IdParent") long IdParent) {

 return cartService.findCartbyidparent(IdParent);

 }
 @GetMapping("GetAllMostpopularProducts")
 @ResponseBody
 public List<ItemList> GetAllMostpopularProducts () {

 return cartService.retrieveAllMostProducts();

 }
 @GetMapping("GetMontantTotalConfirmer/{IdParent}")
 @ResponseBody
 public float GetMontantTotal (@PathVariable("IdParent") long IdParent) {

 return cartService.findbyPrixConfirmer(IdParent);

 }
 @GetMapping("GetMontantTotalEnCours/{IdParent}")
 @ResponseBody
 public float GetMontantTotalEnCours (@PathVariable("IdParent") long IdParent) {

 return cartService.findbyPrixEnCours(IdParent);

 }
 
 @PostMapping("/AddCart/{IdProd}/{IdParent}/{qte}")
 @ResponseBody
 public Cart  AddCart (@PathVariable("IdProd")long IdProd,@PathVariable("IdParent")long IdParent,@PathVariable("qte") int quantity  )   {
  return cartService.AddCart(quantity, IdProd, IdParent);

 }	 
 @PutMapping("/updateLigneItem/{itemid}/{IdParent}/{qte}")
 @ResponseBody
 public ItemList updateLigneItem (@PathVariable("IdParent") long IdParent,@PathVariable("itemid")long itemid, @PathVariable("qte") int qte  )   {
  return cartService.updateLigne(qte, IdParent, itemid);

 }	
 @DeleteMapping("/RemoveLigneItem/{itemid}/{IdParent}")
 @ResponseBody
 public void RemoveLigneItem(@PathVariable("IdParent") long IdParent,@PathVariable("itemid")long itemid) {
	 cartService.deleteLigne(itemid, IdParent);
 }
 @PutMapping("/ConfirmLigneItem/{itemid}")
 @ResponseBody
 public ItemList ConfirmLigneItem (@PathVariable("itemid")long itemid  )   {
 return cartService.confirmligne(itemid);
 }	
 

 
 
}
