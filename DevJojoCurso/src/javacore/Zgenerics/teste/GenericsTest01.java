package javacore.Zgenerics.teste;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {

	public static void main(String[] args) {
		
		//List sem generic , adicionado object , ou seja , qualuer coisa
		//Generic obriga em tempo de compilação um tipo
		//Mas ao compilar o generic some , type erasure
		List lista = new ArrayList();
		lista.add("Sherek");
		lista.add(123);
		lista.add(true);
		lista.add(23.0f);
		
		for (Object object : lista) {
			if(object instanceof String) {
				System.out.println("String: " + object);
			}else if(object instanceof Integer)
				System.out.println("Inteiro: " + object);
			else if(object instanceof Boolean)
				System.out.println("Boolean: " + object);
			else
				System.out.println("Desconheço");
		}
		
	}

}
