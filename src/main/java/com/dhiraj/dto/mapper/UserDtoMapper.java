package com.dhiraj.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dhiraj.dto.UserDto;
import com.dhiraj.model.User;
import com.dhiraj.util.UserUtil;

public class UserDtoMapper {
	
	public static UserDto toUserDto(User user) {
		
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFullName(user.getFullName());
		userDto.setImage(user.getImage());
		userDto.setBackgroundImage(user.getBackgroundImage());
		userDto.setBio(user.getBio());
		userDto.setBirthDate(user.getBirthDate());
		userDto.setFollowers(toUserDtos(user.getFollowers()));
		userDto.setFollowings(toUserDtos(user.getFollowings()));
		userDto.setLogin_with_google(user.isLogin_with_google());
		userDto.setLocation(user.getLocation());
		userDto.setVerified(UserUtil.isVerified(user.getVerification().getEndsAt()));
		userDto.setIs_Admin(user.is_Admin);
		
		return userDto;
	}
	
	public static List<UserDto> toUserDtos(List<User> users) {
		
		List<UserDto> userDtos=new ArrayList<>();
		
		for(User user: users) {
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setFullName(user.getFullName());
			userDto.setImage(user.getImage());
			userDtos.add(userDto);
		}
		return userDtos;
	}

}
