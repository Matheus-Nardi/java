package javacore.ZZGconcorrencia.app;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javacore.ZZGconcorrencia.model.*;

import javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

public class CompletableFutureTest05 {
	public static void main(String[] args) {
		StoreServiceWithDiscount service = new StoreServiceWithDiscount();
		// searchPricesWithDiscount(service);
		searchPricesWithDiscountAsync(service);
	}

	private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
		long start = System.currentTimeMillis();
		List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

		var array = stores.stream()
				.map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
				.map(cf -> cf.thenApply(Quote::newQuote))
				.map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
				.map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n" , store , (System.currentTimeMillis() - start))))
				.toArray(CompletableFuture[]::new);

	   CompletableFuture<Void> voidCf = CompletableFuture.allOf(array); //Saber se todas as tarefas foram terminadas
	   voidCf.join();
	   System.out.printf("Finished ? %b%n" , voidCf.isDone());
		long end = System.currentTimeMillis();
		
		//anyOff apenas quando 1 resultado já serve

		System.out.printf("Tempo de execução %d ms ", (end - start));
	}
}
