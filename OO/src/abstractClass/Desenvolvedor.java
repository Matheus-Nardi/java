package abstractClass;

public class Desenvolvedor extends Funcionario{

	public Desenvolvedor(String nome, Double salario) {
		super(nome, salario);
		
	}

	@Override
	public void calcularBonus() {
		Double salarioAumento = this.getSalario() * 0.15;
		this.setSalario(this.getSalario() + salarioAumento);
	}

	


}
