package generics.model;

import java.util.Objects;

public class Revista extends Item {
	private String editora;

	public Revista(String nome, Double preco, String editora) {
		super(nome, preco);
		this.editora = editora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(editora);
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
		Revista other = (Revista) obj;
		return Objects.equals(editora, other.editora);
	}

	@Override
	public String toString() {
		return super.toString() + this.editora;
	}
	
	

}
