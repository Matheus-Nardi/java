package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import models.enumns.ClassificacaoIdade;
import models.enumns.GeneroLivro;

public class Biblioteca {

	private ArrayList<Livro> livros;

	public Biblioteca() {
		livros = new ArrayList<Livro>();
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	public boolean adicionarLivro() {
		Scanner scan = new Scanner(System.in);
		Livro livro = new Livro();
		System.out.println("Digite o titulo do livro: ");
		livro.setTitulo(scan.next());
		System.out.println("Digite o nome do autor: ");
		livro.setAutor(scan.next());
		System.out.println("Digite o ano de publicação (dd/MM/yyyy): ");
		String data = scan.next();
		LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		livro.setAnoPublicacao(dataFormatada);

		livro.setGenero(GeneroLivro.escolherGenero());

		livro.setClassificacao(ClassificacaoIdade.escolherClassificacao());

		livros.add(livro);

		System.out.println("Livro adicionado com sucesso !");
		return true;
	}

	public void mostrarLivrosByGenero() {
		System.out.println("Filtro por genero");
		if (this.getLivros().isEmpty()) {
			System.out.println("Sem livros a serem vistos");
			return;
		}
		GeneroLivro generoEscolhido = GeneroLivro.escolherGenero();
		int countLivros = 0;
		for (Livro livro : livros) {
			if (livro.getGenero().getGenero().equals(generoEscolhido.getGenero()))
				System.out.println(livro);
			else
				countLivros++;
		}
		if (countLivros == this.livros.size())
			System.out.println("Nenhum livro da categoria escolhido foi encontrado");

	}

	public void mostrarLivrosByClassificacao() {
		System.out.println("Filtro por classificacção");
		if (this.getLivros().isEmpty()) {
			System.out.println("Sem livros a serem vistos");
			return;
		}

		ClassificacaoIdade classificacao = ClassificacaoIdade.escolherClassificacao();
		int countLivro = 0;
		for (Livro livro : livros) {
			if (livro.getClassificacao().getClassificacao().equals(classificacao.getClassificacao()))
				System.out.println(livro);
			else
				countLivro++;
		}
		if (countLivro == livros.size())
			System.out.println("Nenhum livro da categoria escolhido foi encontrado");

	}
}
