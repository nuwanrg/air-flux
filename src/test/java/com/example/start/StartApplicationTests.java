package com.example.start;

import com.example.start.dto.FlightPlan;
import com.example.start.dto.OperationsPlan;
import com.example.start.service.AirFluxServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartApplicationTests {

    @Autowired
    private AirFluxServiceImpl airFluxService;

    //These are the unit test cases to be developed
    @Test
    public void testFlightPlan() {
        List<FlightPlan> flightPlans = airFluxService.getFlightPlans();
    }

    //These are the unit test cases to be developed
    @Test
    public void testOperationsPlan() {
        List<OperationsPlan> operationPlan = airFluxService.getOperationPlan("FL-0001");
    }

}
