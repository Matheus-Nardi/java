package javacore.Zgenerics.WildCard.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javacore.Zgenerics.WildCard.model.Barco;
import javacore.Zgenerics.WildCard.model.Carro;
import javacore.Zgenerics.service.RentaService;

public class ClassGenericTest03 {
	public static void main(String[] args) {
		List<Carro> carrosDisponiveis = new ArrayList<Carro>(
				Arrays.asList(
					new Carro("BMW"),
					new Carro("Mercedes")));
		
		List<Barco> barcosDisponiveis = new ArrayList<Barco>(
				Arrays.asList(
					new Barco("Canoa"),
					new Barco("Lancha")));
		
		RentaService<Carro> rentaService = new RentaService<Carro>(carrosDisponiveis);
		Carro carro = rentaService.mostrarObjetosDisponivel();
		System.out.println("Usando carro...");
		rentaService.retornarObjetoAlugado(carro);
		
		System.out.println("----------------------");
		RentaService<Barco> rentaService2 = new RentaService<Barco>(barcosDisponiveis);
		Barco barco = rentaService2.mostrarObjetosDisponivel();
		System.out.println("Curtindo o barco");
		rentaService2.retornarObjetoAlugado(barco);
	}
}
