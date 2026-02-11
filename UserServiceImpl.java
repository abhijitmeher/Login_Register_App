package com.durgasoft.App018.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgasoft.App018.repository.UserRepository;
import com.durgasoft.App018.user.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public String userRegister(User user) {
		
		repository.save(user);
		
		return "success";
	}
	
	@Override	
	public String userLogin(String email, String password) {
		String status = null;
		try {
			repository.findByEmailAndPassword(email, password);
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		
		return status;	
	}

}
