package com.opti.shope.ui.controller;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
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
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	ModelMapper modelmapper = new ModelMapper();
	
	@GetMapping(path = "/{userPublicId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public UserRest getUserDetail(@PathVariable String userPublicId) {
		UserRest userRest = new UserRest();
		UserDto userDto = userService.getUserDetailsById(userPublicId);
		modelmapper.map(userDto, userRest);
		return userRest;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest createUserDetail(@RequestBody UserDetailRequestModel userDetailRequestModel) throws Exception {
		UserRest userRest = new UserRest();
		
		UserDto userDto = modelmapper.map(userDetailRequestModel, UserDto.class);
		UserDto createdUser = null;
		try {
			createdUser = userService.createUser(userDto);
			modelmapper.map(createdUser, userRest);
		} 
		catch(UserServiceException userException) {
			userException.printStackTrace();
			throw new UserServiceException(userException.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new UserServiceException(ErrorMessages.UNKNOWN_EXCEPION_OCCUED.getErrorMessage());
		}

		return userRest;
	}

	@PutMapping
	public String updateUserDetail() {
		return "updateUserDetail";

	}

	@DeleteMapping(path = "/{userId}")
	public String deleteUserDetail(@PathVariable String userId) {
		if(StringUtils.isEmpty (userId)) {
			throw new UserServiceException(ErrorMessages.PROVIDE_USER_ID.getErrorMessage());
		}
		
		return userService.deleteUser(userId)?"deleted Successfullty":"Issue occured while deleting record";
	}

}
