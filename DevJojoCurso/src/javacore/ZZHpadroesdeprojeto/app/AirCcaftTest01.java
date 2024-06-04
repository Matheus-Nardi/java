package javacore.ZZHpadroesdeprojeto.app;

import javacore.ZZHpadroesdeprojeto.dominio.Aircraft;

public class AirCcaftTest01 {

	public static void main(String[] args) {
		bookSeat("1A");
		bookSeat("1A");

	}
	
	private static void bookSeat(String seat) {
		Aircraft aircraft = new Aircraft("345-000");
		System.out.println(aircraft.bookSeat(seat));
	}

}
