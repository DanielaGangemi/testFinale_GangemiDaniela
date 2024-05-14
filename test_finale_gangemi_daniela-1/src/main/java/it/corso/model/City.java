package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_city")
	private int idCity;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(

			name = "id_weather_forecast", referencedColumnName = "id_weather_forecast"

	)
	private WeatherForecast weatherForecastCity;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(

			name = "user_city", 
			joinColumns = @JoinColumn(name = "id_city", referencedColumnName = "id_city"), 
			inverseJoinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user")

	)
	private List<User> userList = new ArrayList<>();

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeatherForecast getWeatherForecastCity() {
		return weatherForecastCity;
	}

	public void setWeatherForecastCity(WeatherForecast weatherForecastCity) {
		this.weatherForecastCity = weatherForecastCity;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
