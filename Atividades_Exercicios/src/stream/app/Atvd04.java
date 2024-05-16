package stream.app;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Atvd04 {
	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		BinaryOperator<Integer> sum = (x1, x2) -> x1 + x2;
		System.out.println(numeros.stream()
		.filter(x -> x>5)
		.reduce(0,sum));
	}
}
