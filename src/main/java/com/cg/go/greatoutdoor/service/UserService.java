package com.cg.go.greatoutdoor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.go.greatoutdoor.dao.IUserRepository;
import com.cg.go.greatoutdoor.entity.Userdata;
import com.cg.go.greatoutdoor.exception.UserAlreadyExistsException;
import com.cg.go.greatoutdoor.exception.UserNotFoundException;

@Transactional
@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	@Override
	public Userdata addUser(Userdata user) {
		boolean exists = user.getUserId() != null && userRepository.existsById(user.getUserId());
		if (exists)
			throw new UserAlreadyExistsException("user already exists for id=" + user.getUserId());
		user = userRepository.save(user);
		return user;
	}

	@Override
	public Userdata updateUser(Userdata user) {
		boolean exists = user.getUserId() != null && userRepository.existsById(user.getUserId());
		if (!exists)
			throw new UserNotFoundException("user already exists for id=" + user.getUserId());
		user = userRepository.save(user);
		return user;
	}

	
	@Override
	public void deleteUser(Integer userId) {
		Userdata user=findById(userId);
		userRepository.delete(user);
	}

	public Userdata findById(Integer userid) {

		Optional<Userdata> optional = userRepository.findById(userid);
		if (!optional.isPresent())
			throw new UserNotFoundException("user not found for id=" + userid);
		Userdata user = optional.get();
		return user;
	}
}
