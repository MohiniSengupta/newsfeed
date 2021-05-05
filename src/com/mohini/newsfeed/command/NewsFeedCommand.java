package com.mohini.newsfeed.command;

import java.util.Collection;
import java.util.List;

import com.mohini.newsfeed.model.Post;
import com.mohini.newsfeed.service.LogService;
import com.mohini.newsfeed.service.NewsFeedService;

public class NewsFeedCommand implements Command {
	
	private final NewsFeedService newsFeedService;
	
	private final LogService logService;
	
	public NewsFeedCommand(final NewsFeedService newsFeedService,final LogService logService) {
		
		this.newsFeedService = newsFeedService;
		this.logService =logService;
		
	}

	@Override
	public boolean canAccept(String command, List<String> args) {
		return true;
	}

	@Override
	public void execute(List<String> arguments) {
		Collection<Post> posts = newsFeedService.fetchPosts();
		for(Post post : posts) {
			logService.print(post.toString());
		}
		
	}
	
}
