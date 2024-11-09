package com.bytestore.backbytestore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestore.backbytestore.model.Brand;
import com.bytestore.backbytestore.service.BrandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/")
    public List<Brand> getBrand() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Optional<Brand> getBrandById(@PathVariable("id") Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping("/")
    public String postBrand(@RequestBody Brand brand) {
        brandService.saveBrand(brand);
        return "Brand created";
    }

    @PutMapping("/{id}")
    public String putBrand(@PathVariable Long id, @RequestBody Brand brand) {
        brandService.updateBrand(brand, id);
        return "Brand updated";
    }
    
}
