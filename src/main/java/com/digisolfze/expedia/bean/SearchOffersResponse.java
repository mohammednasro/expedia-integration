package com.digisolfze.expedia.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchOffersResponse {
	private OfferInfo offerInfo;
	private UserInfo userInfo;
	private DebugInfo debugInfo;
	private AbInfo abInfo;
	private PricingSummaries pricingSummaries;
	private Offers offers;
}
