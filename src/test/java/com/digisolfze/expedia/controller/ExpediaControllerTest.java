package com.digisolfze.expedia.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.digisolfze.expedia.facade.ExpediaFacade;


@SpringBootTest
@AutoConfigureMockMvc
class ExpediaControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@Autowired
	@Qualifier("expediaFacade")
	private ExpediaFacade expediaFacade;	
	
	
	@Test
	void testGetExpediaOffers() throws Exception {
		
	mockMvc.perform(MockMvcRequestBuilders.get("/v1/expedia/offers")
				.param("originCity", "Amman")
                .param("destinationCity", "New York")
                .header("accept", "*/*"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}

}
