package it.corso.dto;

import java.util.ArrayList;
import java.util.List;

import it.corso.model.City;

public class UserShowDto {

	private String firstName;

	private String lastName;

	private String email;

	private List<CityShowDto> cityList = new ArrayList<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CityShowDto> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityShowDto> cityList) {
		this.cityList = cityList;
	}

}
