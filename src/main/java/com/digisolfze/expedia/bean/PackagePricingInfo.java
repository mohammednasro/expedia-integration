package com.digisolfze.expedia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class PackagePricingInfo {
    private String currencyCode;
    private double perPsgrPackagePrice;
    private double totalPackagePrice;
    private double perPsgrSavings;
    private double totalSavings;
    private double percentSavings;
    private double savingsPctOfHotel;
    private double savingsPctOfFlight;
    private String formattedPerPassengerPackagePrice;
    private String formattedTotalPriceValue;
    
}