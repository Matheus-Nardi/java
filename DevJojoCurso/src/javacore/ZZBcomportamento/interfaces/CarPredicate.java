package javacore.ZZBcomportamento.interfaces;

import javacore.ZZBcomportamento.model.Car;

@FunctionalInterface
public interface CarPredicate {
	//anonimas,funções,consisa
	boolean test(Car car);
	
	//parametro -> expressao
	//Car car -> car.getColor.equals("green");
}

//Uma interface funcional é aquela que possui apenas um método abstrato