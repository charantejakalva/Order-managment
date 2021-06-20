package com.egen.service;

//import com.egen.exception.OrderNotFoundException;
import com.egen.exception.OrderNotFoundException;
import com.egen.model.OrderItem;
import com.egen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.time.ZonedDateTime;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplement implements OrderService{

    public final OrderRepository repository;

    public OrderServiceImplement( OrderRepository repository) {
        this.repository = repository;
    }

    public  List<OrderItem> getAllOrders() {
        return (List<OrderItem>) repository.findAll();
    }

    public OrderItem getOrderById(String id) {
        Optional<OrderItem> order =  repository.findById(id);
        if (order == null){
            throw new OrderNotFoundException("Order with Order id" + id+ "is not available");
        }
        else{
            return  order.get();
        }
    }

//    @Override
//    public  List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime) {
//        return repository.getAllOrdersWithInInterval(startTime,endTime);
//    }
//
//    @Override
//    public  List<Order> top10OrdersWithHighestDollarAmountInZip(String zip) {
//        return null;
//    }

    public OrderItem placeOrder(OrderItem orderItem) {
        return repository.save(orderItem);
    }

//    @Override
//    public  Order cancelOrder(Order order) {
//        return repository.cancelOrder(order);
//    }
//
//    @Override
//    public  Order updateOrder(Order order) {
//        return repository.updateOrder(order);
//    }


}
