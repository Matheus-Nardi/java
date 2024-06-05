package designPattern.model;

public class Bolo {
	private Personalizacao.TipoBolo tipoBolo;
	private Personalizacao.Tamanho tamanho;
	private Personalizacao.Recheio recheio;
	private Personalizacao.Cobertura cobertura;
	private Personalizacao.Decoracao decoracao;
	
	

	public Personalizacao.TipoBolo getTipoBolo() {
		return tipoBolo;
	}

	public void setTipoBolo(Personalizacao.TipoBolo tipoBolo) {
		this.tipoBolo = tipoBolo;
	}

	public Personalizacao.Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Personalizacao.Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Personalizacao.Recheio getRecheio() {
		return recheio;
	}

	public void setRecheio(Personalizacao.Recheio recheio) {
		this.recheio = recheio;
	}

	public Personalizacao.Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Personalizacao.Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public Personalizacao.Decoracao getDecoracao() {
		return decoracao;
	}

	public void setDecoracao(Personalizacao.Decoracao decoracao) {
		this.decoracao = decoracao;
	}
	
	

	@Override
	public String toString() {
		return "Bolo [tipoBolo=" + tipoBolo + ", tamanho=" + tamanho + ", recheio=" + recheio + ", cobertura="
				+ cobertura + ", decoracao=" + decoracao + "]";
	}

	private Bolo(BoloBuilder boloBuilder) {
		super();
		this.tipoBolo = boloBuilder.tipoBolo;
		this.tamanho = boloBuilder.tamanho;
		this.recheio = boloBuilder.recheio;
		this.cobertura = boloBuilder.cobertura;
		this.decoracao = boloBuilder.decoracao;
	}

	public static class BoloBuilder {
		private Personalizacao.TipoBolo tipoBolo;
		private Personalizacao.Tamanho tamanho;
		private Personalizacao.Recheio recheio;
		private Personalizacao.Cobertura cobertura;
		private Personalizacao.Decoracao decoracao;

		public BoloBuilder tipoBolo(Personalizacao.TipoBolo tipo) {
			this.tipoBolo = tipo;
			return this;
		}

		public BoloBuilder tamanho(Personalizacao.Tamanho tamanho) {
			this.tamanho = tamanho;
			return this;
		}

		public BoloBuilder recheio(Personalizacao.Recheio recheio) {
			this.recheio = recheio;
			return this;
		}

		public BoloBuilder cobertura(Personalizacao.Cobertura cobertura) {
			this.cobertura = cobertura;
			return this;
		}

		public BoloBuilder decoracao(Personalizacao.Decoracao decoracao) {
			this.decoracao = decoracao;
			return this;
		}

		public Bolo build() {
			return new Bolo(this);
		}
	}
}
