package com.mohini.newsfeed;

import com.mohini.newsfeed.executor.CommandLineExecutor;
import com.mohini.newsfeed.factory.ObjectsFactory;

public class FacebookNewsFeedApp {

	public static void main(String[] args) {

		ObjectsFactory objectfactory = new ObjectsFactory();
		CommandLineExecutor executor = new CommandLineExecutor(objectfactory);
		executor.execute();
	}
}
