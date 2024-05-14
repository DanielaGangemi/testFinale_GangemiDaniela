package it.corso.dto;

public class WeatherInsertDto {

	private double latitude;

	private double longitude;

	private double generationtime_ms;

	private double utc_offset_seconds;

	private String timezone;

	private String timezone_abbreviation;

	private HourlyUnitsInsertDto hourly_units;

	private HourlyInsertDto hourly;

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

	public HourlyUnitsInsertDto getHourly_units() {
		return hourly_units;
	}

	public void setHourly_units(HourlyUnitsInsertDto hourly_units) {
		this.hourly_units = hourly_units;
	}

	public HourlyInsertDto getHourly() {
		return hourly;
	}

	public void setHourly(HourlyInsertDto hourly) {
		this.hourly = hourly;
	}

	@Override
	public String toString() {
		return "WeatherInsertDto [latitude=" + latitude + ", longitude=" + longitude + ", generationtime_ms="
				+ generationtime_ms + ", utc_offset_seconds=" + utc_offset_seconds + ", timezone=" + timezone
				+ ", timezone_abbreviation=" + timezone_abbreviation + ", hourly_units=" + hourly_units + ", hourly="
				+ hourly + "]";
	}

}
