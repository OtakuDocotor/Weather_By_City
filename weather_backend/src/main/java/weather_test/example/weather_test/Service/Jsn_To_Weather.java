package weather_test.example.weather_test.Service;

import java.util.Date;
import java.util.List;

import weather_test.example.weather_test.Models.forecast_weather;

public class Jsn_To_Weather {
    private String name;
    private Main main;
    private List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public static class  Main {
        private double temp;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
    public static class Weather {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
    public forecast_weather ConvertToForecast()
    {
        Date now = new Date();
        forecast_weather res=new forecast_weather(this.name,this.weather.get(0).description,(int)Math.round(this.main.temp),now);
        return res;
    }
}
