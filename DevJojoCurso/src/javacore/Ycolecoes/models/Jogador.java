package javacore.Ycolecoes.models;

import java.util.Objects;

public class Jogador implements Comparable<Jogador> {
	private Integer id;
	private String nome;
	private Integer numeroCamisa;

	public Jogador(Integer id, String nome, Integer numeroCamisa) {
		super();
		Objects.requireNonNull(id , "O ID não pode ser nulo");  //Garante que não seja nulo
		Objects.requireNonNull(nome, "O nome não pode ser nulo");
		this.id = id;
		this.nome = nome;
		this.numeroCamisa = numeroCamisa;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", numeroCamisa=" + numeroCamisa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, numeroCamisa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroCamisa, other.numeroCamisa);
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroCamisa() {
		return numeroCamisa;
	}

	public void setNumeroCamisa(Integer numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	@Override
	public int compareTo(Jogador o) {
		return this.nome.compareTo(o.getNome());
	}
	
	

}
