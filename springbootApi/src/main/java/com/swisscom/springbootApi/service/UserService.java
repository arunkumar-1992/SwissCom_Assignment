package com.swisscom.springbootApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisscom.springbootApi.model.User;
import com.swisscom.springbootApi.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User update(User user) {
		return userRepository.save(user);
		
	}
	
	public List<User> findAllUsers(){
		
		return userRepository.findAll();
		
	}
	
	public void DeleteUser(User user) {
		userRepository.delete(user);
	}
	
	public User findUserByFirstName(String id) {
		return userRepository.findUserByFirstName(id);
	}

}
