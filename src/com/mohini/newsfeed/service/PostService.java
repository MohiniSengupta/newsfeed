package com.mohini.newsfeed.service;

import java.util.Collection;
import java.util.List;

import com.mohini.newsfeed.model.Post;

public interface PostService {

	Post createPost(String content);
	
	Post addComment(Integer postId, String comment);
	
	Post addUpvote(Integer postId);
	
	Post addDownvote(Integer postId);
	
	Collection<Post> findAllPosts();
	
	List < Post> getAllPostByUser(String userName);
	
}
