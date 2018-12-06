package com.example.start.repository;

import com.example.start.model.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {

    @Query("select s from FlightSchedule s where s.origin.code = :airport")
    List<FlightSchedule> findByAirportLocation(@Param("airport") String airport);

}
