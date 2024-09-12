package com.egen.service;
import com.egen.model.Order;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

public interface OrderService {

      ResponseEntity<List<Order>> getAllOrders();

      ResponseEntity<Order> getOrderById(String id);

      ResponseEntity<List<Order>> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime);

      ResponseEntity<List<Order>> top10OrdersWithHighestDollarAmountInZip(String zip);
      ResponseEntity<Order> placeOrder(Order order);

      ResponseEntity<Order> cancelOrder(Order order);

      ResponseEntity<Order> updateOrder(Order order);
}
