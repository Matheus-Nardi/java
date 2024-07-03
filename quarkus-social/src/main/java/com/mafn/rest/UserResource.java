package com.mafn.rest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mafn.domain.model.User;
import com.mafn.domain.repository.UserRepository;
import com.mafn.rest.dto.CreateUserRequest;
import com.mafn.rest.dto.ResponseError;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	private UserRepository repository;
	private Validator validator;

	@Inject
	public UserResource(UserRepository repository, Validator validator) {
		this.repository = repository;
		this.validator = validator;
	}

	@POST
	@Transactional
	public Response createUser(CreateUserRequest userRequest) {
		Set<ConstraintViolation<CreateUserRequest>> violations = validator.validate(userRequest);
		if (!violations.isEmpty()) {
			return ResponseError.createFromValidation(violations).withStatusCode(ResponseError.UNPROCESSABLE_ENTITY_STATUS);
			 
		}
		User user = new User();
		String name = userRequest.getName();

		String nameFormat = name.substring(0, 1).toUpperCase() + name.substring(1);
		user.setName(nameFormat);
		user.setAge(userRequest.getAge());
		repository.persist(user);
		return Response.status(Response.Status.CREATED.getStatusCode())
				.entity(userRequest)
				.build();
	}

	@GET
	public Response listAllUser() {
		PanacheQuery<User> allUsers = repository.findAll();
		return Response.ok(allUsers.list()).build();
	}

	@GET
	@Path("{name}")
	public Response listAllUserByName(@PathParam("name") String name) {
		List<User> usersByName = repository.findyByName(name);
		return Response.ok(usersByName).build();

	}

	@DELETE
	@Transactional
	@Path("{id}")
	public Response deleteUser(@PathParam("id") Long id) {
		User userById = repository.findById(id);
		if (userById != null) {
			repository.delete(userById);
			return Response.noContent().build();
		}

		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Transactional
	@Path("{id}")
	public Response updateUser(@PathParam("id") Long id, CreateUserRequest userData) {
		User userFromDB = repository.findById(id);

		if (userFromDB != null) {
			userFromDB.setName(userData.getName());
			userFromDB.setAge(userData.getAge());
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
}
