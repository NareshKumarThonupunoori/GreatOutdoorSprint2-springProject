package com.cg.go.greatoutdoor.service;

import com.cg.go.greatoutdoor.entity.Userdata;

public interface IUserService {
	
	public Userdata addUser(Userdata user);

	public Userdata updateUser(Userdata user);

	void deleteUser(Integer userId);
	
}
