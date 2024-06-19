package javacore.ZZJcrudJbdc.app;

import java.util.Scanner;

import javacore.ZZJcrudJbdc.service.ProducerService;

public class CrudTest01 {
	private static final Scanner SCANNER = new Scanner(System.in);
	public static void main(String[] args) {
		int op;
		while(true) {
			producerMenu();
			op = Integer.parseInt(SCANNER.nextLine());
			ProducerService.menu(op);
			
		}
	}
	
	private static void producerMenu() {
		System.out.println("Type the number od your operation");
		System.out.println("1. Search for producer");
		System.out.println("2. Delete producer");
		System.out.println("3. Save producer");
		System.out.println("4. Update producer");
		System.out.println("0. Exit");
	}
}
