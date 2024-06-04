package javacore.ZZHpadroesdeprojeto.app;

import javacore.ZZHpadroesdeprojeto.dominio.Country;
import javacore.ZZHpadroesdeprojeto.dominio.Currency;
import javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyTest01 {
	public static void main(String[] args) {
		Currency newCurrency = CurrencyFactory.newCurrency(Country.BRAZIL);
		
		System.out.println(newCurrency.getSymbol());
	}
}
