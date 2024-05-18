package stream.app;

import java.util.List;

import stream.model.User;

public class Atvd06 {

	public static void main(String[] args) {
		List<User> users = List
				.of(new User("Michael", 23),
					new User("Ronaldo Cris", 47),
					new User("Plinio Salgado", 17),
					new User("Sabrina Melo", 67));	
			
		//Calcular Médias das idades
		 System.out.println(users.stream()
		 	  .mapToInt(User::getIdade)
		 	  .average()
		 	  .orElse(0));
	}

}
