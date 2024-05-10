package javacore.Zgenerics.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javacore.Zgenerics.WildCard.model.Carro;

public class CarroRentavelService {
	private List<Carro> carrosDisponiveis = new ArrayList<Carro>(
			Arrays.asList(
				new Carro("BMW"),
				new Carro("Mercedes")));
	
	public Carro mostrarCarroDisponivel() {
		System.out.println("Buscando carro disponível");
		Carro c = carrosDisponiveis.remove(0);
		System.out.println("Alugando carro: ");
		System.out.println("Carros disponíveis para alugar: ");
		System.out.println(carrosDisponiveis);
		
		return c;
	}
	
	public void retornarCarroAlugado(Carro carro) {
		System.out.println("Devolvendo carro:" + carro);
		carrosDisponiveis.add(carro);
		System.out.println("Carros disponíveis para alugar: ");
		System.out.println(carrosDisponiveis);
	}
	
}
