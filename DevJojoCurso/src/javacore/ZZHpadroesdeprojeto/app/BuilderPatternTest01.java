package javacore.ZZHpadroesdeprojeto.app;

import javacore.ZZHpadroesdeprojeto.dominio.Person;
import javacore.ZZHpadroesdeprojeto.dominio.Person.PersonBuilder;

public class BuilderPatternTest01 {
	public static void main(String[] args) {
//		new Pessoa("Matheus","Nardi","teteusMal" , "matheus@gmail.com"); //Não sei o que cada argumento é 
		
		Person person = new Person.PersonBuilder()
				.firstName("Matheus")
				.lastName("Nardi")
				.username("tetus")
				.email("matheusnardi@gmail.com")
				.build();
		
		System.out.println(person);
		
	
	}
}
