package com.example.weather;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Path("/weather")
@RequiredArgsConstructor
public class WeatherResource {

    private final WeatherService weatherService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public WeatherResponse getWeather(WeatherRequest request) {
        return weatherService.getWeather(request.getZipcode());
    }
}
