package stream.model;

import java.util.Objects;

public class Employer {
	private Integer id;
	private String name;
	private String email;
	private Double salary;
	private Integer idade;
	private Departament departament;

	public Employer(Integer id, String name, String email, Double salary, Integer idade, Departament departament) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.idade = idade;
		this.departament = departament;
	}

	public Employer(Integer id, String name, String email, Double salary, Integer idade) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, idade, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employer other = (Employer) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(idade, other.idade)
				&& Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", idade=" + idade
				+ ", departament=" + departament + "]";
	}

	public void setNewSalaray(Double aumento) {
		this.salary += this.salary * aumento;
	}

}
