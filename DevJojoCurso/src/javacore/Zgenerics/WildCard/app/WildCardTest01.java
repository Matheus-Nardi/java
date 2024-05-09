package javacore.Zgenerics.WildCard.app;

import javacore.Zgenerics.WildCard.model.Animal;
import javacore.Zgenerics.WildCard.model.Cachorro;
import javacore.Zgenerics.WildCard.model.Gato;

public class WildCardTest01 {

	public static void main(String[] args) {
		
		Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
		Gato[] gatos = {new Gato() , new Gato() };
		
		
		showConsulta(cachorros);
		showConsulta(gatos);
	}
	
	private static void showConsulta(Animal[] animais) {
		for (Animal animal : animais) {
			animal.consulta();
		}
	}

}
