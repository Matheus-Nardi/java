package com.mafn.domain.repository;

import java.util.List;

import com.mafn.domain.model.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
		
	public List<User> findyByName(String name){
		String nameFormat = name.substring(0,1).toUpperCase() + name.substring(1);
		return find("name like ?1" , "%"+nameFormat+"%").list();
	}
	
}
