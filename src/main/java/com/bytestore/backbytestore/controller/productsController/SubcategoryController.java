package com.bytestore.backbytestore.controller.productsController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestore.backbytestore.model.products.Subcategory;
import com.bytestore.backbytestore.service.productsService.SubcategoryService;

@RestController
@RequestMapping(path = "/subcategory")
public class SubcategoryController {
    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping("/")
    public List<Subcategory> getAllSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @GetMapping("/{id}")
    public Optional<Subcategory> getIdSubcategory(@PathVariable Long Id) {
        return subcategoryService.getIdSubcategory(Id);
    }

    @PostMapping("/")
    public String postSubcategory(@RequestBody Subcategory subcategory){
        subcategoryService.saveSubcategory(subcategory);
        return "Subcategory created";
    }

    @PutMapping("/{id}")
    public String putSubcategory(@PathVariable Long id, @RequestBody Subcategory subcategory) {
        subcategoryService.updateSubcategory(subcategory, id);
        return "Subcategory updated";
    }

}
