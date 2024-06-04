package javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

// Singleton : sempre apontar para o mesmo objeto
public class AircraftSingletonLazy {
	// Eager initialization :
	private static AircraftSingletonLazy ISTANCE;

	private final Set<String> avaliableSeats = new HashSet<String>();
	private final String name;

	private AircraftSingletonLazy(String name) {
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

	public static AircraftSingletonLazy getIstance() {
		if (ISTANCE == null) {
			synchronized (AircraftSingletonLazy.class) {
				if (ISTANCE == null) {
					ISTANCE = new AircraftSingletonLazy("375-000");
				}
			}
		}
		return ISTANCE;
	}

	public boolean bookSeat(String seat) {
		return avaliableSeats.remove(seat);
	}
}
