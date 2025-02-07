package com.digisolfze.expedia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HotelDeeplinks {

	private String hotelInfositeUrl;
	private String hotelSearchResultUrl;
	private String pinnedHotelSearchResultUrl;
	private String decodedHotelInfositeUrl;
	private String decodedHotelSearchResultUrl;
	private String decodedHsrSortByVrUrl;
	private String decodedPinnedHsrSortByRecommendedUrl;
	private String decodedPinnedHsrSortByBestUrl;
	private String decodedPinnedHsrSortByModUrl;
	private String decodedPinnedHsrSortByVrUrl;
	private String similarSearchLink;


}