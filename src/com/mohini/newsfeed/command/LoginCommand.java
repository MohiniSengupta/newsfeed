package com.mohini.newsfeed.command;

import java.util.List;

import com.mohini.newsfeed.service.SecurityService;

public class LoginCommand implements Command {
	
	private final SecurityService securityService;
	
	private final NewsFeedCommand newsfeedService;
	
	public LoginCommand(final SecurityService securityService, final NewsFeedCommand newsfeedService ) {
		
		this.securityService = securityService;
		this.newsfeedService = newsfeedService;
	}
	
	
	

	@Override
	public boolean canAccept(String command, List<String> args) {
		
		return args.size() == 1;
	}

	@Override
	public void execute(List<String> arguments) {
		securityService.login(arguments.get(0));
		newsfeedService.execute(arguments);
	}

}
