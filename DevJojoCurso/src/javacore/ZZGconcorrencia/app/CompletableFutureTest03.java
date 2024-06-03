package javacore.ZZGconcorrencia.app;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import javacore.ZZGconcorrencia.service.StoreServiceDeprecated;

public class CompletableFutureTest03 {
	public static void main(String[] args) {
		StoreServiceDeprecated serviceDeprecated = new StoreServiceDeprecated();
		searchPricesAsyncComppletableFuture(serviceDeprecated);
	}
	
	//Caso não tenha acesso a metodos async, posso add uma camada com completableFuture
	private static void searchPricesAsyncComppletableFuture(StoreServiceDeprecated serviceDeprecated) {
		long start = System.currentTimeMillis();
		List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");
		//Criando um executor com uma ThreadFactory personalizada
		ExecutorService executor = Executors.newFixedThreadPool(10 , r -> {
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			return thread;
		});
		List<CompletableFuture<Double>> completableFutures = stores.stream()
			.map(s -> CompletableFuture.supplyAsync(() -> serviceDeprecated.getPriceSync(s),executor))
			.collect(Collectors.toList());
		
		List<Double> prices = completableFutures.stream()
			.map(CompletableFuture::join)
			.collect(Collectors.toList());
		
		System.out.println(prices);
		
		long end = System.currentTimeMillis();
		executor.shutdown();

		System.out.printf("Tempo passado para busca: %d ms %n", (end - start));
	}
}
