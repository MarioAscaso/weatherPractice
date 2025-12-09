package com.daw.BackWeatherInfoApiPractice.domain.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoApifyResponse{

    private double lon;
    private double lat;

    public GeoApifyResponse(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {return lon;}
    public double getLat() {return lat;}
}