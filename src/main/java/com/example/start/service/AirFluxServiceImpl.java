package com.example.start.service;


import com.example.start.dto.FlightPlan;
import com.example.start.dto.OperationsPlan;
import com.example.start.exceptions.ResourceNotFoundException;
import com.example.start.model.Aircraft;
import com.example.start.model.Airport;
import com.example.start.model.FlightSchedule;
import com.example.start.repository.AircraftRepository;
import com.example.start.repository.AirportRepository;
import com.example.start.repository.FlightScheduleRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("AirFluxService")
@Transactional(readOnly = true)
public class AirFluxServiceImpl implements AirFluxService {

    @Autowired
    private FlightScheduleRepository flightScheduleRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public List<FlightPlan> getFlightPlans(String airport) {
        List<FlightPlan> flightPlans = new ArrayList<>();
        List<FlightSchedule> flightSchedules = flightScheduleRepository.findAll();
        List<Aircraft> allAirCrafts = aircraftRepository.findAll();
        getFlightPlans(flightPlans, flightSchedules, allAirCrafts);
        return flightPlans.stream().filter(a -> a.getOrigin().equals(airport)).collect(Collectors.toList());
    }

    @Override
    public List<FlightPlan> getFlightPlans() {
        List<FlightPlan> flightPlans = new ArrayList<>();
        List<FlightSchedule> flightSchedules = flightScheduleRepository.findAll();
        List<Aircraft> allAirCrafts = aircraftRepository.findAll();

        return getFlightPlans(flightPlans, flightSchedules, allAirCrafts);
    }

    private List<FlightPlan> getFlightPlans(List<FlightPlan> flightPlans, List<FlightSchedule> flightSchedules, List<Aircraft> allAirCrafts) {

        //This is for fixing LHR time zone
        for (FlightSchedule flightSchedule : flightSchedules) {
            flightSchedule.setDepartureTime(fixTimeZone(flightSchedule.getDepartureTime(), -1, flightSchedule.getOrigin().getCode()));
            flightSchedule.setDuration(fixTimeZone(flightSchedule.getDuration(), -1, flightSchedule.getDestination().getCode()));
        }

        flightSchedules.sort((o1, o2) -> {
            if (o1.getDepartureTime() == null || o2.getDepartureTime() == null)
                return 0;
            return o1.getDepartureTime().compareTo(o2.getDepartureTime());
        });

        flightSchedules.sort((o1, o2) -> {
            if (o1.getDuration() == null || o2.getDuration() == null)
                return 0;
            return o1.getDuration().compareTo(o2.getDuration());
        });

        for (FlightSchedule schedule : flightSchedules) {
            String type = null;
            Airport origin = schedule.getOrigin();
            Airport destination = schedule.getDestination();

            for (Aircraft ac : allAirCrafts) {
                if (ac.getLocation().getId().equals(origin.getId()) && (ac.getNowTime() == null || ac.getNowTime().before(schedule.getDepartureTime()))) {
                    type = ac.getType();
                    ac.setLocation(destination);
                    ac.setNowTime(schedule.getDuration());
                    break;
                }
            }

            FlightPlan plan = new FlightPlan();
            plan.setOrigin(origin.getCode());
            plan.setDestination(destination.getCode());
            Date depDate = fixTimeZone(schedule.getDepartureTime(), 1, origin.getCode());
            plan.setDeparture(formatDate(depDate, origin.getLocation()));
            Date arrDate = fixTimeZone(schedule.getDuration(), 1, destination.getCode());
            plan.setArrival(formatDate(arrDate, destination.getLocation()));
            plan.setEquipment(type);
            flightPlans.add(plan);
        }


        return flightPlans;
    }

    private Date fixTimeZone(Date departureTime, int diff, String airportCode) {
        if (airportCode.equals("LHR")) {
            return DateUtils.addHours(departureTime, diff);
        }

        return DateUtils.addHours(departureTime, 0);
    }

    private String getTimeCity(String city) {
        switch (city) {
            case "Munich":
                return "Berlin";
            case "Hamburg":
                return "Berlin";
            default:
                return city;

        }
    }

    private String formatDate(Date date, String city) {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss.SSS'Z'");
        String s = d.format(date) + "T" + t.format(date);
        ZonedDateTime zonedDateTime = Instant.parse(s).atZone(ZoneId.of("Europe/" + getTimeCity(city)));
        return zonedDateTime.toString().substring(0, 22);
    }

    @Override
    public List<OperationsPlan> getOperationPlan(String registration) {
        List<FlightPlan> flightPlans = new ArrayList<>();
        List<OperationsPlan> operationsPlans = new ArrayList<>();
        List<FlightSchedule> flightSchedules = flightScheduleRepository.findAll();
        List<Aircraft> allAirCrafts = aircraftRepository.findAll();
        getFlightPlans(flightPlans, flightSchedules, allAirCrafts);

        Optional<Aircraft> any = allAirCrafts.stream().filter(a -> a.getRegNumber().equals(registration)).findAny();
        if (!any.isPresent()) {
            throw new ResourceNotFoundException("Registration Number not found", registration, "");
        }

        Aircraft aircraft = any.get();

        List<FlightPlan> filteredFlightPlans = flightPlans.stream().filter(a -> a.getEquipment().equals(aircraft.getType())).collect(Collectors.toList());
        for (FlightPlan plan : filteredFlightPlans) {
            OperationsPlan oPlan = new OperationsPlan();
            oPlan.setDeparture(plan.getDeparture());
            oPlan.setDestination(plan.getDestination());
            oPlan.setOrigin(plan.getOrigin());
            operationsPlans.add(oPlan);
        }
        return operationsPlans;
    }
}
