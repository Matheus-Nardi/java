package concorrencia.model;

import java.util.concurrent.ThreadLocalRandom;

public class Pedido {
	private final int id;
	private final String detalhes;

	public Pedido(String detalhes) {
		super();
		this.id = ThreadLocalRandom.current().nextInt(0, 500);
		this.detalhes = detalhes;
	}

	public int getId() {
		return id;
	}

	public String getDetalhes() {
		return detalhes;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", detalhes=" + detalhes + "]";
	}

}
