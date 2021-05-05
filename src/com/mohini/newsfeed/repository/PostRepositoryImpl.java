package com.mohini.newsfeed.repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mohini.newsfeed.model.Post;

public class PostRepositoryImpl extends InMemoryCrudRepository<Post,Integer> implements PostRepository{

	public List<Post> getPostByUserId(String userName){
		
		Collection<Post> posts = findAll();
		
	Stream < Post> postsStream =  	posts.stream().filter(p -> p.getCreatedBy().getName() == userName);
	
	return postsStream.collect(Collectors.toList());
	}
}
