package com.damtab.m_motors.services;

import com.damtab.m_motors.pojo.Car;
import com.damtab.m_motors.pojo.Order;
import com.damtab.m_motors.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() { return orderRepository.findAll();}

    public Order getOrderById(Long id) { return orderRepository.findById(id).orElse(null);}

    public void createOrder(Order order) {orderRepository.save(order);}

    public Boolean deleteOrder(Long id) {
        Boolean toDelete = orderRepository.existsById(id);
        if(toDelete) {
            orderRepository.deleteById(id);
        }
        return toDelete;
    }

    public void updatedOrder(Long id, Order newOrder) {
        Order oldOrder = this.getOrderById(id);
        if (oldOrder == null) {
            throw new RuntimeException("Car not found");
        }

        if(oldOrder != null) {
            oldOrder.setCar(newOrder.getCar());
            oldOrder.setOfferType(newOrder.getOfferType());
            oldOrder.setOldCar(newOrder.getOldCar());
            oldOrder.setSubscription(newOrder.getSubscription());


            orderRepository.save(oldOrder);
        }
    }
}
