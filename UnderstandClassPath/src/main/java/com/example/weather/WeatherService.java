package com.example.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherResponse getWeather(String zipcode) {
        String url = "https://wttr.in/" + zipcode + "?format=j1";

        try {
            TrustManager[] trustAll = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String type) {}
                public void checkServerTrusted(X509Certificate[] certs, String type) {}
            }};
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAll, new java.security.SecureRandom());

            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier((hostname, session) -> true);
            conn.setRequestProperty("User-Agent", "curl/8.0");

            String json;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                json = reader.lines().collect(Collectors.joining("\n"));
            }

            JsonNode root = objectMapper.readTree(json);
            JsonNode currentCondition = root.path("current_condition").get(0);
            JsonNode nearestArea = root.path("nearest_area").get(0);

            String location = nearestArea.path("areaName").get(0).path("value").asText()
                    + ", " + nearestArea.path("country").get(0).path("value").asText();
            String temperature = currentCondition.path("temp_F").asText() + "°F ("
                    + currentCondition.path("temp_C").asText() + "°C)";
            String humidity = currentCondition.path("humidity").asText() + "%";
            String description = currentCondition.path("weatherDesc").get(0).path("value").asText().trim();

            return new WeatherResponse(zipcode, location, temperature, humidity, description);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse weather data for zipcode: " + zipcode, e);
        }
    }
}
