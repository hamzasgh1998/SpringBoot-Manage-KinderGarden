package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.ProductsRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category_Products addCategroy(Category_Products cat){
		return categoryRepository.save(cat);
	}
	
	
	@Override
	public Category_Products GetCategory(long idCat){
		return categoryRepository.findById(idCat).get();
	}
	
	@Override
	public Category_Products updateCategory(Category_Products cat){
	
		return categoryRepository.save(cat);
		
	}
	@Override
	public List<Category_Products> retrieveAllCategory() {
		return (List<Category_Products>) categoryRepository.findAll();
		}
	
	@Override
	public void deleteCategory (long id_cat){
		categoryRepository.deleteById(id_cat);
	}
	
		
	}
	
	 
	

