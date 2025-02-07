package com.digisolfze.expedia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digisolfze.expedia.bean.SearchOffersResponse;
import com.digisolfze.expedia.client.ExpediaOffersClient;
import com.digisolfze.expedia.service.ExpediaService;

/**
 * Implementation of the ExpediaService interface.
 * This service class is responsible for interacting with the Expedia API
 * to fetch offers based on the origin and destination cities provided by the user.
 * It acts as a bridge between the controller and the client for making API calls.
 * 
 * @author Mohammed Nasro
 * 
 */
@Service(value = "expediaService")
public class DefaultExpediaService implements ExpediaService {

    /**
     * The client used to interact with the Expedia API to fetch offers.
     */
    @Autowired
    private ExpediaOffersClient expediaOffersClient;

    /**
     * Fetches offers from the Expedia API based on the provided origin and destination cities.
     * 
     * @param originCity The city of origin for the travel offer search.
     * @param destinationCity The city of destination for the travel offer search.
     * @return A {@link SearchOffersResponse} object containing the search results from the Expedia API.
     */
    @Override
    public SearchOffersResponse searchOffers(String originCity, String destinationCity) {
        return expediaOffersClient.fetchOffers(originCity, destinationCity);
    }

}

