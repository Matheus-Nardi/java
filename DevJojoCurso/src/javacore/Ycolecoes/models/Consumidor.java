package javacore.Ycolecoes.models;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Consumidor {
	private Integer id;
	private String nome;
	
	
	
	
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


	public Consumidor( String nome) {
		super();
		this.id = ThreadLocalRandom.current().nextInt(0,1000);  //Criação de ids automatico
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "Consumidor [id=" + id + ", nome=" + nome + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumidor other = (Consumidor) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
