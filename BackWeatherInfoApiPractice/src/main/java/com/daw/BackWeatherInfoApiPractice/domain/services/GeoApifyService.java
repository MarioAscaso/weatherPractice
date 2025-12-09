package com.daw.BackWeatherInfoApiPractice.domain.services;

import com.daw.BackWeatherInfoApiPractice.domain.api.responses.GeoApifyResponse;
import com.daw.BackWeatherInfoApiPractice.shared.api.ApiService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeoApifyService {

    @Value("${geoapify.api.geocoding}")
    String geocodingEndopoint;

    @Autowired
    ApiService apiService;

    public GeoApifyResponse geocoding(String aCity) throws IOException{
        String geocodingEndpointURL = geocodingEndopoint.replace("<city>", aCity);
        ResponseBody responseBody = apiService.get(geocodingEndpointURL);

        if(responseBody==null){
            throw new IOException("LA RESPUESTA DE LA API ES NULA!");
        }

        String jsonReceived = responseBody.string();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonReceived);

        JsonNode results = rootNode.path("results");

        if (results.isArray() && results.size() > 0) {
            JsonNode firstResult = results.get(0);

            double lat = firstResult.path("lat").asDouble();
            double lon = firstResult.path("lon").asDouble();

            return new GeoApifyResponse(lon, lat);
        } else {
            throw new IOException("NO SE HAN ENCONTRADO COORDENADAS PARA LA CIUDAD: " + aCity);
        }
    }
}

