package it.corso.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hourly_units")
public class HourlyUnits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hourly_units")
	private int idHourlyUnits;

	@Column(name = "time")
	private String time;

	@Column(name = "temperature_2m")
	private String temperature_2m;

	@Column(name = "relative_humidity_2m")
	private String relative_humidity_2m;

	@Column(name = "precipitation_probability")
	private String precipitation_probability;

	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "hourlyUnits")
	private List<WeatherForecast> weatherForecastList = new ArrayList<>();

	public int getIdHourlyUnits() {
		return idHourlyUnits;
	}

	public void setIdHourlyUnits(int idHourlyUnits) {
		this.idHourlyUnits = idHourlyUnits;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTemperature_2m() {
		return temperature_2m;
	}

	public void setTemperature_2m(String temperature_2m) {
		this.temperature_2m = temperature_2m;
	}

	public String getRelative_humidity_2m() {
		return relative_humidity_2m;
	}

	public void setRelative_humidity_2m(String relative_humidity_2m) {
		this.relative_humidity_2m = relative_humidity_2m;
	}

	public String getPrecipitation_probability() {
		return precipitation_probability;
	}

	public void setPrecipitation_probability(String precipitation_probability) {
		this.precipitation_probability = precipitation_probability;
	}

	public List<WeatherForecast> getWeatherForecastList() {
		return weatherForecastList;
	}

	public void setWeatherForecastList(List<WeatherForecast> weatherForecastList) {
		this.weatherForecastList = weatherForecastList;
	}

}
