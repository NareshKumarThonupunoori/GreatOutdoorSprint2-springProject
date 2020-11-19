package com.cg.go.greatoutdoor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.go.greatoutdoor.dao.IUserRepository;

import com.cg.go.greatoutdoor.dto.user.UserResponse;
import com.cg.go.greatoutdoor.entity.Userdata;
import com.cg.go.greatoutdoor.exception.UserAlreadyExistsException;
import com.cg.go.greatoutdoor.exception.UserNotFoundException;

@Transactional
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserResponse addUser(Userdata user) {
		boolean exists = user.getUserId() != null && userRepository.existsById(user.getUserId());
		if (exists)
			throw new UserAlreadyExistsException("user already exists for id=" + user.getUserId());
		user = userRepository.save(user);
		return new UserResponse(false, "User Created Successfully", user);
	}

	


	@Override
	public Userdata logout(Userdata user) {

		return user;
	}

	

}
