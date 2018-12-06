package com.example.start.service;


import com.example.start.dto.FlightPlan;
import com.example.start.dto.OperationsPlan;

import java.util.List;

public interface AirFluxService {

    /**
     * Get flight plans by airport
     *
     * @param airport
     * @return list of {@code FlightPlan}
     */
    public List<FlightPlan> getFlightPlans(String airport);

    /**
     * get all flight plans
     *
     * @return list of {@code FlightPlan}
     */
    public List<FlightPlan> getFlightPlans();

    /**
     * get operation plans by registration number
     *
     * @param registration registration number
     * @return list of {@code OperationsPlan}
     */
    public List<OperationsPlan> getOperationPlan(String registration);

}
