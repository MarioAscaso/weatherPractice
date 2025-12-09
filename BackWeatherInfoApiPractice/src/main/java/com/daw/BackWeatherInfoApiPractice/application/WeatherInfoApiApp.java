package com.daw.BackWeatherInfoApiPractice.application;

import com.daw.BackWeatherInfoApiPractice.domain.api.responses.GeoApifyResponse;
import com.daw.BackWeatherInfoApiPractice.domain.services.GeoApifyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class WeatherInfoApiApp {

    @Autowired
    GeoApifyService geoApifyService;

    public GeoApifyResponse getLonLan(String aCity) throws IOException {
        GeoApifyResponse geoResponse = geoApifyService.geocoding(aCity);
        return geoResponse;
    }

}
