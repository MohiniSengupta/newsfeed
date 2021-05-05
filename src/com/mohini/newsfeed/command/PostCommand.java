package com.mohini.newsfeed.command;

import java.util.List;

import com.mohini.newsfeed.service.PostService;

public class PostCommand implements Command {

	private final PostService postService;
	
	public PostCommand(final PostService postService) {
		this.postService = postService;
	}
	
	@Override
	public boolean canAccept(String command, List<String> args) {
		return args.size() == 1;
	}

	@Override
	public void execute(List<String> arguments) {
		postService.createPost(arguments.get(0));
	}

}
