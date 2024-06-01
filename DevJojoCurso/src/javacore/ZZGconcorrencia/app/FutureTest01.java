package javacore.ZZGconcorrencia.app;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * Trabalhar com prog assincrona , uma parte do programa faz uma coisa 
 * enquanto a outra se responsabiliza por outra, naõ travando , ou tendo uma má requisição */
public class FutureTest01 {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService exeService = Executors.newSingleThreadExecutor();
		Future<Double> dollarRequest = exeService.submit(() -> {
			TimeUnit.SECONDS.sleep(5);
			return 4.35D;
		});
		System.out.println(doSomenthing());
		Double dollarResponse = dollarRequest.get(3, TimeUnit.SECONDS);
		System.out.println("Dollar value: " + dollarResponse);
		exeService.shutdown();
	}
	
	private static long doSomenthing() {
		System.out.println(Thread.currentThread().getName());
		long sum = 0;
		for (int i = 0; i < 10_000; i++) {
			sum+=i;
		}
		
		return sum;
	}
}

