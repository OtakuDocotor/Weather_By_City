package weather_test.example.weather_test.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import weather_test.example.weather_test.Models.forecast_weather;
import weather_test.example.weather_test.Service.WeatherService;
import weather_test.example.weather_test.repo.forecast_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/weather")
@CrossOrigin(origins ="http://localhost:5173")
public class weather_main_controller {

    private final WeatherService weatherService;
    @Autowired
    private forecast_repo _Forecast_repo;

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
        _Forecast_repo.save(res);
        return res;
    }

    @GetMapping("/history")
    public Iterable<forecast_weather> getMethodName() {
        Iterable<forecast_weather> res= _Forecast_repo.findAll();
        return res;
    }
    
    
}
