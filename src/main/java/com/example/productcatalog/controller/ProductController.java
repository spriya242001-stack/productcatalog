package com.example.productcatalog.controller;
import com.example.productcatalog.entity.ProductEntity;
import com.example.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }


    @GetMapping("/addProduct")
    public String showAddForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "add-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute ProductEntity product) {
        service.saveProduct(product);
        return "redirect:/displayProducts";
    }


    @GetMapping("/displayProducts")
    @ResponseBody
    public List<ProductEntity> displayProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/products/category/{categoryName}")
    @ResponseBody
    public List<ProductEntity> displayProductsByCategory(
            @PathVariable String categoryName) {

        return service.getProductsByCategory(categoryName);
    }
}