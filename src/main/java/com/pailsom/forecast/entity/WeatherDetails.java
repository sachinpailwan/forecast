package com.pailsom.forecast.entity;

import com.pailsom.forecast.controller.ForecastController;
import sun.rmi.runtime.Log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="WeatherDetails")
public class WeatherDetails {
    public WeatherDetails() {
    }

    @Override

    public String toString() {
        return "WeatherDetails{" +
                "id=" + id +
                ", loadDateTime=" + ForecastController.format.format(loadDateTime) +
                ", cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    public WeatherDetails(Long id, Date loadDateTime, String cityName, long temperature) {
        this.id = id;
        this.loadDateTime = loadDateTime;
        this.cityName = cityName;
        this.temperature = temperature;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date loadDateTime;
    private String cityName;
    private long temperature;

    public Date getLoadDateTime() {
        return loadDateTime;
    }

    public void setLoadDateTime(Date loadDateTime) {
        this.loadDateTime = loadDateTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }
}
