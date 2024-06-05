package designPattern.model;

import designPattern.model.Personalizacao.Cobertura;
import designPattern.model.Personalizacao.Decoracao;
import designPattern.model.Personalizacao.Recheio;
import designPattern.model.Personalizacao.Tamanho;
import designPattern.model.Personalizacao.TipoBolo;

public class BoloFactory {
	public static Bolo newBolo(int tipoPreDefinido) {
		switch (tipoPreDefinido) {
		case 1:
			return new Bolo.BoloBuilder().tipoBolo(TipoBolo.CHOCOLATE).tamanho(Tamanho.MEDIO)
					.recheio(Recheio.BRIGADEIRO).cobertura(Cobertura.CHANTILY).decoracao(Decoracao.FLORES).build();
		case 2:
			return new Bolo.BoloBuilder().tipoBolo(TipoBolo.BAUNILHA).tamanho(Tamanho.PEQUENO)
					.recheio(Recheio.BRIGADEIRO).cobertura(Cobertura.GANACHE).decoracao(Decoracao.CONFEITOS).build();
			
		case 3:
			return new Bolo.BoloBuilder().tipoBolo(TipoBolo.RED_VELVET).tamanho(Tamanho.MEDIO)
					.recheio(Recheio.DOCE_DE_LEITE).cobertura(Cobertura.GANACHE).decoracao(Decoracao.FRUTAS).build();
		default:
			throw new IllegalArgumentException("Não foi encontrado um bolo para essa ocasião");
		}
	}
}
