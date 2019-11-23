package com.opti.shope.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.opti.shope.io.entity.UserEntity;
import com.opti.shope.repositories.UserRepository;
import com.opti.shope.service.UserService;
import com.opti.shope.shared.dto.UserDto;
import com.opti.shope.shared.uility.RandomIdGenUtil;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RandomIdGenUtil randomIdGenUtil;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		if(userRepository.existsByEmail(userDto.getEmail())) {
			throw new RuntimeException("USER WITH SAME EMIL ID IS ALEADY EXISTS ,PLEASE TRY WITH ANOTHER EMAIL");
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));	
		
		userEntity.setUserId(randomIdGenUtil.generateUserID(30));
		
		UserEntity storedUserDetail = userRepository.save(userEntity);
		
		UserDto createdUser = new UserDto();
		BeanUtils.copyProperties(storedUserDetail, createdUser);
		
		return createdUser;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity= userRepository.findByEmail(email);
		if(userEntity==null)throw new UsernameNotFoundException(email);
		return new User(email,userEntity.getEncryptedPassword(),new ArrayList<>());
	}

	@Override
	public UserDto getUser(String userEmail) {
		UserEntity userEntity= userRepository.findByEmail(userEmail);
		if(userEntity==null)throw new UsernameNotFoundException(userEmail);
		UserDto returnObj=new UserDto();
		BeanUtils.copyProperties(userEntity, returnObj);
		return returnObj;
	}




}
