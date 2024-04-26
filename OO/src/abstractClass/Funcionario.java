package abstractClass;

public abstract class Funcionario extends Pessoa {
//Um template, modelo , não deveria existir 
// Criada para ser extendida
	private String nome;
	private Double salario;

	public Funcionario(String nome, Double salario) {
		super();
		this.nome = nome;
		this.salario = salario;
		calcularBonus();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	//Garante que para toda classe extendida haja um metodo abstrato
	public abstract void calcularBonus();
	
	@Override
		public void imprime() {
			System.out.println("Testando o imprimir");
			
		}

}
