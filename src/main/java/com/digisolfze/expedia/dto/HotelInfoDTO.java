package com.digisolfze.expedia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelInfoDTO {
	private String hotelId;
	private String hotelName;
	private String localizedHotelName;
	private String hotelDestination;
	private String hotelDestinationRegionID;
	private String hotelLongDestination;
	private String hotelStreetAddress;
	private String hotelCity;
	private String hotelProvince;
	private String hotelCountryCode;
	private double hotelLatitude;
	private double hotelLongitude;
	private String hotelStarRating;
	private double hotelGuestReviewRating;
	private String formattedHotelGuestReviewRating;
	private int hotelReviewTotal;
	private String formattedHotelReviewTotal;
	private String hotelImageUrl;
	private String bigHotelImageUrl;
	private String vipIconUrl;
	private boolean vipAccess;
	private boolean enhancedCleaningAvailable;
    @JsonProperty("isOfficialRating")
	private boolean officialRating;
    
}
