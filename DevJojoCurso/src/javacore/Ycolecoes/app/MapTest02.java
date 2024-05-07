package javacore.Ycolecoes.app;

import java.util.HashMap;
import java.util.Map;

import javacore.Ycolecoes.models.Consumidor;
import javacore.Ycolecoes.models.Manga;

public class MapTest02 {
	public static void main(String[] args) {
		
		
		Consumidor consumidor1 = new Consumidor("Matheus Nardi");
		Consumidor consumidor2 = new Consumidor("Cleiton Rasta");
		
		Manga manga1 = new Manga("Bersek", 9.55, 0);
		Manga manga2 = new Manga("Attak on Titan", 10.99, 20);
		Manga manga3 = new Manga("Demon Slayer", 11.25, 15);
		Manga manga4 = new Manga("Blue lock", 7.45, 0);
		
		Map<Consumidor,Manga> map = new HashMap<Consumidor, Manga>();
		map.put(consumidor1, manga2);
		map.put(consumidor2, manga1);
		
		for (Map.Entry<Consumidor, Manga> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
			System.out.println("---------------------");
		}
	}
}
