package com.digisolfze.expedia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class FlightInfo {
    private String flightDealCarrier;
    private String flightDealCarrierName;
    private int lengthOfStay;
    private String flightDealCarrierImageUrl;
    private String flightDealCarrierImageUrlSqSvg;
    private String tripType;
}