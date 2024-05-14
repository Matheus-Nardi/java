package javacore.ZZBcomportamento.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javacore.ZZBcomportamento.interfaces.CarPredicate;
import javacore.ZZBcomportamento.model.Car;

public class ComportamentoPorParametroTest02 {

	private static List<Car> cars = List.of(new Car("black", 2021), new Car("red", 2001), new Car("green", 2011));

	public static void main(String[] args) {

		System.out.println(filter(cars, car -> car.getColor().equals("black")));
		System.out.println(filter(cars, car -> car.getYear() < 2012));

		List<Car> redCars = filter(cars, new CarPredicate() {
			@Override
			public boolean test(Car car) {
				return car.getColor().equals("red");
			}
		});
		System.out.println(redCars);

		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(filterGeneric(nums, n -> n % 2 == 0));
	}

	private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
		List<Car> filter = new ArrayList<Car>();
		for (Car car : cars) {
			if (carPredicate.test(car))
				filter.add(car);
		}
		return filter;
	}

	private static <T> List<T> filterGeneric(List<T> list, Predicate<T> predicate) {
		List<T> filteredList = new ArrayList<T>();
		for (T e : list) {
			if (predicate.test(e))
				filteredList.add(e);
		}
 
		return filteredList;
	}

}
