package javacore.ZZstream.app;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
	//Benchmark : fazer a analise se o tempo de processamento vale a pena
	//Unboxing boxig  : tipo primitivo x Wrapper
	//Limit, findFirst : podem dar problema
	//Custo total da computação N , P 
	//Quantidade de dados : se for mt pequena não vale a pena usar parallel
	//Tipos de coleções : dependendo do tipo , a perfomace é diferente 
	//Tamanho o stream com tamanho definido tem melhor parallel
	//Processament do merge
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());

		long num = 10_000_000;
		sumFor(num);
		sumStremIterate(num);
		sumParallelStremIterate(num);
		sumLongStremIterate(num);
		sumLongParallelStremIterate(num);
	}

	private static void sumFor(long num) {
		System.out.println("Sum for");
		long result = 0;
		long init = System.currentTimeMillis();

		for (long i = 1; i <= num; i++) {
			result += i;

		}
		
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end-init) + "ms");
	}
	
	private static void sumStremIterate(long num) {
		System.out.println("Sum stream Iterate");
		
		long init = System.currentTimeMillis();

		Long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
		
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end-init) + "ms");
	}
	
	
	private static void sumParallelStremIterate(long num) {
		System.out.println("Sum parallel stream Iterate");
		
		long init = System.currentTimeMillis();

		Long result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
		
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end-init) + "ms");
	}
	
	private static void sumLongStremIterate(long num) {
		System.out.println("Sum long stream Iterate");
		
		long init = System.currentTimeMillis();

		Long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
		
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end-init) + "ms");
	}
	
	private static void sumLongParallelStremIterate(long num) {
		System.out.println("Sum long parallel stream Iterate");
		
		long init = System.currentTimeMillis();

		Long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
		
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end-init) + "ms");
	}
}
