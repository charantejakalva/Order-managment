package com.egen.service;
import com.egen.model.OrderItem;
import org.hibernate.criterion.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

       List<OrderItem> getAllOrders();

       Optional<OrderItem> getOrderById(String id);

//       List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime);
//
//        List<Order> top10OrdersWithHighestDollarAmountInZip(String zip);
       OrderItem placeOrder(OrderItem orderItem);

       OrderItem cancelOrder(OrderItem order);

       OrderItem updateOrder(OrderItem order);
       String createRandomOrders(int num);
}
