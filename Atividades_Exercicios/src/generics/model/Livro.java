package generics.model;

import java.util.Objects;

public class Livro extends Item {
	private String autor;

	public Livro(String nome, Double preco, String autor) {
		super(nome, preco);
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(autor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(autor, other.autor);
	}

	@Override
	public String toString() {
		return super.toString() + this.autor;
	}
	
	
	

}
