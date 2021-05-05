package com.mohini.newsfeed.service;

import java.util.Optional;

import com.mohini.newsfeed.model.User;
import com.mohini.newsfeed.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	final private UserRepository repository;
	
	
	public UserServiceImpl(final UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User createUser(String name) {
		User user = new User(name);
		return repository.save(name, user);
	}

	@Override
	public Optional<User> getUser(String name) {
		return repository.findById(name);
	}

	@Override
	public void addFollower(final User user, final String follower) {
		final User newFollower = repository.findById(follower).orElseThrow(()-> new IllegalArgumentException("The new follower doesnot exist: "+follower));
		user.getFollowingUsers().add(newFollower);
	}

}
