package it.corso.service;

import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CityDao;
import it.corso.dao.UserDao;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.dto.UserShowDto;
import it.corso.model.City;
import it.corso.model.User;

@Service
public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UserDao userDao;

	@Autowired
	private CityDao cityDao;

	@Override
	public void userRegistration(UserRegistrationDto userRegistrationDto) {

		userRegistrationDto.setPassword(DigestUtils.sha256Hex(userRegistrationDto.getPassword()));

		User user = modelMapper.map(userRegistrationDto, User.class);

		Optional<City> city = cityDao.findById(userRegistrationDto.getCityId());

		user.getCityList().add(city.get());

		userDao.save(user);

	}

	@Override
	public boolean existsByEmail(String email) {

		return userDao.existsByEmail(email);

	}

	@Override
	public User findByEmail(String email) {

		return userDao.findByEmail(email);

	}

	@Override
	public boolean userLogin(UserLoginRequestDto userLoginRequestDto) {

		String hashedPassoword = DigestUtils.sha256Hex(userLoginRequestDto.getPassword());

		return userDao.findByEmailAndPassword(userLoginRequestDto.getEmail(), hashedPassoword) != null ? true : false;
	}

	@Override
	public UserShowDto findUserByEmail(String email) {

		User user = findByEmail(email);
		
		UserShowDto userShowDto = modelMapper.map(user, UserShowDto.class);
		
		System.out.println(userShowDto.toString());

		return userShowDto;

	}

}
