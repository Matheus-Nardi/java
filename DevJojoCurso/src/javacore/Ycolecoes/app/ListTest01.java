package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>(16);
		List<String> nomes2 = new ArrayList<>(16);
		nomes.add("Matheus Nardi");
		nomes.add("William");
		nomes.add("Wanderson");
		
		nomes2.add("Marta");
		nomes2.add("Maria");
		
		
		nomes.remove(1);
		nomes.remove("Wanderson");
		
		
		for (String nome : nomes) {
			System.out.println(nome);
		}
		nomes.addAll(nomes2);
		System.out.println("-----------------");
		
		for (int i = 0; i < nomes.size(); i++) {
			System.out.println(nomes.get(i));
			
		}
	}

}
