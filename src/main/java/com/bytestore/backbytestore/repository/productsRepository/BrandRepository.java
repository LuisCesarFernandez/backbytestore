package com.bytestore.backbytestore.repository.productsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestore.backbytestore.model.products.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
