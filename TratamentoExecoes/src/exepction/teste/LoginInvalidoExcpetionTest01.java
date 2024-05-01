package exepction.teste;

import java.util.Scanner;

import exepction.teste.models.LoginInvalidoException;

public class LoginInvalidoExcpetionTest01 {
	public static void main(String[] args) {
		try {
			login();
		} catch (LoginInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	public static void login() throws LoginInvalidoException {
		Scanner scan = new Scanner(System.in);
		String usernameDB = "Saitama";
		String senhaDB = "carecas";
		System.out.println("Usuario: ");
		String userDigitado = scan.nextLine();
		System.out.println("Senha: ");
		String senhaDigitada = scan.nextLine();
		if(!usernameDB.equals(userDigitado) || !senhaDB.equals(senhaDigitada)) {
			throw new LoginInvalidoException();
		}
		
		System.out.println("Login realizado com sucesso");
	}
}
