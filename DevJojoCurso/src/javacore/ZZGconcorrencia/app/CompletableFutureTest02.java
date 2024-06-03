package javacore.ZZGconcorrencia.app;

import java.util.List;
import java.util.concurrent.CompletableFuture;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javacore.ZZGconcorrencia.service.StoreService;

public class CompletableFutureTest02 {
	public static void main(String[] args) {
		StoreService storeService = new StoreService();
		searchPricesAsyncComppletableFuture(storeService);
	}
	
	//Ter cuidado ao utilizar future e completable com stream
	private static void searchPricesAsyncComppletableFuture(StoreService storeService) {
		long start = System.currentTimeMillis();
		List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");
		
		 List<CompletableFuture<Double>> completableFutures = stores.stream()
				.map(storeService::getPricesAsyncCompletableFuture).collect(Collectors.toList());
		 
		List<Double> prices = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println(prices);
		
		long end = System.currentTimeMillis();

		System.out.printf("Tempo passado para busca: %d ms %n", (end - start));
	}
}
