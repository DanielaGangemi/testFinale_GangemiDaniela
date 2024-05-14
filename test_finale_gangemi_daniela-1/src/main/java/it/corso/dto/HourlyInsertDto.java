package it.corso.dto;

import java.util.ArrayList;
import java.util.List;

public class HourlyInsertDto {

	private List<String> time = new ArrayList<>();

	private List<Double> temperature_2m = new ArrayList<>();

	private List<Integer> relative_humidity_2m = new ArrayList<>();

	private List<Integer> precipitation_probability = new ArrayList<>();

	public List<String> getTime() {
		return time;
	}

	public void setTime(List<String> time) {
		this.time = time;
	}

	public List<Double> getTemperature_2m() {
		return temperature_2m;
	}

	public void setTemperature_2m(List<Double> temperature_2m) {
		this.temperature_2m = temperature_2m;
	}

	public List<Integer> getRelative_humidity_2m() {
		return relative_humidity_2m;
	}

	public void setRelative_humidity_2m(List<Integer> relative_humidity_2m) {
		this.relative_humidity_2m = relative_humidity_2m;
	}

	public List<Integer> getPrecipitation_probability() {
		return precipitation_probability;
	}

	public void setPrecipitation_probability(List<Integer> precipitation_probability) {
		this.precipitation_probability = precipitation_probability;
	}

	@Override
	public String toString() {
		return "HourlyInsertDto [time=" + time + ", temperature_2m=" + temperature_2m + ", relative_humidity_2m="
				+ relative_humidity_2m + ", precipitation_probability=" + precipitation_probability + "]";
	}

}
