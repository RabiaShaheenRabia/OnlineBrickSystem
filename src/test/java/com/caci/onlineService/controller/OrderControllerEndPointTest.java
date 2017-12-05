package com.caci.onlineService.controller;

import com.caci.onlinebricksystem.controller.EntityControllerEndPoint;
import com.caci.onlinebricksystem.controller.OrderControllerEndPoint;
import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Entity;
import com.caci.onlinebricksystem.domain.Order;
import com.caci.onlinebricksystem.common.Status;
import com.caci.onlinebricksystem.service.OrderService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabia on 03/12/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrderControllerEndPoint.class)
@SpringBootTest
public class OrderControllerEndPointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;
    /*
    As a Rest Client
I want to submit new orders for bricks
So I can start customers’ orders

    Given
        A customer wants to buy any number of bricks
    When
        A create Order request for a number of bricks is submitted
    Then
        an Order reference is returned
	And the Order reference is unique to the submission

     */

    //create customer object
    //create Order object
    //create Entity
    private static Entity expectedEntity;
    private static Customer expectedCustomer;
    private static Order expectedOrder;
    private static List<Order> orders;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
        orders = new ArrayList<Order>();

        expectedEntity = new Entity(Long.valueOf(1),"Bricks",1000);
        expectedOrder = new Order(Long.valueOf(1),expectedEntity,LocalDate.now(), LocalTime.now(),expectedCustomer, Status.OrderStatus.START);
        orders.add(expectedOrder);
        expectedCustomer = new Customer(Long.valueOf(1),
                "George","CACI","12345678901",
                "george@gmail.com",orders);
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }





}
