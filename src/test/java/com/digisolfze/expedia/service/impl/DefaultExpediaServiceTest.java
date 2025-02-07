package com.digisolfze.expedia.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.digisolfze.expedia.bean.SearchOffersResponse;

@SpringBootTest
class DefaultExpediaServiceTest {

    @Autowired
	@Qualifier("expediaService")
	private DefaultExpediaService expediaService;
	
	@Test
	void testSearchOffers() {
	       String originCity = "Amman";
	        String destinationCity = "New York";

	        SearchOffersResponse result = expediaService.searchOffers(originCity, destinationCity);

	        assertTrue(result!=null);
	        assertTrue(result.getOffers()!=null);
	        assertTrue(!CollectionUtils.isEmpty(result.getOffers().getPackages()));

	}

}
