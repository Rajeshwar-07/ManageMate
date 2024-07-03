package com.projectmanagement.service;

import java.util.List;

import com.projectmanagement.dto.UserDto;
import com.projectmanagement.model.Users;

public interface UsersService {

	public UserDto createUser(Users user, Long projectId);

	public UserDto getUserById(Long userId);

	public List<UserDto> getUserList();

	public String deleteUsers(Long userId);

	public Users updateUser(Long userId, Users updatedUser);
}
