package set.model;

import java.util.Objects;

public class Participant implements Comparable<Participant>{
	private String nome;
	private String email;
	private Boolean statusConfirmação;
	public Participant(String nome, String email, Boolean statusConfirmação) {
		super();
		this.nome = nome;
		this.email = email;
		this.statusConfirmação = statusConfirmação;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatusConfirmação() {
		return statusConfirmação == true ? "Confirmado" : "Na lista";
	}
	public void setStatusConfirmação(Boolean statusConfirmação) {
		this.statusConfirmação = statusConfirmação;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, nome, statusConfirmação);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(statusConfirmação, other.statusConfirmação);
	}
	@Override
	public int compareTo(Participant o) {
		return this.getNome().compareToIgnoreCase(o.getNome());
	}
	@Override
	public String toString() {
		return "Participant [nome=" + nome + ", email=" + email + ", statusConfirmação=" + this.getStatusConfirmação() + "]";
	}
	
	
	
	
}
