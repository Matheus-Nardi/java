package map.model;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Candidato {
	private Integer codUnico;
	private String nome;
	private Integer idade;
	
	
	public Candidato(String nome, Integer idade) {
		super();
		this.codUnico = ThreadLocalRandom.current().nextInt(0,1000);
		this.nome = nome;
		this.idade = idade;
	}

	public Integer getCodUnico() {
		return codUnico;
	}

	public void setCodUnico(Integer codUnico) {
		this.codUnico = codUnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codUnico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(codUnico, other.codUnico);
	}

	@Override
	public String toString() {
		return "Candidato [codUnico=" + codUnico + ", nome=" + nome + ", idade=" + idade + "]";
	}
	
	
	
	
	
	
	
}
