package javacore.ZZIjdbc.app;

import javacore.ZZIjdbc.model.Producer;
import javacore.ZZIjdbc.repository.ProducerRepository;

public class ConnectionFactoryTest01 {
	public static void main(String[] args) {
		Producer producer = Producer.ProducerBuilder.builder()
		.name("Animate").build();
		
		ProducerRepository.save(producer);
	}
}
