package com.bytestore.backbytestore.controller.salesController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestore.backbytestore.model.sales.Order;
import com.bytestore.backbytestore.service.salesService.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public List<Order> listOrder() {
        return orderService.getOrder();
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public Optional<Order> listIdOrder(@PathVariable Long id) {
        return orderService.getIdOrder(id);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/")
    public String createOrder(@RequestBody Order order) {
        orderService.postOrder(order);
        return "order created";
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public String updateOrder(@PathVariable Long id, @RequestBody Order order) {
        orderService.putOrder(id, order);
        return "order updated";
    }
    
}
