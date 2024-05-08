package map.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap02 {
	public static void main(String[] args) {
		List<Map<Integer, String>> listMap = new ArrayList<Map<Integer,String>>();
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "Caderno");
		map.put(2, "Borracha");
		map.put(3, "Lapis");
		
		listMap.add(map);
		
		for (Map<Integer, String> mapList : listMap) {
			System.out.println(mapList.keySet());
			System.out.println(mapList.values());
		}
	}
}
