package com.cg.go.greatoutdoor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.dto.user.CreateUserRequest;
import com.cg.go.greatoutdoor.entity.Userdata;
import com.cg.go.greatoutdoor.service.IUserService;

@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public Userdata addUser(@RequestBody CreateUserRequest requestData) {
		Userdata user=new Userdata(requestData.getUserName(),requestData.getUserType(),requestData.getUserPassword());
		user=userService.addUser(user);
		return user;
	}
	
	@PutMapping("/update")
    public Userdata updateUser(@RequestBody CreateUserRequest requestData) {
		Userdata user=new Userdata(requestData.getUserName(),requestData.getUserType(),requestData.getUserPassword());
		user.setUserId(requestData.getUserId());
		user=userService.updateUser(user);
		return user;
	}
	
	@DeleteMapping("/remove/userId/{id}")
    public String deleteUser(@PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
		String response = "removed user with userid=" + userId;
        return response;
    }
}
