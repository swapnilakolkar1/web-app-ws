package com.opti.shope.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opti.shope.service.UserService;
import com.opti.shope.service.exception.UserServiceException;
import com.opti.shope.shared.dto.UserDto;
import com.opti.shope.shared.utility.ErrorMessages;
import com.opti.shope.ui.model.request.UserDetailRequestModel;
import com.opti.shope.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(path = "/{userPublicId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public UserRest getUserDetail(@PathVariable String userPublicId) {
		UserRest userRest = new UserRest();
		UserDto userDto = userService.getUserDetailsById(userPublicId);
		BeanUtils.copyProperties(userDto, userRest);
		return userRest;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest createUserDetail(@RequestBody UserDetailRequestModel userDetailRequestModel) throws Exception {
		UserRest userRest = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailRequestModel, userDto);
		UserDto createdUser = null;
		try {
			createdUser = userService.createUser(userDto);
			BeanUtils.copyProperties(createdUser, userRest);
		} catch (Exception e) {
			throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXISTED.getErrorMessage());
		}
		

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
