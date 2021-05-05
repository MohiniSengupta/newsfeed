package com.mohini.newsfeed.command;

import java.util.List;

import com.mohini.newsfeed.service.SecurityService;
import com.mohini.newsfeed.service.UserService;

public class FollowCommand implements Command{
	
	private final SecurityService securityService;
	
	private final UserService userService;
	
	public FollowCommand(final SecurityService securityService,final UserService userService ) {
		this.securityService = securityService;
		this.userService = userService;
	}

	@Override
	public boolean canAccept(String command, List<String> args) {
		// TODO Auto-generated method stub
		return args.size()==1;
	}

	@Override
	public void execute(List<String> arguments) {
		userService.addFollower(securityService.getLoggedInUser(), arguments.get(0));
	}

}
