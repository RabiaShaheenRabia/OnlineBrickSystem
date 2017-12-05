package com.caci.onlinebricksystem.service;

import com.caci.onlinebricksystem.common.Status;
import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Entity;
import com.caci.onlinebricksystem.domain.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabia on 03/12/2017.
 */
@Service
public class CustomerService implements ICustomerService{


    @Override
    public Customer registerCustomer(Customer customer) {

        /*List<Order> orders = new ArrayList<Order>();

        customer = new Customer(Long.valueOf(1),
                "George","CACI","12345678901",
                "george@gmail.com",orders);

        Entity expectedEntity = new Entity(Long.valueOf(1),"Bricks",1000);
        Order expectedOrder = new Order(Long.valueOf(1),expectedEntity, LocalDate.now(), LocalTime.now(),customer, Status.OrderStatus.START);
        orders.add(expectedOrder);
        customer.setOrders(orders);*/
        return  null;
    }

    @Override
    public List<Customer> retreiveAllCustomers() {
        return null;
    }

    @Override
    public Customer retreiveSpecificCustomer(Long customerId) {
        return null;
    }

    @Override
    public List<Order> retreiveOrdersForCustomer(Long customerId) {
        return null;
    }

    @Override
    public Order retreiveDetailsForSpecificOrder(Long customerId, Long orderId) {
        return null;
    }

    @Override
    public Customer deleteCustomer(Long customerId) {
        return null;
    }

    @Override
    public Customer updateCustomer(Long customerId){
        return null;
    }

}
