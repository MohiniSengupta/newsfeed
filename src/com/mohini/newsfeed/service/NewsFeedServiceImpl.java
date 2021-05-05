package com.mohini.newsfeed.service;

import java.util.Collection;

import com.mohini.newsfeed.model.Post;
import com.mohini.newsfeed.model.User;

public class NewsFeedServiceImpl implements NewsFeedService {

	final private PostService postService;
	
	final private SecurityService securityService;
	
	public NewsFeedServiceImpl(final PostService postService , 
			final  SecurityService securityService) {
		this.postService = postService;
		this.securityService = securityService;
	}
	
	@Override
	public Collection<Post> fetchPosts() {
		
		User user = securityService.getLoggedInUser();
		final Collection<Post> posts = postService.getAllPostByUser(user.getName()); // finad post of all friends and followers
		return posts;
	}

}
