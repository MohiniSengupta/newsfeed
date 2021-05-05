package com.mohini.newsfeed.model;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Votes {

	private AtomicInteger upVotes = new AtomicInteger(0);
	private AtomicInteger downVotes = new AtomicInteger(0);

}
