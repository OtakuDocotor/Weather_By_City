package weather_test.example.weather_test.Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class forecast_weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _Id;
    private String _City, _Description;
    private int _Temperature;
    private Date _RequestedAt;
    public Date getRequestedAt() {
        return _RequestedAt;
    }
    public void setRequestedAt(Date requestedAt) {
        _RequestedAt = requestedAt;
    }
    public int get_Temperature() {
        return _Temperature;
    }
    public void set_Temperature(int _Temperature) {
        this._Temperature = _Temperature;
    }
    public String get_Description() {
        return _Description;
    }
    public void set_Description(String _Description) {
        this._Description = _Description;
    }
    public String get_City() {
        return _City;
    }
    public void set_City(String _City) {
        this._City = _City;
    }
    public long get_Id() {
        return _Id;
    }
    public void set_Id(long _Id) {
        this._Id = _Id;
    }
    public forecast_weather()
    {

    }
    public forecast_weather(String city, String description, int temperature,Date date)
    {
        this._City=city;
        this._Description=description;
        this._Temperature=temperature;
        this._RequestedAt=date;
    }
}
