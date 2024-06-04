package javacore.ZZHpadroesdeprojeto.dominio;
//Objeto do factory é desacoplar a criação de objetos com a lógica da regra de negocio
public class CurrencyFactory {
	public static Currency newCurrency(Country country) {
		switch (country) {
		case USA:
			return new UsDollar();
		case BRAZIL:
			return new Real();
		default:
			throw new IllegalArgumentException("No currency found for this country");
		}
	}
}
