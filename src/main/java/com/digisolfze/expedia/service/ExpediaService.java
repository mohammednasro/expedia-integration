package com.digisolfze.expedia.service;

import com.digisolfze.expedia.bean.SearchOffersResponse;

/**
 * Service interface for interacting with Expedia's offer search API.
 * This interface defines the contract for fetching offers from Expedia's 
 * external service based on the origin and destination cities.
 * 
 * <p>The {@code searchOffers} method makes an external call to Expedia's
 * offer service and returns a {@link SearchOffersResponse} containing the
 * offers available for the specified cities, or null if no offers are found.</p>
 * 
 * <p>This service is responsible for retrieving raw data from Expedia and
 * providing it to the facade layer for further processing or transformation.</p>
 * 
 * @author Mohammed Nasro
 * 
 */
public interface ExpediaService {

    /**
     * Fetches available offers between the specified origin and destination cities.
     * 
     * @param originCity the city from which the journey will depart.
     * @param destinationCity the city where the journey will arrive.
     * @return a {@link SearchOffersResponse} containing the offers found for the
     *         given cities, or null if no offers are found.
     */
    public SearchOffersResponse searchOffers(String originCity, String destinationCity);
}
