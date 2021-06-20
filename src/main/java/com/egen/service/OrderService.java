package com.egen.service;
import com.egen.model.OrderItem;

import java.util.List;

public interface OrderService {

       List<OrderItem> getAllOrders();

//       Order getOrderById(String id);
//
//       List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime);
//
//        List<Order> top10OrdersWithHighestDollarAmountInZip(String zip);
       OrderItem placeOrder(OrderItem orderItem);

//       Order cancelOrder(Order order);
//
//       Order updateOrder(Order order);
}
