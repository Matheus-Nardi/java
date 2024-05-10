package javacore.Zgenerics.WildCard.app;

import javacore.Zgenerics.WildCard.model.Carro;
import javacore.Zgenerics.service.CarroRentavelService;

public class ClasseGenerica01 {
	public static void main(String[] args) {
		CarroRentavelService carroRentavelService = new CarroRentavelService();
		
		Carro c = carroRentavelService.mostrarCarroDisponivel();
		System.out.println("Usando o carro por um mes...");
		carroRentavelService.retornarCarroAlugado(c);
	}
}
