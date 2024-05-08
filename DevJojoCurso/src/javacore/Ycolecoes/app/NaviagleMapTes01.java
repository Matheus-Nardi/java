package javacore.Ycolecoes.app;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NaviagleMapTes01 {
	public static void main(String[] args) {
		//TreeMap ordena pela chave , logo ter comparable ou comparator
		NavigableMap<String, String> map = new TreeMap<String, String>();

		map.put("C", "Letra C");
		map.put("A", "Letra A");
		map.put("D", "Letra D");
		map.put("B", "Letra B");
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		//Retorna todos que vem antes , se tiver o true o parametro entra junto
		
		System.out.println(map.headMap("C" , true));
		
		System.out.println(map.lowerKey("B"));
		System.out.println(map.floorKey("B"));
		System.out.println(map.higherKey("C"));
		System.out.println(map.ceilingKey("C"));
		
		
		
	}
}
