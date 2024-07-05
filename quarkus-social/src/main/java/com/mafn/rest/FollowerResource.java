package com.mafn.rest;

import java.util.List;
import java.util.stream.Collectors;

import com.mafn.domain.model.Follower;
import com.mafn.domain.model.User;
import com.mafn.domain.repository.FollowerRepository;
import com.mafn.domain.repository.UserRepository;
import com.mafn.rest.dto.FollowerRequest;
import com.mafn.rest.dto.FollowerResponse;
import com.mafn.rest.dto.FollowersPerUserResponse;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
		
		
		if(userId.equals(request.getFollowerId())) {
			return Response.status(Response.Status.CONFLICT).entity("You can't follow yourself").build();
		}
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
	
	@GET
	public Response getAllFollowerByUser(@PathParam("userId") Long userId) {
		
		User user = userRepository.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		List<Follower> allFollowers = followerRepository.findByUser(userId);
		FollowersPerUserResponse followersPerUserResponse = new FollowersPerUserResponse();
		followersPerUserResponse.setFollowersCount(allFollowers.size());
		
		List<FollowerResponse> followersList = allFollowers.stream().map(FollowerResponse::new).collect(Collectors.toList());
		
		followersPerUserResponse.setContent(followersList);
		
		return Response.ok(followersPerUserResponse).build();
				
	}
	
	@DELETE
	@Transactional
	public Response unfollowUser(@PathParam("userId") Long userId , @QueryParam("followerId") Long followerId ) {
		User user = userRepository.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		followerRepository.deleteByFollowerAndUser(followerId, userId);
		
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	
}
