package com.mafn.jogos_jpa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.domain.Modo;
import com.mafn.jogos_jpa.service.DesenvolvedorService;
import com.mafn.jogos_jpa.service.GeneroService;

public class InputUtils {
	private static final Scanner SCAN = new Scanner(System.in);

	public static String lerString() {
		return SCAN.nextLine();
	}

	public static Double lerDouble() {
		try {
			return Double.parseDouble(SCAN.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Informe um valor do tipo double válido!Exemplo 1.99");
			return lerDouble();
		}
	}

	public static Long lerLong() {
		try {
			return Long.parseLong(SCAN.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Informe um valor do tipo long válido!");
			return lerLong();
		}
	}

	public static Integer lerInt() {
		try {
			return Integer.parseInt(SCAN.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Informe um valor do tipo int válido!Exemplo 1");
			return lerInt();
		}
	}

	public static LocalDate lerData() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			return LocalDate.parse(SCAN.nextLine(), formato);
		} catch (Exception e) {
			System.out.println("Informe uma data no formato válido! Exemplo: 21-10-2024");
			return lerData();
		}
	}

	public static Modo lerEnumModo() {
		for (Modo modo : Modo.values()) {
			System.out.printf("[%d] - [%s]%n", modo.ordinal(), modo.name());
		}

		try {
			return Modo.valueOfOrdinal(lerInt());
		} catch (IllegalArgumentException e) {
			System.out.println("Informe um modo válido!");
			return lerEnumModo();
		}
	}

	public static Desenvolvedor lerDesenvolvedor() {
		System.out.println("Informe o nome do desenvolvedor: ");
		String nome = SCAN.nextLine();
		System.out.println("Informe a url do site:  ");
		String url = SCAN.nextLine();

		return Desenvolvedor.builder().nome(nome).urlSite(url).build();
	}

	public static Genero lerGenero() {
		System.out.println("Informe o nome do genero: ");
		String nome = SCAN.nextLine();
		return Genero.builder().nome(nome).build();
	}

	public static List<Genero> lerGeneros() {
		List<Genero> generos = new ArrayList<Genero>();
		GeneroService generoService = new GeneroService();
		generoService.obterTodos().forEach(g -> System.out.printf("[%d] - %s%n" , g.getId() , g.getNome()));
		boolean add = true;
		while (add) {
			System.out.println("1.Adicionar");
			System.out.println("2.Parar");
			Integer op = lerInt();
			switch (op) {
			case 1:
				System.out.println("Informe o id do genero: ");
				generos.add(generoService.obterById(lerLong()));
				break;
			case 2:
				add = false;
				break;
			default:
				System.out.println("Informe uma opção válida!");
			}
		}

		return generos;
	}

	public static Jogo lerJogo() {
		DesenvolvedorService desenvolvedorService = new DesenvolvedorService();
		System.out.println("Infore o nome do jogo:");
		String nome = lerString();
		System.out.println("Infore o preço do jogo:");
		Double preco = lerDouble();
		System.out.println("Infore a data de lançamento do jogo:");
		LocalDate dataLancamento = lerData();
		System.out.println("Informe o id do desenvolvedor do jogo: ");
		desenvolvedorService.obterTodos().forEach(des -> System.out.printf("[%d] - %s%n" , des.getId() , des.getNome()));
		Desenvolvedor desenvolvedor = desenvolvedorService.obterById(lerLong());
		System.out.println("Informe os generos: ");
		List<Genero> generos = lerGeneros();
		System.out.println("Infore o modo do jogo:");
		Modo modo = lerEnumModo();

		Jogo jogo = Jogo.builder().nome(nome).preco(preco).dataLancamento(dataLancamento).desenvolvedor(desenvolvedor)
				.generos(generos).modo(modo).build();

		for (Genero genero : generos) {
			jogo.adiconarGenero(genero);
		}

		return jogo;

	}

}
