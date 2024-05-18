package stream.app;

import java.util.Comparator;
import java.util.List;

import stream.model.User;

public class Atvd05 {
	public static void main(String[] args) {
		List<User> users = List
				.of(new User("Michael", 23),
					new User("Ronaldo Cris", 47),
					new User("Plinio Salgado", 17),
					new User("Sabrina Melo", 67));	
			
		//Existe usuario menor de 18 ? 
		System.out.println(users.stream()
						.anyMatch(u -> u.getIdade() < 18));
		
		//Usuario que possuem um nome maior que 10 sortidos
		users.stream()
			.filter(u -> u.getName().length() > 10)
			.sorted(Comparator.comparing(User::getName))
			.forEach(System.out::println);
		
		System.out.println( "Existe usuario idoso ?" + !users.stream()
			.noneMatch(u -> u.getIdade() > 60));
		
		
		
	}
}
