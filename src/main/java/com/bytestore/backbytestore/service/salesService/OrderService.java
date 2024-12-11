package com.bytestore.backbytestore.service.salesService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestore.backbytestore.model.sales.Order;
import com.bytestore.backbytestore.repository.salesRepository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
    
    public Optional<Order> getIdOrder(Long id) {
        return orderRepository.findById(id);
    }

    public String postOrder(Order order) {
        orderRepository.save(order);
        return "order created";
    }

    public String putOrder(Long id, Order order) {
        order.setId_order(id);
        orderRepository.save(order);
        return "order update";
    }

}
