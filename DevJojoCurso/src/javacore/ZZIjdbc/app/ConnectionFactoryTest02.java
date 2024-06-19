package javacore.ZZIjdbc.app;

import java.util.List;

import javacore.ZZIjdbc.model.Producer;
import javacore.ZZIjdbc.service.ProducerServiceRowSet;

public class ConnectionFactoryTest02 {
	public static void main(String[] args) {
		Producer producerUpdate = Producer.builder().id(2).name("AnimatE").build();
//		ProducerServiceRowSet.updateJdbcRowSet(producerUpdate);
		System.out.println("---------------");
		List<Producer> byNameJdbcRowSet = ProducerServiceRowSet.findByNameJdbcRowSet("");
		System.out.println(byNameJdbcRowSet);
		
//		ProducerServiceRowSet.updateCachedRowSet(producerUpdate);
	
	}
}
