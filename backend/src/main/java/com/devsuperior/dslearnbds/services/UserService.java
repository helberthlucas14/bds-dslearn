package com.devsuperior.dslearnbds.services;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;

import ch.qos.logback.classic.Logger;


@Service
public class UserService implements UserDetailsService {

	private static Logger Logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	
	@Transactional(readOnly = true)
	public UserDTO findById(long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
		return new UserDTO(entity);
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByEmail(username);
		if(user ==  null) {
			Logger.error("User not found:" + username);
			throw new UsernameNotFoundException("Email not found");
		}
		Logger.info("User found: " + username);
		return user;
	}
}
