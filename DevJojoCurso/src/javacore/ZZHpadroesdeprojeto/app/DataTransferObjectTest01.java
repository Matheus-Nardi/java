package javacore.ZZHpadroesdeprojeto.app;

import javacore.ZZHpadroesdeprojeto.dominio.Aircraft;
import javacore.ZZHpadroesdeprojeto.dominio.Country;
import javacore.ZZHpadroesdeprojeto.dominio.Currency;
import javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;
import javacore.ZZHpadroesdeprojeto.dominio.Person;
import javacore.ZZHpadroesdeprojeto.dominio.ReportDto;
import javacore.ZZHpadroesdeprojeto.dominio.ReportDto.ReportDtoBuilder;

public class DataTransferObjectTest01 {
	public static void main(String[] args) {
		Aircraft aircraft = new Aircraft("777");
		Country country = Country.BRAZIL;
		Currency currency = CurrencyFactory.newCurrency(country);
		Person person = new Person.PersonBuilder().firstName("Matheus").lastName("Alexandre").build();
		
		ReportDto builder = new ReportDto.ReportDtoBuilder()
			.aircraftName(aircraft.getName())
			.country(country)
			.currency(currency)
			.personName(person.getFirstName())
			.builder();
		
		System.out.println(builder);
	}
}
