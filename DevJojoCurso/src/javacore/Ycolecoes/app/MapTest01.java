package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest01 {
	public static void main(String[] args) {
		//Chave, valor
		//Sem chaves duplicadas, pois a chave é um set
		//LinkedHash ordem inserção é mantida
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "TO");
		map.put(2, "SC");
		map.put(3, "CE");
		map.put(4, "AM");
		map.putIfAbsent(4, "RS");
		System.out.println(map.get(3));
		
		System.out.println(map);
		
		for(Integer key : map.keySet()) {
			System.out.println("Chave: " + key + " - Valor: " + map.get(key));
		}
		System.out.println("--------------------");
		
		for (String value : map.values()) {
			System.out.println("Valor: " + value);
		}
		System.out.println("--------------------");
		for (Map.Entry<Integer, String> keyValue : map.entrySet() ) {
			System.out.println("Chave: " + keyValue.getKey() + " - Valor: " + keyValue.getValue());
		}
		
		
	}
}
