package com.bytestore.backbytestore.controller.productsController;

import com.bytestore.backbytestore.model.products.Category;
import com.bytestore.backbytestore.service.productsService.CategoryService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("permitAll()")
    @GetMapping("/")
    public List<Category> listCategories() {
        return categoryService.getAllCategories();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Optional<Category> listIdCategory(@PathVariable("id") Long id) {
        return categoryService.getIdCategory(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public String createCategory(@RequestBody Category category) {
        categoryService.postCategory(category);
        return "Category created";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody Category category) {
        categoryService.putCategory(category, id);
        return "Category updated";
    }
    
}
