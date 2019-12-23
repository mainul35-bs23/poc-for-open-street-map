package com.dkv.model;

import lombok.*;

import java.util.List;

@Data
public class TripDetails {
    private String startDate;
    private List<Location> locations;
    private PersonalizationInformation personalizationInformation;
    private String routingOptions;
}
