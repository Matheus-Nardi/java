package lambdas.methodreference.app;

import java.util.List;
import java.util.function.BiPredicate;

//Implemente uma função que receba uma lista de números e retorne o
//	maior número presente na lista.
public class Atvd03 {
	public static void main(String[] args) {
		List<Integer> list = List.of(1,3,4,20,43,21,50,28);
		//Fazendo com método
		System.out.println(biggerNumber(list, (a,b) -> a>b));
		
		//Com method reference
		System.out.println(biggerNumber(list, BiggerNumber::biggerNumberTest));
		
		BiPredicate<Integer, Integer> predicate = (a,b) -> a>b ;
		int maior = Integer.MIN_VALUE;
		for (Integer integer : list) {
			if(predicate.test(integer, maior))
				maior = integer;
				
		}
		System.out.println(maior);
	}
	
	public static Integer biggerNumber(List<Integer> list, BiPredicate<Integer,Integer> predicate){
		Integer bigNumber = Integer.MIN_VALUE;
		for (Integer integer : list) {
			if(predicate.test(integer,bigNumber)) 
				bigNumber = integer;
		}
		
		return bigNumber;
	}
}

class BiggerNumber{
	public static boolean biggerNumberTest(int a, int b){
		return a>b;
	}
}
