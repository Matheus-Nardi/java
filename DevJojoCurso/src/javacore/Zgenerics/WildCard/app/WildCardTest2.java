package javacore.Zgenerics.WildCard.app;

import java.util.List;

import javacore.Zgenerics.WildCard.model.Animal;
import javacore.Zgenerics.WildCard.model.Cachorro;
import javacore.Zgenerics.WildCard.model.Gato;

public class WildCardTest2 {

	public static void main(String[] args) {
		List<Cachorro> dogs  = List.of(new Cachorro() , new Cachorro());
		List<Gato> cats  = List.of(new Gato() , new Gato());
		
		showConsulta(dogs);  //Erro de compilação , devido ao type erasure se não houvesse o generic
	}
	
	private static void showConsulta(List<? extends Animal> animais) {
		for (Animal animal : animais) {
			animal.consulta();
		}
		
		//Não posso adicionar elementos, apenas a leitura
		//Não há uma certeza se é um Cachorro ou gato
	}
	
	private static void showConsultaAnimal(List<? super Animal> animais) {
		for (Object animal : animais) {
			((Animal) animal).consulta();
		}
		
		animais.add(new Gato());
		
		//Posso adicionar devido ao poliforismo , o pai de animal é object 
		//Tanto faz ser um gato ou cachorro , é um object !
	}
	
	

}
