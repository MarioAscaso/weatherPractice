package com.daw.BackWeatherInfoApiPractice.infrastructure.controller;


import com.daw.BackWeatherInfoApiPractice.application.WeatherInfoApiApp;
import com.daw.BackWeatherInfoApiPractice.domain.api.responses.GeoApifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class WeatherInfoApiController {

    @Autowired
    WeatherInfoApiApp app;

    @GetMapping("/getLonLat")
    public GeoApifyResponse getLanLon(@RequestParam(name="city") String aCity) throws IOException{
        return app.getLonLan(aCity);
    }
}
