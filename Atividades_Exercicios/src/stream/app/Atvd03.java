package stream.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atvd03 {
	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3));

		List<Integer> impares = numeros.stream().filter(n -> n % 2 != 0).toList();

		List<Integer> onlyPar = numeros.stream().filter(n -> n % 2 == 0).toList();

		numeros.removeAll(impares);
		System.out.println(numeros);
		System.out.println(onlyPar);
	}
}
