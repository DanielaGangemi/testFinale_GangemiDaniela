package it.corso.service;

import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.dto.UserShowDto;
import it.corso.model.User;

public interface UserService {

	void userRegistration(UserRegistrationDto userRegistrationDto);
	
	boolean existsByEmail(String email);
	
	User findByEmail(String email);

	boolean userLogin(UserLoginRequestDto userLoginRequestDto);
	
	UserShowDto findUserByEmail(String email);

}
