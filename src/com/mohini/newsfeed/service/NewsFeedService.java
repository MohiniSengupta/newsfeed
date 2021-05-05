package com.mohini.newsfeed.service;

import java.util.Collection;

import com.mohini.newsfeed.model.Post;

public interface NewsFeedService {

	Collection<Post> fetchPosts();
}
