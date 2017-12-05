package com.caci.onlinebricksystem.service;

import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rabia on 03/12/2017.
 */
@Service
public class OrderService implements IOrderService {

    @Override
    public Order submitOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> retreiveAllOrders() {
        return null;
    }

    @Override
    public Order retreiveSpecificOrder(Long orderId) {
        return null;
    }

    @Override
    public Customer retreiveDetailsForSpecificCustomer(Long customerId, Long orderId) {
        return null;
    }

    @Override
    public Order deleteOrder(Long orderId) {
        return null;
    }

    @Override
    public Order updateOrder(Long orderId){
        return null;
    }
}
