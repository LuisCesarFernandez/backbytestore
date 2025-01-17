package com.bytestore.backbytestore.controller.productsController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("permitAll()")
    @GetMapping("/")
    public List<Subcategory> listSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Optional<Subcategory> ListIdSubcategory(@PathVariable Long Id) {
        return subcategoryService.getIdSubcategory(Id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public String createSubcategory(@RequestBody Subcategory subcategory){
        subcategoryService.postSubcategory(subcategory);
        return "Subcategory created";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public String updateSubcategory(@PathVariable Long id, @RequestBody Subcategory subcategory) {
        subcategoryService.putSubcategory(subcategory, id);
        return "Subcategory updated";
    }

}
