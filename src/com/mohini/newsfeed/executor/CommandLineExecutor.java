package com.mohini.newsfeed.executor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mohini.newsfeed.command.Command;
import com.mohini.newsfeed.command.DownvoteCommand;
import com.mohini.newsfeed.command.FollowCommand;
import com.mohini.newsfeed.command.LoginCommand;
import com.mohini.newsfeed.command.NewsFeedCommand;
import com.mohini.newsfeed.command.PostCommand;
import com.mohini.newsfeed.command.ReplyCommand;
import com.mohini.newsfeed.command.SignUpCommand;
import com.mohini.newsfeed.command.UpvoteCommand;
import com.mohini.newsfeed.factory.ObjectsFactory;

public class CommandLineExecutor {

	private Map<String, Command> commands = new LinkedHashMap<>();

	public CommandLineExecutor(final ObjectsFactory objects) {
			// different method
		commands.put("post", new PostCommand(objects.getPostService()));
		commands.put("follow", new FollowCommand(objects.getSecurityService(), objects.getUserService()));
		commands.put("reply", new ReplyCommand(objects.getPostService()));
		commands.put("upvote", new UpvoteCommand(objects.getPostService()));
		commands.put("downvote", new DownvoteCommand(objects.getPostService()));

		final NewsFeedCommand newsFeedCommand = new NewsFeedCommand(objects.getNewsFeddService(),
				objects.getLogService());
		final LoginCommand loginCommand = new LoginCommand(objects.getSecurityService(), newsFeedCommand);
		commands.put("shownewsfeed", newsFeedCommand);
		commands.put("login", loginCommand);
		commands.put("signup", new SignUpCommand(objects.getUserService(), loginCommand));

	}

	public void execute() {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				final String line = scanner.nextLine();
				Instruction instruction = parseLine(line);
				
				if(commands.containsKey(instruction.getCommand())) {
					final Command command = commands.get(instruction.getCommand());
					if(command.canAccept(instruction.getCommand(), instruction.getArguments())) {
						command.execute(instruction.getArguments());
					}else {
						throw new IllegalArgumentException("Invalid arguments, command not accepting given arguments for :"+instruction.getCommand());
					}
					
				}
				else
					throw new IllegalArgumentException("Unknown command"+instruction.getCommand());
				
				
			}catch(Exception e) {
			e.printStackTrace();
			}
		}
	}

	private Instruction parseLine(String line) {
       final String[] words = line.split("\\~");

        List<String> arguments = new ArrayList<>();
        for(int i = 1;  i < words.length; i++)
        	arguments.add(words[i]);
        
        return new Instruction(words[0],arguments);
	
	}
}
