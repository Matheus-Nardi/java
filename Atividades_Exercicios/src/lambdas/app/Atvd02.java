package lambdas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Atvd02 {
	public static void main(String[] args) {
		 List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);
		System.out.println(square(nums , n -> n*n));
		
		System.out.println();
	}
	
	private static List<Integer> square(List<Integer> list , Function<Integer,Integer> function){
		List<Integer> result = new ArrayList<Integer>();
		for (Integer integer : list) {
			Integer n = function.apply(integer);
			result.add(n);
		}
		
		return result;
	}
}
