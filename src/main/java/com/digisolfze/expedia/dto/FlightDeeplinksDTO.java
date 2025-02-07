package com.digisolfze.expedia.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FlightDeeplinksDTO {
	private String flightSearchUrl;
	private String decodedFlightSearchUrl;

}