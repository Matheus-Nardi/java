package abibliotecaTryCatch.app;

import abibliotecaTryCatch.models.Biblioteca;
import abibliotecaTryCatch.models.Livro;

public class Main {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		
		for (int i = 0; i < 2; i++) {
			Livro generico = biblioteca.createBook();
			biblioteca.adicionarLivro(generico);
		}
		
		Livro livroPos0 = biblioteca.getLivros().get(0);
		
		biblioteca.devolverLivro(livroPos0);
		biblioteca.emprestarLivro(livroPos0);
//		System.out.println("Removendo o primeiro livro");
//		biblioteca.removerLivro(livroPos0);
//		System.out.println("Removendo o primeiro livro novamente");
//		biblioteca.removerLivro(livroPos0);
//		


	}

}
