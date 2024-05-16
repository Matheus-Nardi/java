package javacore.ZZDoptional.app;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {

	public static void main(String[] args) {
		//Utilzado para evitar valores nulos , null appoitment exep
		//Evitar usar como atributo de classe e parametro
		Optional<String> o1 = Optional.of("OMG");
		Optional<String> o2 = Optional.ofNullable(null);
		Optional<String> o3 = Optional.empty();
		
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		
		System.out.println("---------------");
		Optional<String> nameOptional = findName("Maria");
		String e = nameOptional.orElse("Não achei nada");
		System.out.println(e);
		nameOptional.ifPresent(n -> System.out.println(n.toUpperCase()));
		

	}
	private static Optional<String> findName(String name) {
		List<String> nomes = List.of("Matheus", "Maria");
		int index = nomes.indexOf(name);
		if(index != -1) 
			return Optional.of(nomes.get(index));
		
		return Optional.empty();
	}

}
