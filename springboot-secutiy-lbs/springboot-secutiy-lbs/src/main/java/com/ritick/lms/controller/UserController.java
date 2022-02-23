package com.ritick.lms.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritick.lms.exception.NotFoundException;
import com.ritick.lms.model.User;
import com.ritick.lms.service.UserService;

@RestController
@RequestMapping("lms/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers(){
		System.out.println("In User service to return user details");
		return userService.getUserDetails();
	}

	@GetMapping("/users/{userId}")
	public Optional<User> getUser(@PathVariable int userId){
		System.out.println("In User service to return user detail");
		Optional<User> tuser = userService.getUserDetailsById(userId);
		if(tuser==null)
		{
			System.out.println("User not found ");
			throw new NotFoundException("User not found Exception");
		}
		return tuser;
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		System.out.println("In user service to save user details");
		user.setUserId(0);
		userService.registerUserDetails(user);
		return user;
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		System.out.println("In user service to update user details");
		userService.updateUserDetails(user);
		return user;
	}

	@DeleteMapping("/users/{userId}")
	public String deleteBook(@PathVariable int userId) throws Exception{
		System.out.println("In user service to delete user");
		Optional<User> tUser = userService.getUserDetailsById(userId);
		if(tUser==null)
		{
			System.out.println("User not found ");
			throw new NotFoundException("User not found Exception");
		}
		userService.deleteUserDetails(userId);
		return "User has been deleted";
	}


    @GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }

	@GetMapping("/hello")
	public String test() {
		return "hello from test";
	}






}
