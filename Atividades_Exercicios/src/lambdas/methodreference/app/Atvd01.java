package lambdas.methodreference.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lambdas.methodreference.model.CheckPar;

public class Atvd01 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9,10));
		
		Predicate<Integer> predicate = CheckPar::checharPar;
		Predicate<Integer> predicate2 = n -> (n%2==0) ;
		
		for (Integer integer : list) {
			if(predicate.test(integer))
				System.out.println(integer);
		}
		
	}
}
