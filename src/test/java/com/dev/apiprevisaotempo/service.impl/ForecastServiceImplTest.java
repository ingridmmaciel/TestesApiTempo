package com.dev.apiprevisaotempo.service.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.dev.apiprevisaotempo.mapper.CityMapper;
import com.dev.apiprevisaotempo.repository.CityRepository;
import com.dev.apiprevisaotempo.repository.ForecastRepository;
import com.dev.apiprevisaotempo.service.CityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ForecastServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ForecastServiceImplTest {
    @MockBean
    private CityMapper cityMapper;

    @MockBean
    private CityRepository cityRepository;

    @MockBean
    private CityService cityService;

    @MockBean
    private ForecastRepository forecastRepository;

    @Autowired
    private ForecastServiceImpl forecastServiceImpl;

    @Test
    void testGetForecastByCityId() {
        // Arrange, Act and Assert
        assertNull(forecastServiceImpl.getForecastByCityId(1L));
    }
}
