package com.mohini.newsfeed.command;

import java.util.List;

import com.mohini.newsfeed.service.PostService;

public class UpvoteCommand implements Command {

	private final PostService postService;

	public UpvoteCommand(final PostService postservice){
		this.postService = postservice;
		
	}
	
	@Override
	public boolean canAccept(String command, List<String> args) {
		return args.size()==1;
	}

	@Override
	public void execute(List<String> arguments) {
		postService.addUpvote(Integer.parseInt(arguments.get(0)));
	}

}
