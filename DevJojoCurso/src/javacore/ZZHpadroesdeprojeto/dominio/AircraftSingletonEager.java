package javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;
// Singleton : sempre apontar para o mesmo objeto
public class AircraftSingletonEager {
	//Eager initialization : 
	private static final AircraftSingletonEager ISTANCE = new AircraftSingletonEager("345-000");
	
	
	private final Set<String> avaliableSeats = new HashSet<String>();
	private final String name;
	
	private AircraftSingletonEager(String name){
		this.name = name;
	}
	{
		avaliableSeats.add("1A");
		avaliableSeats.add("2B");
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static AircraftSingletonEager getIstance() {
		return ISTANCE;
	}
	
	public boolean bookSeat(String seat) {
		return avaliableSeats.remove(seat);
	}
}
