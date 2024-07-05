package com.mafn.rest.dto;

import com.mafn.domain.model.Follower;

import lombok.Data;

@Data
public class FollowerResponse {
	private Long id;
	private String name;
	

	public FollowerResponse() {
		// TODO Auto-generated constructor stub
	}
	public FollowerResponse(Follower follower) {
		this(follower.getId(), follower.getFollower().getName());
	}
	
	
	public FollowerResponse(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
