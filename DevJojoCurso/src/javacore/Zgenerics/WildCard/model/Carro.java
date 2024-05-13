package javacore.Zgenerics.WildCard.model;

public class Carro {
	private String nome;
	
	public Carro(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Carro [nome=" + nome + "]";
	}
	 public String getNome() {
		return nome;
	}
	
}
