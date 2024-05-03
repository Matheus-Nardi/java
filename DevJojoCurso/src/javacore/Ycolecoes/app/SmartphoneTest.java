package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.List;

import javacore.Ycolecoes.models.Smartphone;

public class SmartphoneTest {
	public static void main(String[] args) {
		//é indexada
		Smartphone s1 = new Smartphone("1abc2", "Apple");
		Smartphone s2 = new Smartphone("290Ac", "Sansung");
		Smartphone s3 = new Smartphone("9perc", "Motorola");
		Smartphone s4 = new Smartphone("pp342", "Xiaomi");

		List<Smartphone> smartphones = new ArrayList<>(6);

		smartphones.add(s1);
		smartphones.add(s2);
		smartphones.add(0,s3); //Dessa maneira escolho o indice do elemento
		smartphones.add(s4);

		for (Smartphone smartphone : smartphones) {
			System.out.println(smartphone);
		}

		Smartphone s5 = new Smartphone("9perc", "Motorola");
		System.out.println(smartphones.contains(s5));
		
		int indexSmartphone = smartphones.indexOf(s3); //Retorna o indice do objeto , se não encontrar retorna -1;
		System.out.println(indexSmartphone);
		
		smartphones.remove(s4);
		
		if(smartphones.indexOf(s4) != -1) {
			System.out.println(smartphones.get(smartphones.indexOf(s4)));
		}else
			throw new IllegalArgumentException("O indice passado não foi encontrado");

	}
}
