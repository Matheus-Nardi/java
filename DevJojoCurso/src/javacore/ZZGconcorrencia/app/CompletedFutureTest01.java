package javacore.ZZGconcorrencia.app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javacore.ZZGconcorrencia.service.StoreService;

public class CompletedFutureTest01 {
	public static void main(String[] args) {
		StoreService storeService = new StoreService();
//		searchPricesSync(storeService);
//		searchPricesAsyncFuture(storeService);
		searchPricesAsyncComppletableFuture(storeService);
	}

	private static void searchPricesSync(StoreService storeService) {
		long start = System.currentTimeMillis();
		System.out.println(storeService.getPriceSync("Store 1"));
		System.out.println(storeService.getPriceSync("Store 2"));
		System.out.println(storeService.getPriceSync("Store 3"));
		System.out.println(storeService.getPriceSync("Store 4"));
		long end = System.currentTimeMillis();
		System.out.printf("Tempo passado para busca: %d ms %n", (end - start));
	}

	private static void searchPricesAsyncFuture(StoreService storeService) {
		long start = System.currentTimeMillis();
		Future<Double> pricesAsyncFuture = storeService.getPricesAsyncFuture("Store 1");
		Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
		Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
		Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");
		try {
			System.out.println(pricesAsyncFuture.get());
			System.out.println(pricesAsyncFuture2.get());
			System.out.println(pricesAsyncFuture3.get());
			System.out.println(pricesAsyncFuture4.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		StoreService.shutdown();
		System.out.printf("Tempo passado para busca: %d ms %n", (end - start));
	}

	private static void searchPricesAsyncComppletableFuture(StoreService storeService) {
		long start = System.currentTimeMillis();
		CompletableFuture<Double> pricesAsyncFuture = storeService.getPricesAsyncCompletableFuture("Store 1");
		CompletableFuture<Double> pricesAsyncFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
		CompletableFuture<Double> pricesAsyncFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
		CompletableFuture<Double> pricesAsyncFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");

		//Join não precisa tratar execeção
		System.out.println(pricesAsyncFuture.join());
		System.out.println(pricesAsyncFuture2.join());
		System.out.println(pricesAsyncFuture3.join());
		System.out.println(pricesAsyncFuture4.join());

		long end = System.currentTimeMillis();

		System.out.printf("Tempo passado para busca: %d ms %n", (end - start));
	}
}
