package javacore.ZZstream.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest05 {
	public static void main(String[] args) {
		List<String> list = List.of("Gomu", "No", "Mi");
		String[] letters = list.get(0).split("");
		System.out.println(Arrays.toString(letters));
		
		List<String> letters2 =list.stream()
			.map(s->s.split(""))
			.flatMap(Arrays::stream)
			.collect(Collectors.toList());
		
		letters2.forEach(System.out::println);
			
	}
}
