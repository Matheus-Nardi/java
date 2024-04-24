package models.enumns;

import java.util.Scanner;

public enum GeneroLivro {
	FICÇÃO(1, "Ficação"), NÃOFICÇÃO(2, "Não ficção"), ROMANCE(3, "Romance"), AVENTURA(4, "Aventura"),
	AUTOAJUDA(5, "Auto-ajuda");

	private Integer indice;
	private String genero;

	private GeneroLivro(Integer indice, String genero) {
		this.indice = indice;
		this.genero = genero;
	}

	public Integer getIndice() {
		return indice;
	}

	public String getGenero() {
		return genero;
	}

	public static GeneroLivro getByIndice(Integer indice) {
		for (GeneroLivro generos : values()) {
			if (generos.getIndice() == indice)
				return generos;
		}
		return null;
	}

	public static GeneroLivro escolherGenero() {
		System.out.println("Informe o genero do livro: ");
		Scanner scan = new Scanner(System.in);
		for (GeneroLivro genero : GeneroLivro.values()) {
			System.out.println(genero.getIndice() + " - " + genero.getGenero());
		}
		return GeneroLivro.getByIndice(scan.nextInt());
	}

}
