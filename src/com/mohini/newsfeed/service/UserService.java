package com.mohini.newsfeed.service;

import java.util.Optional;

import com.mohini.newsfeed.model.User;

public interface UserService {

	User createUser(String name);
	
	Optional<User> getUser(String name);
	
	void addFollower(User user, String follower);
	
}
