package com.opti.shope.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opti.shope.io.entity.UserEntity;
import com.opti.shope.repositories.UserRepository;
import com.opti.shope.service.UserService;
import com.opti.shope.service.exception.UserServiceException;
import com.opti.shope.shared.dto.UserDto;
import com.opti.shope.shared.utility.ErrorMessages;
import com.opti.shope.shared.utility.RandomIdGenUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RandomIdGenUtil randomIdGenUtil;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private ModelMapper mp = new ModelMapper();
	
	@Override
	public UserDto createUser(UserDto userDto) {
		String userId=randomIdGenUtil.generateUserID(30);
		if (userRepository.existsByEmail(userDto.getEmail())) {
			throw new UserServiceException("USER WITH SAME EMIL ID IS ALEADY EXISTS ,PLEASE TRY WITH ANOTHER EMAIL");
		}
		
		userDto.setUserId(userId);
		
		if(userDto.getAddress() !=null) {
			userDto.getAddress().setAddrressId(randomIdGenUtil.generateAddressID(30));
		}
		else {
			throw new UserServiceException("Address Deails not provided");
		}
		
		UserEntity userEntity = new UserEntity();
		mp.map(userDto, userEntity);

		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		
		UserEntity storedUserDetail = userRepository.save(userEntity);
		
		UserDto createdUser = new UserDto();
		mp.map(storedUserDetail, createdUser);
		
		return createdUser;
	}

	@Override
	public UserDetails loadUserByUsername(String email)  {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException(email);
		return new User(email, userEntity.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUser(String userEmail) {
		UserEntity userEntity = userRepository.findByEmail(userEmail);
		if (userEntity == null)
			throw new UsernameNotFoundException(userEmail);
		UserDto returnObj = new UserDto();
		mp.map(userEntity, returnObj);
		return returnObj;
	}

	@Override
	public UserDto getUserDetailsById(String userPublicID) {
		UserEntity userEntity = userRepository.findByUserId(userPublicID);
		if (userEntity == null)
			throw new UsernameNotFoundException(userPublicID);
		UserDto returnObj = new UserDto();
		mp.map(userEntity, returnObj);
		return returnObj;
	}

	@Override
	public boolean deleteUser(String userPublicID) {
		UserEntity userEntity  = userRepository.findByUserId(userPublicID);
		if (userEntity == null)
			throw new UsernameNotFoundException(userPublicID);
		userRepository.delete(userEntity);
		return true;
	}

	@Override
	public boolean updateUserProfilePic(String userPublicId,MultipartFile file){
		UserEntity userEntity  = userRepository.findByUserId(userPublicId);
		if (userEntity == null)
			throw new UsernameNotFoundException(userPublicId);
		try {
			userEntity.setProfilePic(file.getBytes());
			userEntity.setProfilePicFileFormat(file.getContentType());
		} catch (IOException e) {
			e.printStackTrace();
			throw new UserServiceException(ErrorMessages.UNKNOWN_EXCEPION_OCCUED.getErrorMessage());
		}
		userRepository.save(userEntity);
		return false;
	}

}
