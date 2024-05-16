package lambdas.methodreference.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
//Crie um programa que receba uma lista de strings e retorne uma lista contendo
//apenas as strings que começam com a letra "A".
public class Atvd02 {
	public static void main(String[] args) {
		List<String> list = List.of("Amanda","Carlos","Bruna","Ananias");
		//Fazendo com método
		System.out.println(stringsWithA(list, s -> s.toUpperCase().charAt(0) == 'A'));
		System.out.println("---------");
		//Fazendo em linha
		Predicate<String> predicate = s -> s.toUpperCase().charAt(0) == 'A';
		for (String string : list) {
			if(predicate.test(string)) 
				System.out.println(string);
		}
		System.out.println("---------");
		//Fazendo com Method Reference
		System.out.println(stringsWithA(list, StartA::startA));
	}

	public static List<String> stringsWithA(List<String> list, Predicate<String> predicate) {
		List<String> result = new ArrayList<String>();
		for (String string : list) {
			if(predicate.test(string)) {
				result.add(string);
			}
		}
		return result;
	}
}

class StartA{
	public static boolean startA(String s) {
		return s.toUpperCase().charAt(0) == 'A' ? true : false;
	}
}
