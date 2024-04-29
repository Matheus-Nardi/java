package exepction.teste;

import java.io.File;
import java.io.IOException;

public class ExpectionTest01 {
	public static void main(String[] args) {
		criarNovoArquivo();
	}
	
	private static void criarNovoArquivo() {
		File file = new File("arquivo\\teste.txt");
		try {
			boolean criado = file.createNewFile();
			System.out.println("Arquivo criado: " + criado);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
