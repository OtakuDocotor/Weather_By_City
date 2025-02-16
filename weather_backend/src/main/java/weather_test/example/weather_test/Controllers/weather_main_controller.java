package weather_test.example.weather_test.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import weather_test.example.weather_test.Models.forecast_weather;
import weather_test.example.weather_test.Service.WeatherService;
import weather_test.example.weather_test.repo.forecast_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/weather")
public class weather_main_controller {

    private final WeatherService weatherService;
    @Autowired
    private forecast_repo repo;

    public weather_main_controller(WeatherService ws)
    {
        this.weatherService=ws;
    }

    public weather_main_controller()
    {
        this.weatherService= new WeatherService();
    }

    @GetMapping("/current")
    public forecast_weather postMethodName(@RequestParam String city) {
        forecast_weather res =weatherService.getWeatherByCity(city);
        repo.save(res);
        return res;
    }
    
}
