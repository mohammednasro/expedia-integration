package com.digisolfze.expedia.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OfferDateRangeDTO {
    private List<Integer> travelStartDate;
    private List<Integer> travelEndDate;
    private String formattedTravelStartDate;
    private String formattedTravelEndDate;
    private int lengthOfStay;
    
}
