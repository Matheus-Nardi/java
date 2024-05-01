package exepction.teste;

import exepction.teste.models.Funcionario;
import exepction.teste.models.LoginInvalidoException;
import exepction.teste.models.Pessoa;

public class OverrideExceptionTest {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		Funcionario funcionario = new Funcionario();
		
		try {
			funcionario.salvar();
		} catch (LoginInvalidoException e) {
			e.printStackTrace();
		}
	}
}
