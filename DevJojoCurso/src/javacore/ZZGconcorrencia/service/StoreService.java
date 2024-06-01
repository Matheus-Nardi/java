package javacore.ZZGconcorrencia.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreService {
	private static final ExecutorService exeService = Executors.newCachedThreadPool();

	public double getPriceSync(String storeName) {
		System.out.printf("Obtendo preço de forma sincrona da loja: %s %n", storeName);
		return priceGenerator();
	}

	public Future<Double> getPricesAsyncFuture(String storeName) {
		System.out.printf("Obtendo preço de forma assincrona da loja: %s %n", storeName);

		return exeService.submit(this::priceGenerator);

	}
	
	public CompletableFuture<Double> getPricesAsyncCompletableFuture(String storeName) {
		System.out.printf("Obtendo preço de forma assincrona da loja: %s %n", storeName);

		return CompletableFuture.supplyAsync(this::priceGenerator);

	}
	
	public static void shutdown() {
		exeService.shutdown();
	}

	private double priceGenerator() {
		System.out.printf("%s gerando preço %n", Thread.currentThread().getName());
		delay();
		return ThreadLocalRandom.current().nextInt(1, 500) * 10;
	}

	private void delay() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
