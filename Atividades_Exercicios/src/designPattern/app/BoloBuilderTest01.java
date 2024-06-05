package designPattern.app;

import java.util.Scanner;

import designPattern.model.Bolo;
import designPattern.model.Bolo.BoloBuilder;
import designPattern.model.BoloFactory;
import designPattern.model.Personalizacao.Cobertura;
import designPattern.model.Personalizacao.Decoracao;
import designPattern.model.Personalizacao.Recheio;
import designPattern.model.Personalizacao.Tamanho;
import designPattern.model.Personalizacao.TipoBolo;

public class BoloBuilderTest01 {

	public static void main(String[] args) {
		//Gerando bolo padrão pelo factory
		Scanner scan = new Scanner(System.in);
		Bolo boloFromFactory = BoloFactory.newBolo(opcoesBolo(scan));
		System.out.println(boloFromFactory);
		
		//Gerando bolo personalizado pelo builder
		Bolo boloFromBuilder = new Bolo.BoloBuilder().tipoBolo(TipoBolo.RED_VELVET).tamanho(Tamanho.GRANDE)
		.recheio(Recheio.BRIGADEIRO).cobertura(Cobertura.PASTA_AMERICANA).decoracao(Decoracao.FRUTAS).build();
		
		System.out.println(boloFromBuilder);
	}
	
	public static int opcoesBolo(Scanner scan) {
		System.out.println("1.Casamento");
		System.out.println("2.Formatura");
		System.out.println("3.Aniversario");
		
		return scan.nextInt();
	}

}
