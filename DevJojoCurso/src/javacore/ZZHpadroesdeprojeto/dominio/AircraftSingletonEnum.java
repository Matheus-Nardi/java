package javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;
// Util para impedir a mudança de construtor via reflections
public enum AircraftSingletonEnum {
	ISTANCE;

	private final Set<String> avaliableSeats;

	private AircraftSingletonEnum() {
		this.avaliableSeats = new HashSet<String>();
		this.avaliableSeats.add("1A");
		this.avaliableSeats.add("1B");
	}
	
	public boolean bookSeat(String seat) {
		return avaliableSeats.remove(seat);
	}
	
	
}
