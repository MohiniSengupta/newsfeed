package com.mohini.newsfeed.service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.mohini.newsfeed.model.Post;
import com.mohini.newsfeed.repository.PostRepository;

public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	private final SecurityService securityService;

	private final AtomicInteger postId = new AtomicInteger(0); // why here??
	
	public PostServiceImpl(final PostRepository postRepository, final SecurityService securityService) {
		this.postRepository = postRepository;
		this.securityService = securityService;

	}

	@Override
	public Post createPost(final String content) {
		final Post newPost = Post.builder().id(postId.incrementAndGet()).content(content)
				.createdBy(securityService.getLoggedInUser()).build();
		return postRepository.save(newPost.getId(), newPost);
	}

	@Override
	public Post addComment(final Integer postId, final String comment) {
		
		Post parentPost = getPost(postId);
		
		synchronized(parentPost) {
			int id = parentPost.getComments().size() + 1;
		    parentPost.getComments().add(Post.builder()
		    		.id(id)
					.content(comment)
					.createdBy(securityService.getLoggedInUser()).build());
		}
		
		return parentPost;
	}

	private Post getPost(Integer postId) {
		return postRepository.findById(postId)
				.orElseThrow(() -> new IllegalArgumentException("No post exists with post id: " + postId));
	}

	@Override
	public Post addUpvote(Integer postId) {
		final Post post = getPost(postId);
		post.getVotes().getUpVotes().incrementAndGet();
		return post;
	}

	@Override
	public Post addDownvote(Integer postId) {
		final Post post = getPost(postId);
		post.getVotes().getDownVotes().incrementAndGet();
		return post;
	}

	@Override
	public Collection<Post> findAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public List<Post> getAllPostByUser(String userName) {
	 
		 return postRepository.getPostByUserId(userName);
	}

}
