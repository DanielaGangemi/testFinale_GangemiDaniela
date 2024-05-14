package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.HourlyDao;
import it.corso.dao.HourlyUnitsDao;
import it.corso.dao.WeatherForecastDao;
import it.corso.dto.HourlyInsertDto;
import it.corso.dto.HourlyUnitsInsertDto;
import it.corso.dto.WeatherInsertDto;
import it.corso.model.Hourly;
import it.corso.model.HourlyUnits;
import it.corso.model.WeatherForecast;

@Service
public class WeatherServiceImpl implements WeatherService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private WeatherForecastDao weatherForecastDao;

	@Autowired
	private HourlyUnitsDao hourlyUnitsDao;

	@Autowired
	private HourlyDao hourlyDao;

	@Override
	public void insert(WeatherInsertDto weatherInsertDto) {

		WeatherForecast wf = new WeatherForecast();

		wf.setLatitude(weatherInsertDto.getLatitude());
		wf.setLongitude(weatherInsertDto.getLongitude());
		wf.setGenerationtime_ms(weatherInsertDto.getGenerationtime_ms());
		wf.setUtc_offset_seconds(weatherInsertDto.getUtc_offset_seconds());
		wf.setTimezone(weatherInsertDto.getTimezone());
		wf.setTimezone_abbreviation(weatherInsertDto.getTimezone_abbreviation());

		HourlyUnitsInsertDto hourlyUnits = weatherInsertDto.getHourly_units();

		HourlyUnits hu = new HourlyUnits();

		hu.setTime(hourlyUnits.getTime());
		hu.setTemperature_2m(hourlyUnits.getTemperature_2m());
		hu.setRelative_humidity_2m(hourlyUnits.getRelative_humidity_2m());
		hu.setPrecipitation_probability(hourlyUnits.getPrecipitation_probability());

		HourlyInsertDto hourly = weatherInsertDto.getHourly();

		int size = hourly.getTime().size();

		List<Hourly> hList = new ArrayList<>();

		for (int i = 0; i < size; i++) {

			Hourly h = new Hourly();

			h.setTime(hourly.getTime().get(i));
			h.setTemperature_2m(hourly.getTemperature_2m().get(i));
			h.setRelative_humidity_2m(hourly.getRelative_humidity_2m().get(i));
			h.setPrecipitation_probability(hourly.getPrecipitation_probability().get(i));

			hList.add(h);

		}

		wf.setHourlyUnits(hu);
		wf.setHourlyList(hList);

		hourlyUnitsDao.save(hu);
		weatherForecastDao.save(wf);

		for (Hourly elem : hList) {

			elem.setWeatherForecast(wf);

			hourlyDao.save(elem);

		}

	}

}
