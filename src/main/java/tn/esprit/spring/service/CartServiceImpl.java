package tn.esprit.spring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.ItemList;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.entities.enumerations.Status;
import tn.esprit.spring.repository.CartRepository;
import tn.esprit.spring.repository.ItemListRepository;
import tn.esprit.spring.repository.ProductsRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	
	private String login; private String password;
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ItemListRepository itemListRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService us;
	

	@Autowired
	CartService cartService;

	
	@Override
	public Cart AddCart(int qte, long Id_prod, long idParent) {

		Cart car = cartRepository.findCartbyidParentone(idParent);
		Products P = productsRepository.findById(Id_prod).get();
		LocalDate now = LocalDate.now();

		System.out.println(P.getNomProd() + "+++++++++++++++++++++++++++++++");
		if (car == null) {
			Cart cart = new Cart();
			Parent Pr = (Parent) userRepository.findById(idParent).get();
			cart.setParent(Pr);
			float prix = P.getPrix();
			float totalamount=prix*qte;
			
			if (totalamount > 300) {
				cart.setPrix(totalamount - totalamount * 0.1);
			} else if (totalamount > 500) {
				cart.setPrix(totalamount - totalamount * 0.2);
			}
			else {
				
			cart.setPrix(totalamount);
		}
			cart.setQuantite(qte);
			cartRepository.save(cart);

			ItemList IL = new ItemList();
			IL.setQuantity(qte);

			IL.setPrice(prix * qte);
			IL.setProducts(P);
			IL.setStatus(Status.encours);

			IL.setDate(now);
			IL.setCart(cart);

			itemListRepository.save(IL);

		} else {
			ItemList IL = new ItemList();
			IL.setQuantity(qte);
			float prix = P.getPrix();

			float total = prix * qte;
			IL.setPrice(total);

			IL.setProducts(P);
			IL.setStatus(Status.encours);
			IL.setDate(now);
			IL.setCart(car);
			int newqtetotal = car.getQuantite() + qte;
			car.setQuantite(newqtetotal);
			double amount = car.getPrix();
			double totalamount = amount + total;
			System.out.println("*************************" + totalamount + "***********************");
			if (totalamount > 300) {
				car.setPrix(totalamount - totalamount * 0.1);
			} else if (totalamount > 500) {
				car.setPrix(totalamount - totalamount * 0.2);
			}
			else car.setPrix(totalamount);
			cartRepository.save(car);

			itemListRepository.save(IL);

		}
		return car;
}
		
	
	
	public List<ItemList> findItemList(long IdParent){
		return itemListRepository.findAllitem(IdParent);
	}
	
	

	public Cart findCartbyidparent(long IdParent) {
		Cart car = cartRepository.findCartbyidParentone(IdParent);

		car.getPrix();
		car.getQuantite();
		return car;

	}
	public List<ItemList> getAllItemPayee(long IdParent) {
		return itemListRepository.findbyStatusPayee(IdParent);
	}

	
	public ItemList getItem(long IdItem) {
		return  itemListRepository.findById(IdItem).get();
	}
	
	public List<ItemList> getAllItemEncours(long IdParent) {
		return itemListRepository.findbystatusEnCours(IdParent);
	}

	public List<ItemList> getAllItemConfirmer(long IdParent) {
		return itemListRepository.findbystatusConfirmer(IdParent);
	}

	public ItemList updateLigne(int quantite, long parentid, long itemid) {
		ItemList li = itemListRepository.findById(itemid).get();
		Cart car = cartRepository.findCartbyidParentone(parentid);
		int oldQte = li.getQuantity();
		if (oldQte > quantite) {
			int newQte = oldQte - quantite;
			float prixp = li.getProducts().getPrix();
			float newprix = li.getPrice() - newQte * prixp;
			li.setQuantity(quantite);
			li.setPrice(newprix);
			float newprixcart = (float) (car.getPrix() - newQte * prixp);

			itemListRepository.save(li);
			int qtecar = car.getQuantite();
			car.setQuantite(qtecar - newQte);
			car.setPrix(newprixcart);
			cartRepository.save(car);

		} else if (oldQte < quantite) {
			int newQte = quantite - oldQte;
			float prixp = li.getProducts().getPrix();
			float newprix = li.getPrice() + newQte * prixp;
			li.setQuantity(quantite);
			li.setPrice(newprix);
			float newprixcart = (float) (car.getPrix() + newQte * prixp);

			itemListRepository.save(li);
			car.setPrix(newprixcart);
			int qtecar = car.getQuantite();
			car.setQuantite(qtecar + newQte);
			
			cartRepository.save(car);
			
			

		}
		return itemListRepository.findById(itemid).get();

	}

	

	public void deleteLigne(long IdItem, long parentid) {
		ItemList li = itemListRepository.findById(IdItem).get();
		// ItemList li=(ItemList)
		// itemListRepository.findbystatusEnCours(parentid);
		Cart car = cartRepository.findCartbyidParentone(parentid);

		int qteitem = li.getQuantity();
		int qtecar = car.getQuantite();
		float prixitem = li.getPrice();
		float prixcar = (float) car.getPrix();
		car.setPrix(prixcar - prixitem);
		car.setQuantite(qtecar - qteitem);
		cartRepository.save(car);

		itemListRepository.deleteById(IdItem);

	}

	public ItemList confirmligne(long IdItem) {
		ItemList li = itemListRepository.findById(IdItem).get();
		int oldProd = li.getProducts().getQuantite();
		int qteItem=li.getQuantity();
		if (oldProd>=qteItem){
		li.getProducts().setQuantite(oldProd - li.getQuantity());
		li.setStatus(Status.Confirmer);
		itemListRepository.save(li);
		}
		return  itemListRepository.findById(IdItem).get();
	}

	

	/*
	 * ItemList IL = itemListRepository.findById(idItem).get();
	 * 
	 * //List<Cart> cartList=cartRepository.findCartbyidParent(idParent); Parent
	 * P=(Parent) userRepository.findById(idParent).get(); cart.setParent(P);
	 * /*if (cartList.isEmpty()){
	 * 
	 * 
	 * //Set<ItemList> itemList = new HashSet<>(); //itemList.add(IL); //
	 * cart.setItemList(itemList); IL.setCart(cart);
	 * itemListRepository.save(IL); }
	 * 
	 */

	/*
	 * //ItemList it =itemListRepository.findById(id_it).get();
	 * 
	 * Parent p = (Parent) userRepository.findById(Id_Parent).get(); //ItemList
	 * It=itemListRepository.findById(IdItem).get(); cart.setParent(p); //Set
	 * <ItemList> itemlist=new HashSet<>(); //itemlist.add(it);
	 * 
	 * cart.setItemList(it);
	 * 
	 * // System.out.println(cart.getItemList();); cartRepository.save(cart);
	 * 
	 */

	
	
	

	
	public void Payeeligne(long IdItem) {
		ItemList li = itemListRepository.findById(IdItem).get();
		li.setStatus(Status.payee);
		itemListRepository.save(li);
	}
	
	public List<Cart> retrieveAll() {
		return (List<Cart>) cartRepository.findAll();
	}
	/*
	 * public double PointMerci(long idParent){ Cart car =
	 * cartRepository.findCartbyidParentone(idParent); double pm=0; double
	 * price=car.getPrix(); if (price>300){ float a=(float) (price-price*0.1);
	 * pm= car.setPrix(a); return pm ; } else if (price>500){
	 * pm=Math.round(price-price*0.2); return pm ; } return pm ;
	 */

	public Float findbyPrixConfirmer(long IdParent) {

		return itemListRepository.findbyPrixConfirmer(IdParent);

	}

	public Float findbyPrixEnCours(long IdParent) {

		return itemListRepository.findbyPrixEnCours(IdParent);

	}

	public List<ItemList> retrieveAllMostProducts() {
		return itemListRepository.MostPopularProducts();
	}
/*
	public Integer findpop(long IdProd) {
	return itemListRepository.findMostPopularProduct(IdProd);

}
*/



	

/*
 * public PubliciteProducts pubProd(){ //
 * List <PubliciteProducts>pub=new
 *ArrayList<>(); int qte=0; 
 *List<ItemList>il = (List<ItemList>)
 * itemListRepository.findAll(); 
 * PubliciteProducts pubP=new PubliciteProducts();
 * 
 * for (ItemList i : il){
 * 
 * //for (PubliciteProducts j: pub){
 * 
 * //if ( qte<findpop(i.getProducts().getIdProd())){
 * qte=findpop(i.getProducts().getIdProd());
 * 
 * 
 * pubP.setNom(i.getProducts().getNomProd());
 * 
 * pubP.setQuantite(qte);
 * 
 * 
 * }
 * 
 * 
 * return pubProdRepository.save(pubP); }
 */



}
