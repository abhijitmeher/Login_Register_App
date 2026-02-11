package com.durgasoft.App018.service;

import com.durgasoft.App018.user.User;

public interface UserService {
	
	public String userRegister(User user);
	public String userLogin(String email, String password);	
	
}	
