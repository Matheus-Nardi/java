package javacore.ZZClambdas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

//Classe + metodo não estático
public class MethodReferenceTeste03 {
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<String>(List.of("Mayara" , "Ricardo" , "Carlão"));
		
		nomes.sort(String::compareTo);
		
		System.out.println(nomes);
		
		Function<String,Integer> numStringToInteger = Integer::parseInt;
		
		System.out.println(numStringToInteger.apply("10"));
		
		BiPredicate<List<String>, String> checkName = List::contains;
		System.out.println(checkName.test(nomes, "Mayara"));
	}
}
