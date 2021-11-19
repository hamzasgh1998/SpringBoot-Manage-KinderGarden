package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Category_Products;



public interface CategoryService {
	
	
	 
	 Category_Products addCategroy(Category_Products cat);

	 List<Category_Products> retrieveAllCategory();
	 void deleteCategory (long id_cat);
	Category_Products updateCategory(Category_Products cat);

	Category_Products GetCategory(long idCat);
}
