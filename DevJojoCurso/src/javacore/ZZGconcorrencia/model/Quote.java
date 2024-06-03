package javacore.ZZGconcorrencia.model;

import javax.management.Query;

import javacore.ZZGconcorrencia.model.Discount.Code;

// storeName:price:discountCode
public final class Quote {
	private final String store;
	private final double price;
	private final Discount.Code discountCode;
	
	
	private Quote(String store, double price, Code discountCode) {
		super();
		this.store = store;
		this.price = price;
		this.discountCode = discountCode;
	}
	
	/**
	 * Criar um novo orçamento apartir do modelo :  storeName:price:discountCode
	 * @param value contendo storeName:price:discountCode
	 * @return um novo orçamento com valores de @param 
	 */
	public static Quote newQuote(String value) {
		String[] split = value.split(":");
		return new Quote(split[0], Double.parseDouble(split[1]), Discount.Code.valueOf(split[2]));
	}

	public String getStore() {
		return store;
	}

	public double getPrice() {
		return price;
	}

	public Discount.Code getDiscountCode() {
		return discountCode;
	}
	
	
	
	
}
