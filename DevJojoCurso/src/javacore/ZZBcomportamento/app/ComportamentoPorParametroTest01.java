package javacore.ZZBcomportamento.app;

import java.util.ArrayList;
import java.util.List;

import javacore.ZZBcomportamento.model.Car;

public class ComportamentoPorParametroTest01 {

	private static List<Car> cars = List.of(new Car("black", 2021), new Car("red", 2001), new Car("green", 2011));

	public static void main(String[] args) {
		System.out.println(filterGreenCar(cars));
		System.out.println(filterByColor(cars,"black"));
		System.out.println("---------");
		System.out.println(filterByYear(cars,2012 ));
		
	}

	private static List<Car> filterGreenCar(List<Car> cars) {
		List<Car> grennCars = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getColor().equalsIgnoreCase("green"))
				grennCars.add(car);
		}
		return grennCars;
	}
	
	private static List<Car> filterByColor(List<Car> cars , String color) {
		List<Car> carByColor = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getColor().equalsIgnoreCase(color))
				carByColor.add(car);
		}
		return carByColor;
	}
	
	private static List<Car> filterByYear(List<Car> cars , int year) {
		List<Car> carByAge = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getYear() < year)
				carByAge.add(car);
		}
		return carByAge;
	}
}
