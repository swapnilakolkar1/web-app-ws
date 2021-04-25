package com.opti.shope.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import com.opti.shope.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto userDto);
	UserDto getUser(String email);
	UserDto getUserDetailsById(String userPublicID);
	boolean deleteUser(String userPublicID);
	boolean updateUserProfilePic(String userPublicId,MultipartFile file);
}
