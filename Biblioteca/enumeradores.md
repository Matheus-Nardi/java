Enumeradores visam representar tipos. Ou seja , em determinado estudo de caso percebo que um livro pode possuir difeentes tipo de genero (ficção , aventura , romance). Portanto é bom conteto para usar um enum.
Declaração de um enum com construtror e métodos get
```
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

```
Para mostrar os valores no enum é possivel percoorer o metodo values() que retorna um array
```
for (GeneroLivro genero : GeneroLivro.values()) {
			System.out.println(genero.getIndice() + " - " + genero.getGenero());
		}
```
Método para filtrar um livro de acordo com seu genero (parece confuso!)
* Ele faz verficações básicas se a lista está vazia ou se não possui um elemento que atende ao genero.
* livro.getGenero() retorna um enum do tipo GeneroLivro
* .getGenero() retorna o atributo genero do enum
* .equals(generoEscolhido.getGenero())) verifica se é igual ao genero escolhido pelo úsuario.
```
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
```
O projeto Biblioteca visa a atulização do enum para cadastro de livros
