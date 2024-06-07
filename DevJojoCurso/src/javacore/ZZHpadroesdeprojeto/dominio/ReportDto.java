package javacore.ZZHpadroesdeprojeto.dominio;

//DTO serve quando preciso acessar varios objetos diferentes
//Crio uma classe com todos os objetos necessarios
//Em vez de mandar 4 objetos, mando apenas 1
public class ReportDto {
	private String aircraftName;
	private Country country;
	private Currency currency;
	private String personName;
	
	

	private ReportDto(String aircraftName, Country country, Currency currency, String personName) {
		super();
		this.aircraftName = aircraftName;
		this.country = country;
		this.currency = currency;
		this.personName = personName;
	}

	
	


	@Override
	public String toString() {
		return "ReportDto [aircraftName=" + aircraftName + ", country=" + country + ", currency=" + currency
				+ ", personName=" + personName + "]";
	}





	public static final class ReportDtoBuilder {
		private String aircraftName;
		private Country country;
		private Currency currency;
		private String personName;

		public ReportDtoBuilder aircraftName(String aircraftName) {
			this.aircraftName = aircraftName;
			return this;
		}

		public ReportDtoBuilder country(Country country) {
			this.country = country;
			return this;

		}
		
		public ReportDtoBuilder currency(Currency currency) {
			this.currency = currency;
			return this;

		}
		
		public ReportDtoBuilder personName(String personName) {
			this.personName = personName;
			return this;

		}
		
		public  ReportDto builder() {
			return new ReportDto(aircraftName,country,currency,personName);
		}
	}
}
