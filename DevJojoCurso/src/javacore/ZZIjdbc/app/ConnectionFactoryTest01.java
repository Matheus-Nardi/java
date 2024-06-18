package javacore.ZZIjdbc.app;

import java.util.List;

import javacore.ZZIjdbc.model.Producer;
import javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

public class ConnectionFactoryTest01 {
	public static void main(String[] args) {

		Producer producer = Producer.builder().name("Studio Deen").build();
		Producer producerUpdate = Producer.builder().id(1).name("Studio Deen").build();
		//ProducerService.save(producer);
		//ProducerService.deleteBetween(3,6);
		//ProducerService.delete(7);
		//ProducerService.update(producerUpdate);
		
//		ProducerService.findAll().forEach(System.out::println);
		
//		ProducerService.findByName("Ani").forEach(System.out::println);
		
//		ProducerService.showProducerMetaData();
		
//		ProducerService.showDriverMetaData();
//		ProducerService.showTypeScrollWorking();
		
//		ProducerService.findByNameAndUpdateToUpperCase("animate").forEach(System.out::println);
//		System.out.println(ProducerService.findByNamePreparedStatement("Bone"));
//		ProducerService.findByNameAndDelete("A-1 pictures");
		
		ProducerService.updatePreparedStatment(producerUpdate);
		
		
	}
}
