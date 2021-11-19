package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.ItemList;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.entities.enumerations.Status;

public interface CartService  {

	
	
	//public void AddItem (int qte,long pirce ,long Id_prod,Status status);
	//public void AddCart (long idParent,Cart cart,long idItem) ;
	
	
	
	public ItemList getItem(long IdItem);
	public List<Cart>  retrieveAll();
	public List <ItemList > getAllItemEncours(long IdParent);
	public List<ItemList> findItemList(long IdParent);
	public ItemList updateLigne(int quantite,long parentid,long itemid);
	public void deleteLigne(long IdItem,long parentid);
	public ItemList confirmligne(long IdItem);
	public List<ItemList> getAllItemConfirmer(long IdParent);
	public Cart findCartbyidparent(long IdParent);
	public Float findbyPrixConfirmer(long IdParent);
	public Float findbyPrixEnCours(long IdParent);
	//public PubliciteProducts pubProd( PubliciteProducts pp);
	//public Integer findpop (long IdProd);
	List<ItemList> retrieveAllMostProducts();
	//public void deleteCart(long IdCart);
	public void Payeeligne(long IdItem);

	public List<ItemList> getAllItemPayee(long IdParent);
	//void AddCart(int qte, long Id_prod, long idParent, Cart cart);
	Cart AddCart(int qte, long Id_prod, long idParent);
	
}