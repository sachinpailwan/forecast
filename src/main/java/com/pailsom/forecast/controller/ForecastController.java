package com.pailsom.forecast.controller;

import com.pailsom.forecast.entity.AuditLog;
import com.pailsom.forecast.entity.WeatherDetails;
import com.pailsom.forecast.service.ForeCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class ForecastController {

    @Autowired
    ForeCastService service;
    public static SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss a", Locale.ENGLISH);

    @RequestMapping(value = "/forecast",method = RequestMethod.GET)
    public List<WeatherDetails> getHighestTemperature(@RequestParam(value = "cities") List<String> cities)  {

        List<WeatherDetails> weatherDetails = service.getHighestTemperatureCity(cities,
                "11 Mar 2019, 00:00:01 AM",
                "11 Mar 2019, 11:58:59 PM");
        updateLog(cities.toString(), weatherDetails.toString());
        return weatherDetails;
    }

    private void updateLog(@RequestParam(value = "cities") String request, String response) {
        AuditLog auditLog = new AuditLog();
        auditLog.setRequest(request);
        auditLog.setResponse(response);
        auditLog.setLoadDate(new Date());
        service.auditLog(auditLog);
    }

    @RequestMapping(value = "/forecastfortime",method = RequestMethod.GET)
    public List<WeatherDetails> getHighestTemperatureWithTime(@RequestParam(value = "cities") List<String> cities,
                                                              @RequestParam (value="startTime") String startTime,
                                                              @RequestParam (value="endTime") String endTime) throws ParseException {

        List<WeatherDetails> weatherDetails = service.getHighestTemperatureCity(cities,
                startTime,
                endTime);
        updateLog("cities"+cities.toString()+" startTime"+startTime+" endTime"+endTime, weatherDetails.toString());
        return weatherDetails;
    }

}
