package com.mohini.newsfeed.command;

import java.util.List;

import com.mohini.newsfeed.service.PostService;

	

public class ReplyCommand implements Command {

	private final PostService postService;

	public ReplyCommand(final PostService postService) {
		this.postService = postService;
	}
		
	@Override
	public boolean canAccept(String command, List<String> args) {
		return args.size() == 2;
	}

	@Override
	public void execute(List<String> arguments) {
		postService.addComment(Integer.parseInt(arguments.get(0)), arguments.get(1));
	}

}
