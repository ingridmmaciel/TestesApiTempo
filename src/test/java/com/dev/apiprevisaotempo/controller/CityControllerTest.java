package com.dev.apiprevisaotempo.controller;

import static org.mockito.Mockito.when;

import com.dev.apiprevisaotempo.service.CityService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CityController.class})
@ExtendWith(SpringExtension.class)
class CityControllerTest {
    @Autowired
    private CityController cityController;

    @MockBean
    private CityService cityService;

    @Test
    void testGetAllCity() throws Exception {
        // Arrange
        when(cityService.getAllCities()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cities");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }
}
