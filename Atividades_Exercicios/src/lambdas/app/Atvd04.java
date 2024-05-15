package lambdas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Atvd04 {
	public static void main(String[] args) {
		List<String> nomes = List.of("Ananias","Amanda","Ricado","Matheus","ana");
		mutante(nomes , n -> n.charAt(0) == 'A' || n.charAt(0) == 'a', n -> n.toUpperCase() , n -> System.out.println(n));
	}
	
	private static List<String> mutante(List<String> nomes, Predicate<String> predicate, Function<String, String> function , Consumer<String> consumer){
		List<String> nomeComLetra = new ArrayList<String>();
		for (String string : nomes) {
			if(predicate.test(string)) nomeComLetra.add(string);
		}
		
		List<String> upper = new ArrayList<String>();
		for (String string : nomeComLetra) {
			String s = function.apply(string);
			upper.add(s);
		}
		
		for (String string : upper) {
			consumer.accept(string);
		}
		
		return upper;
		
		
	}
}
