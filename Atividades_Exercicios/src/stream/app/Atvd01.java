package stream.app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Atvd01 {
	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		//Forma 1 : Com comparator em lambda
		numeros.stream()
		.sorted((n1,n2) -> Integer.compare(n1, n2))
		.forEach(System.out::println);;
		
		System.out.println("-------");
		numeros.stream()
		.sorted()
		.forEach(System.out::println);
	}
}
