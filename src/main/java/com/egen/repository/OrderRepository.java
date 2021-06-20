package com.egen.repository;

import com.egen.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderItem, String> {
//     List<Order> getAllOrders();
//
//    Order getOrderById(String id);
//
//     List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime);
//
//     List<Order> top10OrdersWithHighestDollarAmountInZip(String zip);
//    Order placeOrder(Order order);
//
//    Order cancelOrder(Order order);
//
//    Order updateOrder(Order order);
}
