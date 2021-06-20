package com.egen.controller;

import com.egen.model.OrderItem;
import com.egen.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class OrderController {

    private OrderService service;
    public OrderController(OrderService service) {
        this.service = service;
    }

    /**
     * implement the following endpoints
     */

    @GetMapping("orders")
    public ResponseEntity<List<OrderItem>> getAllOrders(){
        //TODO
        return ResponseEntity.ok(service.getAllOrders());
    }

//    public ResponseEntity<List<Order>> getOrderById(String id){
//        //TODO
//        return null;
//    }
//
//    public ResponseEntity<List<Order>> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime){
//        //TODO
//        return null;
//    }
//
//    public ResponseEntity<List<Order>> top10OrdersWithHighestDollarAmountInZip(String zip){
//        //TODO
//        return null;
//    }
    @PostMapping("/place")
    public ResponseEntity<OrderItem> placeOrder(@RequestBody OrderItem orderItem){
        return ResponseEntity.ok(service.placeOrder(orderItem));
    }

//    public ResponseEntity<Order> cancelOrder(Order order){
//        return null;
//    }
//
//    public ResponseEntity<Order> updateOrder(Order order){
//        return null;
//    }
}
