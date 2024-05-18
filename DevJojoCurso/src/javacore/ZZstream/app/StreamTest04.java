package javacore.ZZstream.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {
	public static void main(String[] args) {
		//Flat Map : usado como um map em estruturas aninhadas, como uma lista de lista
		List<List<String>> devjojo = new ArrayList<List<String>>();
		
		List<String> devs = List.of("Matheus Nardi" ,  "Catarina");
		List<String> desingers = List.of("Ana" ,  "William");
		List<String> students = List.of("Matheus Nardi" ,  "Gustavo","Carolina","Danilo");
		
		devjojo.add(devs);
		devjojo.add(desingers);
		devjojo.add(students);
		
		for (List<String> people : devjojo) {
			for (String person : people) {
				System.out.println(person);
			}
		}
		System.out.println("=====FLAT MAP=====");
		devjojo.stream()
			.flatMap(Collection::stream)
			.sorted()
			.forEach(System.out::println);
		
	}
}
