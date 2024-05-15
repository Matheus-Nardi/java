package lambdas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Atvd03 {
	public static void main(String[] args) {
		List<String> nomes = List.of("Java","c#","php","javaScript","rust","cobol");
		List<String> newList = moreOrEquals4lenght(nomes, n -> n.length() >= 4);
		newList.forEach(n -> System.out.println(n));
		System.out.println("------");
		nomes.forEach(n -> {
			if(n.length()>=4) System.out.println(n);
		});
		
		
		//System.out.println(newList);
	}
	
	public static List<String> moreOrEquals4lenght(List<String> nomes , Predicate<String> predicate){
		List<String> filter = new ArrayList<String>();
		for (String e : nomes) {
			if(predicate.test(e)) {
				filter.add(e);
			}
		}
		
		return filter;
	}
}
