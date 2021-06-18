package com.egen.service;

import com.egen.exception.OrderNotFoundException;
import com.egen.model.Order;
import com.egen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class OrderServiceImplement implements OrderService{

    @Autowired
    OrderRepository repository;
    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        return repository.getAllOrders();
    }

    @Override
    public ResponseEntity<Order> getOrderById(String id) {
        ResponseEntity<Order> order =  repository.getOrderById(id);
        if (order == null){
            throw new OrderNotFoundException("Order with Order id" + id+ "is not available");
        }
        else{
            return  order;
        }
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime) {
        return null;
    }

    @Override
    public ResponseEntity<List<Order>> top10OrdersWithHighestDollarAmountInZip(String zip) {
        return null;
    }

    @Override
    public ResponseEntity<Order> placeOrder(Order order) {
        return null;
    }

    @Override
    public ResponseEntity<Order> cancelOrder(Order order) {
        return null;
    }

    @Override
    public ResponseEntity<Order> updateOrder(Order order) {
        return null;
    }
}
