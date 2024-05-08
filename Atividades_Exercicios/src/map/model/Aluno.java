package map.model;

import java.util.Arrays;
import java.util.Objects;

public class Aluno {
	private Integer numeroMatricula;
	private Double[] notas;

	
	public Aluno(Integer numeroMatricula, Double[] notas) {
		super();
		this.numeroMatricula = numeroMatricula;
		this.notas = notas;
	}


	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}


	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}


	public Double[] getNotas() {
		return notas;
	}


	public void setNotas(Double[] notas) {
		this.notas = notas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numeroMatricula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(numeroMatricula, other.numeroMatricula);
	}


	@Override
	public String toString() {
		return "Aluno Matricula=" + numeroMatricula + ", Notas=" + Arrays.toString(notas);
	}
	
	
	
	
	
	
}
