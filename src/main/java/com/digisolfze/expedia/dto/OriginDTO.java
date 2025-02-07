package com.digisolfze.expedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginDTO {
    private String regionID;
    private String longName;
    private String country;
    private String province;
    private String city;
    private String tla;
    private String source;
}