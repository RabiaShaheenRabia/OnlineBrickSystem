package com.caci.onlinebricksystem.controller;

import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Order;
import com.caci.onlinebricksystem.service.CustomerService;
import com.caci.onlinebricksystem.service.ICustomerService;
import com.caci.onlinebricksystem.service.IOrderService;
import com.caci.onlinebricksystem.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Rabia on 03/12/2017.
 */
@Slf4j
@RestController
@RequestMapping(value="/bricks", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderControllerEndPoint {

    @Autowired
    private static final IOrderService orderService = new OrderService();


    @PostMapping(path="/orders")
    public ResponseEntity<Void> submitOrder(@RequestBody Order newOrder){
        Order order = orderService.submitOrder(newOrder);
        if(order==null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(order.getOrderId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping(path="/orders")
    public List<Order> retreiveAllOrders(){
        return orderService.retreiveAllOrders();
    }

    @GetMapping(path="/orders/{orderId}")
    public Order retreiveSpecificOrder (@PathVariable Long  orderId){
        return orderService.retreiveSpecificOrder(orderId);
    }


    @GetMapping(path="/orders/{orderId}/customers/{customerId}")
    public Customer retreiveDetailsForSpecificCustomer (@PathVariable Long customerId,
                                                        @PathVariable Long orderId){
        return orderService.retreiveDetailsForSpecificCustomer(customerId,orderId);
    }

    @DeleteMapping(path="/orders/{orderId}")
    public Order deleteOrder(@PathVariable Long orderId){
        return orderService.deleteOrder(orderId);
    }

}
