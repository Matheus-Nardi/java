package javacore.ZZJcrudJbdc.app;

import java.util.Scanner;

import javacore.ZZJcrudJbdc.service.AnimeService;
import javacore.ZZJcrudJbdc.service.ProducerService;

public class CrudTest01 {
	private static final Scanner SCANNER = new Scanner(System.in);
	public static void main(String[] args) {
		int op;
		while(true) {
			menu();
			op = Integer.parseInt(SCANNER.nextLine());
			switch (op) {
			case 1:
				animeMenu();
				AnimeService.menu(Integer.parseInt(SCANNER.nextLine()));
				break;
			case 2 :
				producerMenu();
				ProducerService.menu(Integer.parseInt(SCANNER.nextLine()));
				break;
			case 0:
				System.exit(0);
			default: throw new IllegalArgumentException("Not a valid option");
			}
			
		}
	}
	
	public static void menu() {
		System.out.println("Type the number of your operation");
		System.out.println("1. Anime");
		System.out.println("2. Producer");
		System.out.println("0. Exit");
	}
	
	private static void producerMenu() {
		System.out.println("Type the number od your operation");
		System.out.println("1. Search for producer");
		System.out.println("2. Delete producer");
		System.out.println("3. Save producer");
		System.out.println("4. Update producer");
		System.out.println("5. Go back");
	}
	private static void animeMenu() {
		System.out.println("Type the number od your operation");
		System.out.println("1. Search for anime");
		System.out.println("2. Delete anime");
		System.out.println("3. Save anime");
		System.out.println("4. Update anime");
		System.out.println("5. Go back");
	}
}
