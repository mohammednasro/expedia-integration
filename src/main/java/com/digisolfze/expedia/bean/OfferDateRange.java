package com.digisolfze.expedia.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OfferDateRange {
    private List<Integer> travelStartDate;
    private List<Integer> travelEndDate;
    private String formattedTravelStartDate;
    private String formattedTravelEndDate;
    private int lengthOfStay;
    
    // Getters and Setters
}
