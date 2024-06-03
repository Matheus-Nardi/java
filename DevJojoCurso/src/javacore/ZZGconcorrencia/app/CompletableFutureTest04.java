package javacore.ZZGconcorrencia.app;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javacore.ZZGconcorrencia.model.*;

import javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

public class CompletableFutureTest04 {
	public static void main(String[] args) {
		StoreServiceWithDiscount service = new StoreServiceWithDiscount();
		//searchPricesWithDiscount(service);
		searchPricesWithDiscountAsync(service);
	}
	
	private static void searchPricesWithDiscount(StoreServiceWithDiscount service) {
		long start = System.currentTimeMillis();
		List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");
//		stores.forEach(s -> System.out.println(service.getPriceSync(s)));
		
		stores.stream()
			.map(service::getPriceSync)
			.map(Quote::newQuote)
			.map(service::applyDiscount)
			.forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.printf("Tempo de execução %d ms ", (end-start));
	}
	
	private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
		long start = System.currentTimeMillis();
		List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");
		
		List<CompletableFuture<String>> completableFutures = stores.stream()
			//Obtendo o price formato em name:price:discountCode
			.map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
			//Istanciando novo orçamentos atraves da string gerada acima
			.map(cf -> cf.thenApply(Quote::newQuote))
			//Compando o completableFuture
			.map(cf -> cf.thenCompose(quote ->CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
			.collect(Collectors.toList());
		
		completableFutures.stream()
			.map(CompletableFuture::join)
			.forEach(System.out::println);
		
		
		long end = System.currentTimeMillis();

		System.out.printf("Tempo de execução %d ms ", (end-start));
	}
}



