package com.projectmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.dto.UserDto;
import com.projectmanagement.model.Users;
import com.projectmanagement.service.UsersService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private final UsersService service;

	public UserController(UsersService service) {
		this.service = service;
	}

	@PostMapping(name = "post", path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserDto> createUser(@RequestBody Users user, @RequestParam Long projectId) {
		UserDto saveUser = service.createUser(user, projectId);
		return new ResponseEntity<UserDto>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping(name = "get", path = "/{userId}")
	public ResponseEntity<UserDto> findUserById(@PathVariable Long userId) {
		UserDto getUser = service.getUserById(userId);
		return ResponseEntity.ok(getUser);
	}

	@GetMapping(name = "get")
	public ResponseEntity<List<UserDto>> GetUserList() {
		List<UserDto> userList = service.getUserList();
		return ResponseEntity.ok(userList);
	}

	@DeleteMapping(name = "delete", path = "/{userId}/delete")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		String deleteUser = service.deleteUsers(userId);
		return ResponseEntity.ok(deleteUser);
	}

	@PutMapping(name = "put", path = "/{userId}/update")
	public ResponseEntity<Users> updateUser(@PathVariable Long userId, @RequestBody Users user) {
		Users updateUser = service.updateUser(userId, user);
		return new ResponseEntity<Users>(updateUser, HttpStatus.OK);
	}

}
