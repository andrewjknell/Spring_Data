package com.andrewknell.shopping;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrewknell.shopping.models.Category;
import com.andrewknell.shopping.models.Product;
import com.andrewknell.shopping.services.ShopServ;

@Controller
public class ShopControl {
	private final ShopServ serv;
	
	public ShopControl(ShopServ serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/")
	public String addProduct(@ModelAttribute("product")Product p) {
		return "index.jsp";
	}
	
	@PostMapping("/newProduct")
	public String newProduct(@Valid @ModelAttribute("product")Product p, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			serv.create(p);
			return "index.jsp";
		}
	}
	
	@RequestMapping("/category")
	public String addCategory(@ModelAttribute("category")Category c) {
		return "category.jsp";
	}
	
	@PostMapping("/newCategory")
	public String newCategory(@Valid @ModelAttribute("category")Category c, BindingResult result) {
		if(result.hasErrors()) {
			return "category.jsp";
		} else {
			serv.create(c);
			return "category.jsp";
		}
	}
	
	@RequestMapping("/product/{id}")
	public String catToProduct(@PathVariable("id")Long id, Model model) {
		Product product = serv.findOneP(id);
		model.addAttribute("product", product);
		List<Category> cats = serv.getAll();
		model.addAttribute("categories", cats);
		return "catToPro.jsp";
	}
	
	@PostMapping("/catAddToProduct/{id}")
	public String catAddToProduct(@Valid @ModelAttribute("product")Product p, BindingResult result, @PathVariable("id")Long id) {
		if(result.hasErrors()) {
			return "catToPro.jsp";
		} else {
			Product current = serv.findOneP(id);
			List<Category> adding = current.getCategories();
			List<Category> newToAdd = p.getCategories();
			for(int i = 0;i<newToAdd.size();i++) {
				adding.add(newToAdd.get(i));
			}
			current.setCategories(adding);
			serv.update(current);
			return "catToPro.jsp";
		}
	}
}
