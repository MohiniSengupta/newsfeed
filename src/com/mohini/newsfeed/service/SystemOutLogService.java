package com.mohini.newsfeed.service;

public class SystemOutLogService implements LogService {

	@Override
	public void print(String content) {
		System.out.println(content);
	}

}
