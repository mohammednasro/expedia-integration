package com.digisolfze.expedia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class PackageUrls {
    private String packageSearchUrl;
    private String decodedPackageSearchUrl;
    private String similarSearchLink;
    private FlightDeeplinks flightDeeplinks;
    private HotelDeeplinks hotelDeeplinks;
}