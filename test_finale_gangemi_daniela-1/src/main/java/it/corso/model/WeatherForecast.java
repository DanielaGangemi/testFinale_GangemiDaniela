package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather_forecast")
public class WeatherForecast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_weather_forecast")
	private int idWeatherForecast;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "generationtime_ms")
	private double generationtime_ms;

	@Column(name = "utc_offset_seconds")
	private double utc_offset_seconds;

	@Column(name = "timezone")
	private String timezone;

	@Column(name = "timezone_abbreviation")
	private String timezone_abbreviation;

	@Column(name = "elevation")
	private int elevation;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(

			name = "id_hourly_units", referencedColumnName = "id_hourly_units"

	)
	private HourlyUnits hourlyUnits;

	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "weatherForecast")
	private List<Hourly> hourlyList = new ArrayList<>();

	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "weatherForecastCity")
	private List<City> cityList = new ArrayList<>();

	public int getIdWeatherForecast() {
		return idWeatherForecast;
	}

	public void setIdWeatherForecast(int idWeatherForecast) {
		this.idWeatherForecast = idWeatherForecast;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getGenerationtime_ms() {
		return generationtime_ms;
	}

	public void setGenerationtime_ms(double generationtime_ms) {
		this.generationtime_ms = generationtime_ms;
	}

	public double getUtc_offset_seconds() {
		return utc_offset_seconds;
	}

	public void setUtc_offset_seconds(double utc_offset_seconds) {
		this.utc_offset_seconds = utc_offset_seconds;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTimezone_abbreviation() {
		return timezone_abbreviation;
	}

	public void setTimezone_abbreviation(String timezone_abbreviation) {
		this.timezone_abbreviation = timezone_abbreviation;
	}

	public int getElevation() {
		return elevation;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public HourlyUnits getHourlyUnits() {
		return hourlyUnits;
	}

	public void setHourlyUnits(HourlyUnits hourlyUnits) {
		this.hourlyUnits = hourlyUnits;
	}

	public List<Hourly> getHourlyList() {
		return hourlyList;
	}

	public void setHourlyList(List<Hourly> hourlyList) {
		this.hourlyList = hourlyList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	@Override
	public String toString() {
		return "WeatherForecast [idWeatherForecast=" + idWeatherForecast + ", latitude=" + latitude + ", longitude="
				+ longitude + ", generationtime_ms=" + generationtime_ms + ", utc_offset_seconds=" + utc_offset_seconds
				+ ", timezone=" + timezone + ", timezone_abbreviation=" + timezone_abbreviation + ", elevation="
				+ elevation + ", hourlyUnits=" + hourlyUnits + ", hourlyList=" + hourlyList + ", cityList=" + cityList
				+ "]";
	}

}
