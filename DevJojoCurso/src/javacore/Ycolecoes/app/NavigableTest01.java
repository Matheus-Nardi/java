package javacore.Ycolecoes.app;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import javacore.Ycolecoes.models.Smartphone;

class SmartphoneByMarca implements Comparator<Smartphone> {

	@Override
	public int compare(Smartphone o1, Smartphone o2) {
		return o1.getMarca().compareToIgnoreCase(o2.getMarca());
	}

}

public class NavigableTest01 {
	public static void main(String[] args) {
		NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneByMarca()); // Realiza sort , logo temos que ter a
																				// implementação de comparable

		set.add(new Smartphone("123", "Nokia"));
		set.add(new Smartphone("900", "Motorla"));
		set.add(new Smartphone("342", "Sansung"));
		set.add(new Smartphone("859", "Apple"));

		for (Smartphone smartphone : set) {
			System.out.println(smartphone);
		}
	}
}
