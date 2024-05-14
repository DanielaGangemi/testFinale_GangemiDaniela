package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CityDao;
import it.corso.dto.CityShowDto;
import it.corso.model.City;

@Service
public class CityServiceImpl implements CityService {
	
	private ModelMapper mapper = new ModelMapper();

	@Autowired
	private CityDao cityDao;

	@Override
	public List<CityShowDto> findAll() {

		List<City> cityList = cityDao.findAll();

		List<CityShowDto> cityListDto = new ArrayList<>();

		cityList.forEach(c -> cityListDto.add(mapper.map(c, CityShowDto.class)));

		return cityListDto;

	}

}
