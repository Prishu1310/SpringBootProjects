package com.sathya.springmvc.productcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springmvc.productentity.ProductEntity;
import com.sathya.springmvc.productmodel.ProductModel;
import com.sathya.springmvc.productrepository.ProductRepository;
import com.sathya.springmvc.productservice.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@Autowired
	ProductService productservice;
	    
	@GetMapping("/productform")
	public String getProductForm(Model model) {
		ProductModel productModel = new ProductModel();
		productModel.setMadeIn("India");
		productModel.setQuantity(2);
		model.addAttribute("productModel",productModel);
		return "add-product";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@Valid ProductModel productModel,BindingResult bindingResult,Model model) {
		HashMap<String, String> validationError = new HashMap<String,String>();
		if(bindingResult.hasErrors()){
			for(FieldError fieldError :bindingResult.getFieldErrors()) {
				
				validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			model.addAttribute("validationError",validationError);
			//model.addAttribute("productModel",productModel);
			return "add-product";
		}
		productservice.saveProduct(productModel);
		return "redirect:/getallproducts";
	}


	@GetMapping("/getallproducts")
	public String getAllProducts(Model model) {
		List<ProductEntity> products = productservice.getAllProducts();
		model.addAttribute("products",products); 
		return "product-list";
	}
	@GetMapping("/getsearchform")
	public String getSearchForm() {
		return "search";
		}
	
	@PostMapping("/searchbyid")
	public String searchById(@RequestParam Long id,Model model) {
		ProductEntity products = productservice.searchById(id);
		model.addAttribute("products", products);
		return "search";
	}
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable("id") Long id) {
		productservice.deleteProductById(id);
		return "redirect:/getallproducts";
	}
	@GetMapping("/edit/{id}")
	public String editById(@PathVariable("id") Long id,Model model) {
		ProductModel products = productservice.editById(id);
		model.addAttribute("products",products);
		model.addAttribute("id",id);
		return "edit-product";
		
	}
	@PostMapping("/editproduct/{id}")
	public String editProduct(@PathVariable("id") Long id, ProductModel productModel) {
		productservice.editById(id,productModel);
		return "redirect:/getallproducts";
   }
 }