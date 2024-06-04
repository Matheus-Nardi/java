package javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
	private final Set<String> avaliableSeats = new HashSet<String>();
	private final String name;
	
	public Aircraft(String name){
		this.name = name;
	}
	{
		avaliableSeats.add("1A");
		avaliableSeats.add("2B");
	}
	
	public boolean bookSeat(String seat) {
		return avaliableSeats.remove(seat);
	}
}
