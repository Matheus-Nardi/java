package javacore.ZZHpadroesdeprojeto.app;

import javacore.ZZHpadroesdeprojeto.dominio.Aircraft;
import javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftEagerTest01 {

	public static void main(String[] args) {
		bookSeat("1A");
		bookSeat("1A");

	}
	
	private static void bookSeat(String seat) {
		System.out.println(AircraftSingletonEager.getIstance());
		AircraftSingletonEager aircraftSingletonEager = AircraftSingletonEager.getIstance();
		System.out.println(aircraftSingletonEager.bookSeat(seat));
	}

}
