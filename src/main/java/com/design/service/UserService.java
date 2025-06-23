package com.design.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.entity.User;
import com.design.repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	    private UserRepository repository;

	    public User getUserById(Long id) {
	        return repository.findById(id).orElse(null);
	    }
	    
	    
	    
	    public User saveUser(User user) {
	        return repository.save(user);
	    }
}
