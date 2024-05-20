package javacore.ZZstream.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
	public static void main(String[] args) {
		// exlusive 0 a 9
		// Inclusive 0 a 10

		IntStream myStream = IntStream.rangeClosed(0, 10);

		IntStream.rangeClosed(0, 20).filter(n -> n % 2 != 0).forEach(n -> System.out.print(n + " "));

		int sum = myStream.sum();

		System.out.println("\n" + sum);

		Stream.of("Payday", "Call of Duty", "Free fire", "Skyrim")
				.map(String::toUpperCase)
				.filter(game -> game.endsWith("Y"))
				.sorted()
				.forEach(System.out::println);

		int[] num = { 1, 2, 3, 4, 5, 6, 7 };
		Arrays.stream(num).average().ifPresent(System.out::println);

	}
}
