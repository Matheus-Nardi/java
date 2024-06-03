package javacore.ZZGconcorrencia.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javacore.ZZGconcorrencia.model.Discount;
import javacore.ZZGconcorrencia.model.Quote;

public class StoreServiceWithDiscount {
	private static final ExecutorService exeService = Executors.newCachedThreadPool();

	public String getPriceSync(String storeName) {
		double price = priceGenerator();
		Discount.Code discountCode = Discount.Code.values()[ThreadLocalRandom.current()
				.nextInt(Discount.Code.values().length)];

		return String.format("%s:%.2f:%s", storeName, price, discountCode);
	}
	
	
	public String applyDiscount(Quote quote) {
		delay();
		double discount = quote.getPrice() * (100 - quote.getDiscountCode().getPercentage()) / 100;
		return String.format(" '%s' original price: %.2f | Applying discount code %s , Final price : %.2f", quote.getStore(),
				quote.getPrice(),
				quote.getDiscountCode(),
				discount);
	}

	public static void shutdown() {
		exeService.shutdown();
	}

	private double priceGenerator() {
		delay();
		return ThreadLocalRandom.current().nextInt(1, 500) * 10;
	}

	private void delay() {
		try {
			int milli = ThreadLocalRandom.current().nextInt(200 , 2500);
			TimeUnit.MICROSECONDS.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
