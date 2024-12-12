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
    public List<Product> listProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> listIdProduct(@PathVariable Long Id) {
        return productService.getIdProduct(Id);
    }

    @PostMapping("/")
    public String createProduct(@RequestBody Product product) {
        productService.postProduct(product);
        return "Product created";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.putProduct(product, id);
        return "Product updated";
    }
}
