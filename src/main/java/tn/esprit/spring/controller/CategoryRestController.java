package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.Products;
import tn.esprit.spring.service.CategoryService;

@RestController
public class CategoryRestController {
	
	
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping("/GetCategory/{Category-id}")
	 @ResponseBody
	 public Category_Products GetCategory(@PathVariable("Category-id") long CategoryId) {
	 return categoryService.GetCategory(CategoryId);
	}
	@GetMapping("/GetAllCategory")
	 @ResponseBody
	 public List<Category_Products>retrieveAllCategory() {
	 return categoryService.retrieveAllCategory();
	}
	
	 @DeleteMapping("/RemoveCategory/{Category-id}")
	  @ResponseBody
	  public void removeCategory(@PathVariable("Category-id") Long CategoryId) {
		 categoryService.deleteCategory(CategoryId);
	  }
	 
	 @PutMapping("/UpdateCategory")
	  @ResponseBody
	  public Category_Products UpdateCategory(@RequestBody Category_Products CP) {
	  return categoryService.updateCategory(CP);
	 
	  }
	 @PostMapping("/AddCategory")
	 
	 @ResponseBody
	 public Category_Products AddCategory(@RequestBody Category_Products CP) {
	categoryService.addCategroy(CP);
	 return CP;
	 }

}
