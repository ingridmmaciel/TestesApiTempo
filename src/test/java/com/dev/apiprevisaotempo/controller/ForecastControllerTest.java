package com.dev.apiprevisaotempo.controller;

import static org.mockito.Mockito.when;

import com.dev.apiprevisaotempo.dto.request.ForecastRequest;
import com.dev.apiprevisaotempo.dto.response.CityResponse;
import com.dev.apiprevisaotempo.entity.City;
import com.dev.apiprevisaotempo.entity.Forecast;
import com.dev.apiprevisaotempo.service.ForecastService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ForecastController.class})
@ExtendWith(SpringExtension.class)
class ForecastControllerTest {
    @Autowired
    private ForecastController forecastController;

    @MockBean
    private ForecastService forecastService;

    @Test
    void testGetForecast() throws Exception {
        // Arrange
        City city = new City();
        city.setAtualizacao(LocalDate.of(1970, 1, 1));
        city.setId(1L);
        city.setNome("foo");
        city.setPrevisoes(new ArrayList<>());
        city.setUf("foo");

        Forecast forecast = new Forecast();
        forecast.setCity(city);
        forecast.setDia("foo");
        forecast.setId(1L);
        forecast.setIuv(10.0d);
        forecast.setMaxima(1);
        forecast.setMinima(1);
        forecast.setTempo("foo");
        when(forecastService.getForecastByCityId(Mockito.<Long>any())).thenReturn(forecast);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/forecast/{idCity}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(forecastController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<Forecast><id>1</id><dia>foo</dia><tempo>foo</tempo><maxima>1</maxima><minima>1</minima><iuv>10.0</iuv"
                                        + "><city><nome>foo</nome><uf>foo</uf><atualizacao>1970</atualizacao><atualizacao>1</atualizacao><atualizacao"
                                        + ">1</atualizacao><id>1</id></city></Forecast>"));
    }

    @Test
    void testGetForecastByCityName() throws Exception {
        // Arrange
        CityResponse cityResponse = new CityResponse();
        cityResponse.setAtualizacao(LocalDate.of(1970, 1, 1));
        cityResponse.setNome("Nome");
        cityResponse.setPrevisoes(new ArrayList<>());
        cityResponse.setUf("Uf");
        when(forecastService.getForecastByCityName(Mockito.<ForecastRequest>any())).thenReturn(cityResponse);

        ForecastRequest forecastRequest = new ForecastRequest();
        forecastRequest.setCityName("Oxford");
        String content = (new ObjectMapper()).writeValueAsString(forecastRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/forecast/city")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(forecastController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<CityResponse><nome>Nome</nome><uf>Uf</uf><atualizacao>1970</atualizacao><atualizacao>1</atualizacao"
                                        + "><atualizacao>1</atualizacao><previsoes/></CityResponse>"));
    }
}
