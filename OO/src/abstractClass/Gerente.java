package abstractClass;

public class Gerente  extends Funcionario{

	public Gerente(String nome, Double salario) {
		super(nome, salario);
		
	}

	@Override
	public void calcularBonus() {
		Double salarioAumento = this.getSalario() * 0.2;
		this.setSalario(this.getSalario() + salarioAumento);
	}



	
	
	

}
