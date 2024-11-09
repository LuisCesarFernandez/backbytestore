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
@Table(name = "subcategory")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subcategory;

    @Column(name = "name_subcategory")
    private String name_subcategory;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Subcategory() {}
    public Subcategory(String name_subcategory) {
        this.name_subcategory = name_subcategory;
    }
    
}
