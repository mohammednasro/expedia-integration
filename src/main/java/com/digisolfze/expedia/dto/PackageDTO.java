package com.digisolfze.expedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO {
	private OfferDateRangeDTO offerDateRange;
	private DestinationDTO destination;
	private boolean displayDestinationAlternativeIsAvailable;
	private HotelInfoDTO hotelInfo;
	private HotelPricingInfoDTO hotelPricingInfo;
	private FlightInfoDTO flightInfo;
	private FlightPricingInfoDTO flightPricingInfo;
	private PackageInfoDTO packageInfo;
	private PackagePricingInfoDTO packagePricingInfo;
	private PackageUrlsDTO packageUrls;
	private OriginDTO origin;
}