package com.dev.apiprevisaotempo.repository;

import com.dev.apiprevisaotempo.entity.City;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {CityRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.dev.apiprevisaotempo.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    /**
     * Method under test: {@link CityRepository#findByNome(String)}
     */
    @Test
    void testFindByNome() {
        // Arrange
        City city = new City();
        city.setAtualizacao(LocalDate.of(1970, 1, 1));
        city.setId(1L);
        city.setNome("Nome");
        city.setPrevisoes(new ArrayList<>());
        city.setUf("Uf");

        City city2 = new City();
        city2.setAtualizacao(LocalDate.of(1970, 1, 1));
        city2.setId(2L);
        city2.setNome("com.dev.apiprevisaotempo.entity.City");
        city2.setPrevisoes(new ArrayList<>());
        city2.setUf("com.dev.apiprevisaotempo.entity.City");
        cityRepository.save(city);
        cityRepository.save(city2);

        // Act
        City result = cityRepository.findByNome("Nome");

        // Assert
        assertNotNull(result);
        assertTrue(result.getNome().equals("Nome"));
    }
}
