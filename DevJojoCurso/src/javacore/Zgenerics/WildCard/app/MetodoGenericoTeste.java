package javacore.Zgenerics.WildCard.app;

import java.util.List;

import javacore.Zgenerics.WildCard.model.Carro;

public class MetodoGenericoTeste {
	public static void main(String[] args) {
		List<Carro> carros = criarArrayObject(new Carro("Fusca"));
		System.out.println(carros);
	}
	
	private static <T> List<T> criarArrayObject(T t) {
		return List.of(t);
		
	}
}
