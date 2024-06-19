package javacore.ZZIjdbc.app;

import java.util.List;

import javacore.ZZIjdbc.model.Producer;
import javacore.ZZIjdbc.service.ProducerService;

public class ConnectionFactoryTest03 {
	public static void main(String[] args) {
		List<Producer> producers = List.of(Producer.builder().name("Toei Animation").build() ,
				Producer.builder().name("White Fox").build(),
				Producer.builder().name("Studio Ghibli").build());
		
		ProducerService.saveTransaction(producers);
	}
}
