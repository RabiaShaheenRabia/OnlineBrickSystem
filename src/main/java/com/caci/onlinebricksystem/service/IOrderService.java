package com.caci.onlinebricksystem.service;

import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Rabia on 04/12/2017.
 */
public interface IOrderService {

    Order submitOrder(Order order);

    List<Order> retreiveAllOrders();

    Order retreiveSpecificOrder ( Long  orderId);

    Customer retreiveDetailsForSpecificCustomer ( Long customerId,
                                                         Long orderId);
    Order deleteOrder(Long orderId);

    Order updateOrder(Long orderId);
}
