package weather_test.example.weather_test.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import weather_test.example.weather_test.Models.forecast_weather;

@Service
public class WeatherService {
    private String _ApiUrl = "https://api.openweathermap.org/data/2.5/weather";
    private final RestTemplate _restTemplate;
    public WeatherService(RestTemplate resttemp) {
        this._restTemplate = resttemp;
    }
    public WeatherService()
    {
        this._restTemplate= new RestTemplate();
    }
    public forecast_weather getWeatherByCity(String city, String key ) {
        String url = UriComponentsBuilder.fromUriString(_ApiUrl)
                .queryParam("q", city)
                .queryParam("appid", key)
                .queryParam("units", "metric")
                .toUriString();
        forecast_weather res=(_restTemplate.getForObject(url, Jsn_To_Weather.class)).ConvertToForecast();
        return  res;
    }
}
