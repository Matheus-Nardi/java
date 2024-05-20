package javacore.ZZstream.model;

import java.util.Objects;

public class Book implements Comparable<Book> {
	private Integer id;
	private String nome;
	private Double preco;
	private Category category;

	public Book(Integer id, String nome, Double preco, Category category) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.category = category;
	}

	public Book(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", nome=" + nome + ", preco=" + preco + ", category=" + category + "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.getNome().compareToIgnoreCase(o.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(nome, other.nome);
	}

}
