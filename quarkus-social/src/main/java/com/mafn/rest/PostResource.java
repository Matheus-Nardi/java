package com.mafn.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.mafn.domain.model.Follower;
import com.mafn.domain.model.Post;
import com.mafn.domain.model.User;
import com.mafn.domain.repository.FollowerRepository;
import com.mafn.domain.repository.PostRepository;
import com.mafn.domain.repository.UserRepository;
import com.mafn.rest.dto.CreatePostRequest;
import com.mafn.rest.dto.PostResponse;
import com.mafn.rest.dto.ResponseError;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

	private UserRepository userRepository;
	private PostRepository postRepository;
	private FollowerRepository followerRepository;
	private Validator validator;
	
	@Inject
	public PostResource(UserRepository userRepository,PostRepository postRepository, Validator validator,FollowerRepository followerRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
		this.followerRepository = followerRepository;
		this.validator = validator;
	}
	@POST
	@Transactional
	@PathParam("{userId}")
	public Response savePost( @PathParam("userId") Long userId,  CreatePostRequest postRequest) {
		User user = userRepository.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Set<ConstraintViolation<CreatePostRequest>> violations = validator.validate(postRequest);
		if(!violations.isEmpty()) {
			return ResponseError.createFromValidation(violations).withStatusCode(ResponseError.UNPROCESSABLE_ENTITY_STATUS);
		}
		Post post = new Post();
		post.setUser(user);
		post.setText(postRequest.getText());
		postRepository.persist(post);
		return Response.status(Response.Status.CREATED).build();	
		
	}
	
	@GET
	public Response listPosts(@PathParam("userId") Long userId , @HeaderParam("followerId") Long followerId) {
		User user = userRepository.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		if(followerId == null) {
			return Response.status(Response.Status.BAD_REQUEST).entity("You forgot the header followerId").build();
		}
		User follower = userRepository.findById(followerId);
		
		if(follower == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Not found a follower with that id.").build();
		}
		
		if(!followerRepository.isFollower(follower, user) && !userId.equals(followerId)) {
			return Response.status(Response.Status.FORBIDDEN).entity("You can't see these posts!").build();
		}
		
		List<Post> postByUserId = postRepository.find("user ", user).list();
		
		List<PostResponse> postResponse = postByUserId.stream()
				.map(PostResponse::fromEntity)
				.toList()
				.reversed();
		 
		return Response.ok(postResponse).build();
	}
}
