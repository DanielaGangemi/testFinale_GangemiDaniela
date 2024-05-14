package it.corso.dto;

public class HourlyUnitsInsertDto {

	private String time;

	private String temperature_2m;

	private String relative_humidity_2m;

	private String precipitation_probability;

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

	@Override
	public String toString() {
		return "HourlyUnitsInsertDto [time=" + time + ", temperature_2m=" + temperature_2m + ", relative_humidity_2m="
				+ relative_humidity_2m + ", precipitation_probability=" + precipitation_probability + "]";
	}

}
