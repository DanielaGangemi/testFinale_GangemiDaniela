package it.corso.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hourly")
public class Hourly {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hourly")
	private int idHourly;

	@Column(name = "time")
	private String time;

	@Column(name = "temperature_2m")
	private double temperature_2m;

	@Column(name = "relative_humidity_2m")
	private double relative_humidity_2m;

	@Column(name = "precipitation_probability")
	private double precipitation_probability;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(

			name = "id_weather_forecast", referencedColumnName = "id_weather_forecast"

	)
	private WeatherForecast weatherForecast;

	public int getIdHourly() {
		return idHourly;
	}

	public void setIdHourly(int idHourly) {
		this.idHourly = idHourly;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getTemperature_2m() {
		return temperature_2m;
	}

	public void setTemperature_2m(double temperature_2m) {
		this.temperature_2m = temperature_2m;
	}

	public double getRelative_humidity_2m() {
		return relative_humidity_2m;
	}

	public void setRelative_humidity_2m(double relative_humidity_2m) {
		this.relative_humidity_2m = relative_humidity_2m;
	}

	public double getPrecipitation_probability() {
		return precipitation_probability;
	}

	public void setPrecipitation_probability(double precipitation_probability) {
		this.precipitation_probability = precipitation_probability;
	}

	public WeatherForecast getWeatherForecast() {
		return weatherForecast;
	}

	public void setWeatherForecast(WeatherForecast weatherForecast) {
		this.weatherForecast = weatherForecast;
	}

	@Override
	public String toString() {
		return "Hourly [idHourly=" + idHourly + ", time=" + time + ", temperature_2m=" + temperature_2m
				+ ", relative_humidity_2m=" + relative_humidity_2m + ", precipitation_probability="
				+ precipitation_probability + ", weatherForecast=" + weatherForecast + "]";
	}

}
