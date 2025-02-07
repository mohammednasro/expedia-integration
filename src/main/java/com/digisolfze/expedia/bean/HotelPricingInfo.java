package com.digisolfze.expedia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelPricingInfo {
	private double hotelPerPsgrBaseRate;
	private double hotelPerPsgrTaxesAndFees;
	private double hotelPerPsgrTotalRate;
	private double hotelTotalBaseRate;
	private double hotelTotalTaxesAndFees;
	private double hotelTotalRate;
	private String currency;
	private String formattedTotalPriceValue;
	private boolean displayAveragePrice;
	private boolean drr;
}