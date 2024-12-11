package com.bytestore.backbytestore.controller.productsController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.bytestore.backbytestore.model.products.Product;
import com.bytestore.backbytestore.service.productsService.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getIdProduct(@PathVariable Long Id) {
        return productService.getIdProduct(Id);
    }

    @PostMapping("/")
    public String postProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Product created";
    }

    @PutMapping("/{id}")
    public String putProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(product, id);
        return "Product updated";
    }
}
