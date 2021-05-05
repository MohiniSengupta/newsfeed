package com.mohini.newsfeed.factory;

import com.mohini.newsfeed.repository.PostRepository;
import com.mohini.newsfeed.repository.PostRepositoryImpl;
import com.mohini.newsfeed.repository.UserRepository;
import com.mohini.newsfeed.repository.UserRepositoryImpl;
import com.mohini.newsfeed.service.LogService;
import com.mohini.newsfeed.service.NewsFeedService;
import com.mohini.newsfeed.service.NewsFeedServiceImpl;
import com.mohini.newsfeed.service.PostService;
import com.mohini.newsfeed.service.PostServiceImpl;
import com.mohini.newsfeed.service.SecurityService;
import com.mohini.newsfeed.service.SystemOutLogService;
import com.mohini.newsfeed.service.UserService;
import com.mohini.newsfeed.service.UserServiceImpl;

import lombok.Data;

@Data
public class ObjectsFactory {
	
	private final UserRepository userRepository = new UserRepositoryImpl();
	
	private final PostRepository postRepository = new PostRepositoryImpl();
	
	private final UserService userService = new UserServiceImpl(userRepository);
	
	private final SecurityService securityService = new SecurityService(userService);
	
	private final PostService postService = new PostServiceImpl(postRepository, securityService);
	
	private final NewsFeedService newsFeddService = new NewsFeedServiceImpl(postService, securityService );
	
	private final LogService logService = new SystemOutLogService();

}
