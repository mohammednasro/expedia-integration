package com.digisolfze.expedia.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class PackageUrlsDTO {
    private String packageSearchUrl;
    private String decodedPackageSearchUrl;
    private String similarSearchLink;
    private FlightDeeplinksDTO flightDeeplinks;
    private HotelDeeplinksDTO hotelDeeplinks;
}