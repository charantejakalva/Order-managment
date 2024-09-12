package com.egen.repository;

import com.egen.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public class OrderRepositoryImplement implements OrderRepository{
    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        return null;
    }

    @Override
    public ResponseEntity<Order> getOrderById(String id) {
        return null;
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
