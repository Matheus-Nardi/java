package javacore.ZZJcrudJbdc.service;

import java.util.Optional;
import java.util.Scanner;

import javacore.ZZJcrudJbdc.domain.Producer;
import javacore.ZZJcrudJbdc.repository.ProducerRepository;

public class ProducerService {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void menu(int op) {
		switch (op) {
		case 0 -> System.exit(0);
		case 1 -> findByName();
		case 2 -> delete();
		case 3 -> save();
		case 4 -> update();
		}
	}

	private static void findByName() {
		System.out.println("Type the name or empty to all:");
		String name = SCANNER.nextLine();
		ProducerRepository.findByName(name)
			.forEach(producer -> System.out.printf("ID: [%d] | %s%n", producer.getId() , producer.getName()));
		
	}
	
	private static void delete() {
		System.out.println("Type the id of the producer you want to delete:");

		Integer id = Integer.parseInt(SCANNER.nextLine());
		System.out.println("Are you sure ? Y|N");
		boolean choise = SCANNER.nextLine().equalsIgnoreCase("Y") ? true : false;
		if(choise) {
			ProducerRepository.delete(id);
		}else 
			return;
		
	}
	
	private static void save() {
		System.out.println("Type the name of producer:");
		String producerName = SCANNER.nextLine();
		Producer producer = Producer.builder().name(producerName).build();
		ProducerRepository.save(producer);
	}
	
	private static void update() {
		System.out.println("Type the id of the producer you want to update:");
		Integer id = Integer.parseInt(SCANNER.nextLine());
		 Optional<Producer> producerOptional = ProducerRepository.findById(id);
		 if(producerOptional.isEmpty())
			 return;
		 
		Producer producerFromDB = producerOptional.get();
		System.out.println(producerFromDB);
		System.out.println("Type the new name of producer:");
		String producerName = SCANNER.nextLine();
		Producer producerToUpdate = Producer.builder().id(producerFromDB.getId()).name(producerName).build();
		ProducerRepository.update(producerToUpdate);
	}
}
