package com.caci.onlinebricksystem.service;

import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Order;

import java.util.List;

/**
 * Created by Rabia on 04/12/2017.
 */
public interface ICustomerService {

    Customer registerCustomer(Customer customer);

    List<Customer> retreiveAllCustomers( );

    Customer retreiveSpecificCustomer (Long  customerId);

    List<Order> retreiveOrdersForCustomer (Long customerId);

    Order retreiveDetailsForSpecificOrder (Long customerId,
                                                        Long orderId);

    Customer deleteCustomer(Long customerId);
    Customer updateCustomer(Long customerId);
}
