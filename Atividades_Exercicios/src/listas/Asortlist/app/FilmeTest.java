package listas.Asortlist.app;

import java.util.Scanner;

import listas.Asortlist.service.Service;

public class FilmeTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int op;
		do {
			FilmeTest.menu();
			op = scan.nextInt();
			
			switch (op) {
			case 1:
				Service.mostrarFilmes();
				break;
			case 2:
				Service.mostrarFilmesByDuration();
				break;
			case 3:
				Service.mostrarFilmesByLunchYear();
				break;
			case 4:
				Service.adicionarFilme();
				break;
			case 5:
				Service.alterarFilme();
				break;
			case 6:
				Service.removerFilme();
				break;
			case 7 :
				System.out.println("Saindo...");
				System.exit(0);
				break;
			default:
				System.out.println("Escolha uma opção válida");
				break;
			}
			System.out.println("-------------------");
		}while(op != 5);
	}
	
	public static void menu(){
		System.out.println("1. Ver filmes");
		System.out.println("2. Ver filmes por duração (DESC)");
		System.out.println("3. Ver filmes por data de lançamento (DESC)");
		System.out.println("4. Adicionar filme");
		System.out.println("5. Editar filme");
		System.out.println("6. Remover filme");
		System.out.println("7. Sair");
		System.out.print("Sua escolha: ");
		
	}
}



	
