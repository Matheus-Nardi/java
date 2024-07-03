package com.mafn.domain.repository;

import java.util.List;

import com.mafn.domain.model.Post;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {

	public List<Post> findPostByUserId(Long userId){
		return  findAll().stream()
					.filter(post -> post.getUser().getId().equals(userId))
					.toList();
	}
}
