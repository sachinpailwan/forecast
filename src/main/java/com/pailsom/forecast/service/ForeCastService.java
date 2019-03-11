package com.pailsom.forecast.service;

import com.pailsom.forecast.entity.AuditLog;
import com.pailsom.forecast.entity.WeatherDetails;
import com.pailsom.forecast.repository.AuditLogRespository;
import com.pailsom.forecast.repository.WeatherDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForeCastService {

    @Autowired
    WeatherDetailRepository repository;

    @Autowired
    AuditLogRespository auditLogRespository;

    public List<WeatherDetails> getHighestTemperatureCity(List<String> cities,String startTime ,String endTime) {

       return cities.stream().map(cityName->{
           try {
               return repository.getHighestForeCast(cityName, startTime,endTime).get(0);
           } catch (Exception e) {
               return new WeatherDetails(-1L,new Date(),cityName,-1);
           }
       }).collect(Collectors.toList());
    }

    public void auditLog(AuditLog auditLog){
        auditLogRespository.save(auditLog);
    }
}
