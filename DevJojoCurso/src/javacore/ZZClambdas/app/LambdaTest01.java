package javacore.ZZClambdas.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
	public static void main(String[] args) {
		List<String> strings = List.of("Matheus", "Pedro", "Maria");
		List<Integer> integer = List.of(1, 2, 3, 4, 5, 6);
		forEach(strings, s -> System.out.println(s));
		forEach(integer, i -> System.out.println(i));

		integer.forEach(n -> {
			if (n % 2 == 0)
				System.out.println(n);
		});

		integer.forEach(n -> System.out.println(n * n));

	}

	public static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for (T e : list) {
			consumer.accept(e);
		}
	}
}
