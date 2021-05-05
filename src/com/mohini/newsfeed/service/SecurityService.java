package com.mohini.newsfeed.service;

import java.util.Optional;

import com.mohini.newsfeed.model.User;

public class SecurityService { // why not impl??
	
	private ThreadLocal<User> userTL = new ThreadLocal<User>();
	
	private UserService userService;
	
	public SecurityService(final UserService userService) {
		this.userService = userService;
	}
	
	public void login(String userName) {
		userTL.remove();
		final Optional<User> user = userService.getUser(userName); // why final??
		if(user.isPresent()) {
			userTL.set(user.get());
		}else {
			throw new IllegalArgumentException("No user found with username "+userName);
		}
	}
	
	public User getLoggedInUser()
	{
		return Optional.ofNullable(userTL.get()).orElseThrow(()->new IllegalStateException("No active session found"));
	}
}
