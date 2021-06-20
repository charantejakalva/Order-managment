package com.egen.service;

//import com.egen.exception.OrderNotFoundException;
import com.egen.exception.OrderNotFoundException;
import com.egen.model.OrderItem;
import com.egen.model.OrderStatus;
import com.egen.repository.OrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.jemos.podam.api.AttributeMetadata;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.PodamUtils;
import uk.co.jemos.podam.typeManufacturers.IntTypeManufacturerImpl;
import uk.co.jemos.podam.typeManufacturers.TypeManufacturer;

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

    public Optional<OrderItem> getOrderById(String id) {
        Optional<OrderItem> order =  repository.findById(id);
        if (order == null){
            throw new OrderNotFoundException("Order with Order id" + id+ "is not available");
        }
        else{
            return Optional.of(order.get());
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


    public  OrderItem cancelOrder(OrderItem order) {
        OrderItem oi  = repository.findById(order.getId()).get();
        oi.setOrderStatus(OrderStatus.CANCEL);
        return repository.save(oi);
    }


    public  OrderItem updateOrder(OrderItem order) {
        return repository.save(order);
    }

    public String createRandomOrders(int num){
        PodamFactory factory =  new PodamFactoryImpl();
        TypeManufacturer<Integer> manufacturer = new IntTypeManufacturerImpl(){

            @Override
            public Integer getInteger(AttributeMetadata attributeMetadata){
                if(attributeMetadata.getPojoClass().getName().equalsIgnoreCase("java.sql.Timestamp")){
                    return PodamUtils.getIntegerInRange(0,999);
                }
                else{
                    return super.getInteger(attributeMetadata);
                }
            }
        };
        factory.getStrategy().addOrReplaceTypeManufacturer(int.class,manufacturer);
        for(int i=0; i<num;i++){
            OrderItem orderItem = factory.manufacturePojoWithFullData(OrderItem.class);
            this.placeOrder(orderItem);
        }
        return "success";
    }
}
