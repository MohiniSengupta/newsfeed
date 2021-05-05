package com.mohini.newsfeed.command;

import java.util.List;

public interface Command {

	boolean canAccept(String command, List<String> args);
	
	void execute(List<String> arguments);
	
}
