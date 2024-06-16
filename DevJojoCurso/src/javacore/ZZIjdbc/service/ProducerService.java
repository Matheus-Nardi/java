package javacore.ZZIjdbc.service;

import java.util.List;

import javacore.ZZIjdbc.model.Producer;
import javacore.ZZIjdbc.repository.ProducerRepository;

public class ProducerService {

	public static void save(Producer producer) {
		ProducerRepository.save(producer);
	}

	public static void deleteBetween(Integer firstId, Integer lastId) {
		if (firstId <= 0 || lastId <= 0)
			throw new IllegalArgumentException("Invalid value for id");

		ProducerRepository.deleteBetween(firstId, lastId);
	}

	public static void delete(Integer id) {
		requireValidId(id);
		ProducerRepository.delete(id);
	}

	public static void update(Producer producer) {
		requireValidId(producer.getId());
		ProducerRepository.update(producer);
	}
	
	public static List<Producer> findAll() {
		return ProducerRepository.findAll();
	}
	
	public static List<Producer> findByName(String name) {
		return ProducerRepository.findByName(name);
	}
	
	public static void showProducerMetaData() {
		 ProducerRepository.showProducerMetaData();
	}
	
	public static void showDriverMetaData() {
		 ProducerRepository.showDriverMetaData();
	}
	public static void showTypeScrollWorking() {
		ProducerRepository.showTypeScrollWorking();
	}

	private static void requireValidId(Integer id) {
		if (id == null || id <= 0)
			throw new IllegalArgumentException("Invalid value for id");
	}
}
