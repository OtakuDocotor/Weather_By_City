package weather_test.example.weather_test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import weather_test.example.weather_test.Models.forecast_weather;

public interface forecast_repo extends JpaRepository<forecast_weather,Long> {

}
