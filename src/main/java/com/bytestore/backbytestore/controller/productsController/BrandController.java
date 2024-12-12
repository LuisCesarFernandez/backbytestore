package com.bytestore.backbytestore.controller.productsController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestore.backbytestore.model.products.Brand;
import com.bytestore.backbytestore.service.productsService.BrandService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/")
    public List<Brand> listBrand() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Optional<Brand> listIdBrand(@PathVariable("id") Long id) {
        return brandService.getIdBrand(id);
    }

    @PostMapping("/")
    public String createBrand(@RequestBody Brand brand) {
        brandService.postBrand(brand);
        return "Brand created";
    }

    @PutMapping("/{id}")
    public String updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        brandService.putBrand(brand, id);
        return "Brand updated";
    }
    
}
