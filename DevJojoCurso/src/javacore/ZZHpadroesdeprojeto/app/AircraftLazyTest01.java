package javacore.ZZHpadroesdeprojeto.app;

import javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

public class AircraftLazyTest01 {

	public static void main(String[] args) {
		bookSeat("1A");
		bookSeat("1A");

	}
	
	private static void bookSeat(String seat) {
		System.out.println(AircraftSingletonLazy.getIstance());
		AircraftSingletonLazy aircraftSingletonLazy = AircraftSingletonLazy.getIstance();
		System.out.println(aircraftSingletonLazy.bookSeat(seat));
	}

}
