package com.digisolfze.expedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightPricingInfoDTO {
	private String currencyCode;
	private double flightTotalBaseFare;
	private double flightTotalTax;
	private double flightTotalPrice;
	private double flightPerPsgrBaseFare;
	private double flightPerPsgrTax;
	private double flightPerPsgrBaseFarePlusTax;
	private double flightPerPsgrTotalPrice;
	private double trendAgcyFlightPrice;
	private double pctChangeFromTrend;
	private String formattedTotalPriceValue;

}
