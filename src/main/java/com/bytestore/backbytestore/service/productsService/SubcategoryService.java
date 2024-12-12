package com.bytestore.backbytestore.service.productsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestore.backbytestore.model.products.Subcategory;
import com.bytestore.backbytestore.repository.productsRepository.SubcategoryRepository;

@Service
public class SubcategoryService {
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public Optional<Subcategory> getIdSubcategory(Long id) {
        return subcategoryRepository.findById(id);
    }

    public Subcategory postSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory putSubcategory(Subcategory subcategory, Long id) {
        subcategory.setId_subcategory(id);
        return subcategoryRepository.save(subcategory);
    }
}