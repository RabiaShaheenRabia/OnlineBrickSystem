package com.caci.onlinebricksystem.controller;

import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Order;
import com.caci.onlinebricksystem.service.CustomerService;
import com.caci.onlinebricksystem.service.ICustomerService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Rabia on 03/12/2017.
 */
@Slf4j
@RestController
@RequestMapping(value="/bricks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerControllerEndPoint {

    @Autowired
    private final ICustomerService customerService =  new CustomerService();

    @PostMapping(path = "/customers" ,consumes = "application/json",produces = "application/json")
    public ResponseEntity<Void> registerCustomer(@RequestAttribute Customer newCustomer){
        Customer customer = customerService.registerCustomer(newCustomer);
        if(customer==null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(customer.getCustomerId()).toUri();

        log.info("CustomerControllerEndPoint: registerCustomer Customer Added with Name : ",customer.getCustomerName());
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/customers")
    public List<Customer> retreiveAllCustomers( ){
        log.info("CustomerControllerEndPoint: retreiveAllCustomers ");
        return customerService.retreiveAllCustomers();
    }

    @GetMapping(path = "/customers/{customerId}")
    public Customer retreiveSpecificCustomer (@PathVariable("customerId") Long  customerId){
        log.info("CustomerControllerEndPoint: retreiveSpecificCustomer customerId = ",customerId);
        return customerService.retreiveSpecificCustomer(customerId);
    }


    @GetMapping(path = "/customers/{customerId}/orders")
    public List<Order> retreiveOrdersForCustomer (@PathVariable Long customerId){
        log.info("CustomerControllerEndPoint: retreiveOrdersForCustomer = ",customerId);
        return customerService.retreiveOrdersForCustomer(customerId);
    }

    @GetMapping(path = "/customers/{customerId}/orders/{orderId}")
    public Order retreiveDetailsForSpecificOrder (@PathVariable Long customerId,
                                                        @PathVariable Long orderId){
        log.info("CustomerControllerEndPoint: retreiveDetailsForSpecificOrder ");
        return customerService.retreiveDetailsForSpecificOrder(customerId,orderId);
    }

    @DeleteMapping(path = "/customers/{customerId}")
    public Customer deleteCustomer(@PathVariable Long customerId){
        log.info("CustomerControllerEndPoint: deleteCustomer ");
        return customerService.deleteCustomer(customerId);
    }

    @PutMapping(path="/customers/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId){
        log.info("CustomerControllerEndPoint: updateCustomer ");
        return customerService.updateCustomer(customerId);
    }
}
