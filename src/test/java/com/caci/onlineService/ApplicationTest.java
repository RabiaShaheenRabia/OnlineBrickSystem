package com.caci.onlineService;

import com.caci.onlinebricksystem.Application;
import com.caci.onlinebricksystem.controller.CustomerControllerEndPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Rabia on 03/12/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class ApplicationTest {
    @Test
    public void contextLoads(){

    }
}
