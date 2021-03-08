package com.tts.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.services.ProductService;

import lombok.Data;

@Data
@Controller
@ControllerAdvice 
public class MainController  {
    @Autowired
    ProductService productService;
    public void addNew() {
        List<Product> allProducts = productService.findAll();
        if (allProducts.isEmpty()) {
            List<Product> newProducts = new ArrayList<Product>();
            newProducts.add(new Product(20, (float) 4.99, ".73mm", "Yellow", "Dunlop", "Tortex",
            		"images/yellow.jpg"));
            newProducts.add(new Product(20, (float) 4.99, ".88mm", "Green", "Dunlop", "Tortex",
            		"images/green.jpg"));
            newProducts.add(new Product(20, (float) 4.99, "1.0mm", "Blue", "Dunlop", "Tortex",
            		"images/blue.jpg"));
            newProducts.add(new Product(20, (float) 4.99, "1.4mm", "Purple", "Dunlop", "Tortex",
            		"images/purple.jpg"));
for (Product product : newProducts) {
                productService.save(product);
                System.out.println(product);
            }
        } else {
            System.out.println("You don't need more items!");
        }
    }

    @GetMapping("/")
    public String main() {
    	addNew();
        return "main";
    }

   @ModelAttribute("products")
   public List<Product> products() {
       return productService.findAll();
   }
   @ModelAttribute("categories")
   public List<String> categories() {
       return productService.findDistinctCategories();
   }
   @ModelAttribute("brands")
   public List<String> brands() {
       return productService.findDistinctBrands();
   }
   @GetMapping("/filter")
   public String filter(@RequestParam(required = false) String category,
   @RequestParam(required = false) String brand, Model model)        {
   List<Product> filtered =
productService.findByBrandAndOrCategory(brand, category);
   model.addAttribute("products", filtered);
       return "main";
   }

   @GetMapping("/about")
   public String about() {
       return "about";
  }
}
