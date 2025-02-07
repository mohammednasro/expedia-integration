package com.digisolfze.expedia.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Offers {
    @JsonProperty("Package")
    private List<Package> packages;
}