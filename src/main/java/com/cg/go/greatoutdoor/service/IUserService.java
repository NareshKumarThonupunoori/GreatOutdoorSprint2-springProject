package com.cg.go.greatoutdoor.service;

import org.springframework.stereotype.Service;


import com.cg.go.greatoutdoor.dto.user.UserResponse;
import com.cg.go.greatoutdoor.entity.Userdata;

@Service
public interface IUserService {
	
	public UserResponse addUser(Userdata user);
	public Userdata logout(Userdata user);
	
}
