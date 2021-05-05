package com.mohini.newsfeed.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {

	private Integer id;
	
	private String content;
	
	@Builder.Default
	private Votes votes = new Votes();
	
	@Builder.Default
	private List<Post> comments = new ArrayList<>();
	
	private User createdBy;
	
	@Builder.Default
	private Instant createdAt = Instant.now();
}
