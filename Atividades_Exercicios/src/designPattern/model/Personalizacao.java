package designPattern.model;

public class Personalizacao {
	public enum TipoBolo {
		CHOCOLATE, BAUNILHA, RED_VELVET;
		
		public void forEachTipoBolo() {
			for (TipoBolo tipo : values()) {
				System.out.println(tipo.name());
			}
		}
		
		public TipoBolo valuesOf(int tipo) {
			for (TipoBolo tipoBolo : values()) {
				if(tipoBolo.ordinal() == tipo)
					return tipoBolo;
			}
			throw new IllegalArgumentException("Argumento fornecido ilegal!");
		}
	}

	public enum Tamanho {
		PEQUENO, MEDIO, GRANDE;
	}

	public enum Recheio {
		BRIGADEIRO, DOCE_DE_LEITE, FRUTAS_VERMELHAS;
	}

	public enum Cobertura {
		CHANTILY, GANACHE, PASTA_AMERICANA;
	}

	public enum Decoracao {
		FRUTAS, CONFEITOS, FLORES;
	}
	
	
}
