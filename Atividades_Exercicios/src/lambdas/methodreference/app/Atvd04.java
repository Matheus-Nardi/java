package lambdas.methodreference.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Escreva um programa que receba uma lista de palavras e 
//retorne uma lista contendo o tamanho de cada palavra.
public class Atvd04 {

	public static void main(String[] args) {
		Function<String, Integer> function = s -> s.length();
		Function<String, Integer> functionMethod = String::length;

		List<String> palavras = List.of("abacaxi", "suco", "amendoa", "carburador");
		List<Integer> result = lenghtWord(functionMethod, palavras);
		List<Integer> result2 = lenghtWord(function, palavras);

		System.out.println(result);
		System.out.println(result2);

	}

	private static List<Integer> lenghtWord(Function<String, Integer> function, List<String> palavras) {
		List<Integer> result = new ArrayList<Integer>();
		for (String string : palavras) {
			Integer qtdLetras = function.apply(string);
			result.add(qtdLetras);
		}
		return result;
	}

}
