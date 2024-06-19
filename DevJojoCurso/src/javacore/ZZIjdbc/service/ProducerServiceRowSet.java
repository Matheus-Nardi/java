package javacore.ZZIjdbc.service;

import java.util.List;

import javacore.ZZIjdbc.model.Producer;
import javacore.ZZIjdbc.repository.ProducerRepositoryRowSet;

public class ProducerServiceRowSet {
	public static List<Producer> findByNameJdbcRowSet(String name){
		return ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
	}
	
	public static void updateJdbcRowSet(Producer producer) {
		ProducerRepositoryRowSet.updateJdbcRowSet(producer);
	}
	public static void updateCachedRowSet(Producer producer) {
		ProducerRepositoryRowSet.updateCachedRowSet(producer);
	}
}
