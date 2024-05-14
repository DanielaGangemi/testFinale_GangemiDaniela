package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmailAndPassword(String email, String password);
	
	User findByEmail(String email);
	
	boolean existsByEmail(String email);

}
