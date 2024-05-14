package it.corso.dto;

import jakarta.validation.constraints.Pattern;

public class UserRegistrationDto {

	@Pattern(regexp = "[a-zA-Z\\s']{1,50}")
	private String firstName;

	@Pattern(regexp = "[a-zA-Z\\s']{1,50}")
	private String lastName;

	@Pattern(regexp = "[A-Za-z0-9\\.\\+_-]+@[A-Za-z0-9\\._-]+\\.[A-Za-z]{2,24}")
	private String email;

	private String password;

	private int cityId;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int roleId) {
		this.cityId = roleId;
	}

}
