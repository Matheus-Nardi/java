package com.mafn.domain.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mafn.domain.model.Follower;
import com.mafn.domain.model.User;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Follower> {

	public boolean isFollower(User follower, User user) {
		Map<String, Object> params = new HashMap<>();
		params.put("follower", follower);
		params.put("user", user);
		PanacheQuery<Follower> query = find("follower =:follower and user =:user",params);
		Optional<Follower> firstResultOptional = query.firstResultOptional();
		
		return firstResultOptional.isPresent();
	}
	
	public List<Follower> findByUser(Long userId){
		return find("user.id", userId).list();
	}
	
	public void deleteByFollowerAndUser(Long followerId , Long userId) {
		Map<String, Object> params = Parameters.with("followerId", followerId).and("userId", userId).map();
		delete("follower.id =:followerId and user.id =:userId",params);
		
	}
}
