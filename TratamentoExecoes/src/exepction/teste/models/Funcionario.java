package exepction.teste.models;

public class Funcionario extends Pessoa {
	@Override
	public void salvar() throws LoginInvalidoException {
		System.out.println("Salvando funcionario...");
	}
}
