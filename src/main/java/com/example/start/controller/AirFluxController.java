package com.example.start.controller;

import com.example.start.dto.FlightPlan;
import com.example.start.dto.OperationsPlan;
import com.example.start.service.AirFluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@ResponseBody
public class AirFluxController {

    @Autowired
    private AirFluxService airFluxService;


    @GetMapping(value = "/flightplan", produces = "application/json")
    public List<FlightPlan> getFlightPlans() {
        return airFluxService.getFlightPlans();
    }

    @GetMapping(value = "/flightplan/{airport}", produces = "application/json")
    public List<FlightPlan> getFlightPlans(@PathVariable String airport) {
        return airFluxService.getFlightPlans(airport);
    }


    @GetMapping(value = "/operationsplan/{registration}", produces = "application/json")
    public List<OperationsPlan> getOperationsPlan(@PathVariable String registration) {
        return airFluxService.getOperationPlan(registration);
    }
}
