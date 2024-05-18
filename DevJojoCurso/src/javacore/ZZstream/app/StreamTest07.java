package javacore.ZZstream.app;

import java.util.List;

public class StreamTest07 {
	public static void main(String[] args) {
		List<Integer> nums = List.of(-45,1,2,3,4,5);
		System.out.println(nums.stream()
			.reduce(0 ,(x,y) -> x+y));
		
		System.out.println(nums.stream()
				.reduce(0,Integer::sum));
		
		System.out.println(nums.stream()
				.reduce(1,(x,y) -> x*y));
		
		nums.stream()
			.reduce(Integer::max)
			.ifPresent(System.out::println);
		
		System.out.println(nums.stream()
		.reduce(Integer.MIN_VALUE , Integer::max));
	}
}
