package com.mafn.rest;

import com.mafn.domain.model.Follower;
import com.mafn.domain.model.User;
import com.mafn.domain.repository.FollowerRepository;
import com.mafn.domain.repository.UserRepository;
import com.mafn.rest.dto.FollowerRequest;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users/{userId}/followers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerResource {

	private UserRepository userRepository;
	private FollowerRepository followerRepository;
	private Validator validator;
	
	
	@Inject
	public FollowerResource(UserRepository userRepository, FollowerRepository followerRepository,
			Validator validator) {
		this.userRepository = userRepository;
		this.followerRepository = followerRepository;
		this.validator = validator;
	}
	
	@PUT
	@Transactional
	public Response followUser(@PathParam("userId") Long userId, FollowerRequest request) {
		User user = userRepository.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		User follower = userRepository.findById(request.getFollowerId());
		
		boolean isFollower = followerRepository.isFollower(follower, user);
		if(!isFollower) {
			Follower entityFollower = new Follower();
			entityFollower.setUser(user);
			entityFollower.setFollower(follower);
			followerRepository.persist(entityFollower);
		}
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	
}
