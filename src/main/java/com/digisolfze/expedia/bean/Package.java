package com.digisolfze.expedia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Package {
    private OfferDateRange offerDateRange;
    private Destination destination;
    private boolean displayDestinationAlternativeIsAvailable;
    private HotelInfo hotelInfo;
    private HotelPricingInfo hotelPricingInfo;
    private FlightInfo flightInfo;
    private FlightPricingInfo flightPricingInfo;
    private PackageInfo packageInfo;
    private PackagePricingInfo packagePricingInfo;
    private PackageUrls packageUrls;
    private Origin origin;

}