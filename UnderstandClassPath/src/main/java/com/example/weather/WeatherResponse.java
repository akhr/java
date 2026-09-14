package com.example.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private String zipcode;
    private String location;
    private String temperature;
    private String humidity;
    private String description;
}
