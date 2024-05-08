package abibliotecaTryCatch.models;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	private List<Livro> livros;

	public Biblioteca() {
		livros = new ArrayList<Livro>();
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void adicionarLivro(Livro livro) {
		if (livros.contains(livro))
			throw new RuntimeException("Livro já existente");

		livros.add(livro);

	}

	public void removerLivro(Livro livro) {
		if (!livros.contains(livro))
			throw new RuntimeException("O livro não pode ser removido , porque não existe ou já foi removido");

		livros.remove(livro);
	}

	public void emprestarLivro(Livro livro) {
		if (!livro.getDisponivel() == true)
			throw new RuntimeException("O livro não pode ser emprestado");

		System.out.println("Livro emprestado");
		livro.setDisponivel(false);
	}

	public void devolverLivro(Livro livro) {
		if (!livro.getDisponivel() == false) {
			throw new RuntimeException("O livro já está disponível , portanto não foi emprestado");
		}

		System.out.println("Devolvendo livro...");
		livro.setDisponivel(true);
	}

	public Livro createBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o titulo: ");
		String titulo = scan.nextLine();
		System.out.println("Digite o autor: ");
		String autor = scan.nextLine();
		LocalDate dataLancamento = tratarData(scan);
		System.out.println("O livro está disponível ? [1]Sim - [2]Não: ");
		Boolean disponivel = scan.nextInt() == 1 ? true : false;
		return new Livro(titulo, autor, dataLancamento, disponivel);
	}

	private LocalDate tratarData(Scanner scan) {
		LocalDate data = null;
		boolean dataValida = false;
		while (!dataValida) {
			try {
				System.out.println("Digite o ano de lançamento (dd-MM-yyy): ");
				String dataLancamento = scan.next();
				data = LocalDate.parse(dataLancamento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				dataValida = true;
			} catch (DateTimeException e) {
				System.out.println("Formato inválido! Insira novamente: ");
				scan.nextLine();
			}
		}
		return data;

	}
}
