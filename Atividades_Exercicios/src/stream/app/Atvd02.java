package stream.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Atvd02 {
	public static void main(String[] args) {
		
		List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3));
		
		boolean isPositive = numeros.stream()
		.allMatch(n -> n == Math.abs(n));
		
	
		
		System.out.println("Todos os numeros são positivos :" + (isPositive ? "Sim" : "Não"));
		
	}
}
