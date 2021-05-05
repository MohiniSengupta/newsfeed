package com.mohini.newsfeed.command;

import java.util.List;

import com.mohini.newsfeed.service.PostService;

public class DownvoteCommand implements Command {
	
	private final PostService postService;

	
	public DownvoteCommand(final PostService postService) {
		this.postService = postService;
	}
	
	@Override
	public boolean canAccept(String command, List<String> args) {
		return args.size() == 1;
	}

	@Override
	public void execute(List<String> arguments) {
		postService.addDownvote(Integer.parseInt(arguments.get(0)));
	}

}
