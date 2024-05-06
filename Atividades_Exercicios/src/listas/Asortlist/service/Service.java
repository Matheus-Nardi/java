package listas.Asortlist.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import listas.Asortlist.modelo.ClassificaoIndicativa;
import listas.Asortlist.modelo.Filme;
import listas.Asortlist.repository.Repository;
import listas.Asortlist.utils.FilmeByDuration;
import listas.Asortlist.utils.FilmeByLaunchDate;

public class Service {
	private static List<Filme> filmes = Repository.returnDefaultMovies();

	public static void adicionarFilme() {
		Scanner scan = new Scanner(System.in);
		Filme filme = new Filme();
		System.out.print("Digite o titulo: ");
		filme.setTitulo(scan.nextLine());
		System.out.print("Digite a descrição: ");
		filme.setDescricao(scan.nextLine());
		System.out.print("Digite a duração: ");
		filme.setDuração(scan.nextLong());
		scan.nextLine();
		System.out.print("Digite o ano de lançamento: ");
		filme.setDataLancamento(scan.nextLine());
		System.out.print("Informe a classificao indicativa: ");
		ClassificaoIndicativa.mostrarClassificao();
		filme.setClassificao(ClassificaoIndicativa.valueOf(scan.nextInt()));

		filmes.add(filme);
	}
	
	public static void alterarFilme() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual filme voce deseja alterar ?");
		mostrarFilmes();

		int index = scan.nextInt();
		Filme filmeAlterado = filmes.get(index);
		filmes.remove(index);
		scan.nextLine();
		System.out.print("Digite o titulo: ");
		filmeAlterado.setTitulo(scan.nextLine());
		System.out.print("Digite a descrição: ");
		filmeAlterado.setDescricao(scan.nextLine());
		System.out.print("Digite a duração: ");
		filmeAlterado.setDuração(scan.nextLong());
		scan.nextLine();
		System.out.print("Digite o ano de lançamento: ");
		filmeAlterado.setDataLancamento(scan.nextLine());
		System.out.print("Informe a classificao indicativa: ");
		ClassificaoIndicativa.mostrarClassificao();
		filmeAlterado.setClassificao(ClassificaoIndicativa.valueOf(scan.nextInt()));
		
		filmes.add(index, filmeAlterado);
		
		mostrarFilmes();
	}

	public static void removerFilme() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual filme voce deseja remover ?");
		mostrarFilmes();

		int index = scan.nextInt();

		try {
			filmes.remove(index);
		} catch (Exception e) {
			System.out.println("Parametro não reconhecido" + e.getMessage());
		}

		System.out.println("Lista atualizada");
		mostrarFilmes();
	}

	public static void mostrarFilmes() {
		Collections.sort(filmes);
		for (int i = 0; i < filmes.size(); i++) {
			System.out.println(i + " - " + filmes.get(i));
		}
	}

	public static void mostrarFilmesByDuration() {
		filmes.sort(new FilmeByDuration());
		for (int i = 0; i < filmes.size(); i++) {
			System.out.println(i + " - " + filmes.get(i));
		}
	}

	public static void mostrarFilmesByLunchYear() {
		filmes.sort(new FilmeByLaunchDate());
		for (int i = 0; i < filmes.size(); i++) {
			System.out.println(i + " - " + filmes.get(i));
		}
	}

}


