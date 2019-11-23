package com.opti.shope.ui.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opti.shope.service.UserService;
import com.opti.shope.shared.dto.UserDto;
import com.opti.shope.ui.model.request.UserDetailRequestModel;
import com.opti.shope.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public String getUserDetail() {
		return "getUserDetail";
	}

	@PostMapping
	public UserRest createUserDetail(@RequestBody UserDetailRequestModel userDetailRequestModel) {
		UserRest userRest = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailRequestModel, userDto);
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, userRest);

	
		return userRest;
	}

	@PutMapping
	public String updateUserDetail() {
		return "updateUserDetail";
		
	}

	@DeleteMapping
	public String deleteUserDetail() {
		return "deleteUserDetail";
	}

}
