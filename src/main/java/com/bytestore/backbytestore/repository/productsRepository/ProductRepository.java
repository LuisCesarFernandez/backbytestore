package com.bytestore.backbytestore.repository.productsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestore.backbytestore.model.products.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
