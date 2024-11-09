package com.bytestore.backbytestore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_brand;

    @Column(name = "name_brand")
    private String name_brand;

    public Brand() {}

    public Brand(String name_brand) {
        this.name_brand = name_brand;
    }
}
