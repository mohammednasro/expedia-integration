package com.digisolfze.expedia.facade.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.digisolfze.expedia.dto.OffersDTO;

@SpringBootTest
class DefaultExpediaFacadeTest {

    @Autowired
	@Qualifier("expediaFacade")
	private DefaultExpediaFacade expediaFacade;
	

    @Test
    void testSearchOffersSuccess() {
        String originCity = "Amman";
        String destinationCity = "New York";

        Optional<OffersDTO> result = expediaFacade.searchOffers(originCity, destinationCity);

        assertTrue(result.isPresent());
    }
}
