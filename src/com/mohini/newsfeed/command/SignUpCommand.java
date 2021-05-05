package com.mohini.newsfeed.command;

import java.util.List;

import com.mohini.newsfeed.service.UserService;

public class SignUpCommand implements Command {
	
	private final UserService userService;
	
	private final LoginCommand loginCommand;
	
	public SignUpCommand(final UserService userService, final LoginCommand loginCommand) {
		this.userService = userService;
		this.loginCommand = loginCommand;
	}

	@Override
	public boolean canAccept(String command, List<String> args) {
		return args.size()==1;
	}

	@Override
	public void execute(List<String> arguments) {
		userService.createUser(arguments.get(0));
		loginCommand.execute(arguments);
	}

}
