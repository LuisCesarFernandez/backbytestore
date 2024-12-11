package com.bytestore.backbytestore.model.sales;

import com.bytestore.backbytestore.model.login.User;

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
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order;

    @Column(name = "order_date")
    private String order_date;

    @Column(name = "status")
    private String status;

    @Column(name = "total_price")
    private Double total_price;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
