package com.bytestore.backbytestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestore.backbytestore.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
