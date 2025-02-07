package com.digisolfze.expedia.facade.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digisolfze.expedia.bean.SearchOffersResponse;
import com.digisolfze.expedia.dto.OffersDTO;
import com.digisolfze.expedia.facade.ExpediaFacade;
import com.digisolfze.expedia.mapper.OffersMapper;
import com.digisolfze.expedia.service.ExpediaService;

/**
 * Default implementation of the {@link ExpediaFacade} interface.
 * This service class interacts with the Expedia API to fetch package offers
 * by using the {@link ExpediaService} and converts the offers to DTOs 
 * using the {@link OffersMapper}.
 * 
 * It provides a higher level of abstraction for interacting with Expedia
 * and returning {@link OffersDTO} to the client.
 * 
 * @author Mohammed Nasro
 * 
 */
@Service(value = "expediaFacade")
public class DefaultExpediaFacade implements ExpediaFacade {

    @Autowired
    private OffersMapper offersMapper;

    @Autowired
    private ExpediaService expediaService;

    /**
     * Searches for offers from Expedia based on the specified origin and destination cities.
     * This method fetches the offers from the {@link ExpediaService} and maps them to a 
     * {@link OffersDTO} object. If no offers are found, it returns an empty {@link Optional}.
     * 
     * @param originCity The city of origin for the offer search.
     * @param destinationCity The city of destination for the offer search.
     * @return An {@link Optional} containing the {@link OffersDTO} if offers are found, otherwise an empty {@link Optional}.
     */
    @Override
    public Optional<OffersDTO> searchOffers(String originCity, String destinationCity) {

        SearchOffersResponse searchOffersResponse = expediaService.searchOffers(originCity, destinationCity);

        return searchOffersResponse == null || searchOffersResponse.getOffers() == null ? Optional.empty()
                : Optional.ofNullable(offersMapper.toDTO(searchOffersResponse.getOffers()));
    }
}
