package com.pailsom.forecast.repository;

import com.pailsom.forecast.entity.WeatherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherDetailRepository extends JpaRepository<WeatherDetails, Long> {

   /* @Query("select details from WeatherDetails details where cityName in :cities")
    List<WeatherDetails> getWeatherDetailsByCities(@Param("cities") List<String> cities);*/

    @Query("select d from WeatherDetails d where cityName=:cityName And loadDateTime Between PARSEDATETIME(:startTime,'dd MMM yyyy, hh:mm:ss a','en') " +
            " and PARSEDATETIME(:endTime,'dd MMM yyyy, hh:mm:ss a','en') and temperature in (" +
            "select max(details.temperature) from WeatherDetails details where cityName=:cityName And loadDateTime Between PARSEDATETIME(:startTime,'dd MMM yyyy, hh:mm:ss a','en')" +
            " and PARSEDATETIME(:endTime,'dd MMM yyyy, hh:mm:ss a','en'))")
    List<WeatherDetails> getHighestForeCast(@Param("cityName") String cityName, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
