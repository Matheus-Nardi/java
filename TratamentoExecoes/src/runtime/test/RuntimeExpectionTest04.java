package runtime.test;

import java.io.IOException;
import java.sql.SQLException;

public class RuntimeExpectionTest04 {
	public static void main(String[] args) {
		mutipliCatch();
		
		//Permite o cath em um linha desde que as excptions estejam em linhas de herançã diferente
		try {
			multiCatchEmLinha();
		}catch(SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void mutipliCatch() {
		//Sempre do mais especifico para o mais generico
		try {
			throw new ArrayIndexOutOfBoundsException();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Dentro do ArrayIndexOutOfBoundsException");
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Dentro de IndexOutOfBoundsException");
		}catch(IllegalArgumentException e) {
			System.out.println("Dentro de IllegalArgumentException");
		}catch(RuntimeException e) {
			System.out.println("Dentro do RuntimeException");
		}
	}
	
	private static void multiCatchEmLinha() throws SQLException,IOException {
		
	}
}
