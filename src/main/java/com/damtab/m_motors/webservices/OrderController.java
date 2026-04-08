package com.damtab.m_motors.webservices;


import com.damtab.m_motors.pojo.Order;
import com.damtab.m_motors.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_ORDER)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Object> getAllOrder() {
        List<Order> myListOrder = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(myListOrder);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long id) {
        Order myOrder = orderService.getOrderById(id);
        return myOrder == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myOrder);
    }

    @PostMapping
    public ResponseEntity<Object> createOrder (@RequestBody Order myOrder) {
        orderService.createOrder(myOrder);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable Long id) {
        Boolean toDelete = orderService.deleteOrder(id);
        return toDelete ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long id, @RequestBody Order newOrder) {
        orderService.updatedOrder(id, newOrder);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
