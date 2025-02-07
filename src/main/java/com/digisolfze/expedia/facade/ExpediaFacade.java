package com.digisolfze.expedia.facade;

import java.util.Optional;

import com.digisolfze.expedia.dto.OffersDTO;

/**
 * Facade interface for providing a simplified API for searching Expedia offers.
 * This facade abstracts the underlying service layer and provides a unified method 
 * for fetching available offers between two cities.
 * 
 * <p>The {@code searchOffers} method retrieves offers from Expedia based on the
 * provided origin and destination cities, returning the results as an optional DTO
 * containing the list of offers, if available.</p>
 * 
 * <p>This interface acts as a mediator between the client and the underlying service
 * implementation, allowing clients to interact with Expedia offers in a simplified manner.</p>
 * @author Mohammed Nasro
 */
public interface ExpediaFacade {

    /**
     * Searches for available offers between the specified origin and destination cities.
     * 
     * @param originCity the city from which the journey will depart.
     * @param destinationCity the city where the journey will arrive.
     * @return an {@link Optional} containing an {@link OffersDTO} if offers are found;
     *         otherwise, an empty {@link Optional}.
     */
    public Optional<OffersDTO> searchOffers(String originCity, String destinationCity);
}
