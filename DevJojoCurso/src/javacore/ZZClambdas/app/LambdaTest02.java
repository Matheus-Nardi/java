package javacore.ZZClambdas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
	public static void main(String[] args) {
		List<String> names = List.of("Ana" , "Matheus", "Maria");
		System.out.println(map(names , n -> n.length()));
		System.out.println(map(names , n -> n.toUpperCase()));
		
		
	}

	private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
		List<R> result = new ArrayList<R>();
		for (T e : list) {
			R apply = function.apply(e);
			result.add(apply);
		}

		return result;
	}
}
