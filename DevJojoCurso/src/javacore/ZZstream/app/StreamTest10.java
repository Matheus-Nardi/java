package javacore.ZZstream.app;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class StreamTest10 {
	public static void main(String[] args) {
		Stream.iterate(0, n -> n+2)
			.limit(10)
			.forEach(System.out::println);
		
		Stream.iterate(new int[] {0,1}, 
				n-> new int[] {n[1], n[0]+ n[1] })
				.limit(10)
				.forEach(a -> System.out.println(Arrays.toString(a)));
		
		
		Stream.iterate(new int[] {0,1}, 
				n-> new int[] {n[1], n[0]+ n[1] })
				.limit(10)
				.map(a -> a[0])
				.forEach(System.out::println);
		System.out.println("--------");
		Random rand = new Random();
		Stream.generate(() -> rand.nextInt(0, 250))
		.limit(5)
		.sorted()
		.forEach(System.out::println);
		}
}
