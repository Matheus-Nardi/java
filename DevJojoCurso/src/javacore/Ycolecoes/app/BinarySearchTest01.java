package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(2);
		numeros.add(0);
		numeros.add(4);
		numeros.add(3);
		Collections.sort(numeros); //Ordenar para a busca fazer sentido
		//index 0,1,2,3
		//values 0,2,3,4
		System.out.println(Collections.binarySearch(numeros, 2));
		
		// caso seja passado um valor que não exista , metodo retorna (-(ponto de inserção) -1);
	
	}
}
