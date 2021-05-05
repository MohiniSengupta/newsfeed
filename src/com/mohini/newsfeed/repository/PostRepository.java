package com.mohini.newsfeed.repository;

import java.util.List;

import com.mohini.newsfeed.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

	public List<Post> getPostByUserId(String userName);
}
