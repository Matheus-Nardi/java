package exepction.teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import exepction.teste.models.Leitor1;
import exepction.teste.models.Leitor2;

public class TryWithResources {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			scan.next();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

	public static void lerArquivo() {
		Reader reader = null;
		try {
			reader = new BufferedReader(new FileReader("teste.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void lerArquivoTryResource() {
		try (Reader reader = new BufferedReader(new FileReader("teste.txt"))) {

		} catch (IOException e) {

		}
	}
	
	//Garante o fechamento daquelas classes que implementam closeable
	public static void lerAquivo2() {
		try(Leitor1 leitor1 = new Leitor1();
			Leitor2 leitor2 = new Leitor2()){
			
		}catch(IOException e){
			
		}
	}

}
