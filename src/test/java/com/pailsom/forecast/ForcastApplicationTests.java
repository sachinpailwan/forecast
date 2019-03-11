package com.pailsom.forecast;

import com.pailsom.forecast.controller.ForecastController;
import com.pailsom.forecast.entity.WeatherDetails;
import com.pailsom.forecast.service.ForeCastService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ForecastController.class)
public class ForcastApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ForeCastService service;

	@Test
	public void test() throws Exception {

		WeatherDetails weatherDetails = new WeatherDetails();
		weatherDetails.setCityName("Pune");
		weatherDetails.setId(1L);
		weatherDetails.setLoadDateTime(new Date());
		weatherDetails.setTemperature(30l);

		List<String> cities = new ArrayList<>();
		cities.add("Pune");
		List<WeatherDetails> list = new ArrayList<>();
		list.add(weatherDetails);

		BDDMockito.given(service.getHighestTemperatureCity(cities,"11 Mar 2019, 00:00:01 AM","11 Mar 2019, 11:58:59 PM")).willReturn(list);

		mvc.perform(get("/forecast?cities=pune")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
