package com.caci.onlineService.controller;

import com.caci.onlinebricksystem.common.Status;
import com.caci.onlinebricksystem.controller.CustomerControllerEndPoint;
import com.caci.onlinebricksystem.controller.EntityControllerEndPoint;
import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Entity;
import com.caci.onlinebricksystem.domain.Order;
import com.caci.onlinebricksystem.service.ICustomerService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


/**
 * Created by Rabia on 03/12/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = CustomerControllerEndPoint.class)
@ContextConfiguration(classes = CustomerControllerEndPoint.class)
public class CustomerControllerEndPointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICustomerService customerService;//= new CustomerService();

    private static Entity expectedEntity;
    private static Customer expectedCustomer;
    private static Order expectedOrder;
    private static List<Order> orders=new ArrayList<>();



    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
        orders = new ArrayList<Order>();

        expectedEntity = new Entity(Long.valueOf(1),"Bricks",1000);
        expectedOrder = new Order(Long.valueOf(1),expectedEntity, LocalDate.now(), LocalTime.now(),expectedCustomer, Status.OrderStatus.START);
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



    @Test
    public void registerCustomerTest() throws Exception {
        when(customerService.registerCustomer(
                       Mockito.any(Customer.class) )).thenReturn(expectedCustomer);

        // Send customer as body to /customers
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/bricks/customers").contentType(APPLICATION_JSON_UTF8)
                        .requestAttr("newCustomer",expectedCustomer);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("http://localhost/bricks/customers/1",
          response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void verifyAllCustomersList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bricks/customers").accept(APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0))).andDo(print());
    }



    @Test
    public void retreiveSpecificCustomerTest() throws Exception{
        when(customerService.retreiveSpecificCustomer(Mockito.any(Long.class))
                ).thenReturn(expectedCustomer);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bricks/customers/1").accept(APPLICATION_JSON_UTF8);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void retreiveOrdersForCustomerTest() throws Exception{
        when(customerService.retreiveOrdersForCustomer(Mockito.any(Long.class))
        ).thenReturn(orders);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bricks/customers/1/orders").accept(APPLICATION_JSON_UTF8);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());


    }

    @Test
    public void retreiveDetailsForSpecificOrderTest() throws Exception{
        when(customerService.retreiveDetailsForSpecificOrder(
                Mockito.any(Long.class),Mockito.any(Long.class))
        ).thenReturn(expectedOrder);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bricks/customers/1/orders/1").accept(APPLICATION_JSON_UTF8);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    public void deleteCustomerTest() throws Exception{
        when(customerService.deleteCustomer(Mockito.any(Long.class))
        ).thenReturn(expectedCustomer);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bricks/customers/1").accept(APPLICATION_JSON_UTF8);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());


    }

    @Test
    public void updateCustomerTest() throws Exception{
        when(customerService.updateCustomer(Mockito.any(Long.class))
        ).thenReturn(expectedCustomer);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/bricks/customers/1").accept(APPLICATION_JSON_UTF8);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());


    }


}
