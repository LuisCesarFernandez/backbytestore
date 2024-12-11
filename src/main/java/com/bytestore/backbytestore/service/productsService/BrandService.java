package com.bytestore.backbytestore.service.productsService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestore.backbytestore.model.products.Brand;
import com.bytestore.backbytestore.repository.productsRepository.BrandRepository;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    public void saveBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public void updateBrand(Brand brand, Long id) {
        brand.setId_brand(id);
        brandRepository.save(brand);
    }

    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
}
