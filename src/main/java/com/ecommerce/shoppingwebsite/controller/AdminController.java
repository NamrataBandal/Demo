package com.ecommerce.shoppingwebsite.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.shoppingwebsite.entity.Category;
import com.ecommerce.shoppingwebsite.service.CategoryService;

@Controller
public class AdminController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
		}
	@GetMapping("/admin/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCategoriesAdd(Model model){
		model.addAttribute("category",new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCategoriesAdd(@ModelAttribute("categories")Category category){
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id,Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if(category.isPresent()) {
			model.addAttribute("category",new Category());
			return "categoriesAdd";
		}else
			return "404";
	}
	


}
