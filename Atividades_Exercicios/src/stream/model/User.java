package stream.model;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class User {
	private Integer id;
	private String name;
	private Integer idade;

	public User(String name, Integer idade) {
		this.id = ThreadLocalRandom.current().nextInt(0,1000);
		this.name = name;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idade, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(idade, other.idade) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", idade=" + idade + "]";
	}
	
	
}
