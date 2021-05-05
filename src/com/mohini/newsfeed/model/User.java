package com.mohini.newsfeed.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class User {

	// user id??
	
	private String name;
	
	private List<User> followingUsers = new ArrayList<>();
	
	public User(final String name) {
		this.name = name;
	}
	
}
