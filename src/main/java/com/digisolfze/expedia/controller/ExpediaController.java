package com.digisolfze.expedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digisolfze.expedia.dto.OffersDTO;
import com.digisolfze.expedia.exception.ExpediaOffersException;
import com.digisolfze.expedia.facade.ExpediaFacade;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * The {@link ExpediaController} class handles the API endpoints related to Expedia offers.
 * It exposes a RESTful service for fetching package offers from Expedia, and handles any 
 * exceptions that may occur during the process.
 * 
 * This controller interacts with the {@link ExpediaFacade} to fetch offers and map them 
 * to the appropriate data transfer object (DTO).
 * 
 * @author Mohammed Nasro
 * 
 */
@RestController
@RequestMapping("/v1/expedia")
@Tag(name = "Expedia Offers Controller")
public class ExpediaController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExpediaController.class);
	
	@Autowired
	private ExpediaFacade expediaFacade;

	/**
     * Retrieves Expedia package offers based on the specified origin and destination cities.
     * This endpoint calls the {@link ExpediaFacade} to fetch the available offers and returns
     * them as an {@link OffersDTO} object.
     * 
     * @param originCity The city from which the package will depart. Defaults to "Amman" if not provided.
     * @param destinationCity The city where the package will arrive. Defaults to "New York" if not provided.
     * @return An {@link OffersDTO} containing the available offers, or an empty DTO if no offers are found.
     */
	@GetMapping("/offers")
	public OffersDTO getExpediaOffers(
			@Parameter(description = "The city from which the package will depart.", required = false) 
			@RequestParam(defaultValue = "Amman", required = false, name = "originCity") String originCity,
			@Parameter(description = "The city where the package will arrive.", required = false) 
			@RequestParam(defaultValue = "New York", required = false, name = "destinationCity") String destinationCity) {
		

		return expediaFacade.searchOffers(originCity, destinationCity).orElse(OffersDTO.builder().build());
	}
	
	/**
     * Handles any exceptions that occur during the execution of the API.
     * Logs the exception details and returns a structured error response.
     * 
     * @param ex The exception that was thrown.
     * @return A {@link ResponseEntity} containing a map of error details.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Map<String, String>>> handleException(Exception ex) {
        
    	String type=ex.getClass().getSimpleName();
    	if(ex instanceof ExpediaOffersException )
    	{
    		type=((ExpediaOffersException)ex).getType().toString();
    	}
    	
		LOG.error("Exception: Type [{}], Message [{}] ",type, ex.getMessage());

		Map<String, String> errors = Map.of(type, ex.getMessage());

		Map<String, Map<String, String>> map = new HashMap<>();
		map.put("errors", errors);
		
		return new ResponseEntity<Map<String, Map<String, String>>>(map, HttpStatus.BAD_REQUEST);

    }

}
