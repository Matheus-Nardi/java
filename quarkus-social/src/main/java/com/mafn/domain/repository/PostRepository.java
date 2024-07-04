package com.mafn.domain.repository;

import java.util.List;

import com.mafn.domain.model.Post;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {

}
