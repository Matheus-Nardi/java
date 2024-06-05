package javacore.ZZHpadroesdeprojeto.app;

import javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEnum;

public class AircraftSingetonEnumTest01 {
	public static void main(String[] args) {
		bookSeat("1A");
		bookSeat("1A");
	}

	private static void bookSeat(String seat) {
		System.out.println(AircraftSingletonEnum.ISTANCE);
		System.out.println(AircraftSingletonEnum.ISTANCE.hashCode());
		AircraftSingletonEnum instance = AircraftSingletonEnum.ISTANCE;
		System.out.println(instance.bookSeat(seat));
	}
}
