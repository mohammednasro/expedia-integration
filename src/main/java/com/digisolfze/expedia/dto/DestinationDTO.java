package com.digisolfze.expedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

   public class DestinationDTO {
        private String regionID;
        private String longName;
        private String continent;
        private String country;
        private String province;
        private String city;
        private String displayDestination;
        private String flightDestination;
        private String displayDestinationRegionId;
        private String tla;
        private String metrocode;
        private int pointOfSaleRank;
        
    }