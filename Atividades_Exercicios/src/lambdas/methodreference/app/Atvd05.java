package lambdas.methodreference.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Crie uma função que receba uma lista de strings e retorne uma 
//lista contendo apenas as strings que possuem mais de 5 caracteres.
public class Atvd05 {
	public static void main(String[] args) {
		List<String> words = List.of("Abobora", "Cupcake", "Amor" , "Pai" , "Sol" , "Carro");
		System.out.println(returnLenghtMore5(words, Atvd05::lenghtWord));
		System.out.println(returnLenghtMore5(words, s-> s.length() > 5));
	}
	public static List<String> returnLenghtMore5(List<String> list, Predicate<String> predicate){
		List<String> result = new ArrayList<String>();
		for (String string : list) {
			if(predicate.test(string))
				result.add(string);
		}
		return result;
	}
	public static boolean lenghtWord(String s) {
		return s.length() > 5 ? true:false;
	}
}
