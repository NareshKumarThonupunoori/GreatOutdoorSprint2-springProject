package com.cg.go.greatoutdoor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.dto.user.CreateUserRequest;
import com.cg.go.greatoutdoor.dto.user.UserResponse;
import com.cg.go.greatoutdoor.entity.Userdata;
import com.cg.go.greatoutdoor.service.IUserService;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/signUp")
    public UserResponse addUser(@RequestBody CreateUserRequest requestData) {
        Userdata user = new Userdata(requestData.getUserName(), requestData.getUserType(), requestData.getUserPassword());
        return userService.addUser(user);
    }

    @GetMapping("/admin/welcome")
    public String adminLogin() {
        return "Welcome To website";
    }
    

    @GetMapping("/user/welcome")
    public String userLogin() {
        return "Welcome To website";
    }

    @GetMapping("/logout")
    public @ResponseBody
    Userdata logout(Userdata user) {
        return userService.logout(user);
    }

}