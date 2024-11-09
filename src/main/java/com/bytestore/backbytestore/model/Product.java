package com.bytestore.backbytestore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @Column(name = "name_product")
    private String name_product;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "url_image")
    private String url_image;

    @Column(name = "available")
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "id_subcategory")
    private Subcategory subcategory;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    public Product() {}

    public Product(String name_product, String description, Double price, String url_image, Boolean available) {
        this.name_product = name_product;
        this.description = description;
        this.price = price;
        this.url_image = url_image;
        this.available = available;
    }
}
